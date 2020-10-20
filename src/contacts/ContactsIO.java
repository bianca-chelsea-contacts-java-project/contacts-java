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
    Scanner scan = new Scanner(System.in);
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
        System.out.println("Name      | Phone number  |");
        System.out.println("---------------------------");
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%-25s \n", fileContents.get(i));
        }
    }

    //update contacts
    //update the contacts name
    public static void updateContact(Path filePath, String oldValue, String newValue) throws IOException {
        //Replace a line in the file.
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            if (item.toLowerCase().contains(oldValue.toLowerCase())) {
                //Add my modified item
                String[] tokens = item.split("\\|");
                modifiedList.add(newValue + " | " + tokens[1]);
            } else {
                //Add the existing because it isn't what we want to replace.
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    //update contact number
    public static void updateContactNum(Path filePath, Path modifiedFileName, String oldValue, String newValue) throws IOException {
        //Replace a line in the file.
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            if (item.toLowerCase().contains(oldValue.toLowerCase())) {
                //Add my modified item.
                String[] tokens = item.split("\\|");
                modifiedList.add(tokens[0] + " | " + newValue);
                deleteContact(filePath, item.toLowerCase());
            } else {
                //Add the existing because it isn't what we want to replace.
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }


    public static Boolean checkNames(Path dataFilePath, Path modifiedFileName, String newName, String newNumber) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> fileContents = Files.readAllLines(dataFilePath);

        boolean userConfirmation = false;

        //iterating through the lines in contacts.txt
        for (String item : fileContents) {
            //if the line(item) contains the name input by user
            if (item.toLowerCase().contains(newName.toLowerCase())) {
                // then ask user if they want to overwrite
                System.out.println("There's already a contact named " + item + ". Do you want to overwrite it? [Yes/No]");
                String userInput = sc.nextLine().trim();
                userConfirmation = userInput.equalsIgnoreCase("yes");
                //if the user agrees to overwrite, program updates that contact info and terminates this method
                if (userConfirmation) {
                    updateContactNum(dataFilePath, modifiedFileName, newName, newNumber);

                }
            }
        }
        return userConfirmation;
    }


    //add contacts
    public static void addNamesAndNumbers(Path dataFilePath, Path modifiedFileName, String newName, String newNumber) throws IOException {

        if (!checkNames(dataFilePath, modifiedFileName, newName, newNumber)) {
            Contacts1 newUser = new Contacts1(newName, newNumber);
            String testUser = String.format("%-10s| %-14s|", newName , newNumber);
            Files.write(dataFilePath, Arrays.asList(testUser), StandardOpenOption.APPEND);
        }
        ContactsIO.printFileContents(dataFilePath);
    }


    //delete contacts
    public static void deleteContact(Path filePath, String line) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();

        for (String item : fileContents) {
            //I want to remove the paramter line from the list
            if (!item.toLowerCase().contains(line.toLowerCase())) {
                modifiedList.add(item);
            }
        }
        System.out.println("Successfully modified");
        Files.write(filePath, modifiedList);
    }

    //search contacts method
    public static void searchContact(Path filePath, Path modifiedDataFilePath, String userSearch) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            //If contains the item, input into the new modified list
            if (item.toLowerCase().contains(userSearch.toLowerCase())) {
                System.out.println(item);
                modifiedList.add(item);
            }
        }
        Files.write(modifiedDataFilePath, modifiedList);
    }

    public static String userNameInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact name: ");
        String userInput = sc.nextLine().trim();
        return userInput;
    }

    public static String userNumInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact number: ");
        String userNumber = sc.nextLine().trim();
        return userNumber;
    }

}

