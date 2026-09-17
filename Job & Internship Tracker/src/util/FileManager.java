package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // Folder where data will be stored
    private static final String DATA_FOLDER = "data";

    // Folder where reports will be stored
    private static final String REPORT_FOLDER = "reports";

    // Constructor
    public FileManager() {
        createFolders();
    }

    // Create data and reports folders if they don't exist
    private void createFolders() {

        File dataFolder = new File(DATA_FOLDER);
        File reportFolder = new File(REPORT_FOLDER);

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        if (!reportFolder.exists()) {
            reportFolder.mkdirs();
        }
    }

    // Save data to a file
    public void saveData(String fileName, String data) {

        File file = new File(DATA_FOLDER, fileName);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(data);

            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Add data to an existing file
    public void appendData(String fileName, String data) {

        File file = new File(DATA_FOLDER, fileName);

        try (FileWriter writer = new FileWriter(file, true)) {

            writer.write(data);

            System.out.println("Data added successfully.");

        } catch (IOException e) {

            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    // Read all data from a file
    public List<String> readData(String fileName) {

        List<String> lines = new ArrayList<>();

        File file = new File(DATA_FOLDER, fileName);

        if (!file.exists()) {
            return lines;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                lines.add(line);
            }

        } catch (IOException e) {

            System.out.println("Error reading data: " + e.getMessage());
        }

        return lines;
    }

    // Delete a file
    public void deleteFile(String fileName) {

        File file = new File(DATA_FOLDER, fileName);

        if (file.exists()) {

            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Unable to delete file.");
            }

        } else {

            System.out.println("File does not exist.");
        }
    }

    // Save a report
    public void saveReport(String fileName, String content) {

        File file = new File(REPORT_FOLDER, fileName);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(content);

            System.out.println("Report generated successfully.");

        } catch (IOException e) {

            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}