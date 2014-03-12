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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeFTEMPLATE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeFTEMPLATE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_ID"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_NAME" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_SHORTNAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_VERSION" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_GROUP_IDREF" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_GROUP_NAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FT_DEPENDENCIES" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FEATURE_CONTENT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeFTEMPLATE", propOrder = {
    "ftid",
    "ftname",
    "ftshortname",
    "ftdescr",
    "ftversion",
    "ftgroupidref",
    "ftgroupname",
    "ftdependencies",
    "featurecontent"
})
public class TypeFTEMPLATE {

    @XmlElement(name = "FT_ID", required = true)
    protected String ftid;
    @XmlElement(name = "FT_NAME", required = true)
    protected List<BCFTNAME> ftname;
    @XmlElement(name = "FT_SHORTNAME")
    protected List<BCFTSHORTNAME> ftshortname;
    @XmlElement(name = "FT_DESCR")
    protected List<BCFTDESCR> ftdescr;
    @XmlElement(name = "FT_VERSION")
    protected TypeVERSION ftversion;
    @XmlElement(name = "FT_GROUP_IDREF")
    protected String ftgroupidref;
    @XmlElement(name = "FT_GROUP_NAME")
    protected List<BCFTGROUPNAME> ftgroupname;
    @XmlElement(name = "FT_DEPENDENCIES")
    protected BCFTDEPENDENCIES ftdependencies;
    @XmlElement(name = "FEATURE_CONTENT")
    protected BCFEATURECONTENT featurecontent;

    /**
     * Gets the value of the ftid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTID() {
        return ftid;
    }

    /**
     * Sets the value of the ftid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTID(String value) {
        this.ftid = value;
    }

    /**
     * Gets the value of the ftname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFTNAME }
     * 
     * 
     */
    public List<BCFTNAME> getFTNAME() {
        if (ftname == null) {
            ftname = new ArrayList<BCFTNAME>();
        }
        return this.ftname;
    }

    /**
     * Gets the value of the ftshortname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftshortname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTSHORTNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFTSHORTNAME }
     * 
     * 
     */
    public List<BCFTSHORTNAME> getFTSHORTNAME() {
        if (ftshortname == null) {
            ftshortname = new ArrayList<BCFTSHORTNAME>();
        }
        return this.ftshortname;
    }

    /**
     * Gets the value of the ftdescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftdescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFTDESCR }
     * 
     * 
     */
    public List<BCFTDESCR> getFTDESCR() {
        if (ftdescr == null) {
            ftdescr = new ArrayList<BCFTDESCR>();
        }
        return this.ftdescr;
    }

    /**
     * Gets the value of the ftversion property.
     * 
     * @return
     *     possible object is
     *     {@link TypeVERSION }
     *     
     */
    public TypeVERSION getFTVERSION() {
        return ftversion;
    }

    /**
     * Sets the value of the ftversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeVERSION }
     *     
     */
    public void setFTVERSION(TypeVERSION value) {
        this.ftversion = value;
    }

    /**
     * Gets the value of the ftgroupidref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTGROUPIDREF() {
        return ftgroupidref;
    }

    /**
     * Sets the value of the ftgroupidref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTGROUPIDREF(String value) {
        this.ftgroupidref = value;
    }

    /**
     * Gets the value of the ftgroupname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftgroupname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFTGROUPNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFTGROUPNAME }
     * 
     * 
     */
    public List<BCFTGROUPNAME> getFTGROUPNAME() {
        if (ftgroupname == null) {
            ftgroupname = new ArrayList<BCFTGROUPNAME>();
        }
        return this.ftgroupname;
    }

    /**
     * Gets the value of the ftdependencies property.
     * 
     * @return
     *     possible object is
     *     {@link BCFTDEPENDENCIES }
     *     
     */
    public BCFTDEPENDENCIES getFTDEPENDENCIES() {
        return ftdependencies;
    }

    /**
     * Sets the value of the ftdependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCFTDEPENDENCIES }
     *     
     */
    public void setFTDEPENDENCIES(BCFTDEPENDENCIES value) {
        this.ftdependencies = value;
    }

    /**
     * Gets the value of the featurecontent property.
     * 
     * @return
     *     possible object is
     *     {@link BCFEATURECONTENT }
     *     
     */
    public BCFEATURECONTENT getFEATURECONTENT() {
        return featurecontent;
    }

    /**
     * Sets the value of the featurecontent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCFEATURECONTENT }
     *     
     */
    public void setFEATURECONTENT(BCFEATURECONTENT value) {
        this.featurecontent = value;
    }

}
