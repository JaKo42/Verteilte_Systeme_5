/* Datei uProduzent.java                   E.Ammann  */
/* Klasse fuer die Produzenten-Threads               */

class uProduzent extends Thread {
    private uFIFOPuffer fifo;
    private int zaehler;
    private int num_kons;

    public uProduzent(int zaehler, uFIFOPuffer fifo, int num_kons) {
        this.zaehler = zaehler;
        this.fifo = fifo;
        this.num_kons = num_kons;
    }

    public void run() {
        for (int i = 0; i < (4*num_kons); i++) {
            fifo.einfuegen(100 * zaehler + i);
            System.out.println("Produzent " + zaehler + " hat eingefuegt: "
                    + (100*zaehler+i));
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {}
        }
    }
}
