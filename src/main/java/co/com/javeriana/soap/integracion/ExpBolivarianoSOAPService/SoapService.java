package co.com.javeriana.soap.integracion.ExpBolivarianoSOAPService;

import java.text.ParseException;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.expresobolivariano.demo.CancelarReserva;
import org.expresobolivariano.demo.CancelarReservaResponse;
import org.expresobolivariano.demo.ObtenerReserva;
import org.expresobolivariano.demo.ObtenerReservaResponse;
import org.expresobolivariano.demo.RealizarReserva;
import org.expresobolivariano.demo.RealizarReservaResponse;
import org.springframework.stereotype.Component;

import co.com.javeriana.soap.integracion.ftp.FTPInvoker;
import co.com.javeriana.soap.integracion.util.Utils;

@Component
public class SoapService {

	public void cancelarReserva(final Exchange exchange) throws DatatypeConfigurationException, InterruptedException {
		CancelarReserva datos = exchange.getIn().getBody(CancelarReserva.class);
		String filename = "cancelar_" + (new Date()).getTime();
		boolean success = false;
		CancelarReservaResponse response = new CancelarReservaResponse();
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datos.getIdReserva()),
				filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE EXPRESO BOLIVARIANO");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setEstado("ANULADO");
				response.setMotivoEstado(rsta.substring(16, rsta.length()));
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}

	public void obtenerReserva(final Exchange exchange) throws DatatypeConfigurationException, InterruptedException, ParseException {
		ObtenerReserva datos = exchange.getIn().getBody(ObtenerReserva.class);
		String filename = "query_reservas_" + (new Date()).getTime();
		boolean success = false;
		ObtenerReservaResponse response = new ObtenerReservaResponse();
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datos.getIdReserva()),
				filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE EXPRESO BOLIVARIANO");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setIdReserva(rsta.substring(0, 9).trim());
				response.setIdViaje(rsta.substring(9, 18).trim());
				response.setFechaSalida(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(18, 30), "ddMMyyyyHHmm")));
				response.setCiudadOrigen(rsta.substring(30, 51).trim());
				response.setCiudadDestino(rsta.substring(51, 72).trim());
				response.setPuestos(rsta.substring(72, rsta.length()).trim());
				response.setEstado("COMPLETO");
				response.setMotivoEstado("RESERVA PENDIENTE DE CONFIRMAR");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}

	public void realizarReserva(final Exchange exchange) throws DatatypeConfigurationException, InterruptedException, ParseException {
		RealizarReserva datos = exchange.getIn().getBody(RealizarReserva.class);
		String filename = "reservar_" + (new Date()).getTime();
		boolean success = false;
		RealizarReservaResponse response = new RealizarReservaResponse();
		StringBuilder datosReserva = new StringBuilder();
		datosReserva.append(Utils.parseDateString(datos.getFechaInicio().toGregorianCalendar().getTime(), "ddMMyyyyHH00"));
		datosReserva.append(StringUtils.rightPad(datos.getCiudadOrigen(), 21," "));
		datosReserva.append(StringUtils.rightPad(datos.getCiudadDestino(), 21," "));
		datosReserva.append(datos.getPuestos());
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datosReserva.toString()), filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE EXPRESO BOLIVARIANO");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setIdReserva(rsta.substring(0, 9).trim());
				response.setIdViaje(rsta.substring(9, 18).trim());
				response.setFechaSalida(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(18, 30), "ddMMyyyyHHmm")));
				response.setCiudadOrigen(rsta.substring(31, 51).trim());
				response.setCiudadDestino(rsta.substring(51, 72).trim());
				response.setPuestos(rsta.substring(72, rsta.length()).trim());
				response.setEstado("COMPLETO");
				response.setMotivoEstado("RESERVA PENDIENTE DE CONFIRMAR");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}

	
}
