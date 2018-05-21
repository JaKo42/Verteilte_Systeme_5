public class RingBuffer {

    //https://www.programmieraufgaben.ch/aufgabe/ringpuffer-mit-arrays/yui8z5du

    int [] data;
    int count;
    int first;


    public RingBuffer(int data) {
        this.data = new int[data];
        count = 0;
        first = 0;
    }


    public void add(int i) {
        if (count>= data.length)
            throw new IndexOutOfBoundsException("Zu viele Elemente!");
        int newPos = getFirstFreePosition();
        data[newPos] = i;
        count = count + 1;
    }

    public int get(){
        if (0 == count)
            return 0;
        count = count - 1;
        int i = data[first];
        first = (first + 1) % data.length;
        return i;

    }

    private int getFirstFreePosition() {
        return (getLastFilledPosition() + 1) % data.length;

    }


    private int getLastFilledPosition() {
        return (first + count - 1) % data.length;
    }


    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
