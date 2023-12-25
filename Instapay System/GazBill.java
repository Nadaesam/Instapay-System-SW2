
import java.io.Serializable;



public class GazBill extends Bill implements Serializable{
    private float cubicMeters;
    private float gasRate;

    public GazBill(String billId, float tax, float cubicMeters, float gasRate) {
        super(billId, tax);
        this.cubicMeters = cubicMeters;
        this.gasRate = gasRate;
    }

    public float getCubicMeters() {
        return cubicMeters;
    }

    public void setCubicMeters(float cubicMeters) {
        this.cubicMeters = cubicMeters;
    }

    public float getGasRate() {
        return gasRate;
    }

    public void setGasRate(float gasRate) {
        this.gasRate = gasRate;
    }

    @Override
    public float calculateTotal() {
        return cubicMeters * gasRate + getTax();
    }

    @Override
    public void billDetails() {
        super.billDetails();
        System.out.println("Cubic Meters: " + cubicMeters);
        System.out.println("Gas Rate: " + gasRate);
        System.out.println("Total Amount: " + calculateTotal());
    }
}


