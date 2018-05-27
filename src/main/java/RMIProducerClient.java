import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIProducerClient extends Thread {

    static int i = 0;

    public static void main(String[] args) {

        Thread t = null;
  //      for (int j = 0; j < 2; j++) {
                t = new Thread(new RMIProducerClient());
                t.start();
    //    }
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void run() {

        while (true) {
            try {
                BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");
                remRef.produce(i);
                System.out.println("Produced: " + i);
                System.out.println("Quantity: " + remRef.getQuantity());
                System.out.println("First Free Position: " + remRef.getFirstFreePosition());
                System.out.println("Last filled quantity: " + remRef.getLastFilledPosition());
                i++;
                Thread.sleep(800);


            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
