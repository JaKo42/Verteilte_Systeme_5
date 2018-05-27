import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BufferRemoteInterfaceImpl extends UnicastRemoteObject implements BufferRemoteInterface {
    RingBuffer buffer = null;

    protected BufferRemoteInterfaceImpl() throws RemoteException {
        this.buffer = new RingBuffer(20);
    }

    @Override
    public void produce(int i) throws RemoteException {
        try {
            buffer.add(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object consume() throws RemoteException, InterruptedException {
            return buffer.get();

    }

    @Override
    public int getDataSize() throws RemoteException {
        return buffer.data.length;
    }

    @Override
    public int getQuantity() throws RemoteException {
        return buffer.getQuantity();
    }

    @Override
    public int getLastFilledPosition() throws RemoteException {
        return buffer.getLastFilledPosition();
    }

    @Override
    public int getFirstFreePosition() throws RemoteException {
        return buffer.getFirstFreePosition();
    }

    @Override
    public int getFirst() throws RemoteException {
        return buffer.getFirst();
    }


}
