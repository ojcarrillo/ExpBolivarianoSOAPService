package co.com.javeriana.soap.integracion.ExpBolivarianoSOAPService;

import java.io.IOException;

import org.apache.camel.Exchange;
import org.example.demo.CancelarReserva;
import org.example.demo.ObtenerReserva;
import org.example.demo.RealizarReserva;
import org.example.demo.RealizarReservaResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class SoapService {

	public void cancelarReserva(final Exchange exchange) {
		CancelarReserva datos = exchange.getIn().getBody(CancelarReserva.class);
		String serviceURL = "http://35.203.93.92:9092/cancelarReserva/" + datos.getIdReserva();
		String method = "POST";
		String accept = "application/xml";
		String response = ""; //RestInvoker.invokeService(serviceURL, method, accept, datos.getIdReserva());
		exchange.getOut().setBody(response);
	}

	public void obtenerReserva(final Exchange exchange) {
		ObtenerReserva datos = exchange.getIn().getBody(ObtenerReserva.class);
		String serviceURL = "http://35.203.93.92:9092/obtenerReserva/" + datos.getIdReserva();
		String method = "GET";
		String accept = "application/xml";
		String response = ""; //RestInvoker.invokeService(serviceURL, method, accept, datos.getIdReserva());
		exchange.getOut().setBody(response);
	}

	public void realizarReserva(final Exchange exchange) {
		RealizarReserva datos = exchange.getIn().getBody(RealizarReserva.class);
		String serviceURL = "http://35.203.93.92:9092/realizarReserva/";
		String method = "POST";
		String accept = "application/json";
//			ObjectMapper mapper = new ObjectMapper();
//			String jsonInString = mapper.writeValueAsString(datos);
//			jsonInString = jsonInString.split("residentes")[0];
//			String listaPersonas = mapper.writeValueAsString(datos.getResidentes());
//			listaPersonas = listaPersonas.split("persona")[1];
//			String response = RestInvoker.invokeService(serviceURL, method, accept, jsonInString+"residentes"+listaPersonas+"}");
//			RealizarReservaResponse rta = mapper.readValue(response, RealizarReservaResponse.class);
		exchange.getOut().setBody("");
	}
}
