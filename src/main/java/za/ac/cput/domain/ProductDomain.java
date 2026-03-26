/*
 *ProductDomain.java
 *ProductDomain model class
 *Maghdie Petersen 230600204
 *  */
package za.ac.cput.domain;

import java.util.Objects;

public class ProductDomain {
    private String productId;
    private String description;
    private String category;
    private double price;
    private String unitOfMeasure;

    private ProductDomain(Builder builder){
        this.productId = builder.productId;
        this.description = builder.description;
        this.category = builder.category;
        this.price = builder.price;
        this.unitOfMeasure = builder.unitOfMeasure;
    }

    //(no setters to ensure immutability/no changes )
    public String getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductDomain product = (ProductDomain) obj;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(description, product.description) &&
                Objects.equals(category, product.category) &&
                Objects.equals(unitOfMeasure, product.unitOfMeasure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId,description,category,price,unitOfMeasure);
    }

    public static class Builder{
        private String productId;
        private String description;
        private String category;
        private double price;
        private String unitOfMeasure;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setUnitOfMeasure(String unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        //Method to copy an existing Product object into a Builder
        public Builder copy(ProductDomain product){
            this.productId = product.productId;
            this.description = product.description;
            this.category = product.category;
            this.price = product.price;
            this.unitOfMeasure = product.unitOfMeasure;
            return this;
        }

        //Last/Final method to create the Product object
        public ProductDomain build(){
            return new ProductDomain(this);
        }
    }

}


