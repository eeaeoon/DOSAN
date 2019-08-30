package com.example.dosan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class ManageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private String NAME;
    private Integer VALUE;
    private String ACCOUNT_NUM;
    private String BANK_NAME;

    public ManageBean() {
    }

    public ManageBean(String NAME, Integer VALUE, String ACCOUNT_NUM, String BANK_NAME) {
        this.NAME = NAME;
        this.VALUE = VALUE;
        this.ACCOUNT_NUM = ACCOUNT_NUM;
        this.BANK_NAME = BANK_NAME;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getVALUE() {
        return this.VALUE;
    }

    public void setVALUE(Integer VALUE) {
        this.VALUE = VALUE;
    }

    public String getACCOUNT_NUM() {
        return this.ACCOUNT_NUM;
    }

    public void setACCOUNT_NUM(String ACCOUNT_NUM) {
        this.ACCOUNT_NUM = ACCOUNT_NUM;
    }

    public String getBANK_NAME() {
        return this.BANK_NAME;
    }

    public void setBANK_NAME(String BANK_NAME) {
        this.BANK_NAME = BANK_NAME;
    }

    public ManageBean NAME(String NAME) {
        this.NAME = NAME;
        return this;
    }

    public ManageBean VALUE(Integer VALUE) {
        this.VALUE = VALUE;
        return this;
    }

    public ManageBean ACCOUNT_NUM(String ACCOUNT_NUM) {
        this.ACCOUNT_NUM = ACCOUNT_NUM;
        return this;
    }

    public ManageBean BANK_NAME(String BANK_NAME) {
        this.BANK_NAME = BANK_NAME;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ManageBean)) {
            return false;
        }
        ManageBean manageBean = (ManageBean) o;
        return Objects.equals(NAME, manageBean.NAME) && Objects.equals(VALUE, manageBean.VALUE) && Objects.equals(ACCOUNT_NUM, manageBean.ACCOUNT_NUM) && Objects.equals(BANK_NAME, manageBean.BANK_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, VALUE, ACCOUNT_NUM, BANK_NAME);
    }

    @Override
    public String toString() {
        return "{" +
            " NAME='" + getNAME() + "'" +
            ", VALUE='" + getVALUE() + "'" +
            ", ACCOUNT_NUM='" + getACCOUNT_NUM() + "'" +
            ", BANK_NAME='" + getBANK_NAME() + "'" +
            "}";
    }

    

}