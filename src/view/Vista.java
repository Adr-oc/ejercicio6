package view;
import java.util.Scanner;
import controller.Controller;

public class Vista {

    
    public static void app(String[] args) throws Exception {
        Controller controller = new Controller();
        int[] tickets = controller.getTicketsPriority();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            clearScreen();
            menu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Cantidad de tickets por prioridad:");
                    System.out.println("Baja: " + tickets[0]);
                    System.out.println("Media: " + tickets[1]);
                    System.out.println("Alta: " + tickets[2]);
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Prioridad con mas suma de totales: " + controller.getTopPriority());
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1. Cantidad de tickets por prioridad");
        System.out.println("2. Priodidad de tickets mayor ingreso");
        System.out.println("3. Salir");
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}