public class AccountTest {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount();

        account.setName("Ahmad");
        account.setBalance(10000.0);
        account.DisplayAccount();
        account.Deposit(1500.0);
        account.withdrawl(500);
        account.applyInterest();

        SavingBond savings = new SavingBond(account.getName(), account.getBalance());

        savings.setTempoWaktu(24); // Set tempo waktu

        double totalWithInterest = savings.kenaikanBunga(); // Hitung total dengan kenaikan bunga
        System.out.println("Total saldo setelah kenaikan bunga: " + totalWithInterest);

        savings.payInstallment(500.0, account);
    }
}
