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
// Generated on: 2012.12.03 at 10:12:07 AM MEZ 
//


package com.lp.server.schema.opentrans.cc.orderresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for _XML_XML_PACKAGE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="_XML_XML_PACKAGE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}PACKAGE_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}PACKAGE_DESCR" minOccurs="0"/>
 *         &lt;element ref="{http://www.opentrans.org/XMLSchema/1.0}PACKAGE_DIMENSIONS" minOccurs="0"/>
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
@XmlType(name = "_XML_XML_PACKAGE", propOrder = {
    "packageid",
    "packagedescr",
    "packagedimensions"
})
public class XMLXMLPACKAGE {

    @XmlElement(name = "PACKAGE_ID")
    protected XMLXMLPACKAGEID packageid;
    @XmlElement(name = "PACKAGE_DESCR")
    protected String packagedescr;
    @XmlElement(name = "PACKAGE_DIMENSIONS")
    protected XMLXMLPACKAGEDIMENSIONS packagedimensions;
    @XmlAttribute(name = "xsi_schemaLocation")
    protected String xsiSchemaLocation;
    @XmlAttribute(name = "xmlns_xsd")
    protected String xmlnsXsd;

    /**
     * Gets the value of the packageid property.
     * 
     * @return
     *     possible object is
     *     {@link XMLXMLPACKAGEID }
     *     
     */
    public XMLXMLPACKAGEID getPACKAGEID() {
        return packageid;
    }

    /**
     * Sets the value of the packageid property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLXMLPACKAGEID }
     *     
     */
    public void setPACKAGEID(XMLXMLPACKAGEID value) {
        this.packageid = value;
    }

    /**
     * Gets the value of the packagedescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPACKAGEDESCR() {
        return packagedescr;
    }

    /**
     * Sets the value of the packagedescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPACKAGEDESCR(String value) {
        this.packagedescr = value;
    }

    /**
     * Gets the value of the packagedimensions property.
     * 
     * @return
     *     possible object is
     *     {@link XMLXMLPACKAGEDIMENSIONS }
     *     
     */
    public XMLXMLPACKAGEDIMENSIONS getPACKAGEDIMENSIONS() {
        return packagedimensions;
    }

    /**
     * Sets the value of the packagedimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLXMLPACKAGEDIMENSIONS }
     *     
     */
    public void setPACKAGEDIMENSIONS(XMLXMLPACKAGEDIMENSIONS value) {
        this.packagedimensions = value;
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
