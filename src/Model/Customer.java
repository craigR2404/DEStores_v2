package Model;

public class Customer {
    private String id;
    private String nameYo;
    private String surnameYo;
    private String emailYo;
    private Double creditYo;
    private Loyalty loyalty;
    private Order order;

    public Loyalty getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    public String getSurnameYo() {
        return surnameYo;
    }

    public void setNameYo(String nameYo) {
        this.nameYo = nameYo;
    }

    public void setSurnameYo(String surnameYo) {
        this.surnameYo = surnameYo;
    }

    public void setEmailYo(String emailYo) {
        this.emailYo = emailYo;
    }

    public void setCreditYo(Double creditYo) {
        this.creditYo = creditYo;
    }

    public String getEmailYo() {
        return emailYo;
    }

    public Double getCreditYo() {
        return creditYo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameYo() {
        return nameYo;
    }


    public Customer(String id, String nameYo, String surnameYo, String emailYo, Double creditYo) {

        this.id = id;
        this.nameYo = nameYo;
        this.surnameYo = surnameYo;
        this.emailYo = emailYo;
        this.creditYo = creditYo;

    }

    public Customer(){
        this.id = "";
        this.nameYo = "";
        this.surnameYo = "";
        this.emailYo = "";
        this.creditYo = 0.00;
    }
}
