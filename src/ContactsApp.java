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
        System.out.println("/      | /  __  \\  |  \\ |  | |           |   /   \\     /      ||           |   |  |     |  |     /       |           |\n" +
                "|  ,----'|  |  |  | |   \\|  | `---|  |----`  /  ^  \\   |  ,----'`---|  |----`   |  |     |  |    |   (----`---|  |----`\n" +
                "|  |     |  |  |  | |  . `  |     |  |      /  /_\\  \\  |  |         |  |        |  |     |  |     \\   \\       |  |     \n" +
                "|  `----.|  `--'  | |  |\\   |     |  |     /  _____  \\ |  `----.    |  |        |  `----.|  | .----)   |      |  |     \n" +
                " \\______| \\______/  |__| \\__|     |__|    /__/     \\__\\ \\______|    |__|        |_______||__| |_______/       |__|     \n" +
                "                                                                                                                       ");

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):\n");

        String directoryName = "data";
        String fileName = "contacts.txt";

        Path dataFilePath = ContactsFile.createDirectoryAndFile(directoryName, fileName);

        //Contact chelsea = new Contact("Chelsea", "2102380983");
        //List<String> contactList = Arrays.asList("Name | Phone number");

        //Files.write(dataFilePath, contactList);



     //addNumber(contactList, dataFilePath);

     //namesAndNumbers(dataFilePath);
     //namesAndNumbers(dataFilePath);

        ContactsFile.deleteLine(dataFilePath, "bob");

        ContactsFile.searchContact(dataFilePath, "nope");

     //ContactsFile.searchContact(dataFilePath, "amy");

        ContactsFile.printFileContents(dataFilePath);
    }

//    public static void addNumber(List<String> contactList, Path dataFilePath)throws IOException{
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter new contact name: ");
//        String userInput = sc.nextLine();
//        System.out.println("Enter new contact number: ");
//        String userNumber = sc.nextLine();
//
//        Files.write(dataFilePath, Arrays.asList(userInput, userNumber), StandardOpenOption.APPEND);
//        ContactsFile.printFileContents(dataFilePath);
//    }


    public static void deleteLine(Path filePath, String line) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            //I want to remove the bread from the list.
            if(!item.equals(line)) {
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    public static void namesAndNumbers (Path dataFilePath) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new contact name: ");
        String userInput = sc.nextLine().trim();
        System.out.println("Enter new contact number: ");
        String userNumber = sc.nextLine().trim();

        Contact newUser = new Contact(userInput, userNumber);
        String [] testUser = {newUser.userNameNumber()};

        System.out.println(newUser.userNameNumber());
        Files.write(dataFilePath, Arrays.asList(testUser), StandardOpenOption.APPEND);
        ContactsFile.printFileContents(dataFilePath);
    }

}
