import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIConsumerClient extends Thread {

    public static void main(String[] args) {
        Thread t = null;
//        for (int i = 0; i < 1; i++) {

            t = new Thread(new RMIConsumerClient());
            t.start();
//            }

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");


            while (true) {
                System.out.println("Consumed = " + remRef.consume());
                System.out.println("Quantity: " + remRef.getQuantity());
                System.out.println("First: " + remRef.getFirst());
                System.out.println("First Free Position: " + remRef.getFirstFreePosition());
                System.out.println("Last filled Position: " + remRef.getLastFilledPosition());
                Thread.sleep(500);

            }

        } catch (NotBoundException | MalformedURLException | InterruptedException | RemoteException e) {
            e.printStackTrace();
        }

    }
}
