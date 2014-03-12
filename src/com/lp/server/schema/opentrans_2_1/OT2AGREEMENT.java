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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}AGREEMENT_ID"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}AGREEMENT_LINE_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}AGREEMENT_START_DATE" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}AGREEMENT_END_DATE"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}AGREEMENT_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/2.1}MIME_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *             &lt;pattern value="buyer|supplier|\w{1,50}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="default" type="{http://www.opentrans.org/XMLSchema/2.1}dtBOOLEAN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "agreementid",
    "agreementlineid",
    "agreementstartdate",
    "agreementenddate",
    "supplieridref",
    "agreementdescr",
    "mimeinfo"
})
@XmlRootElement(name = "AGREEMENT")
public class OT2AGREEMENT {

    @XmlElement(name = "AGREEMENT_ID", namespace = "http://www.bmecat.org/bmecat/2005", required = true)
    protected String agreementid;
    @XmlElement(name = "AGREEMENT_LINE_ID", namespace = "http://www.bmecat.org/bmecat/2005")
    protected String agreementlineid;
    @XmlElement(name = "AGREEMENT_START_DATE", namespace = "http://www.bmecat.org/bmecat/2005")
    protected String agreementstartdate;
    @XmlElement(name = "AGREEMENT_END_DATE", namespace = "http://www.bmecat.org/bmecat/2005", required = true)
    protected String agreementenddate;
    @XmlElement(name = "SUPPLIER_IDREF", namespace = "http://www.bmecat.org/bmecat/2005")
    protected TypePARTYID supplieridref;
    @XmlElement(name = "AGREEMENT_DESCR")
    protected List<OT2AGREEMENTDESCR> agreementdescr;
    @XmlElement(name = "MIME_INFO")
    protected OT2MIMEINFO mimeinfo;
    @XmlAttribute
    protected String type;
    @XmlAttribute(name = "default")
    protected String _default;

    /**
     * Gets the value of the agreementid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGREEMENTID() {
        return agreementid;
    }

    /**
     * Sets the value of the agreementid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGREEMENTID(String value) {
        this.agreementid = value;
    }

    /**
     * Gets the value of the agreementlineid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGREEMENTLINEID() {
        return agreementlineid;
    }

    /**
     * Sets the value of the agreementlineid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGREEMENTLINEID(String value) {
        this.agreementlineid = value;
    }

    /**
     * Gets the value of the agreementstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGREEMENTSTARTDATE() {
        return agreementstartdate;
    }

    /**
     * Sets the value of the agreementstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGREEMENTSTARTDATE(String value) {
        this.agreementstartdate = value;
    }

    /**
     * Gets the value of the agreementenddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGREEMENTENDDATE() {
        return agreementenddate;
    }

    /**
     * Sets the value of the agreementenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGREEMENTENDDATE(String value) {
        this.agreementenddate = value;
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
     * Gets the value of the agreementdescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agreementdescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAGREEMENTDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OT2AGREEMENTDESCR }
     * 
     * 
     */
    public List<OT2AGREEMENTDESCR> getAGREEMENTDESCR() {
        if (agreementdescr == null) {
            agreementdescr = new ArrayList<OT2AGREEMENTDESCR>();
        }
        return this.agreementdescr;
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

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefault(String value) {
        this._default = value;
    }

}
