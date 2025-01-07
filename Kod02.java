import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Kod02 {
    public static void main(String[] args) {
        List<String> imiona = new ArrayList<>();

        imiona.add("Yan");
        imiona.add("Nikodem");
        imiona.add("Blazej");

        System.err.println("Lista imion: " );

        Collections.reverse(imiona);

        for(String imie: imiona){
            System.out.println(imie);
        }
    }
}
