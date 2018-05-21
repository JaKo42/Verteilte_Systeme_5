/* Datei uFIFOPuffer.java               E. Ammann      */
/* Klasse fuer den Ringpuffer zur Benutzung durch      */
/* Produzenten und Konsumenten                         */

class uFIFOPuffer {
    private int in_index;
    private int out_index;
    private int groesse;
    private int[] fifo;

    // Konstruktormethode dieser Klasse
    uFIFOPuffer(int groesse) {
        if (groesse < 2) groesse = 2;
        this.groesse = groesse;
        fifo = new int[groesse];
        in_index = out_index = 0;
    }

    // Element aus Puffer holen
    public int auslesen() {
        int temp;
        while (in_index == out_index) {}

        temp = fifo[out_index];
        if (out_index == groesse -1) out_index = 0;
        else out_index++;
        return temp;
    }

    // Element in Puffer stellen
    public void einfuegen(int wert) {
        while ((in_index + 1)%groesse == out_index) {}

        fifo[in_index] = wert;
        if (in_index == groesse -1) in_index = 0;
        else in_index++;
    }
}
