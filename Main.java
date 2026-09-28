import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Bank bank = new Bank();

        bank.addCustomer("Budi", "Santoso");
        Customer customer1 = bank.getCustomer(0);
        
        customer1.setAccount(new Account(500000));
        Account activeAccount = customer1.getAccount(0);

        System.out.println("Selamat Datang, " + customer1.getFirstName() + " " + customer1.getLastName() + "!");
        
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== MENU ATM SEDERHANA ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai (Withdraw)");
            System.out.println("3. Setor Tunai (Deposit)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.println("Saldo Anda saat ini: Rp " + activeAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Masukkan nominal penarikan: Rp ");
                    double tarik = scanner.nextDouble();
                    if (activeAccount.withdraw(tarik)) {
                        System.out.println("Penarikan berhasil! Sisa saldo: Rp " + activeAccount.getBalance());
                    } else {
                        System.out.println("Maaf, saldo tidak mencukupi.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nominal setoran: Rp ");
                    double setor = scanner.nextDouble();
                    if (activeAccount.deposit(setor)) {
                        System.out.println("Setoran berhasil! Saldo Anda: Rp " + activeAccount.getBalance());
                    } else {
                        System.out.println("Nominal setoran tidak valid.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
}