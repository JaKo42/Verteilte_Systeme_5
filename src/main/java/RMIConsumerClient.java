import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIConsumerClient extends Thread {

    public static void main(String[] args) {

        try {
            BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");


            while (true) {
                System.out.println("Consumed = " + remRef.consume());
                System.out.println("Position: " + remRef.getPosition());
                System.out.println("First Free Position: " + remRef.getFirstFreePosition());
                System.out.println("Last filled quantity: " + remRef.getLastFilledPosition());

                Thread.sleep(500);
            }

        } catch (NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
