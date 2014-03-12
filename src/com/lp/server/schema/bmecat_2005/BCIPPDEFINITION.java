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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}IPP_ID"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}IPP_TYPE"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}IPP_OPERATOR_IDREF" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}IPP_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}IPP_OPERATION" maxOccurs="unbounded"/>
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
    "ippid",
    "ipptype",
    "ippoperatoridref",
    "ippdescr",
    "ippoperation"
})
@XmlRootElement(name = "IPP_DEFINITION")
public class BCIPPDEFINITION {

    @XmlElement(name = "IPP_ID", required = true)
    protected String ippid;
    @XmlElement(name = "IPP_TYPE", required = true)
    protected String ipptype;
    @XmlElement(name = "IPP_OPERATOR_IDREF")
    protected TypePARTYID ippoperatoridref;
    @XmlElement(name = "IPP_DESCR")
    protected List<BCIPPDESCR> ippdescr;
    @XmlElement(name = "IPP_OPERATION", required = true)
    protected List<BCIPPOPERATION> ippoperation;

    /**
     * Gets the value of the ippid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPPID() {
        return ippid;
    }

    /**
     * Sets the value of the ippid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPPID(String value) {
        this.ippid = value;
    }

    /**
     * Gets the value of the ipptype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPPTYPE() {
        return ipptype;
    }

    /**
     * Sets the value of the ipptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPPTYPE(String value) {
        this.ipptype = value;
    }

    /**
     * Gets the value of the ippoperatoridref property.
     * 
     * @return
     *     possible object is
     *     {@link TypePARTYID }
     *     
     */
    public TypePARTYID getIPPOPERATORIDREF() {
        return ippoperatoridref;
    }

    /**
     * Sets the value of the ippoperatoridref property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypePARTYID }
     *     
     */
    public void setIPPOPERATORIDREF(TypePARTYID value) {
        this.ippoperatoridref = value;
    }

    /**
     * Gets the value of the ippdescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ippdescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPPDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCIPPDESCR }
     * 
     * 
     */
    public List<BCIPPDESCR> getIPPDESCR() {
        if (ippdescr == null) {
            ippdescr = new ArrayList<BCIPPDESCR>();
        }
        return this.ippdescr;
    }

    /**
     * Gets the value of the ippoperation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ippoperation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPPOPERATION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCIPPOPERATION }
     * 
     * 
     */
    public List<BCIPPOPERATION> getIPPOPERATION() {
        if (ippoperation == null) {
            ippoperation = new ArrayList<BCIPPOPERATION>();
        }
        return this.ippoperation;
    }

}
