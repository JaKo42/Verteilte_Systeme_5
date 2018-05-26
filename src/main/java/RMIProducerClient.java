import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIProducerClient extends Thread {

  static int i = 0;

  public static void main(String[] args) {

    while (true) {
      try {
        BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");
        remRef.produce(i);
        System.out.println("Produced: " + i);
        System.out.println("Position: " + remRef.getPosition());
        System.out.println("First Free Position: " + remRef.getFirstFreePosition());
        System.out.println("Last filled quantity: " + remRef.getLastFilledPosition());
        Thread.sleep(1000);
        i++;


      } catch (RemoteException e) {
        e.printStackTrace();
      } catch (NotBoundException e) {
        e.printStackTrace();
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

    /*Thread thread = null;
    int j = 0;
    while (j < 2) {
      thread = new Thread(new RMIProducerClient());
      thread.start();
      j++;
    }
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
  }

  @Override
  public synchronized void start() {
    run();
  }

  @Override
  public void run() {

    while (true) {
      try {
        BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");
        remRef.produce(i);
        System.out.println("Produced: " + i);
        System.out.println("Write Pos.: " + remRef.getPosition());
        i++;
        sleep(100);
      } catch (NotBoundException e) {
        e.printStackTrace();
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (RemoteException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
