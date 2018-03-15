package com.packt.webstore.domain;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = -3560539622417210365L;
    private Long orderId;
    private Cart cart;
    private Customer customer;
    private ShippingDetail shippingDetail;

    public Order(){
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (cart != null ? !cart.equals(order.cart) : order.cart != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        return shippingDetail != null ? shippingDetail.equals(order.shippingDetail) : order.shippingDetail == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (shippingDetail != null ? shippingDetail.hashCode() : 0);
        return result;
    }
}
