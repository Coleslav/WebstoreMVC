package com.packt.webstore.domain;

import com.packt.webstore.validator.ProductId;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.MessageInterpolator;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@XmlRootElement

public class Product {
    @Pattern(regexp = "P[0-9]+", message = "{javax.validation.constraints.Pattern}")
    @ProductId
    private String productId;
    @Size(min = 4, max = 50, message = "{Size.Product.name.validation}")
    private String name;
    @Min(value = 0, message = "Min.Product.name.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;
    @JsonIgnore
    private MultipartFile productImage;
    @JsonIgnore
    private MultipartFile productDocumentation;

    public Product () {
        super();
    }

    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    //Getters

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public String getCondition() {
        return condition;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    public MultipartFile getProductDocumentation() {
        return productDocumentation;
    }

    //Setters

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public void setProductDocumentation(MultipartFile productDocumentation) {
        this.productDocumentation = productDocumentation;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if(other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Produkt [productId=" + productId + ", nazwa=" + name + "]" ;
    }
}
