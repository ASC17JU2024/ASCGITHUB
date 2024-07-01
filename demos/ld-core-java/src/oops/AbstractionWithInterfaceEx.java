package oops;

public class AbstractionWithInterfaceEx {
    public static void main(String[] args) {
        DebitCard debitCard = new SavingsAccount();
        debitCard.checkAccountBalance();
        debitCard.withdraw();
//        debitCard.transferAmount();

        NetBanking netBanking = new SavingsAccount();
        netBanking.checkAccountBalance();
        netBanking.dispalyAccountInfo();
        netBanking.transferAmount();
//        netBanking.withdraw();
    }
}
interface CoreBanking {
    public void checkAccountBalance();
}
interface NetBanking extends CoreBanking{
//    All the below are dispalyAccountInfo() definitions aresame
    public abstract void dispalyAccountInfo();
//    abstract void dispalyAccountInfo();
//    void dispalyAccountInfo();
    abstract void transferAmount();
//    public void checkAccountBalance();
}

interface DebitCard extends CoreBanking{
//    public void checkAccountBalance();
    public void withdraw();
}
interface InternationalDebitCard extends  DebitCard{
    public void performInternationalTransactions();
}
class SavingsAccount implements NetBanking,DebitCard{

    public void withdraw() {
        System.err.println("Withdraw money from savings account....");
    }
    @Override
//	override the abstract method
    public void dispalyAccountInfo() {
        System.err.println("Savings Account");
    }
    @Override
    public void transferAmount() {
        System.out.println("Transfer amount from Savings Bank Account using NetBanking");
    }
    @Override
    public void checkAccountBalance() {
        System.out.println("Check balance amount from Savings Bank Account");
    }

}