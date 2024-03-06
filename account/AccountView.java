package account;


import java.util.Scanner;

public class AccountView {

    public static void main(Scanner scan) {
        AccountController ctrl = new AccountController();

        while (true){
            System.out.println("[메뉴] 0-Exit\n" +
                                "1-Create\n" +
                                "2-Deposit\n" +
                                "3-Withdraw\n" +
                                "4-Balance\n" +
                                "5-RemoveAccount\n"+
                                "6-AccountList\n");
            switch (scan.next()){
                case "0":
                    System.out.println("Exit Account page");
                    System.out.println(ctrl.createAccount(scan));
                    return;
                case "1":
                    System.out.println("====== Create Account ======");
                    System.out.println(ctrl.createAccount(scan));
                    break;
                case "2":
                    System.out.println("====== Deposit ======");
                    System.out.println(ctrl.deposit(scan));
                    break;
                case "3":
                    System.out.println("====== Withdraw ======");
                    System.out.println(ctrl.withdraw(scan));
                    break;
                case "4":
                    System.out.println("====== Check Balance ======");
                    System.out.println(ctrl.getBalance(scan));
                    break;
                case "5":
                    System.out.println("====== Remove Account ======");
                    System.out.println(ctrl.cancelAccount(scan));
                    break;
                case "6":
                    System.out.println("====== Account List ======");
                    System.out.println(ctrl.getAccounts());
                    break;
            }
        }
    }
}
