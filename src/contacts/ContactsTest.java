package contacts;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsTest {
    public static void main(String[] args) throws IOException {

        //Generate Scanner for users inputs
        Scanner scan = new Scanner(System.in);

        boolean keepGoing = true;

        String directoryName = "data";
        String fileName = "contacts.txt";
        String modifiedFileName = "contacts1.txt";

        Path dataFilePath = ContactsIO.createDirectoryAndFile(directoryName, fileName);
        Path modifiedDataFilePath = ContactsIO.createDirectoryAndFile(directoryName, modifiedFileName);


        do {
            System.out.println("\nWelcome to the ...");
            System.out.println("\n" +
                    " ██████╗ ██████╗ ███╗   ██╗████████╗ █████╗  ██████╗████████╗    ██╗     ██╗███████╗████████╗\n" +
                    "██╔════╝██╔═══██╗████╗  ██║╚══██╔══╝██╔══██╗██╔════╝╚══██╔══╝    ██║     ██║██╔════╝╚══██╔══╝\n" +
                    "██║     ██║   ██║██╔██╗ ██║   ██║   ███████║██║        ██║       ██║     ██║███████╗   ██║   \n" +
                    "██║     ██║   ██║██║╚██╗██║   ██║   ██╔══██║██║        ██║       ██║     ██║╚════██║   ██║   \n" +
                    "╚██████╗╚██████╔╝██║ ╚████║   ██║   ██║  ██║╚██████╗   ██║       ███████╗██║███████║   ██║   \n" +
                    " ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝   ╚═╝       ╚══════╝╚═╝╚══════╝   ╚═╝  ");

            System.out.println("\n" +
                    "1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Search a contact by number.\n" +
                    "5. Delete an existing contact.\n" +
                    "6. Edit an existing contact name.\n" +
                    "7. Exit.\n" +
                    "Enter an option (1, 2, 3, 4, 5, 6, or 7):\n");
            int userSelection = Integer.parseInt(scan.nextLine().trim());
            switch (userSelection) {
                case 1:
                    //View contact list
                    ContactsIO.printFileContents(dataFilePath);
                    break;
                case 2:
                    //Add a new contact
                    ContactsIO.addNamesAndNumbers(dataFilePath,modifiedDataFilePath, ContactsIO.userNameInput(),ContactsIO.userNumInput());
                    break;
                case 3:
                    //Search a contact by name
                    ContactsIO.searchContact(dataFilePath, modifiedDataFilePath, ContactsIO.userNameInput());
                    break;
                case 4:
                    //Search a contact by number
                    ContactsIO.searchContact(dataFilePath, modifiedDataFilePath, ContactsIO.userNumInput());
                    break;
                case 5:
                    //Delete an existing contact
                    ContactsIO.deleteContact(dataFilePath, ContactsIO.userNameInput());
                    break;
                case 6:
                    //Update an existing contact
                    ContactsIO.updateContact(dataFilePath, ContactsIO.userNameInput(), ContactsIO.userNameInput());
                    break;
                case 7:
                    //Exit
                    System.out.println("Thank you!!");
                    System.exit(0);
                default:
                    System.err.println("Please enter a number between 1 - 7!");
                    break;
            }

            System.out.println("Do want to chose another option? [y/n]");
            String userResponse = scan.nextLine().trim();

            if (!userResponse.equalsIgnoreCase("y")) {
                keepGoing = false;
            }
        } while (keepGoing);

    }


}
