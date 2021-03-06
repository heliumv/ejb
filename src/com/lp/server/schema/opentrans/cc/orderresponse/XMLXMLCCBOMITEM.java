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
// Generated on: 2012.12.03 at 10:12:07 AM MEZ 
//


package com.lp.server.schema.opentrans.cc.orderresponse;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for _XML_XML_CC_BOM_ITEM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="_XML_XML_CC_BOM_ITEM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_CUST_POS_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_LEVEL" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_COMPONENT" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_SDESC" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_QTY" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}CC_BOM_UNIT" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentrans.org/XMLSchema/1.0}ComIbmMrmNamespaceInfo154"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_XML_XML_CC_BOM_ITEM", propOrder = {
    "ccbomcustposid",
    "ccbomlevel",
    "ccbomcomponent",
    "ccbomsdesc",
    "ccbomqty",
    "ccbomunit"
})
public class XMLXMLCCBOMITEM {

    @XmlElement(name = "CC_BOM_CUST_POS_ID")
    protected String ccbomcustposid;
    @XmlElement(name = "CC_BOM_LEVEL")
    protected String ccbomlevel;
    @XmlElement(name = "CC_BOM_COMPONENT")
    protected String ccbomcomponent;
    @XmlElement(name = "CC_BOM_SDESC")
    protected String ccbomsdesc;
    @XmlElement(name = "CC_BOM_QTY")
    protected BigDecimal ccbomqty;
    @XmlElement(name = "CC_BOM_UNIT")
    protected String ccbomunit;
    @XmlAttribute(name = "xsi_schemaLocation")
    protected String xsiSchemaLocation;
    @XmlAttribute(name = "xmlns_xsd")
    protected String xmlnsXsd;

    /**
     * Gets the value of the ccbomcustposid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCBOMCUSTPOSID() {
        return ccbomcustposid;
    }

    /**
     * Sets the value of the ccbomcustposid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCBOMCUSTPOSID(String value) {
        this.ccbomcustposid = value;
    }

    /**
     * Gets the value of the ccbomlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCBOMLEVEL() {
        return ccbomlevel;
    }

    /**
     * Sets the value of the ccbomlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCBOMLEVEL(String value) {
        this.ccbomlevel = value;
    }

    /**
     * Gets the value of the ccbomcomponent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCBOMCOMPONENT() {
        return ccbomcomponent;
    }

    /**
     * Sets the value of the ccbomcomponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCBOMCOMPONENT(String value) {
        this.ccbomcomponent = value;
    }

    /**
     * Gets the value of the ccbomsdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCBOMSDESC() {
        return ccbomsdesc;
    }

    /**
     * Sets the value of the ccbomsdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCBOMSDESC(String value) {
        this.ccbomsdesc = value;
    }

    /**
     * Gets the value of the ccbomqty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCCBOMQTY() {
        return ccbomqty;
    }

    /**
     * Sets the value of the ccbomqty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCCBOMQTY(BigDecimal value) {
        this.ccbomqty = value;
    }

    /**
     * Gets the value of the ccbomunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCBOMUNIT() {
        return ccbomunit;
    }

    /**
     * Sets the value of the ccbomunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCBOMUNIT(String value) {
        this.ccbomunit = value;
    }

    /**
     * Gets the value of the xsiSchemaLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsiSchemaLocation() {
        if (xsiSchemaLocation == null) {
            return "openbase_1_0.mxsd";
        } else {
            return xsiSchemaLocation;
        }
    }

    /**
     * Sets the value of the xsiSchemaLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsiSchemaLocation(String value) {
        this.xsiSchemaLocation = value;
    }

    /**
     * Gets the value of the xmlnsXsd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlnsXsd() {
        if (xmlnsXsd == null) {
            return "http://www.w3.org/2001/XMLSchema";
        } else {
            return xmlnsXsd;
        }
    }

    /**
     * Sets the value of the xmlnsXsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlnsXsd(String value) {
        this.xmlnsXsd = value;
    }

}
