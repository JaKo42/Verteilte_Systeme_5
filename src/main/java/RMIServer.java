import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIServer {


  public static void main(String[] args) {


    try {
      System.out.println("create RemoteObject");
      BufferRemoteInterfaceImpl remObj = new BufferRemoteInterfaceImpl();

      Registry registry = LocateRegistry.createRegistry(1099);
      //creates a server on the local host that accepts requests on the specified port.

      //Remoteobjekt registrieren und Server starten
      System.out.println("try : naming RemoteObject");
      Naming.bind("BufferServer", remObj);
      System.out.println("--- server ready, waiting for clients ---");

      System.out.println("stop server ?");
      Scanner scanner = new Scanner(System.in);
      while (true) {
        String s = scanner.next();
        if (s.toLowerCase().equals("j")) {
          registry.unbind("BufferServer");
          System.exit(0);
        }
      }


    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (AlreadyBoundException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
  }
}
