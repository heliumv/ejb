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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_ID"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_ID2" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_VERSION" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_NAME" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_SHORTNAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_SOURCE" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_NOTE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_REMARK" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_CONTACTS" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_ORDER" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}MIME_INFO" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_SYNONYMS" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_FEATURE_TEMPLATES" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_PARENT_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CLASSIFICATION_GROUP_UDX" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="4"/>
 *             &lt;enumeration value="leaf"/>
 *             &lt;enumeration value="node"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="level" type="{http://www.bmecat.org/bmecat/2005}dtCOUNT" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "classificationgroupid",
    "classificationgroupid2",
    "classificationgroupversion",
    "classificationgroupname",
    "classificationgroupshortname",
    "classificationgroupdescr",
    "classificationgroupsource",
    "classificationgroupnote",
    "classificationgroupremark",
    "classificationgroupcontacts",
    "classificationgrouporder",
    "mimeinfo",
    "classificationgroupsynonyms",
    "classificationgroupfeaturetemplates",
    "classificationgroupparentid",
    "classificationgroupudx"
})
@XmlRootElement(name = "CLASSIFICATION_GROUP")
public class BCCLASSIFICATIONGROUP {

    @XmlElement(name = "CLASSIFICATION_GROUP_ID", required = true)
    protected TypeCLASSIFICATIONGROUPID classificationgroupid;
    @XmlElement(name = "CLASSIFICATION_GROUP_ID2")
    protected TypeCLASSIFICATIONGROUPID classificationgroupid2;
    @XmlElement(name = "CLASSIFICATION_GROUP_VERSION")
    protected TypeVERSION classificationgroupversion;
    @XmlElement(name = "CLASSIFICATION_GROUP_NAME", required = true)
    protected List<BCCLASSIFICATIONGROUPNAME> classificationgroupname;
    @XmlElement(name = "CLASSIFICATION_GROUP_SHORTNAME")
    protected List<BCCLASSIFICATIONGROUPSHORTNAME> classificationgroupshortname;
    @XmlElement(name = "CLASSIFICATION_GROUP_DESCR")
    protected List<BCCLASSIFICATIONGROUPDESCR> classificationgroupdescr;
    @XmlElement(name = "CLASSIFICATION_GROUP_SOURCE")
    protected TypeSOURCE classificationgroupsource;
    @XmlElement(name = "CLASSIFICATION_GROUP_NOTE")
    protected List<BCCLASSIFICATIONGROUPNOTE> classificationgroupnote;
    @XmlElement(name = "CLASSIFICATION_GROUP_REMARK")
    protected List<BCCLASSIFICATIONGROUPREMARK> classificationgroupremark;
    @XmlElement(name = "CLASSIFICATION_GROUP_CONTACTS")
    protected TypeCONTACTREF classificationgroupcontacts;
    @XmlElement(name = "CLASSIFICATION_GROUP_ORDER")
    protected BigInteger classificationgrouporder;
    @XmlElement(name = "MIME_INFO")
    protected BCMIMEINFO mimeinfo;
    @XmlElement(name = "CLASSIFICATION_GROUP_SYNONYMS")
    protected BCCLASSIFICATIONGROUPSYNONYMS classificationgroupsynonyms;
    @XmlElement(name = "CLASSIFICATION_GROUP_FEATURE_TEMPLATES")
    protected BCCLASSIFICATIONGROUPFEATURETEMPLATES classificationgroupfeaturetemplates;
    @XmlElement(name = "CLASSIFICATION_GROUP_PARENT_ID")
    protected String classificationgroupparentid;
    @XmlElement(name = "CLASSIFICATION_GROUP_UDX")
    protected UdxCLASSGROUP classificationgroupudx;
    @XmlAttribute
    protected String type;
    @XmlAttribute
    protected BigInteger level;

    /**
     * Gets the value of the classificationgroupid property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCLASSIFICATIONGROUPID }
     *     
     */
    public TypeCLASSIFICATIONGROUPID getCLASSIFICATIONGROUPID() {
        return classificationgroupid;
    }

    /**
     * Sets the value of the classificationgroupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCLASSIFICATIONGROUPID }
     *     
     */
    public void setCLASSIFICATIONGROUPID(TypeCLASSIFICATIONGROUPID value) {
        this.classificationgroupid = value;
    }

    /**
     * Gets the value of the classificationgroupid2 property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCLASSIFICATIONGROUPID }
     *     
     */
    public TypeCLASSIFICATIONGROUPID getCLASSIFICATIONGROUPID2() {
        return classificationgroupid2;
    }

    /**
     * Sets the value of the classificationgroupid2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCLASSIFICATIONGROUPID }
     *     
     */
    public void setCLASSIFICATIONGROUPID2(TypeCLASSIFICATIONGROUPID value) {
        this.classificationgroupid2 = value;
    }

    /**
     * Gets the value of the classificationgroupversion property.
     * 
     * @return
     *     possible object is
     *     {@link TypeVERSION }
     *     
     */
    public TypeVERSION getCLASSIFICATIONGROUPVERSION() {
        return classificationgroupversion;
    }

    /**
     * Sets the value of the classificationgroupversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeVERSION }
     *     
     */
    public void setCLASSIFICATIONGROUPVERSION(TypeVERSION value) {
        this.classificationgroupversion = value;
    }

    /**
     * Gets the value of the classificationgroupname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classificationgroupname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCLASSIFICATIONGROUPNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCLASSIFICATIONGROUPNAME }
     * 
     * 
     */
    public List<BCCLASSIFICATIONGROUPNAME> getCLASSIFICATIONGROUPNAME() {
        if (classificationgroupname == null) {
            classificationgroupname = new ArrayList<BCCLASSIFICATIONGROUPNAME>();
        }
        return this.classificationgroupname;
    }

    /**
     * Gets the value of the classificationgroupshortname property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classificationgroupshortname property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCLASSIFICATIONGROUPSHORTNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCLASSIFICATIONGROUPSHORTNAME }
     * 
     * 
     */
    public List<BCCLASSIFICATIONGROUPSHORTNAME> getCLASSIFICATIONGROUPSHORTNAME() {
        if (classificationgroupshortname == null) {
            classificationgroupshortname = new ArrayList<BCCLASSIFICATIONGROUPSHORTNAME>();
        }
        return this.classificationgroupshortname;
    }

    /**
     * Gets the value of the classificationgroupdescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classificationgroupdescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCLASSIFICATIONGROUPDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCLASSIFICATIONGROUPDESCR }
     * 
     * 
     */
    public List<BCCLASSIFICATIONGROUPDESCR> getCLASSIFICATIONGROUPDESCR() {
        if (classificationgroupdescr == null) {
            classificationgroupdescr = new ArrayList<BCCLASSIFICATIONGROUPDESCR>();
        }
        return this.classificationgroupdescr;
    }

    /**
     * Gets the value of the classificationgroupsource property.
     * 
     * @return
     *     possible object is
     *     {@link TypeSOURCE }
     *     
     */
    public TypeSOURCE getCLASSIFICATIONGROUPSOURCE() {
        return classificationgroupsource;
    }

    /**
     * Sets the value of the classificationgroupsource property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeSOURCE }
     *     
     */
    public void setCLASSIFICATIONGROUPSOURCE(TypeSOURCE value) {
        this.classificationgroupsource = value;
    }

    /**
     * Gets the value of the classificationgroupnote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classificationgroupnote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCLASSIFICATIONGROUPNOTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCLASSIFICATIONGROUPNOTE }
     * 
     * 
     */
    public List<BCCLASSIFICATIONGROUPNOTE> getCLASSIFICATIONGROUPNOTE() {
        if (classificationgroupnote == null) {
            classificationgroupnote = new ArrayList<BCCLASSIFICATIONGROUPNOTE>();
        }
        return this.classificationgroupnote;
    }

    /**
     * Gets the value of the classificationgroupremark property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classificationgroupremark property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCLASSIFICATIONGROUPREMARK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCLASSIFICATIONGROUPREMARK }
     * 
     * 
     */
    public List<BCCLASSIFICATIONGROUPREMARK> getCLASSIFICATIONGROUPREMARK() {
        if (classificationgroupremark == null) {
            classificationgroupremark = new ArrayList<BCCLASSIFICATIONGROUPREMARK>();
        }
        return this.classificationgroupremark;
    }

    /**
     * Gets the value of the classificationgroupcontacts property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCONTACTREF }
     *     
     */
    public TypeCONTACTREF getCLASSIFICATIONGROUPCONTACTS() {
        return classificationgroupcontacts;
    }

    /**
     * Sets the value of the classificationgroupcontacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCONTACTREF }
     *     
     */
    public void setCLASSIFICATIONGROUPCONTACTS(TypeCONTACTREF value) {
        this.classificationgroupcontacts = value;
    }

    /**
     * Gets the value of the classificationgrouporder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCLASSIFICATIONGROUPORDER() {
        return classificationgrouporder;
    }

    /**
     * Sets the value of the classificationgrouporder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCLASSIFICATIONGROUPORDER(BigInteger value) {
        this.classificationgrouporder = value;
    }

    /**
     * Gets the value of the mimeinfo property.
     * 
     * @return
     *     possible object is
     *     {@link BCMIMEINFO }
     *     
     */
    public BCMIMEINFO getMIMEINFO() {
        return mimeinfo;
    }

    /**
     * Sets the value of the mimeinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCMIMEINFO }
     *     
     */
    public void setMIMEINFO(BCMIMEINFO value) {
        this.mimeinfo = value;
    }

    /**
     * Gets the value of the classificationgroupsynonyms property.
     * 
     * @return
     *     possible object is
     *     {@link BCCLASSIFICATIONGROUPSYNONYMS }
     *     
     */
    public BCCLASSIFICATIONGROUPSYNONYMS getCLASSIFICATIONGROUPSYNONYMS() {
        return classificationgroupsynonyms;
    }

    /**
     * Sets the value of the classificationgroupsynonyms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCCLASSIFICATIONGROUPSYNONYMS }
     *     
     */
    public void setCLASSIFICATIONGROUPSYNONYMS(BCCLASSIFICATIONGROUPSYNONYMS value) {
        this.classificationgroupsynonyms = value;
    }

    /**
     * Gets the value of the classificationgroupfeaturetemplates property.
     * 
     * @return
     *     possible object is
     *     {@link BCCLASSIFICATIONGROUPFEATURETEMPLATES }
     *     
     */
    public BCCLASSIFICATIONGROUPFEATURETEMPLATES getCLASSIFICATIONGROUPFEATURETEMPLATES() {
        return classificationgroupfeaturetemplates;
    }

    /**
     * Sets the value of the classificationgroupfeaturetemplates property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCCLASSIFICATIONGROUPFEATURETEMPLATES }
     *     
     */
    public void setCLASSIFICATIONGROUPFEATURETEMPLATES(BCCLASSIFICATIONGROUPFEATURETEMPLATES value) {
        this.classificationgroupfeaturetemplates = value;
    }

    /**
     * Gets the value of the classificationgroupparentid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLASSIFICATIONGROUPPARENTID() {
        return classificationgroupparentid;
    }

    /**
     * Sets the value of the classificationgroupparentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLASSIFICATIONGROUPPARENTID(String value) {
        this.classificationgroupparentid = value;
    }

    /**
     * Gets the value of the classificationgroupudx property.
     * 
     * @return
     *     possible object is
     *     {@link UdxCLASSGROUP }
     *     
     */
    public UdxCLASSGROUP getCLASSIFICATIONGROUPUDX() {
        return classificationgroupudx;
    }

    /**
     * Sets the value of the classificationgroupudx property.
     * 
     * @param value
     *     allowed object is
     *     {@link UdxCLASSGROUP }
     *     
     */
    public void setCLASSIFICATIONGROUPUDX(UdxCLASSGROUP value) {
        this.classificationgroupudx = value;
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
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLevel(BigInteger value) {
        this.level = value;
    }

}
