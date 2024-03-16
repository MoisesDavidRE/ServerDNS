import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Cliente extends UnicastRemoteObject implements Escuchador  {
    private static InterfazServidor servidor = null;
    Scanner consola = new Scanner(System.in);
    String lectura;
    public Cliente () throws RemoteException{}

    @Override
    public void realizarTrabajo () throws RemoteException {
        while (true) {
            lectura = consola.nextLine();
            System.out.println(servidor.getDirIP(lectura));
        }
    }

    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4444);
            servidor = (InterfazServidor) registro.lookup("servidorDNS");
            servidor.ejecutarAsincronamente(new Cliente());
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}