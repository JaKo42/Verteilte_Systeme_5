/* Datei uKonsument.java                   E.Ammann    */
/* Klasse fuer die Konsumenten-Threads                 */

class uKonsument extends Thread {
    private uFIFOPuffer fifo;
    private int zaehler;
    private int num_prod;

    public uKonsument(int zaehler, uFIFOPuffer fifo, int num_prod) {
        this.zaehler = zaehler;
        this.fifo = fifo;
        this.num_prod = num_prod;
    }

    public void run() {
        int temp;

        for (int i = 0; i < (4*num_prod); i++) {
            temp = fifo.auslesen();
            System.out.println("Konsument " + zaehler + " hat ausgelesen: " + temp);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {}
        }
    }
}
