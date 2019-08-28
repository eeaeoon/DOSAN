package com.example.dosan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class ProductBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private String NAME;
    private String PRODUCT;
    private String DATE;

    public ProductBean() {
    }

    public ProductBean(String NAME, String PRODUCT, String DATE) {
        this.NAME = NAME;
        this.PRODUCT = PRODUCT;
        this.DATE = DATE;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRODUCT() {
        return this.PRODUCT;
    }

    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public String getDATE() {
        return this.DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public ProductBean NAME(String NAME) {
        this.NAME = NAME;
        return this;
    }

    public ProductBean PRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
        return this;
    }

    public ProductBean DATE(String DATE) {
        this.DATE = DATE;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductBean)) {
            return false;
        }
        ProductBean productBean = (ProductBean) o;
        return Objects.equals(NAME, productBean.NAME) && Objects.equals(PRODUCT, productBean.PRODUCT)
                && Objects.equals(DATE, productBean.DATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, PRODUCT, DATE);
    }

    @Override
    public String toString() {
        return "{" + " NAME='" + getNAME() + "'" + ", PRODUCT='" + getPRODUCT() + "'" + ", DATE='" + getDATE() + "'"
                + "}";
    }

}