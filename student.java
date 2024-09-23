package tugas2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class student {
    public static Map<String, String> student = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // boolean running = true;
        
        while (true) {
            System.out.println("welcome to the Student Information System Management.");
            System.out.println("menu :");
            System.out.println("1. Create Student");
            System.out.println("2. Read Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Select Option : ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    readStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    // input.close();
                    System.exit(0);
                    // running = false;
                    break;
                default:
                    System.out.println("Invalid option!! Please try again.");
            }
        }
    }

    public static void createStudent() {
        System.out.print("enter NIM: ");
        String nim = scanner.nextLine();
        if (student.containsKey(nim)) {
            System.out.println("NIM has been registered.");
            return;
        }
        System.out.print("enter Name: ");
        String name = scanner.nextLine();
        student.put(nim, name);
        System.out.println("Student successfully added!");
    }

    public static void readStudents() {
        if (student.isEmpty()) {
            System.out.println("No student registered.");
            return;
        }
        System.out.println("Student list : ");
        for (Map.Entry<String, String> entry : student.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public static void updateStudent() {
        System.out.print("Enter NIM that will be updated : ");
        String nim = scanner.nextLine();
        if (!student.containsKey(nim )) {
            System.out.println("NIM not found!");
            return;
        }
        System.out.print("Enter new name : ");
        String newName = scanner.nextLine();
        student.put(nim, newName);
        System.out.println("Student successfully updated!");
    }

    public static void deleteStudent() {
        System.out.print("Enter the NIM to be deleted: ");
        String nim = scanner.nextLine();
        if (student.remove(nim) != null) {
            System.out.println("Student successfully deleted!");
        } else {
            System.out.println("NIM not found!");
        }
    }
}
