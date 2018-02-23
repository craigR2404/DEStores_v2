package Services;

import DataYo.LoyaltyData;
import Model.Loyalty;



import java.util.List;
import java.util.Optional;



public class LoyaltyService {
    private List<Loyalty> loyaltyList = LoyaltyData.getInstance();

    public List<Loyalty> getLoyaltyList() {
        return loyaltyList;
    }


        public Loyalty searchLoyaltyid(String customerId){

            Optional<Loyalty> result = loyaltyList
                    .stream()
                    .filter(Loyalty -> Loyalty.getCustomerId().equals(customerId))
                    .findFirst();
            if(result.isPresent()){
                return result.get();
            }
            else {
                return null;
            }
        }

    public Loyalty searchLoyaltyidAgain(Integer cardnumber){

        Optional<Loyalty> result = loyaltyList
                .stream()
                .filter(Loyalty -> Loyalty.getCardnumber().equals(cardnumber))
                .findFirst();
        if(result.isPresent()){
            return result.get();
        }
        else {
            return null;
        }
    }


    public void editCard(Loyalty loyalty){
        int captureIndex = 0;
        Optional<Loyalty> capture = loyaltyList
                .stream()
                .filter(card -> card.getCardnumber().equals(loyalty.getCardnumber()))
                .findFirst();
        if(capture.isPresent()){
            captureIndex = loyaltyList.indexOf(capture.get());
            loyaltyList.set(captureIndex, loyalty);
        }
    }


    public Loyalty searchByCard(Integer cardnumber) {

        Optional<Loyalty> reslut = loyaltyList
                .stream()
                .filter(Loyalty -> Loyalty.getCardnumber().equals(cardnumber))
                .findFirst();
        return reslut.get();
    }

    public void addLoyalty(Loyalty card){
       card.setCardnumber(loyaltyList.size()+1);

    }
}
