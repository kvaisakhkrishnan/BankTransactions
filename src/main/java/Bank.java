import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts;
    Bank(){
        this.accounts = new ArrayList<>();
        System.out.println("Bank Created");
        System.out.println("============");
    }

    synchronized void deposit(int accountNo, int amount){
        System.out.println("==============================");
        System.out.println("DEPOSIT");
        boolean flag = false;
        for(Account account : this.accounts){
            if(account.accountNo == accountNo){
                flag = true;
                account.balance += amount;
            }
        }
        if(flag == true){
            System.out.println("Balance Updated. Account No: " + accountNo);
            System.out.println("==============================");
        }
        else{
            System.out.println("Account Not Found. Account No: " + accountNo);
            System.out.println("==============================");
        }
    }

    synchronized void withdraw(int accountNo, int amount){
        boolean flag = false;
        for(Account account : this.accounts){
            if(account.accountNo == accountNo){

                if(account.balance >= amount){
                    account.balance -= amount;
                    flag = true;
                }else{
                    System.out.println("Insufficient Balance. Account No: " + accountNo);
                }
            }
        }
        if(flag == true){
            System.out.println("Balance Updated. Account No: " + accountNo);
        }
        else{
            System.out.println("Account Not Found. Account No: " + accountNo);
        }
    }

    synchronized int getBalance(int accountNo){
        boolean flag = false;
        for(Account account : this.accounts){
            if(account.accountNo == accountNo){
                flag = true;
                return account.balance;
            }
        }
        return -1;
    }

    synchronized void addAccount(int accountNo){
        Account account = new Account(accountNo);
        this.accounts.add(account);
    }
}
