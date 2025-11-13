package Assignment;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;
import java.nio.file.*;

public class FileServer extends UnicastRemoteObject implements FileInterface {

    protected FileServer() throws RemoteException {
        super();
    }

    public void uploadFile(String filename, byte[] data) throws RemoteException {
        try {
            Files.write(Paths.get("server_" + filename), data);
            System.out.println("File uploaded: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] downloadFile(String filename) throws RemoteException {
        try {
            System.out.println("File downloaded: " + filename);
            return Files.readAllBytes(Paths.get("server_" + filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            FileServer server = new FileServer();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("FileServer", server);
            System.out.println("File Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
