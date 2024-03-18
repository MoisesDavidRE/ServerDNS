import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfazServidor extends Remote {
    objetoDNS getDirIP (String host) throws RemoteException;
    void ejecutarAsincronamente (Escuchador cliente) throws RemoteException;
}