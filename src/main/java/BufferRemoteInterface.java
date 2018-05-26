import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BufferRemoteInterface extends Remote {

  void produce(int i) throws RemoteException;

  Object consume() throws RemoteException, InterruptedException;

  int getFirst() throws RemoteException;

  int getPosition() throws RemoteException;

  int getLastFilledPosition() throws RemoteException;

  int getFirstFreePosition() throws RemoteException;

  }


