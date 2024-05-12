public class SavingBond {
    private Double balance;
    private String name;
    private Double interestRate;
    private int tempoWaktu; // Asumsi tempoWaktu adalah variabel instance

    public SavingBond(String name, Double balance) {
        this.name = name;
        this.balance = balance;
        this.interestRate = 0.05; // Default interest rate of 5%
    }

    // Metode setter untuk tempoWaktu
    public void setTempoWaktu(int tempoWaktu) {
        this.tempoWaktu = tempoWaktu;
    }

    // Metode getter untuk tempoWaktu
    public int getTempoWaktu() {
        return tempoWaktu;
    }

    public void payInstallment(Double installmentAmount, CheckingAccount account) {
        // Mengambil saldo dari akun cek
        Double checkingBalance = account.getBalance();

        if (installmentAmount > 0 && checkingBalance >= installmentAmount) {
            checkingBalance -= installmentAmount;
            account.setBalance(checkingBalance); // Mengupdate saldo di akun cek
            balance -= installmentAmount;
            System.out.println("Pembayaran cicilan sebesar " + installmentAmount + " Berhasil. Saldo tabungan sekarang " + balance);
        } else if (installmentAmount <= 0) {
            System.out.println("Jumlah cicilan harus lebih dari 0");
        } else {
            System.out.println("Saldo di akun cek tidak mencukupi untuk pembayaran cicilan sebesar: " + installmentAmount);
        }
    }

    // Metode untuk menghitung total uang dengan kenaikan bunga sesuai tempo waktu
    public double kenaikanBunga() {
        double uangTotal = balance; // Menggunakan balance sebagai ganti saldo
        double kenaikanBunga;

        if (tempoWaktu >= 48) {
            kenaikanBunga = 0.025;
        } else if (tempoWaktu >= 36) {
            kenaikanBunga = 0.02;
        } else if (tempoWaktu >= 24) {
            kenaikanBunga = 0.015;
        } else if (tempoWaktu >= 12) {
            kenaikanBunga = 0.01;
        } else {
            kenaikanBunga = 0.005;
        }

        for (int i = 1; i <= tempoWaktu; i++) {
            double bungaBulanIni = uangTotal * kenaikanBunga;
            uangTotal += bungaBulanIni;
        }
        return uangTotal;
    }
}
