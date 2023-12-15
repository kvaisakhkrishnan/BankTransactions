public class TransactionsDemo{
    public void startTransactions() throws InterruptedException {
        Bank bank = new Bank();
        Thread thread1 = new Thread(() -> {
            bank.addAccount(1);
            bank.deposit(1, 100);
            int balance = bank.getBalance(1);
            if(balance == -1){
                System.out.println("Account " + 1 +" Not Found");
            }
            else{
                System.out.println("Account " + 1 +" Balance: " + balance);
            }
        });
        Thread thread2 = new Thread(() -> {
            bank.addAccount(2);
            bank.deposit(2, 1200);
            int balance = bank.getBalance(2);
            if(balance == -1){
                System.out.println("Account " + 2 +" Not Found");
            }
            else{
                System.out.println("Account " + 2 +" Balance: " + balance);
            }
        });
        Thread thread3 = new Thread(() -> {
            bank.withdraw(3, 100);
            bank.addAccount(3);
            bank.withdraw(3, 100);
            bank.deposit(3, 100);
            bank.withdraw(3, 200);
            bank.withdraw(3, 50);
            bank.withdraw(3, 10);
            bank.deposit(3, 100);
            bank.withdraw(3, 10);
            int balance = bank.getBalance(3);
            if(balance == -1){
                System.out.println("Account " + 3 +" Not Found");
            }
            else{
                System.out.println("Account " + 3 +" Balance: " + balance);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("\n\nSTATUS AFTER TREAD EXECUTION");
        System.out.println("-------------------");
        System.out.println("| ACCOUNT | BALANCE |");
        System.out.println("-------------------");
        System.out.println("| 1 | " +  bank.getBalance(1) + " |");
        System.out.println("| 2 | " +  bank.getBalance(2) + " |");
        System.out.println("| 3 | " +  bank.getBalance(3) + " |");
        System.out.println("-------------------");

    }
}
