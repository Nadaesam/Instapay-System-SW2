
import java.io.Serializable;




public class WaterBill extends Bill implements Serializable{
    private float usageUnits;
    private float waterRate;

    public WaterBill(String billId, float tax, float usageUnits, float waterRate) {
        super(billId, tax);
        this.usageUnits = usageUnits;
        this.waterRate = waterRate;
    }

    public float getUsageUnits() {
        return usageUnits;
    }

    public void setUsageUnits(float usageUnits) {
        this.usageUnits = usageUnits;
    }

    public float getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(float waterRate) {
        this.waterRate = waterRate;
    }

    @Override
    public float calculateTotal() {
        return usageUnits * waterRate + getTax();
    }

    @Override
    public void billDetails() {
        super.billDetails();
        System.out.println("Usage Units: " + usageUnits);
        System.out.println("Water Rate: " + waterRate);
        System.out.println("Total Amount: " + calculateTotal());
    }
}


 