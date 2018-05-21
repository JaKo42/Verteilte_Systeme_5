/* Datei uProduzentKonsumentProble.java          E. Ammann   */
/* Demo-Anwendung zum Synchronisationsproblem                 */
/* von Produzenten und Konsumenten.                           */
/* Paramenter:  - Groesse des Puffers                         */
/*              - Zahl der Produzenten                        */
/*              - Zahl der Konsumenten.                       */

class uProduzentKonsumentProblem {
    public static void main(String args[]) {
        int i, num_prod, num_kons;
        uFIFOPuffer puffer;

        if (args.length != 3) {
            System.out.println("Syntaktisch falscher Aufruf des Programms");
            System.exit(1);
        }

        puffer = new uFIFOPuffer(Integer.parseInt(args[0]));
        num_prod = Integer.parseInt(args[1]);
        num_kons = Integer.parseInt(args[2]);

        for (i=0; i<num_prod; i++)
            (new uProduzent(i, puffer, num_kons)).start();
        for (i=0; i<num_kons; i++)
            (new uKonsument(i, puffer, num_prod)).start();
    }
}
