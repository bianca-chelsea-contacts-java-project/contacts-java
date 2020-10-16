import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsFile extends ContactsApp {

    public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Path dataFilePath = Paths.get(directoryName, fileName);

        //We have to create a directory first before we create before we create the file.

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
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s \n",fileContents.get(i));
        }
    }

    //update the contacts lists
    public static void updateLine(Path filePath, String oldValue, String newValue) throws IOException {
        //Replace a line in the file.
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            if(item.equals(oldValue)) {
                //Add my modified item.
                modifiedList.add(newValue);
            } else {
                //Add the existing because it isn't what we want to replace.
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    //delete contacts
    public static void deleteLine(Path filePath, String line) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            //I want to remove the bread from the list.
            if(!item.contains(line)) {
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

    //Empty the contacts list
    public static void  emptyAllContacts (Path dataFilePath) throws IOException {
        Files.write(dataFilePath, new ArrayList<>());
        System.out.println("After empty");
        ContactsFile.printFileContents(dataFilePath);
    }

    //search function
    public static void searchContact (Path filePath, String userSearch) throws IOException{
        List<String> fileContents = Files.readAllLines(filePath);
        //List<String> modifiedList = new ArrayList<>();
        for (String item: fileContents) {
            //System.out.println("item = " + item);
            //If contains the item, input into the new modified list
            if(item.contains(userSearch)) {
                System.out.println("item = " + item);
                //modifiedList.add(item);
            }
        }
        //Files.write(filePath, modifiedList);
    }






}
