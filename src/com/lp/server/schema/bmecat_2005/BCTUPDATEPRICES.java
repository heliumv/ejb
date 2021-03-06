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
 *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}FORMULAS" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="PRODUCT" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_PID"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRODUCT_PRICE_DETAILS" maxOccurs="unbounded"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}USER_DEFINED_EXTENSIONS" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="mode" default="update">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="20"/>
 *                         &lt;enumeration value="update"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/attribute>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ARTICLE" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_AID"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_PRICE_DETAILS" maxOccurs="unbounded"/>
 *                     &lt;element ref="{http://www.bmecat.org/bmecat/2005}USER_DEFINED_EXTENSIONS" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="mode" default="update">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="20"/>
 *                         &lt;enumeration value="update"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/attribute>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="prev_version" use="required" type="{http://www.bmecat.org/bmecat/2005}dtINTEGER" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "formulas",
    "product",
    "article"
})
@XmlRootElement(name = "T_UPDATE_PRICES")
public class BCTUPDATEPRICES {

    @XmlElement(name = "FORMULAS")
    protected BCFORMULAS formulas;
    @XmlElement(name = "PRODUCT")
    protected List<BCTUPDATEPRICES.PRODUCT> product;
    @XmlElement(name = "ARTICLE")
    protected List<BCTUPDATEPRICES.ARTICLE> article;
    @XmlAttribute(name = "prev_version", required = true)
    protected BigInteger prevVersion;

    /**
     * Gets the value of the formulas property.
     * 
     * @return
     *     possible object is
     *     {@link BCFORMULAS }
     *     
     */
    public BCFORMULAS getFORMULAS() {
        return formulas;
    }

    /**
     * Sets the value of the formulas property.
     * 
     * @param value
     *     allowed object is
     *     {@link BCFORMULAS }
     *     
     */
    public void setFORMULAS(BCFORMULAS value) {
        this.formulas = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the product property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRODUCT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCTUPDATEPRICES.PRODUCT }
     * 
     * 
     */
    public List<BCTUPDATEPRICES.PRODUCT> getPRODUCT() {
        if (product == null) {
            product = new ArrayList<BCTUPDATEPRICES.PRODUCT>();
        }
        return this.product;
    }

    /**
     * Gets the value of the article property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the article property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getARTICLE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BCTUPDATEPRICES.ARTICLE }
     * 
     * 
     */
    public List<BCTUPDATEPRICES.ARTICLE> getARTICLE() {
        if (article == null) {
            article = new ArrayList<BCTUPDATEPRICES.ARTICLE>();
        }
        return this.article;
    }

    /**
     * Gets the value of the prevVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrevVersion() {
        return prevVersion;
    }

    /**
     * Sets the value of the prevVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrevVersion(BigInteger value) {
        this.prevVersion = value;
    }


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
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_AID"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}ARTICLE_PRICE_DETAILS" maxOccurs="unbounded"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}USER_DEFINED_EXTENSIONS" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="mode" default="update">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="20"/>
     *             &lt;enumeration value="update"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supplieraid",
        "supplieridref",
        "articlepricedetails",
        "userdefinedextensions"
    })
    public static class ARTICLE {

        @XmlElement(name = "SUPPLIER_AID", required = true)
        protected String supplieraid;
        @XmlElement(name = "SUPPLIER_IDREF")
        protected TypePARTYID supplieridref;
        @XmlElement(name = "ARTICLE_PRICE_DETAILS", required = true)
        protected List<BCARTICLEPRICEDETAILS> articlepricedetails;
        @XmlElement(name = "USER_DEFINED_EXTENSIONS")
        protected UdxPRODUCT userdefinedextensions;
        @XmlAttribute
        protected String mode;

        /**
         * Gets the value of the supplieraid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSUPPLIERAID() {
            return supplieraid;
        }

        /**
         * Sets the value of the supplieraid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSUPPLIERAID(String value) {
            this.supplieraid = value;
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
         * Gets the value of the articlepricedetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the articlepricedetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getARTICLEPRICEDETAILS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BCARTICLEPRICEDETAILS }
         * 
         * 
         */
        public List<BCARTICLEPRICEDETAILS> getARTICLEPRICEDETAILS() {
            if (articlepricedetails == null) {
                articlepricedetails = new ArrayList<BCARTICLEPRICEDETAILS>();
            }
            return this.articlepricedetails;
        }

        /**
         * Gets the value of the userdefinedextensions property.
         * 
         * @return
         *     possible object is
         *     {@link UdxPRODUCT }
         *     
         */
        public UdxPRODUCT getUSERDEFINEDEXTENSIONS() {
            return userdefinedextensions;
        }

        /**
         * Sets the value of the userdefinedextensions property.
         * 
         * @param value
         *     allowed object is
         *     {@link UdxPRODUCT }
         *     
         */
        public void setUSERDEFINEDEXTENSIONS(UdxPRODUCT value) {
            this.userdefinedextensions = value;
        }

        /**
         * Gets the value of the mode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMode() {
            if (mode == null) {
                return "update";
            } else {
                return mode;
            }
        }

        /**
         * Sets the value of the mode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMode(String value) {
            this.mode = value;
        }

    }


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
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_PID"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}SUPPLIER_IDREF" minOccurs="0"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}PRODUCT_PRICE_DETAILS" maxOccurs="unbounded"/>
     *         &lt;element ref="{http://www.bmecat.org/bmecat/2005}USER_DEFINED_EXTENSIONS" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="mode" default="update">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.bmecat.org/bmecat/2005}dtSTRING">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="20"/>
     *             &lt;enumeration value="update"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supplierpid",
        "supplieridref",
        "productpricedetails",
        "userdefinedextensions"
    })
    public static class PRODUCT {

        @XmlElement(name = "SUPPLIER_PID", required = true)
        protected BCSUPPLIERPID supplierpid;
        @XmlElement(name = "SUPPLIER_IDREF")
        protected TypePARTYID supplieridref;
        @XmlElement(name = "PRODUCT_PRICE_DETAILS", required = true)
        protected List<BCPRODUCTPRICEDETAILS> productpricedetails;
        @XmlElement(name = "USER_DEFINED_EXTENSIONS")
        protected UdxPRODUCT userdefinedextensions;
        @XmlAttribute
        protected String mode;

        /**
         * Gets the value of the supplierpid property.
         * 
         * @return
         *     possible object is
         *     {@link BCSUPPLIERPID }
         *     
         */
        public BCSUPPLIERPID getSUPPLIERPID() {
            return supplierpid;
        }

        /**
         * Sets the value of the supplierpid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BCSUPPLIERPID }
         *     
         */
        public void setSUPPLIERPID(BCSUPPLIERPID value) {
            this.supplierpid = value;
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
         * Gets the value of the productpricedetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the productpricedetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPRODUCTPRICEDETAILS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BCPRODUCTPRICEDETAILS }
         * 
         * 
         */
        public List<BCPRODUCTPRICEDETAILS> getPRODUCTPRICEDETAILS() {
            if (productpricedetails == null) {
                productpricedetails = new ArrayList<BCPRODUCTPRICEDETAILS>();
            }
            return this.productpricedetails;
        }

        /**
         * Gets the value of the userdefinedextensions property.
         * 
         * @return
         *     possible object is
         *     {@link UdxPRODUCT }
         *     
         */
        public UdxPRODUCT getUSERDEFINEDEXTENSIONS() {
            return userdefinedextensions;
        }

        /**
         * Sets the value of the userdefinedextensions property.
         * 
         * @param value
         *     allowed object is
         *     {@link UdxPRODUCT }
         *     
         */
        public void setUSERDEFINEDEXTENSIONS(UdxPRODUCT value) {
            this.userdefinedextensions = value;
        }

        /**
         * Gets the value of the mode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMode() {
            if (mode == null) {
                return "update";
            } else {
                return mode;
            }
        }

        /**
         * Sets the value of the mode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMode(String value) {
            this.mode = value;
        }

    }

}
