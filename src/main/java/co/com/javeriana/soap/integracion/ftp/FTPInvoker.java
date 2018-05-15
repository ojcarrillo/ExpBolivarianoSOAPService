package co.com.javeriana.soap.integracion.ftp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPInvoker {
	
	private static final Logger log = LoggerFactory.getLogger(FTPInvoker.class);

	static String server = "35.203.93.92";
	static Integer port = 2021;
	static String user = "touresbalon";
	static String pass = "verysecretpwd";

	public static boolean uploadFile(File file, String filenameServer) {
		boolean success = false;
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			InputStream inputStream = new FileInputStream(file);
			System.out.println("Start uploading first file");
			success = ftpClient.storeFile(filenameServer, inputStream);
			inputStream.close();
			if (success) {
				log.info("The first file is uploaded successfully.");
			}
		} catch (IOException ex) {
			log.info("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				log.info("Error: " + ex.getMessage());
			}
		}
		return success;
	}

	public static File downloadFile(String filenameServer, String filenameLocal) {
		boolean success = false;
		FTPClient ftpClient = new FTPClient();
		File file = new File(filenameLocal);
		try {

			int retry = 0;
			do {
				ftpClient.connect(server, port);
				ftpClient.login(user, pass);
				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setBufferSize(1024 * 1024);

				OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(file));
				success = ftpClient.retrieveFile(filenameServer, outputStream1);
				outputStream1.flush();
				outputStream1.close();
				if (file.length() == 0L) {
					retry++;
					ftpClient.logout();
					ftpClient.disconnect();
					Thread.sleep(1000);
				} else {
					retry = 6;
				}
			} while (retry < 5);
			if (retry == 5) {
				log.error("NUMERO DE INTENTOS FALLIDOS SUPERADOS");
				throw new Exception("NUMERO DE INTENTOS FALLIDOS SUPERADOS");
			}
			if (success) {
				log.info("File #1 has been downloaded successfully.");
			}
		} catch (IOException ex) {
			log.info("Error: " + ex.getMessage());
			ex.printStackTrace();
		} catch (Exception e) {
			log.info("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				log.info("Error: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
		return file;
	}

	public static File createFile(String filename, String ext, String datos) {
		try {
			File queryFile = File.createTempFile(filename, ext);
			Charset charset = Charset.forName("UTF8");
			Files.write(Paths.get(queryFile.getAbsolutePath()), datos.getBytes(), StandardOpenOption.APPEND);
			return queryFile;
		} catch (IOException e) {
			log.info("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String getStringFromFile(File file) {
		String texto = "";
		if (file != null) {
			try {
				BufferedReader readFile = new BufferedReader(new FileReader(file));
				texto = readFile.readLine();
				readFile.close();
				Files.deleteIfExists(file.toPath());
			} catch (IOException e) {
				log.info("Error: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return texto;
	}
}
