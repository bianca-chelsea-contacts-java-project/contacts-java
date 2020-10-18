package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsIO {
    //Scanner for the userInputs
    Scanner scan = new Scanner (System.in);
    String userNameInput = scan.nextLine();
    String userNumInput = scan.nextLine();


    //create a directory and file
    public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Path dataFilePath = Paths.get(directoryName, fileName);

        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        if (!Files.exists(dataFilePath)) {
            Files.createFile(dataFilePath);
        }

        return dataFilePath;
    }

    //print name and number
    public static void printFileContents(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        System.out.println("Name | Phone number");
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s \n",fileContents.get(i));
        }
    }

    //update contacts
    //update the contacts lists
    public static void updateContact(Path filePath, String oldValue, String newValue) throws IOException {
        //Replace a line in the file.
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            if(item.toLowerCase().contains(oldValue.toLowerCase())) {
                //Add my modified item.
                String[] tokens= item.split(" ");
                modifiedList.add(newValue + " | " + tokens[2]);
            } else {
                //Add the existing because it isn't what we want to replace.
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }
    // take the line that contains old value
//split that line by "|"
//to seperate name from number
//name and number get stored in array of strings String[] token
//then add newValue + String[1] token


    //add contacts
    public static void addNamesAndNumbers (Path dataFilePath, String newName, String newNumber) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter new contact name: ");
//        String userInput = sc.nextLine().trim();
//        System.out.println("Enter new contact number: ");
//        String userNumber = sc.nextLine().trim();
//
//        Contacts1 newUser = new Contacts1(userInput, userNumber);
//        String [] testUser = {newUser.userNameNumber()};

        Contacts1 newUser = new Contacts1(newName, newNumber);
        String [] testUser = {newUser.userNameNumber()};

        //System.out.println(newUser.userNameNumber());
        Files.write(dataFilePath, Arrays.asList(testUser), StandardOpenOption.APPEND);
        //Files.write(dataFilePath, Arrays.asList(newUser.userNameNumber()), StandardOpenOption.APPEND);
        ContactsIO.printFileContents(dataFilePath);
    }

    //delete contacts
    public static void deleteContact(Path filePath, String line) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            //I want to remove the bread from the list.
            if(!item.toLowerCase().contains(line.toLowerCase())) {
                System.out.println("Successfully deleted!");
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    //search contacts method
    public static void searchContact (Path filePath, Path modifiedDataFilePath, String userSearch) throws IOException{
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            //System.out.println("item = " + item);
            //If contains the item, input into the new modified list
            if(item.toLowerCase().contains(userSearch.toLowerCase())) {
                System.out.println(item);
                modifiedList.add(item);
            }
        }
        Files.write(modifiedDataFilePath, modifiedList);
    }

//    public static void userInput () {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter contact name: ");
//        String userInput = sc.nextLine().trim();
//        System.out.println("Enter contact number: ");
//        String userNumber = sc.nextLine().trim();
//    }

    public static String userNameInput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact name: ");
        String userInput = sc.nextLine().trim();
        return userInput;
    }

    public static String userNumInput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number: ");
        String userNumber = sc.nextLine().trim();
        return userNumber;
    }

}

