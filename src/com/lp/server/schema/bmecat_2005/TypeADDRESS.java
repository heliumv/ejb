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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeADDRESS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeADDRESS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}NAME" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}NAME2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}NAME3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}DEPARTMENT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}CONTACT_DETAILS" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}CONTACT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}STREET" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ZIP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}BOXNO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ZIPBOX" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}CITY" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}STATE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}COUNTRY" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}COUNTRY_CODED" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}VAT_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PHONE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FAX" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}EMAIL"/>
 *           &lt;element ref="{http://www.bmecat.org/bmecat/2005}PUBLIC_KEY" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}URL" minOccurs="0"/>
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ADDRESS_REMARKS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeADDRESS", propOrder = {
    "name",
    "name2",
    "name3",
    "department",
    "contactdetails",
    "contact",
    "street",
    "zip",
    "boxno",
    "zipbox",
    "city",
    "state",
    "country",
    "countrycoded",
    "vatid",
    "phone",
    "fax",
    "emailAndPUBLICKEY",
    "url",
    "addressremarks"
})
@XmlSeeAlso({
    com.lp.server.schema.bmecat_2005.BCBUYER.ADDRESS.class,
    com.lp.server.schema.bmecat_2005.BCSUPPLIER.ADDRESS.class
})
public class TypeADDRESS {

    @XmlElement(name = "NAME")
    protected List<BCNAME> name;
    @XmlElement(name = "NAME2")
    protected List<BCNAME2> name2;
    @XmlElement(name = "NAME3")
    protected List<BCNAME3> name3;
    @XmlElement(name = "DEPARTMENT")
    protected List<BCDEPARTMENT> department;
    @XmlElement(name = "CONTACT_DETAILS")
    protected List<BCCONTACTDETAILS> contactdetails;
    @XmlElement(name = "CONTACT")
    protected List<BCCONTACT> contact;
    @XmlElement(name = "STREET")
    protected List<BCSTREET> street;
    @XmlElement(name = "ZIP")
    protected List<BCZIP> zip;
    @XmlElement(name = "BOXNO")
    protected List<BCBOXNO> boxno;
    @XmlElement(name = "ZIPBOX")
    protected List<BCZIPBOX> zipbox;
    @XmlElement(name = "CITY")
    protected List<BCCITY> city;
    @XmlElement(name = "STATE")
    protected List<BCSTATE> state;
    @XmlElement(name = "COUNTRY")
    protected List<BCCOUNTRY> country;
    @XmlElement(name = "COUNTRY_CODED")
    protected String countrycoded;
    @XmlElement(name = "VAT_ID")
    protected String vatid;
    @XmlElement(name = "PHONE")
    protected List<BCPHONE> phone;
    @XmlElement(name = "FAX")
    protected List<BCFAX> fax;
    @XmlElements({
        @XmlElement(name = "PUBLIC_KEY", type = BCPUBLICKEY.class),
        @XmlElement(name = "EMAIL", type = String.class)
    })
    protected List<Object> emailAndPUBLICKEY;
    @XmlElement(name = "URL")
    protected String url;
    @XmlElement(name = "ADDRESS_REMARKS")
    protected List<BCADDRESSREMARKS> addressremarks;

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNAME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCNAME }
     * 
     * 
     */
    public List<BCNAME> getNAME() {
        if (name == null) {
            name = new ArrayList<BCNAME>();
        }
        return this.name;
    }

    /**
     * Gets the value of the name2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNAME2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCNAME2 }
     * 
     * 
     */
    public List<BCNAME2> getNAME2() {
        if (name2 == null) {
            name2 = new ArrayList<BCNAME2>();
        }
        return this.name2;
    }

    /**
     * Gets the value of the name3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNAME3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCNAME3 }
     * 
     * 
     */
    public List<BCNAME3> getNAME3() {
        if (name3 == null) {
            name3 = new ArrayList<BCNAME3>();
        }
        return this.name3;
    }

    /**
     * Gets the value of the department property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the department property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDEPARTMENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCDEPARTMENT }
     * 
     * 
     */
    public List<BCDEPARTMENT> getDEPARTMENT() {
        if (department == null) {
            department = new ArrayList<BCDEPARTMENT>();
        }
        return this.department;
    }

    /**
     * Gets the value of the contactdetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactdetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONTACTDETAILS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCONTACTDETAILS }
     * 
     * 
     */
    public List<BCCONTACTDETAILS> getCONTACTDETAILS() {
        if (contactdetails == null) {
            contactdetails = new ArrayList<BCCONTACTDETAILS>();
        }
        return this.contactdetails;
    }

    /**
     * Gets the value of the contact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONTACT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCONTACT }
     * 
     * 
     */
    public List<BCCONTACT> getCONTACT() {
        if (contact == null) {
            contact = new ArrayList<BCCONTACT>();
        }
        return this.contact;
    }

    /**
     * Gets the value of the street property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the street property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTREET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCSTREET }
     * 
     * 
     */
    public List<BCSTREET> getSTREET() {
        if (street == null) {
            street = new ArrayList<BCSTREET>();
        }
        return this.street;
    }

    /**
     * Gets the value of the zip property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zip property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZIP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCZIP }
     * 
     * 
     */
    public List<BCZIP> getZIP() {
        if (zip == null) {
            zip = new ArrayList<BCZIP>();
        }
        return this.zip;
    }

    /**
     * Gets the value of the boxno property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boxno property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBOXNO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCBOXNO }
     * 
     * 
     */
    public List<BCBOXNO> getBOXNO() {
        if (boxno == null) {
            boxno = new ArrayList<BCBOXNO>();
        }
        return this.boxno;
    }

    /**
     * Gets the value of the zipbox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zipbox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZIPBOX().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCZIPBOX }
     * 
     * 
     */
    public List<BCZIPBOX> getZIPBOX() {
        if (zipbox == null) {
            zipbox = new ArrayList<BCZIPBOX>();
        }
        return this.zipbox;
    }

    /**
     * Gets the value of the city property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the city property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCITY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCITY }
     * 
     * 
     */
    public List<BCCITY> getCITY() {
        if (city == null) {
            city = new ArrayList<BCCITY>();
        }
        return this.city;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTATE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCSTATE }
     * 
     * 
     */
    public List<BCSTATE> getSTATE() {
        if (state == null) {
            state = new ArrayList<BCSTATE>();
        }
        return this.state;
    }

    /**
     * Gets the value of the country property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the country property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOUNTRY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCCOUNTRY }
     * 
     * 
     */
    public List<BCCOUNTRY> getCOUNTRY() {
        if (country == null) {
            country = new ArrayList<BCCOUNTRY>();
        }
        return this.country;
    }

    /**
     * Gets the value of the countrycoded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUNTRYCODED() {
        return countrycoded;
    }

    /**
     * Sets the value of the countrycoded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUNTRYCODED(String value) {
        this.countrycoded = value;
    }

    /**
     * Gets the value of the vatid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATID() {
        return vatid;
    }

    /**
     * Sets the value of the vatid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATID(String value) {
        this.vatid = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPHONE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCPHONE }
     * 
     * 
     */
    public List<BCPHONE> getPHONE() {
        if (phone == null) {
            phone = new ArrayList<BCPHONE>();
        }
        return this.phone;
    }

    /**
     * Gets the value of the fax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFAX().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCFAX }
     * 
     * 
     */
    public List<BCFAX> getFAX() {
        if (fax == null) {
            fax = new ArrayList<BCFAX>();
        }
        return this.fax;
    }

    /**
     * Gets the value of the emailAndPUBLICKEY property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailAndPUBLICKEY property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEMAILAndPUBLICKEY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCPUBLICKEY }
     * {@link String }
     * 
     * 
     */
    public List<Object> getEMAILAndPUBLICKEY() {
        if (emailAndPUBLICKEY == null) {
            emailAndPUBLICKEY = new ArrayList<Object>();
        }
        return this.emailAndPUBLICKEY;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the addressremarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressremarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getADDRESSREMARKS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCADDRESSREMARKS }
     * 
     * 
     */
    public List<BCADDRESSREMARKS> getADDRESSREMARKS() {
        if (addressremarks == null) {
            addressremarks = new ArrayList<BCADDRESSREMARKS>();
        }
        return this.addressremarks;
    }

}
