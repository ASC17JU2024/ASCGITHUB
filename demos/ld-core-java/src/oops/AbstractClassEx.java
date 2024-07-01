package oops;

public class AbstractClassEx {
    public static void main(String[] args) {
        Account account;
//        account = new Account();
        account = new SavingAccount();
        account.withdraw();
        account.getBankDetails();
        account = new DigitalWallet();
        account.withdraw();
        account.getBankDetails();

        //Showcase dynamic polymoprhism
        System.out.println("Lets go!");
        account = Math.random() > 0.5 ? (account = new SavingAccount()) : (account = new DigitalWallet());
        account.withdraw();

//        account = new String();
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.withdraw();
    }
}

 abstract class Account {
    String bankName = "HSBC";
    abstract void withdraw();
    void getBankDetails(){
        System.out.println(bankName);
    }
}

class SavingAccount extends Account {
    @Override
    void withdraw(){
        System.out.println("withdraw cash from bank!");
    }
}

class DigitalWallet extends  Account{
    @Override
    void withdraw() {
        System.out.println("transfer amount to bank a/c");
    }
    void getBankDetails(){
        System.out.println("GPay");
    }
}