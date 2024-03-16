import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Escuchador extends Remote {
    void realizarTrabajo() throws RemoteException;
}