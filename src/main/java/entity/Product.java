package entity;

@SuppressWarnings("unused")

public class Product {
    private int productId;
    private String productName;
    private String createDate;
    private Category category ;
    private Brand brand;

    public Product(int productId, String productName, String createDate, Category category, Brand brand) {
        this.productId = productId;
        this.productName = productName;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
    }

    public Product(String productName, String createDate, Category category, Brand brand) {
        this.productName = productName;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                '}';
    }
}