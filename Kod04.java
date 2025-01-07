import java.util.HashMap;
import java.util.Map;

public class Kod04 {
    public static void main(String[] args) {
        
        Map<String, Integer> osoby = new HashMap<>();

        osoby.put("Jan",17);
        osoby.put("Nikodem",18);
        osoby.put("Blazej",18);
        osoby.put("Kacper",18);
        osoby.put("Filip",18);

        for(Map.Entry<String, Integer> entry: osoby.entrySet()){
            String imie = entry.getKey();
            int wiek = entry.getValue();

            System.out.println(imie + " ma " + wiek + " lat");
        }
    }
}
