public class Account {
    int accountNo;
    int balance;
    Account(int accountNo){
        this.accountNo = accountNo;
        this.balance = 0;
        System.out.println("==============================");
        System.out.println("Bank Account Created");
        System.out.println("Account No " + this.accountNo);
        System.out.println("==============================");
    }
}
