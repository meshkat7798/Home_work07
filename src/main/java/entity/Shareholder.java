package entity;

@SuppressWarnings("unused")

public class Shareholder {
    private int shareholderId ;
    private String shareholderName;
    private String phoneNumber;
    private String nationalityCode;
    private Brand[] brands;

    public Shareholder(int shareholderId, String shareholderName, String phoneNumber, String nationalityCode) {
        this.shareholderId = shareholderId;
        this.shareholderName = shareholderName;
        this.phoneNumber = phoneNumber;
        this.nationalityCode = nationalityCode;
    }

    public Shareholder(String shareholderName, String phoneNumber, String nationalityCode) {
        this.shareholderName = shareholderName;
        this.phoneNumber = phoneNumber;
        this.nationalityCode = nationalityCode;
    }

    public Shareholder() {
    }

    public int getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(int shareholderId) {
        this.shareholderId = shareholderId;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public Brand[] getBrands() {
        return brands;
    }

    public void setBrands(Brand[] brands) {
        this.brands = brands;
    }
}