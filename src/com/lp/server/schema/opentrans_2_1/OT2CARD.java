/*******************************************************************************
 * HELIUM V, Open Source ERP software for sustained success
 * at small and medium-sized enterprises.
 * Copyright (C) 2004 - 2014 HELIUM V IT-Solutions GmbH
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


package com.lp.server.schema.opentrans_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}CARD_NUM"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}CARD_AUTH_CODE" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}CARD_REF_NUM" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}CARD_EXPIRATION_DATE"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}CARD_HOLDER_NAME"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *             &lt;pattern value="MasterCard|VISA|AmericanExpress|DinersClub|JCB|Maestro|DiscoverCard|Transcard|DinaCard|ChinaUnionPay|\w{1,50}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardnum",
    "cardauthcode",
    "cardrefnum",
    "cardexpirationdate",
    "cardholdername"
})
@XmlRootElement(name = "CARD")
public class OT2CARD {

    @XmlElement(name = "CARD_NUM", required = true)
    protected String cardnum;
    @XmlElement(name = "CARD_AUTH_CODE")
    protected String cardauthcode;
    @XmlElement(name = "CARD_REF_NUM")
    protected String cardrefnum;
    @XmlElement(name = "CARD_EXPIRATION_DATE", required = true)
    protected String cardexpirationdate;
    @XmlElement(name = "CARD_HOLDER_NAME", required = true)
    protected String cardholdername;
    @XmlAttribute(required = true)
    protected String type;

    /**
     * Gets the value of the cardnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDNUM() {
        return cardnum;
    }

    /**
     * Sets the value of the cardnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDNUM(String value) {
        this.cardnum = value;
    }

    /**
     * Gets the value of the cardauthcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDAUTHCODE() {
        return cardauthcode;
    }

    /**
     * Sets the value of the cardauthcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDAUTHCODE(String value) {
        this.cardauthcode = value;
    }

    /**
     * Gets the value of the cardrefnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDREFNUM() {
        return cardrefnum;
    }

    /**
     * Sets the value of the cardrefnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDREFNUM(String value) {
        this.cardrefnum = value;
    }

    /**
     * Gets the value of the cardexpirationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDEXPIRATIONDATE() {
        return cardexpirationdate;
    }

    /**
     * Sets the value of the cardexpirationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDEXPIRATIONDATE(String value) {
        this.cardexpirationdate = value;
    }

    /**
     * Gets the value of the cardholdername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDHOLDERNAME() {
        return cardholdername;
    }

    /**
     * Sets the value of the cardholdername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDHOLDERNAME(String value) {
        this.cardholdername = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
