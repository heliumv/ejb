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


package com.lp.server.schema.opentrans_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lp.server.schema.bmecat_2005.TypePARTYID;


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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PARTY_ID" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}PARTY_ROLE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}ADDRESS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}ACCOUNT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}MIME_INFO" minOccurs="0"/>
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
    "partyid",
    "partyrole",
    "address",
    "account",
    "mimeinfo"
})
@XmlRootElement(name = "PARTY")
public class OT2PARTY {

    @XmlElement(name = "PARTY_ID", namespace = "http://www.bmecat.org/bmecat/2005", required = true)
    protected List<TypePARTYID> partyid;
    @XmlElement(name = "PARTY_ROLE")
    protected List<String> partyrole;
    @XmlElement(name = "ADDRESS")
    protected List<OT2ADDRESS> address;
    @XmlElement(name = "ACCOUNT")
    protected List<OT2ACCOUNT> account;
    @XmlElement(name = "MIME_INFO")
    protected OT2MIMEINFO mimeinfo;

    /**
     * Gets the value of the partyid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARTYID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypePARTYID }
     * 
     * 
     */
    public List<TypePARTYID> getPARTYID() {
        if (partyid == null) {
            partyid = new ArrayList<TypePARTYID>();
        }
        return this.partyid;
    }

    /**
     * Gets the value of the partyrole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyrole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARTYROLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPARTYROLE() {
        if (partyrole == null) {
            partyrole = new ArrayList<String>();
        }
        return this.partyrole;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getADDRESS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OT2ADDRESS }
     * 
     * 
     */
    public List<OT2ADDRESS> getADDRESS() {
        if (address == null) {
            address = new ArrayList<OT2ADDRESS>();
        }
        return this.address;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACCOUNT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OT2ACCOUNT }
     * 
     * 
     */
    public List<OT2ACCOUNT> getACCOUNT() {
        if (account == null) {
            account = new ArrayList<OT2ACCOUNT>();
        }
        return this.account;
    }

    /**
     * Gets the value of the mimeinfo property.
     * 
     * @return
     *     possible object is
     *     {@link OT2MIMEINFO }
     *     
     */
    public OT2MIMEINFO getMIMEINFO() {
        return mimeinfo;
    }

    /**
     * Sets the value of the mimeinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OT2MIMEINFO }
     *     
     */
    public void setMIMEINFO(OT2MIMEINFO value) {
        this.mimeinfo = value;
    }

}
