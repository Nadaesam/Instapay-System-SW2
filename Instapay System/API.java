
import java.util.ArrayList;
import java.util.List;

public class API {

    private List<BankUser> bankUsers = new ArrayList<>();
    private List<WalletUser> walletUsers = new ArrayList<>();

    API() {

        ArrayList<WalletUser> WU = new ArrayList<>();

        BillFactory billFactory = new BillFactory();
        Bill waterBill5 = billFactory.createBill("WaterBill", "1", 10, 50, 100);
        Bill electricityBill5 = billFactory.createBill("ElectricityBill", "1", 10, 60, 20);
        Bill gazBill5 = billFactory.createBill("GazBill", "2", 10, 30, 50);

        Wallet wallet1 = new FawryWallet("1", 6000, "111");
        WalletUser user1 = new WalletUser("1", "1Ahmad", "password!!!", "111", true);
        user1.setWallet(wallet1);

        user1.getBills().add(waterBill5);
        user1.getBills().add(electricityBill5);
        user1.getBills().add(gazBill5);
        WU.add(user1);

        Wallet wallet2 = new VodafoneCashWallet("2", 6000, "222");
        WalletUser user2 = new WalletUser("2", "2Ahmad", "password!!!", "222", true);
        user2.setWallet(wallet2);

        user2.getBills().add(waterBill5);
        user2.getBills().add(electricityBill5);
        user2.getBills().add(gazBill5);
        WU.add(user2);

        Wallet wallet3 = new CIBWallet("3", 6000, "333");
        WalletUser user3 = new WalletUser("3", "3Ahmad", "password!!!", "333", true);
        user3.setWallet(wallet3);

        user3.getBills().add(waterBill5);
        user3.getBills().add(electricityBill5);
        user3.getBills().add(gazBill5);
        WU.add(user3);

        walletUsers = WU;

        ArrayList<BankUser> BU = new ArrayList<>();

        Bill waterBill1 = billFactory.createBill("WaterBill", "1", 10, 50, 100);
        Bill electricityBill1 = billFactory.createBill("ElectricityBill", "1", 10, 60, 20);
        Bill gazBill1 = billFactory.createBill("GazBill", "2", 10, 30, 50);

        BankAccount bank1 = new BankAccount("1", "EL Bank Alahly", 6000, "1111");
        BankUser buser1 = new BankUser("1", "4Ahmad", "password!!!", "1111", true);
        buser1.setBankAccount(bank1);

        buser1.getBills().add(waterBill1);
        buser1.getBills().add(electricityBill1);
        buser1.getBills().add(gazBill1);

        BU.add(buser1);

        Bill waterBill2 = billFactory.createBill("WaterBill", "1", 10, 50, 100);
        Bill electricityBill2 = billFactory.createBill("ElectricityBill", "1", 10, 60, 20);
        Bill gazBill2 = billFactory.createBill("GazBill", "2", 10, 30, 50);

        BankAccount bank2 = new BankAccount("2", "EL Bank Alahly", 6000, "2222");
        BankUser buser2 = new BankUser("2", "5Ahmad", "password!!!", "2222", true);
        buser2.setBankAccount(bank2);

        buser2.getBills().add(waterBill2);
        buser2.getBills().add(electricityBill2);
        buser2.getBills().add(gazBill2);

        BU.add(buser2);

        Bill waterBill3 = billFactory.createBill("WaterBill", "1", 10, 50, 100);
        Bill electricityBill3 = billFactory.createBill("ElectricityBill", "1", 10, 60, 20);
        Bill gazBill3 = billFactory.createBill("GazBill", "2", 10, 30, 50);

        BankAccount bank3 = new BankAccount("3", "EL Bank Alahly", 6000, "3333");
        BankUser buser3 = new BankUser("3", "6Ahmad", "password!!!", "3333", true);
        buser3.setBankAccount(bank3);

        buser3.getBills().add(waterBill3);
        buser3.getBills().add(electricityBill3);
        buser3.getBills().add(gazBill3);

        BU.add(buser3);

        bankUsers = BU;

    }

    public ArrayList<Bill> getUserBiils(User user) {

        for (BankUser u : bankUsers) {
            if (u.getMobileNumber().equals(user.getMobileNumber())) {
                return u.getBills();
            }
        }

        for (WalletUser u : walletUsers) {
            if (u.getMobileNumber().equals(user.getMobileNumber())) {
                return u.getBills();
            }
        }
        System.out.println("it is null--------------------------");
        return null;
    }

    public void addBankUser(BankUser user) {
        bankUsers.add(user);
    }

    public void addWalletUser(WalletUser user) {
        walletUsers.add(user);
    }

    public boolean authenticateWalletUser(String mobileNumber) {
        for (WalletUser user : walletUsers) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean autheticateBankUser(String mobileNumber) {

        for (BankUser user : bankUsers) {
            if (user.getMobileNumber().equals(mobileNumber)) {
                return true;
            }
        }

        return false;
    }

    public WalletUser getUserWallet(String mobileNumber) {
        for (WalletUser user : walletUsers) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return user;
            }
        }
        return null;
    }

    public Wallet getWallet(String mobileNumber) {
        for (WalletUser user : walletUsers) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return user.getWallet();
            }
        }
        return null;
    }

    public BankAccount getUserBankAccount(String mobileNumber) {
        for (BankUser user : bankUsers) {
            if (user.getMobileNumber().equals(mobileNumber)) {
                return user.getBankAccount();
            }
        }

        return null;
    }

    BankUser getBankUser(String mobileNumber) {
        for (BankUser user : bankUsers) {

            if (user.getMobileNumber().equals(mobileNumber)) {
                return user;
            }
        }
        return null;
    }

}
