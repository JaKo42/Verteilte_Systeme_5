public class Server {

    //muss RMI interface implementieren
    //http://www.straub.as/java/rmi/rmi2.html

    RingBuffer buffer;


public Server(int maxCount){
    this.buffer = new RingBuffer(maxCount);
}



public void add(int i){

    buffer.add(i);
}

public int get(){
    int result =  buffer.get();
    return result;
}





}