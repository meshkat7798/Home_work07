package entity;

import java.util.Arrays;

@SuppressWarnings("unused")

public class Brand {
    private int brandId;
    private String brandName;
    private Category category;
    private String brandWebsite;
    private String brandDescription;
    private Shareholder[] shareholders;

    public Brand(int brandId, String brandName, String brandWebsite, String brandDescription) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandWebsite = brandWebsite;
        this.brandDescription = brandDescription;
    }

    public Brand(String brandName,  String brandWebsite, String brandDescription) {
        this.brandName = brandName;
        this.brandWebsite = brandWebsite;
        this.brandDescription = brandDescription;
    }

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBrandWebsite() {
        return brandWebsite;
    }

    public void setBrandWebsite(String brandWebsite) {
        this.brandWebsite = brandWebsite;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public Shareholder[] getShareholders() {
        return shareholders;
    }

    public void setShareholders(Shareholder[] shareholders) {
        this.shareholders = shareholders;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", category=" + category +
                ", brandWebsite='" + brandWebsite + '\'' +
                ", brandDescription='" + brandDescription + '\'' +
                ", shareholders=" + Arrays.toString(shareholders) +
                '}';
    }
}