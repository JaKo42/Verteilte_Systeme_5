import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIInformationClient {


    public static void main(String[] args) {

        try {
            BufferRemoteInterface remRef = (BufferRemoteInterface) Naming.lookup("//localhost:1099/BufferServer");
            System.out.println("Size of Ringbuffer: " + remRef.getDataSize());
            System.out.println("Quantity of Data in the Buffer: " + remRef.getQuantity());

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
