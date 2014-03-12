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

import java.math.BigDecimal;
import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}DESCRIPTION_SHORT" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}DESCRIPTION_LONG" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}INTERNATIONAL_AID" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}EAN" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_ALT_AID" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}BUYER_AID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}MANUFACTURER_AID" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}MANUFACTURER_IDREF" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}MANUFACTURER_NAME" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}MANUFACTURER_TYPE_DESCR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ERP_GROUP_BUYER" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ERP_GROUP_SUPPLIER" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}DELIVERY_TIME" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SPECIAL_TREATMENT_CLASS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}KEYWORD" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}REMARKS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SEGMENT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_ORDER" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_STATUS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}INTERNATIONAL_RESTRICTIONS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ACCOUNTING_INFO" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}AGREEMENT_REF" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_TYPE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_CATEGORY" minOccurs="0"/>
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
    "descriptionshort",
    "descriptionlong",
    "internationalaid",
    "ean",
    "supplieraltaid",
    "buyeraid",
    "manufactureraid",
    "manufactureridref",
    "manufacturername",
    "manufacturertypedescr",
    "erpgroupbuyer",
    "erpgroupsupplier",
    "deliverytime",
    "specialtreatmentclass",
    "keyword",
    "remarks",
    "segment",
    "articleorder",
    "articlestatus",
    "internationalrestrictions",
    "accountinginfo",
    "agreementref",
    "articletype",
    "articlecategory"
})
@XmlRootElement(name = "ARTICLE_DETAILS")
public class BCARTICLEDETAILS {

    @XmlElement(name = "DESCRIPTION_SHORT", required = true)
    protected List<BCDESCRIPTIONSHORT> descriptionshort;
    @XmlElement(name = "DESCRIPTION_LONG")
    protected List<BCDESCRIPTIONLONG> descriptionlong;
    @XmlElement(name = "INTERNATIONAL_AID")
    protected List<BCINTERNATIONALAID> internationalaid;
    @XmlElement(name = "EAN")
    protected String ean;
    @XmlElement(name = "SUPPLIER_ALT_AID")
    protected String supplieraltaid;
    @XmlElement(name = "BUYER_AID")
    protected List<BCBUYERAID> buyeraid;
    @XmlElement(name = "MANUFACTURER_AID")
    protected String manufactureraid;
    @XmlElement(name = "MANUFACTURER_IDREF")
    protected TypePARTYID manufactureridref;
    @XmlElement(name = "MANUFACTURER_NAME")
    protected String manufacturername;
    @XmlElement(name = "MANUFACTURER_TYPE_DESCR")
    protected List<BCMANUFACTURERTYPEDESCR> manufacturertypedescr;
    @XmlElement(name = "ERP_GROUP_BUYER")
    protected String erpgroupbuyer;
    @XmlElement(name = "ERP_GROUP_SUPPLIER")
    protected String erpgroupsupplier;
    @XmlElement(name = "DELIVERY_TIME")
    protected BigDecimal deliverytime;
    @XmlElement(name = "SPECIAL_TREATMENT_CLASS")
    protected List<BCSPECIALTREATMENTCLASS> specialtreatmentclass;
    @XmlElement(name = "KEYWORD")
    protected List<BCKEYWORD> keyword;
    @XmlElement(name = "REMARKS")
    protected List<BCREMARKS> remarks;
    @XmlElement(name = "SEGMENT")
    protected List<BCSEGMENT> segment;
    @XmlElement(name = "ARTICLE_ORDER")
    protected BigInteger articleorder;
    @XmlElement(name = "ARTICLE_STATUS")
    protected List<BCARTICLESTATUS> articlestatus;
    @XmlElement(name = "INTERNATIONAL_RESTRICTIONS")
    protected List<BCINTERNATIONALRESTRICTIONS> internationalrestrictions;
    @XmlElement(name = "ACCOUNTING_INFO")
    protected BCACCOUNTINGINFO accountinginfo;
    @XmlElement(name = "AGREEMENT_REF")
    protected BCAGREEMENTREF agreementref;
    @XmlElement(name = "ARTICLE_TYPE")
    protected List<String> articletype;
    @XmlElement(name = "ARTICLE_CATEGORY")
    protected String articlecategory;

    /**
     * Gets the value of the descriptionshort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descriptionshort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDESCRIPTIONSHORT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCDESCRIPTIONSHORT }
     * 
     * 
     */
    public List<BCDESCRIPTIONSHORT> getDESCRIPTIONSHORT() {
        if (descriptionshort == null) {
            descriptionshort = new ArrayList<BCDESCRIPTIONSHORT>();
        }
        return this.descriptionshort;
    }

    /**
     * Gets the value of the descriptionlong property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descriptionlong property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDESCRIPTIONLONG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCDESCRIPTIONLONG }
     * 
     * 
     */
    public List<BCDESCRIPTIONLONG> getDESCRIPTIONLONG() {
        if (descriptionlong == null) {
            descriptionlong = new ArrayList<BCDESCRIPTIONLONG>();
        }
        return this.descriptionlong;
    }

    /**
     * Gets the value of the internationalaid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the internationalaid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINTERNATIONALAID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCINTERNATIONALAID }
     * 
     * 
     */
    public List<BCINTERNATIONALAID> getINTERNATIONALAID() {
        if (internationalaid == null) {
            internationalaid = new ArrayList<BCINTERNATIONALAID>();
        }
        return this.internationalaid;
    }

    /**
     * Gets the value of the ean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEAN() {
        return ean;
    }

    /**
     * Sets the value of the ean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEAN(String value) {
        this.ean = value;
    }

    /**
     * Gets the value of the supplieraltaid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUPPLIERALTAID() {
        return supplieraltaid;
    }

    /**
     * Sets the value of the supplieraltaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUPPLIERALTAID(String value) {
        this.supplieraltaid = value;
    }

    /**
     * Gets the value of the buyeraid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buyeraid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBUYERAID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCBUYERAID }
     * 
     * 
     */
    public List<BCBUYERAID> getBUYERAID() {
        if (buyeraid == null) {
            buyeraid = new ArrayList<BCBUYERAID>();
        }
        return this.buyeraid;
    }

    /**
     * Gets the value of the manufactureraid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANUFACTURERAID() {
        return manufactureraid;
    }

    /**
     * Sets the value of the manufactureraid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANUFACTURERAID(String value) {
        this.manufactureraid = value;
    }

    /**
     * Gets the value of the manufactureridref property.
     * 
     * @return
     *     possible object is
     *     {@link TypePARTYID }
     *     
     */
    public TypePARTYID getMANUFACTURERIDREF() {
        return manufactureridref;
    }

    /**
     * Sets the value of the manufactureridref property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypePARTYID }
     *     
     */
    public void setMANUFACTURERIDREF(TypePARTYID value) {
        this.manufactureridref = value;
    }

    /**
     * Gets the value of the manufacturername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMANUFACTURERNAME() {
        return manufacturername;
    }

    /**
     * Sets the value of the manufacturername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMANUFACTURERNAME(String value) {
        this.manufacturername = value;
    }

    /**
     * Gets the value of the manufacturertypedescr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufacturertypedescr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMANUFACTURERTYPEDESCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCMANUFACTURERTYPEDESCR }
     * 
     * 
     */
    public List<BCMANUFACTURERTYPEDESCR> getMANUFACTURERTYPEDESCR() {
        if (manufacturertypedescr == null) {
            manufacturertypedescr = new ArrayList<BCMANUFACTURERTYPEDESCR>();
        }
        return this.manufacturertypedescr;
    }

    /**
     * Gets the value of the erpgroupbuyer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERPGROUPBUYER() {
        return erpgroupbuyer;
    }

    /**
     * Sets the value of the erpgroupbuyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERPGROUPBUYER(String value) {
        this.erpgroupbuyer = value;
    }

    /**
     * Gets the value of the erpgroupsupplier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERPGROUPSUPPLIER() {
        return erpgroupsupplier;
    }

    /**
     * Sets the value of the erpgroupsupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERPGROUPSUPPLIER(String value) {
        this.erpgroupsupplier = value;
    }

    /**
     * Gets the value of the deliverytime property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDELIVERYTIME() {
        return deliverytime;
    }

    /**
     * Sets the value of the deliverytime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDELIVERYTIME(BigDecimal value) {
        this.deliverytime = value;
    }

    /**
     * Gets the value of the specialtreatmentclass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialtreatmentclass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPECIALTREATMENTCLASS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCSPECIALTREATMENTCLASS }
     * 
     * 
     */
    public List<BCSPECIALTREATMENTCLASS> getSPECIALTREATMENTCLASS() {
        if (specialtreatmentclass == null) {
            specialtreatmentclass = new ArrayList<BCSPECIALTREATMENTCLASS>();
        }
        return this.specialtreatmentclass;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKEYWORD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCKEYWORD }
     * 
     * 
     */
    public List<BCKEYWORD> getKEYWORD() {
        if (keyword == null) {
            keyword = new ArrayList<BCKEYWORD>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREMARKS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCREMARKS }
     * 
     * 
     */
    public List<BCREMARKS> getREMARKS() {
        if (remarks == null) {
            remarks = new ArrayList<BCREMARKS>();
        }
        return this.remarks;
    }

    /**
     * Gets the value of the segment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSEGMENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCSEGMENT }
     * 
     * 
     */
    public List<BCSEGMENT> getSEGMENT() {
        if (segment == null) {
            segment = new ArrayList<BCSEGMENT>();
        }
        return this.segment;
    }

    /**
     * Gets the value of the articleorder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getARTICLEORDER() {
        return articleorder;
    }

    /**
     * Sets the value of the articleorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setARTICLEORDER(BigInteger value) {
        this.articleorder = value;
    }

    /**
     * Gets the value of the articlestatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articlestatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getARTICLESTATUS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCARTICLESTATUS }
     * 
     * 
     */
    public List<BCARTICLESTATUS> getARTICLESTATUS() {
        if (articlestatus == null) {
            articlestatus = new ArrayList<BCARTICLESTATUS>();
        }
        return this.articlestatus;
    }

    /**
     * Gets the value of the internationalrestrictions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the internationalrestrictions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINTERNATIONALRESTRICTIONS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCINTERNATIONALRESTRICTIONS }
     * 
     * 
     */
    public List<BCINTERNATIONALRESTRICTIONS> getINTERNATIONALRESTRICTIONS() {
        if (internationalrestrictions == null) {
            internationalrestrictions = new ArrayList<BCINTERNATIONALRESTRICTIONS>();
        }
        return this.internationalrestrictions;
    }

    /**
     * Gets the value of the accountinginfo property.
     * 
     * @return
     *     possible object is
     *     {@link BCACCOUNTINGINFO }
     *     
     */
    public BCACCOUNTINGINFO getACCOUNTINGINFO() {
        return accountinginfo;
    }

    /**
     * Sets the value of the accountinginfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCACCOUNTINGINFO }
     *     
     */
    public void setACCOUNTINGINFO(BCACCOUNTINGINFO value) {
        this.accountinginfo = value;
    }

    /**
     * Gets the value of the agreementref property.
     * 
     * @return
     *     possible object is
     *     {@link BCAGREEMENTREF }
     *     
     */
    public BCAGREEMENTREF getAGREEMENTREF() {
        return agreementref;
    }

    /**
     * Sets the value of the agreementref property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCAGREEMENTREF }
     *     
     */
    public void setAGREEMENTREF(BCAGREEMENTREF value) {
        this.agreementref = value;
    }

    /**
     * Gets the value of the articletype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articletype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getARTICLETYPE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getARTICLETYPE() {
        if (articletype == null) {
            articletype = new ArrayList<String>();
        }
        return this.articletype;
    }

    /**
     * Gets the value of the articlecategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getARTICLECATEGORY() {
        return articlecategory;
    }

    /**
     * Sets the value of the articlecategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setARTICLECATEGORY(String value) {
        this.articlecategory = value;
    }

}