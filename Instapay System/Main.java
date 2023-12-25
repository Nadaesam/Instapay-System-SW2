
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        API api = new API();
        User newUser = new BankUser();
        Database userdb = new Database();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 to register");
            System.out.println("Enter 2 to login");
            System.out.println("Enter 3 to Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.println("Enter 1 to register by Bank Account");
                System.out.println("Enter 2 to register by wallet");
                choice = scanner.nextInt();
                System.out.println();

                if (choice == 1) {
                    newUser = new BankUser();
                    newUser.register();
                } else if (choice == 2) {
                    newUser = new WalletUser();
                    newUser.register();
                }
            } else if (choice == 2) {
                newUser = newUser.login();
                while (newUser != null) {
                    System.out.println();
                    System.out.println("Enter 1 to pay a bill");
                    System.out.println("Enter 2 to transfer to a bank account");
                    System.out.println("Enter 3 to transfer to a wallet");
                    System.out.println("Enter 4 to transfer to another InstaPay account");
                    System.out.println("Enter 5 to view Profile");
                    System.out.println("Enter 6 to go to Login Padge");
                    choice = scanner.nextInt();
                    System.out.println();

                    if (choice == 1) {
                        System.out.println("Enter the type of bill you want to pay (WaterBill, ElectricityBill, GazBill):");
                        String billType = scanner.next();

                        Bill billToPay = null;
                        newUser.setBills(api.getUserBiils(newUser));
                        for (Bill bill : newUser.getBills()) {
                            if (bill.getClass().getSimpleName().equals(billType)) {
                                billToPay = bill;
                                break;
                            }
                        }

                        if (billToPay != null) {

                            BillPayer billPayer = new BillPayer();
                            billPayer.payBill(newUser, billToPay);

                        } else {
                            System.out.println("Invalid bill type.");
                        }
                    }
                    if (choice == 2) {
                        if ("BankUser".equals(newUser.getType())) {
                            System.out.println("Enter the reseiver phone number:");
                            String mobileNumber = scanner.next();

                            System.out.println("Enter the amount you want to transfer:");
                            float amount = scanner.nextInt();

                           
                            BankUser reciever = api.getBankUser(mobileNumber);
                            LocalDateTime date = LocalDateTime.of(2023, 11, 15, 0, 0);
                            BankAccountTransfer t = new BankAccountTransfer("1", amount, date, newUser, reciever);

                            t.transfer(newUser, reciever, amount);
                            t.generateReceipt();
                        } else {
                            System.out.println("this service valid only for bank users");
                        }
                    }
                    if (choice == 3) {
                        System.out.println("Enter the reseiver phone number:");
                        String ph = scanner.next();

                        System.out.println("Enter the amount you want to transfer:");
                        float am = scanner.nextInt();

                        WalletUser wu = api.getUserWallet(ph);

                        if (wu != null) {

                            LocalDateTime date = LocalDateTime.of(2023, 11, 15, 0, 0);
                            WalletTransfer t = new WalletTransfer("1", am, date, newUser, wu);

                            t.transfer(newUser, wu, am);
                            t.generateReceipt();

                        } else {
                            System.out.println("Receiver not found");
                        }

                    }
                    if (choice == 4) {
                        System.out.println("Enter the reseiver username:");
                        String username = scanner.next();
                        System.out.println("Enter the amount you want to transfer:");
                        float amount = scanner.nextInt();
                        LocalDateTime date = LocalDateTime.of(2023, 11, 15, 0, 0);
                        User reciever = userdb.getUser(username);
                        boolean recieverExist = userdb.doesUserExist(username);
                        if (recieverExist) {
                            InstapyTransfer transaction = new InstapyTransfer("12", amount, date, newUser, reciever);
                            transaction.generateReceipt();
                        } else {
                            System.out.println("Receiver not found");
                        }
                    }
                    if (choice == 5) {
                        newUser.displayUserInfo();
                    }
                    if (choice == 6) {
                        break;
                    }
                }
            } else if (choice == 3) {
                return;
            }

        }

    }
}
