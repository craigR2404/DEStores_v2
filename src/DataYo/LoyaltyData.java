package DataYo;

import Model.Loyalty;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyData {
    private static final List<Loyalty> loyaltyList = new ArrayList();


    private LoyaltyData(){

    }

    static {
        loyaltyList.add(new Loyalty("1",4001,"20%"));
        loyaltyList.add(new Loyalty("2", 4002,"50%"));
    }

    public static List<Loyalty> getInstance() {
        return loyaltyList;}
}
