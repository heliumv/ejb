/*******************************************************************************
 * HELIUM V, Open Source ERP software for sustained success
 * at small and medium-sized enterprises.
 * Copyright (C) 2004 - 2015 HELIUM V IT-Solutions GmbH
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published 
 * by the Free Software Foundation, either version 3 of theLicense, or 
 * (at your option) any later version.
 * 
 * According to sec. 7 of the GNU Affero General Public License, version 3, 
 * the terms of the AGPL are supplemented with the following terms:
 * 
 * "HELIUM V" and "HELIUM 5" are registered trademarks of 
 * HELIUM V IT-Solutions GmbH. The licensing of the program under the 
 * AGPL does not imply a trademark license. Therefore any rights, title and
 * interest in our trademarks remain entirely with us. If you want to propagate
 * modified versions of the Program under the name "HELIUM V" or "HELIUM 5",
 * you may only do so if you have a written permission by HELIUM V IT-Solutions 
 * GmbH (to acquire a permission please contact HELIUM V IT-Solutions
 * at trademark@heliumv.com).
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contact: developers@heliumv.com
 ******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.30 at 04:44:14 PM MEZ 
//


package com.lp.server.schema.bmecat_2005;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ORDER_UNIT"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}CONTENT_UNIT"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}NO_CU_PER_OU" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_PIDREF" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRICE_QUANTITY" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}QUANTITY_MIN" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}QUANTITY_INTERVAL" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}QUANTITY_MAX" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PACKING_UNITS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orderunit",
    "contentunit",
    "nocuperou",
    "supplierpidref",
    "supplieridref",
    "pricequantity",
    "quantitymin",
    "quantityinterval",
    "quantitymax",
    "packingunits"
})
@XmlRootElement(name = "PRODUCT_ORDER_DETAILS")
public class BCPRODUCTORDERDETAILS {

    @XmlElement(name = "ORDER_UNIT", required = true)
    protected String orderunit;
    @XmlElement(name = "CONTENT_UNIT")
    protected String contentunit;
    @XmlElement(name = "NO_CU_PER_OU", defaultValue = "1")
    protected BigDecimal nocuperou;
    @XmlElement(name = "SUPPLIER_PIDREF")
    protected String supplierpidref;
    @XmlElement(name = "SUPPLIER_IDREF")
    protected TypePARTYID supplieridref;
    @XmlElement(name = "PRICE_QUANTITY", defaultValue = "1")
    protected BigDecimal pricequantity;
    @XmlElement(name = "QUANTITY_MIN", defaultValue = "1")
    protected Float quantitymin;
    @XmlElement(name = "QUANTITY_INTERVAL", defaultValue = "1")
    protected Float quantityinterval;
    @XmlElement(name = "QUANTITY_MAX")
    protected Float quantitymax;
    @XmlElement(name = "PACKING_UNITS")
    protected BCPACKINGUNITS packingunits;

    /**
     * Gets the value of the orderunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERUNIT() {
        return orderunit;
    }

    /**
     * Sets the value of the orderunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERUNIT(String value) {
        this.orderunit = value;
    }

    /**
     * Gets the value of the contentunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENTUNIT() {
        return contentunit;
    }

    /**
     * Sets the value of the contentunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENTUNIT(String value) {
        this.contentunit = value;
    }

    /**
     * Gets the value of the nocuperou property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNOCUPEROU() {
        return nocuperou;
    }

    /**
     * Sets the value of the nocuperou property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNOCUPEROU(BigDecimal value) {
        this.nocuperou = value;
    }

    /**
     * Gets the value of the supplierpidref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUPPLIERPIDREF() {
        return supplierpidref;
    }

    /**
     * Sets the value of the supplierpidref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUPPLIERPIDREF(String value) {
        this.supplierpidref = value;
    }

    /**
     * Gets the value of the supplieridref property.
     * 
     * @return
     *     possible object is
     *     {@link TypePARTYID }
     *     
     */
    public TypePARTYID getSUPPLIERIDREF() {
        return supplieridref;
    }

    /**
     * Sets the value of the supplieridref property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypePARTYID }
     *     
     */
    public void setSUPPLIERIDREF(TypePARTYID value) {
        this.supplieridref = value;
    }

    /**
     * Gets the value of the pricequantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRICEQUANTITY() {
        return pricequantity;
    }

    /**
     * Sets the value of the pricequantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRICEQUANTITY(BigDecimal value) {
        this.pricequantity = value;
    }

    /**
     * Gets the value of the quantitymin property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQUANTITYMIN() {
        return quantitymin;
    }

    /**
     * Sets the value of the quantitymin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQUANTITYMIN(Float value) {
        this.quantitymin = value;
    }

    /**
     * Gets the value of the quantityinterval property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQUANTITYINTERVAL() {
        return quantityinterval;
    }

    /**
     * Sets the value of the quantityinterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQUANTITYINTERVAL(Float value) {
        this.quantityinterval = value;
    }

    /**
     * Gets the value of the quantitymax property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getQUANTITYMAX() {
        return quantitymax;
    }

    /**
     * Sets the value of the quantitymax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setQUANTITYMAX(Float value) {
        this.quantitymax = value;
    }

    /**
     * Gets the value of the packingunits property.
     * 
     * @return
     *     possible object is
     *     {@link BCPACKINGUNITS }
     *     
     */
    public BCPACKINGUNITS getPACKINGUNITS() {
        return packingunits;
    }

    /**
     * Sets the value of the packingunits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCPACKINGUNITS }
     *     
     */
    public void setPACKINGUNITS(BCPACKINGUNITS value) {
        this.packingunits = value;
    }

}
