package contacts;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ContactsTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the ...");
        System.out.println("\n" +
                " ██████╗ ██████╗ ███╗   ██╗████████╗ █████╗  ██████╗████████╗    ██╗     ██╗███████╗████████╗\n" +
                "██╔════╝██╔═══██╗████╗  ██║╚══██╔══╝██╔══██╗██╔════╝╚══██╔══╝    ██║     ██║██╔════╝╚══██╔══╝\n" +
                "██║     ██║   ██║██╔██╗ ██║   ██║   ███████║██║        ██║       ██║     ██║███████╗   ██║   \n" +
                "██║     ██║   ██║██║╚██╗██║   ██║   ██╔══██║██║        ██║       ██║     ██║╚════██║   ██║   \n" +
                "╚██████╗╚██████╔╝██║ ╚████║   ██║   ██║  ██║╚██████╗   ██║       ███████╗██║███████║   ██║   \n" +
                " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝   ╚═╝       ╚══════╝╚═╝╚══════╝   ╚═╝  ");

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");

        //Generate Scanner for users inputs
        Scanner scan = new Scanner(System.in);

        int userSelection = scan.nextInt();
        String userNameInput = scan.nextLine();
        String userNumInput = scan.nextLine();

        String directoryName = "data";
        String fileName = "contacts.txt";

        Path dataFilePath = ContactsIO.createDirectoryAndFile(directoryName, fileName);



    }


}
