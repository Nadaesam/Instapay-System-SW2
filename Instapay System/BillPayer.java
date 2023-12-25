

public class BillPayer {
    private User user;
    private Bill bill;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void payBill(User user, Bill bill) {
        
        bill.billDetails();
        user.pay(bill.calculateTotal());
        System.out.println("Bill paid successfully!");
        user.removeBill(bill);
      
    }
}
