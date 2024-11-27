/**
 * Klasa kalkulatora geometrycznego
 * Oblicza pole kwadratu i pole koła
 * @author Tobiasz Borysionek
 * @version 1.0
 */

public class GeometryCalculator {
    private double pi=Math.PI;
    private double bok;
    private double promien;

    public double PoleKola (double promien){
        if(bok > 0){
        double pi = Math.PI;
        return pi * promien * promien;
        }else{
            throw new IllegalArgumentException("Promień musi być większy niż zero!");
        }
    }

    public double PoleKwadratu (double bok){
        if (bok > 0){
            return bok * bok;
        }else{
            throw new IllegalArgumentException("Bok musi być większy niż zero!");
        }
    }
    
    /**
     * Główna metoda 
     * @param args lisat argumentow
     */
    public static void main(String[] args) {
        GeometryCalculator kolo = new GeometryCalculator();
        double polekola = kolo.PoleKola(2);
        System.out.println("Pole kola wynosi: "+ polekola);

        GeometryCalculator kwadrat = new GeometryCalculator();
        double polekwadratu = kwadrat.PoleKwadratu(4);
        System.out.println("Pole kwadratu wynosi: "+ polekwadratu);
    }
}
