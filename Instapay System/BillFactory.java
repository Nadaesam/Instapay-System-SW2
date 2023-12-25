

public class BillFactory {
    public Bill createBill(String text , String ID , float t , float usageU , float rate ) {
        
        if (text.equals("WaterBill")) {
            return new WaterBill( ID , t , usageU , rate);
        } else if (text.equals("ElectricityBill")) {
            return new ElectricityBill( ID, t , usageU , rate);
        } else if (text.equals("GazBill")) {
            return new GazBill( ID, t , usageU , rate);
        } else {
            throw new IllegalArgumentException("Invalid bill type");
        }
    }
}


