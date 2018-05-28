import java.util.concurrent.Semaphore;

public class RingBuffer {

    int[] data;
    int quantity;
    int first;
    boolean start;
    Semaphore sem = new Semaphore(1, true);

    public RingBuffer(int data) {
        this.data = new int[data];
        quantity = 0;
        first = 0;
        start = true;
    }


    public void add(int i) throws InterruptedException {
        boolean b = true;
        while (b) {
            sem.acquire();
            if (quantity >= data.length) {
                sem.release();
            } else {
                int newPos = getFirstFreePosition();
                second:
                while (true) {
                    if (data[newPos] != 0 && !start) {
                        sem.release();
                        break second;
                    } else {
                        start = false;
                        b = false;
                        data[newPos] = i;
                        quantity = quantity + 1;
                        sem.release();
                        break;
                    }

                }
            }
        }
    }

    public int get() throws InterruptedException {
        while (true) {
            sem.acquire();
            if (0 >= this.quantity) {
                sem.release();
            } else {
                quantity = quantity - 1;
                int i = data[first];
                data[first] = 0;
                first = (first + 1) % data.length;
                sem.release();
                return i;
            }
        }
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
