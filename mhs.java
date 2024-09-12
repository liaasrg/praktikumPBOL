package Tugass1;
import java.util.Scanner;

public class mhs {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
    
        System.out.print ("masukkan Nama: ");
        String nama = input.nextLine();
    
        System.out.print ("masukkan NIM: ");
        int nim = input.nextInt();
    
        input.close();
    
        System.out.println("hai " +nama +" NIM " +nim +", kamu berhasil menyelesaikan tugas! :)");
        
        }
    
}
