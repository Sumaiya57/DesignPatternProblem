import java.util.Scanner;

public class CommandExecutor {
    private static final String ADMIN_ROLE = "admin";
    private static final String NORMAL_USER_ROLE = "normal_user";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter role (admin/normal_user): ");
        String role = scanner.nextLine();

        if (role.equals(ADMIN_ROLE)) {
            executeAsAdmin(scanner);
        } else if (role.equals(NORMAL_USER_ROLE)) {
            executeAsNormalUser(scanner);
        } else {
            System.out.println("Invalid role.");
        }
    }

    private static void executeAsAdmin(Scanner scanner) {
        System.out.println("Welcome, admin. you can use all commands.");
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        executeCommand(command);
    }

    private static void executeAsNormalUser(Scanner scanner) {
        System.out.println("Welcome, normal user. You can use all commands except 'rm -rf'.");
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        if (command.equals("rm -rf")) {
            System.out.println("Permission denied.");
        } else {
            executeCommand(command);
        }
    }

    private static void executeCommand(String command) {
        // Implement command execution logic here
        System.out.println("Executing command: " + command);
        // Dummy execution for demonstration purposes
        System.out.println("Command executed successfully.");
    }
}
