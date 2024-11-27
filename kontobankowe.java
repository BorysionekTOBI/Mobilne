/**
 * Klasa konta bankowego
 * Reazlizuje wplaty i wyplaty 
 * @author Tobiasz Borysionek
 * @verison 1.0
 */
public class kontobankowe {
    private String numerKonta;
    private double saldo;


    /**
     * Konstruktor klasy kontobakowe
     * @param numerKonta numer konta w zapisie EU
     * @param saldoPoczatkowe wartość stanu konta
     * @throws IllegalArgumentExpection przechwycenie błędu błędnej danej
     */

    public kontobankowe(String numerKonta, double saldoPoczatkowe){
        if (numerKonta == null || numerKonta.isEmpty()){
            throw new IllegalArgumentException("Błędny numer konta...");
        }
        this.numerKonta = numerKonta;
        this.saldo = saldoPoczatkowe;
    }


    /**
     * Metoda zwracajaca saldo
     * @return zwraca aktualny stan konta
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Metoda zwracajaca numer konta
     * @return zwraca numer konta w formacie EU
     */
    public String getnumerKonta(){
        return numerKonta;
    }


    /**
     * Metoda obslugujaca wplate na konto
     * @param kwota kwota wplaty 
     */
    public void wplata(double kwota){
        if (kwota > 0){
            saldo += kwota;
            System.out.printf("Wpłacono %.2f PLN.", kwota);
        }else{
            System.out.println("Kwota wpłaty nie może byc ujemna lub zerowa.");
        }
    }


    /**
     * Metoda obslugujaca wyplate z konta 
     * @param kwota kwota wyplaty
     */
    public void wyplata(double kwota){
        if (kwota > 0 && kwota <= saldo){
            saldo -= kwota;
            System.out.printf("Wypłacono %.2f PLN.", kwota);
        }else{
            System.out.println("Kwota wypłaty nie może być ujemna lub większa od salda.");
        }
    }


    /**
     * Metoda wyswietlajaca obecny stan konta 
     */
    public void saldoShow(){
        System.out.printf("Obecny stan konta to %.2f PLN\n", saldo);
    }


    /**
     * Główna metoda main
     * @param args lista argumentow metody main
     */
    public static void main(String[] args) {
        //Tworzenie obiektu z klasy kontobankowe 
        kontobankowe konto1 = new kontobankowe("PL12313123123123123123", 1000);
        //Wyświetlanie początkowych paametrow konta
        System.out.println("Numer konta: " + konto1.getnumerKonta());
        System.out.printf("Stan konta: %.2f ", konto1.getSaldo());

        konto1.wplata(1000);
        konto1.saldoShow();
        konto1.wyplata(500);
        konto1.saldoShow();
        konto1.wyplata(500);
        konto1.saldoShow();
    }
}
