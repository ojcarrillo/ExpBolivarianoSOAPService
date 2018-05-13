package co.com.javeriana.soap.integracion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utils {
	
	public static XMLGregorianCalendar getFechaEvento() {
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(new Date());
		try {
			XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			return xgcal;
		} catch (DatatypeConfigurationException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public static XMLGregorianCalendar getFechaEvento(Date date) {
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(date);
		try {
			XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			return xgcal;
		} catch (DatatypeConfigurationException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public static Date parseStringDate(String fecha,String formato) throws ParseException {
		SimpleDateFormat formatoDate = new SimpleDateFormat(formato);
		return formatoDate.parse(fecha);
	}
	
	public static String parseDateString(Date fecha,String formato) throws ParseException {
		SimpleDateFormat formatoDate = new SimpleDateFormat(formato);
		return formatoDate.format(fecha);
	}

}
