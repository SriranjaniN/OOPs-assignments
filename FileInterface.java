package Assignment;
import java.rmi.*;
import java.io.*;

public interface FileInterface extends Remote {
    void uploadFile(String filename, byte[] data) throws RemoteException;
    byte[] downloadFile(String filename) throws RemoteException;
}
