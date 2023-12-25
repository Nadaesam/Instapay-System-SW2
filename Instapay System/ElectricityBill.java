
import java.io.Serializable;



public class ElectricityBill extends Bill implements Serializable {
    private float KWhConsumed;
    private float electricityRate;

    public ElectricityBill(String billId, float tax, float KWhConsumed, float electricityRate) {
        super(billId, tax);
        this.KWhConsumed = KWhConsumed;
        this.electricityRate = electricityRate;
    }

    public float getKWhConsumed() {
        return KWhConsumed;
    }

    public void setKWhConsumed(float KWhConsumed) {
        this.KWhConsumed = KWhConsumed;
    }

    public float getElectricityRate() {
        return electricityRate;
    }


public void setElectricityRate(float electricityRate) {
        this.electricityRate = electricityRate;
    }

    @Override
    public float calculateTotal() {
        return KWhConsumed * electricityRate + getTax();
    }

    @Override
    public void billDetails() {
        super.billDetails();
        System.out.println("KWh Consumed: " + KWhConsumed);
        System.out.println("Electricity Rate: " + electricityRate);
        System.out.println("Total Amount: " + calculateTotal());
    }
}


