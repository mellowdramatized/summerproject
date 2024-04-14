import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;


public class Main extends HttpServlet {


    // Define the correct passcode
    private static final String CORRECT_PASSCODE = "1234";

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the passcode
        System.out.println("Enter the passcode to control the garage door:");
        String enteredPasscode = scanner.nextLine();

        // Check if the entered passcode matches the correct passcode
        if (enteredPasscode.equals(CORRECT_PASSCODE)) {
            // Passcode is correct, allow access to control the garage door
            System.out.println("Passcode accepted. You can now control the garage door.");
            // Call a method to open or close the garage door
            // For example: openGarageDoor();
        } else {
            // Passcode is incorrect, deny access to control the garage door
            System.out.println("Incorrect passcode. Access denied.");
        }

        // Close the Scanner
        scanner.close();
    }

    // Method to open the garage door
    private static void openGarageDoor() {
        System.out.println("Opening the garage door...");
        // Implement logic to open the garage door
    }

    // Method to close the garage door
    private static void closeGarageDoor() {
        System.out.println("Closing the garage door...");
        // Implement logic to close the garage door
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("open".equals(action)) {
            // Code to open the garage door
            openGarageDoor();
            System.out.println("Opening garage door...");
            // Call your control logic method to open the door
        } else if ("close".equals(action)) {
            // Code to close the garage door
            closeGarageDoor();
            System.out.println("Closing garage door...");
            // Call your control logic method to close the door
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid action");
            return;
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Action executed successfully");
    }
}