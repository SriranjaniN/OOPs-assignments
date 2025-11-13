package Assignment;
import java.rmi.*;
import java.nio.file.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            FileInterface server = (FileInterface) Naming.lookup("rmi://localhost/FileServer");

            // Upload a file
            byte[] data = Files.readAllBytes(Paths.get("client_upload.txt"));
            server.uploadFile("sample.txt", data);
            System.out.println("File uploaded to server.");

            // Download the same file
            byte[] receivedData = server.downloadFile("sample.txt");
            Files.write(Paths.get("client_download.txt"), receivedData);
            System.out.println("File downloaded from server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
