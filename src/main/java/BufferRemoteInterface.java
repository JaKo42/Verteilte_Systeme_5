import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BufferRemoteInterface extends Remote {

  void produce(int i) throws RemoteException;

  Object consume() throws RemoteException, InterruptedException;

  int getDataSize() throws RemoteException;

  int getFirst() throws RemoteException;

  int getQuantity() throws RemoteException;

  int getLastFilledPosition() throws RemoteException;

  int getFirstFreePosition() throws RemoteException;

  }


