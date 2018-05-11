
package org.example.demo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itinerarios" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idViaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                   &lt;element name="ciudadOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="ciudadDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="puestos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itinerarios"
})
@XmlRootElement(name = "consultarItinerariosResponse")
public class ConsultarItinerariosResponse {

    @XmlElement(required = true)
    protected List<ConsultarItinerariosResponse.Itinerarios> itinerarios;

    /**
     * Gets the value of the itinerarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itinerarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItinerarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultarItinerariosResponse.Itinerarios }
     * 
     * 
     */
    public List<ConsultarItinerariosResponse.Itinerarios> getItinerarios() {
        if (itinerarios == null) {
            itinerarios = new ArrayList<ConsultarItinerariosResponse.Itinerarios>();
        }
        return this.itinerarios;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="idViaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="ciudadOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="ciudadDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="puestos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idViaje",
        "fechaSalida",
        "ciudadOrigen",
        "ciudadDestino",
        "puestos"
    })
    public static class Itinerarios {

        protected String idViaje;
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fechaSalida;
        protected String ciudadOrigen;
        protected String ciudadDestino;
        protected String puestos;

        /**
         * Obtiene el valor de la propiedad idViaje.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdViaje() {
            return idViaje;
        }

        /**
         * Define el valor de la propiedad idViaje.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdViaje(String value) {
            this.idViaje = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaSalida.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFechaSalida() {
            return fechaSalida;
        }

        /**
         * Define el valor de la propiedad fechaSalida.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFechaSalida(XMLGregorianCalendar value) {
            this.fechaSalida = value;
        }

        /**
         * Obtiene el valor de la propiedad ciudadOrigen.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCiudadOrigen() {
            return ciudadOrigen;
        }

        /**
         * Define el valor de la propiedad ciudadOrigen.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCiudadOrigen(String value) {
            this.ciudadOrigen = value;
        }

        /**
         * Obtiene el valor de la propiedad ciudadDestino.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCiudadDestino() {
            return ciudadDestino;
        }

        /**
         * Define el valor de la propiedad ciudadDestino.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCiudadDestino(String value) {
            this.ciudadDestino = value;
        }

        /**
         * Obtiene el valor de la propiedad puestos.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuestos() {
            return puestos;
        }

        /**
         * Define el valor de la propiedad puestos.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuestos(String value) {
            this.puestos = value;
        }

    }

}
