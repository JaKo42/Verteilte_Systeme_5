import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIConsumerClient extends Thread {

    public static void main(String[] args) {
        try {
        BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//192.168.0.11:1099/BufferServer");
        Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Consumed = " + remRef.consume());
                System.out.println("Quantity: " + remRef.getQuantity());
                Thread.sleep(500);
            }


            } catch (InterruptedException | RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }


    }







}
