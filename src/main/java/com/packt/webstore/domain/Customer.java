package com.packt.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;
    private String customerId;
    private String name;
    private Address billingAddress;
    private String phoneNumber;

    public Customer(){
        super();
        this.billingAddress = new Address();
    }

    public Customer(String customerId, String name){
        this();
        this.customerId = customerId;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (billingAddress != null ? !billingAddress.equals(customer.billingAddress) : customer.billingAddress != null)
            return false;
        return phoneNumber != null ? phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

}
