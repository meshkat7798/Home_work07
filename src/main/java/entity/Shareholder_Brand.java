package entity;

public class Shareholder_Brand {
    private int shareholderId ;
    private int brandId ;

    public Shareholder_Brand(int shareholderId , int brandId) {
        this.shareholderId = shareholderId;
        this.brandId = brandId;
    }

    public Shareholder_Brand() {
    }

    public int getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(int shareholderId) {
        this.shareholderId = shareholderId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Shareholder_Brand{" +
                "shareholderId=" + shareholderId +
                ", brandId=" + brandId +
                '}';
    }
}
