import java.util.concurrent.Semaphore;

public class RingBuffer {

    //https://www.programmieraufgaben.ch/aufgabe/ringpuffer-mit-arrays/yui8z5du

    int[] data;
    int quantity;
    int first;
    Semaphore sem = new Semaphore(2, true);

    public RingBuffer(int data) {
        this.data = new int[data];
        quantity = 0;
        first = 0;
    }


    public void add(int i) throws InterruptedException {
        boolean b = true;
        while (b) {
            if (quantity >= data.length) {
                sem.wait();
            } else {
                b = false;
                sem.acquire(1);
                int newPos = getFirstFreePosition();
                while (true) {
                    if (data[newPos] == 0) {
                        sem.wait(10);
                    } else
                        data[newPos] = i;
                    quantity = quantity + 1;
                    sem.release(1);
                    break;
                }
            }
        }
    }

    public int get() throws InterruptedException {
        if (0 == quantity)
            return 0;
        sem.acquire(2);
        quantity = quantity - 1;
        int i = data[first];
        data[first] = 0;
        first = (first + 1) % data.length;
        sem.release(2);
        return i;

    }

    public int getFirstFreePosition() {
        return (getLastFilledPosition() + 1) % data.length;

    }


    public int getLastFilledPosition() {
        return (first + quantity - 1) % data.length;
    }


    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
