import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIProducerClient extends Thread {

    public static void main(String[] args) {

        try {
            BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Insert a starting number.");
            int in = Integer.parseInt(scanner.nextLine());
            System.out.println("Insert the required Quantity to produce.");
            int out = Integer.parseInt(scanner.nextLine());

            for (int i = in; i < in+out; i++) {

                remRef.produce(i);
                System.out.println("Produced: " + i);
                System.out.println("Quantity: " + remRef.getQuantity());
                System.out.println("First Free Position: " + remRef.getFirstFreePosition());
                System.out.println("Last filled quantity: " + remRef.getLastFilledPosition());
                i++;
                Thread.sleep(200);
            }


        } catch (InterruptedException | RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }


    }






}
