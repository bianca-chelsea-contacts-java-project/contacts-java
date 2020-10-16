import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {

    public static void main(String[] args) throws IOException {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");

        String directoryName = "data";
        String fileName = "contacts.txt";


        Contact chelsea = new Contact("Chelsea", "2102380983");

        Path dataFilePath = ContactsFile.createDirectoryAndFile(directoryName, fileName);
        List<String> contactList = Arrays.asList(chelsea.getName(),chelsea.getPhoneNumber());
        Files.write(dataFilePath, contactList);



     addNumber(contactList, dataFilePath);
        ContactsFile.printFileContents(dataFilePath);
    }

    public static void addNumber(List<String> contactList, Path dataFilePath)throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new contact name: ");
        String userInput = sc.nextLine();
        System.out.println("Enter new contact number: ");
        String userNumber = sc.nextLine();

        Files.write(dataFilePath, Arrays.asList(userInput, userNumber), StandardOpenOption.APPEND);
        ContactsFile.printFileContents(dataFilePath);
    }


    public static void deleteNumber(Path dataFilePath, String line){

    }

}
