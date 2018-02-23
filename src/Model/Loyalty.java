package Model;



public class Loyalty {

    private String customerId;
    private Integer cardnumber;
    private String extraDiscount;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(Integer cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExtraDiscount() {
        return extraDiscount;
    }

    public void setExtraDiscount(String extraDiscount) {
        this.extraDiscount = extraDiscount;
    }

    public Loyalty(String customerId, Integer cardnumber, String extraDiscount)
    {
        this.customerId= customerId;
        this.cardnumber = cardnumber;
        this.extraDiscount = extraDiscount;
    }
}
