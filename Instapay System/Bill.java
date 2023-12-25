
import java.io.Serializable;


public abstract class Bill implements Serializable {
    private String billId;
    private float tax;

    public Bill(String billId, float tax) {
        this.billId = billId;
        this.tax = tax;
    }

    public String getBillId() {
        return billId;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public abstract float calculateTotal();

    public void billDetails() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Tax: " + tax);
    }
}




