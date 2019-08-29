package com.example.dosan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INOUT")
public class SendBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer INDEX;
    private String ACCOUNT_NUM;
    private String OTHER_NUM;
    private String OTHER_BANK;
    private String OTHER_NAME;
    private Long VALUE;
    private String DATE;


    public SendBean() {
    }

    public SendBean(String ACCOUNT_NUM, String OTHER_NUM, String OTHER_BANK, String OTHER_NAME, Long VALUE, String DATE) {
        this.ACCOUNT_NUM = ACCOUNT_NUM;
        this.OTHER_NUM = OTHER_NUM;
        this.OTHER_BANK = OTHER_BANK;
        this.OTHER_NAME = OTHER_NAME;
        this.VALUE = VALUE;
        this.DATE = DATE;
    }

    public String getACCOUNT_NUM() {
        return this.ACCOUNT_NUM;
    }

    public void setACCOUNT_NUM(String ACCOUNT_NUM) {
        this.ACCOUNT_NUM = ACCOUNT_NUM;
    }

    public String getOTHER_NUM() {
        return this.OTHER_NUM;
    }

    public void setOTHER_NUM(String OTHER_NUM) {
        this.OTHER_NUM = OTHER_NUM;
    }

    public String getOTHER_BANK() {
        return this.OTHER_BANK;
    }

    public void setOTHER_BANK(String OTHER_BANK) {
        this.OTHER_BANK = OTHER_BANK;
    }

    public String getOTHER_NAME() {
        return this.OTHER_NAME;
    }

    public void setOTHER_NAME(String OTHER_NAME) {
        this.OTHER_NAME = OTHER_NAME;
    }

    public Long getVALUE() {
        return this.VALUE;
    }

    public void setVALUE(Long VALUE) {
        this.VALUE = VALUE;
    }

    public String getDATE() {
        return this.DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public SendBean ACCOUNT_NUM(String ACCOUNT_NUM) {
        this.ACCOUNT_NUM = ACCOUNT_NUM;
        return this;
    }

    public SendBean OTHER_NUM(String OTHER_NUM) {
        this.OTHER_NUM = OTHER_NUM;
        return this;
    }

    public SendBean OTHER_BANK(String OTHER_BANK) {
        this.OTHER_BANK = OTHER_BANK;
        return this;
    }

    public SendBean OTHER_NAME(String OTHER_NAME) {
        this.OTHER_NAME = OTHER_NAME;
        return this;
    }

    public SendBean VALUE(Long VALUE) {
        this.VALUE = VALUE;
        return this;
    }

    public SendBean DATE(String DATE) {
        this.DATE = DATE;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SendBean)) {
            return false;
        }
        SendBean sendBean = (SendBean) o;
        return Objects.equals(ACCOUNT_NUM, sendBean.ACCOUNT_NUM) && Objects.equals(OTHER_NUM, sendBean.OTHER_NUM) && Objects.equals(OTHER_BANK, sendBean.OTHER_BANK) && Objects.equals(OTHER_NAME, sendBean.OTHER_NAME) && Objects.equals(VALUE, sendBean.VALUE) && Objects.equals(DATE, sendBean.DATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_NUM, OTHER_NUM, OTHER_BANK, OTHER_NAME, VALUE, DATE);
    }

    @Override
    public String toString() {
        return "{" +
            " ACCOUNT_NUM='" + getACCOUNT_NUM() + "'" +
            ", OTHER_NUM='" + getOTHER_NUM() + "'" +
            ", OTHER_BANK='" + getOTHER_BANK() + "'" +
            ", OTHER_NAME='" + getOTHER_NAME() + "'" +
            ", VALUE='" + getVALUE() + "'" +
            ", DATE='" + getDATE() + "'" +
            "}";
    }

}