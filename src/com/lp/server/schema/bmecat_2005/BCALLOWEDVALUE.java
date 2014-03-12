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


package com.lp.server.schema.bmecat_2005;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_ID"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_NAME" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_VERSION" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_SHORTNAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_SYNONYMS" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ALLOWED_VALUE_SOURCE" minOccurs="0"/>
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
    "allowedvalueid",
    "allowedvaluename",
    "allowedvalueversion",
    "allowedvalueshortname",
    "allowedvaluedescr",
    "allowedvaluesynonyms",
    "allowedvaluesource"
})
@XmlRootElement(name = "ALLOWED_VALUE")
public class BCALLOWEDVALUE {

    @XmlElement(name = "ALLOWED_VALUE_ID", required = true)
    protected String allowedvalueid;
    @XmlElement(name = "ALLOWED_VALUE_NAME", required = true)
    protected List<BCALLOWEDVALUENAME> allowedvaluename;
    @XmlElement(name = "ALLOWED_VALUE_VERSION")
    protected TypeVERSION allowedvalueversion;
    @XmlElement(name = "ALLOWED_VALUE_SHORTNAME")
    protected List<BCALLOWEDVALUESHORTNAME> allowedvalueshortname;
    @XmlElement(name = "ALLOWED_VALUE_DESCR")
    protected List<BCALLOWEDVALUEDESCR> allowedvaluedescr;
    @XmlElement(name = "ALLOWED_VALUE_SYNONYMS")
    protected BCALLOWEDVALUESYNONYMS allowedvaluesynonyms;
    @XmlElement(name = "ALLOWED_VALUE_SOURCE")
    protected TypeSOURCE allowedvaluesource;

    /**
     * Gets the value of the allowedvalueid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALLOWEDVALUEID() {
        return allowedvalueid;
    }

    /**
     * Sets the value of the allowedvalueid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALLOWEDVALUEID(String value) {
        this.allowedvalueid = value;
    }

    /**
     * Gets the value of the allowedvaluename property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedvaluename property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getALLOWEDVALUENAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCALLOWEDVALUENAME }
     * 
     * 
     */
    public List<BCALLOWEDVALUENAME> getALLOWEDVALUENAME() {
        if (allowedvaluename == null) {
            allowedvaluename = new ArrayList<BCALLOWEDVALUENAME>();
        }
        return this.allowedvaluename;
    }

    /**
     * Gets the value of the allowedvalueversion property.
     * 
     * @return
     *     possible object is
     *     {@link TypeVERSION }
     *     
     */
    public TypeVERSION getALLOWEDVALUEVERSION() {
        return allowedvalueversion;
    }

    /**
     * Sets the value of the allowedvalueversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeVERSION }
     *     
     */
    public void setALLOWEDVALUEVERSION(TypeVERSION value) {
        this.allowedvalueversion = value;
    }

    /**
     * Gets the value of the allowedvalueshortname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedvalueshortname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getALLOWEDVALUESHORTNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCALLOWEDVALUESHORTNAME }
     * 
     * 
     */
    public List<BCALLOWEDVALUESHORTNAME> getALLOWEDVALUESHORTNAME() {
        if (allowedvalueshortname == null) {
            allowedvalueshortname = new ArrayList<BCALLOWEDVALUESHORTNAME>();
        }
        return this.allowedvalueshortname;
    }

    /**
     * Gets the value of the allowedvaluedescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedvaluedescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getALLOWEDVALUEDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCALLOWEDVALUEDESCR }
     * 
     * 
     */
    public List<BCALLOWEDVALUEDESCR> getALLOWEDVALUEDESCR() {
        if (allowedvaluedescr == null) {
            allowedvaluedescr = new ArrayList<BCALLOWEDVALUEDESCR>();
        }
        return this.allowedvaluedescr;
    }

    /**
     * Gets the value of the allowedvaluesynonyms property.
     * 
     * @return
     *     possible object is
     *     {@link BCALLOWEDVALUESYNONYMS }
     *     
     */
    public BCALLOWEDVALUESYNONYMS getALLOWEDVALUESYNONYMS() {
        return allowedvaluesynonyms;
    }

    /**
     * Sets the value of the allowedvaluesynonyms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCALLOWEDVALUESYNONYMS }
     *     
     */
    public void setALLOWEDVALUESYNONYMS(BCALLOWEDVALUESYNONYMS value) {
        this.allowedvaluesynonyms = value;
    }

    /**
     * Gets the value of the allowedvaluesource property.
     * 
     * @return
     *     possible object is
     *     {@link TypeSOURCE }
     *     
     */
    public TypeSOURCE getALLOWEDVALUESOURCE() {
        return allowedvaluesource;
    }

    /**
     * Sets the value of the allowedvaluesource property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeSOURCE }
     *     
     */
    public void setALLOWEDVALUESOURCE(TypeSOURCE value) {
        this.allowedvaluesource = value;
    }

}