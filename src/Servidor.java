import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements InterfazServidor{
    // Matriz de objetos
    static objetoDNS [] matriz = new objetoDNS[10];

//    Constructor vacío
    public Servidor () throws RemoteException {}

//    Sobreescritura de métodos de la InterfazServidor
    @Override
    public void ejecutarAsincronamente (Escuchador cliente) throws RemoteException {
        cliente.realizarTrabajo();
    }
    @Override
    public objetoDNS getDirIP (String dns) throws RemoteException{
        objetoDNS resultado = new objetoDNS();
        for (int i = 0; i <= 9; i++) {
            objetoDNS o = matriz[i];
            if(o.getDns().equals(dns)){
                resultado = o;
            }
        }
        return resultado;
    }

    public static void main(String[] drg) {
//      Asignación de objetos dentro de la matriz
        matriz[0] = new objetoDNS("192.168.5.34","Google.com");
        matriz[1] = new objetoDNS("192.168.6.35","Youtube.com");
        matriz[2] = new objetoDNS("192.168.7.36","Facebook.com");
        matriz[3] = new objetoDNS("192.168.8.37","Asana.com");
        matriz[4] = new objetoDNS("192.168.9.38","Santander.com");
        matriz[5] = new objetoDNS("192.168.10.39","pcel.com");
        matriz[6] = new objetoDNS("192.168.11.40","kingston.com");
        matriz[7] = new objetoDNS("192.168.12.41","Wikipedia.com");
        matriz[8] = new objetoDNS("192.168.13.42","dell.com");
        matriz[9] = new objetoDNS("192.168.14.43","intel.com");

//        Registrar el objeto remoto
        try {
            InterfazServidor servidor = new Servidor();
            System.getProperty(
                    "java.rmi.server.hostname",
                    "127.0.0.1");
            Registry registro = LocateRegistry.getRegistry(4444);
            registro.bind("servidorDNS", servidor);
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }

    }
}