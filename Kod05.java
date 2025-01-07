import java.util.Arrays;

public class Kod05 {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,5,6,7,8,99,100};
        
        System.out.println("Wszystkie liczby: ");
        for(int ele : tab){
            System.out.println(ele);
        }
        int druga = znajdzDruga(tab);
        System.out.println("Druga najwieksza: " + druga);
    }

    public static int znajdzDruga(int[] liczby){
        int najwieksza = Integer.MIN_VALUE;
        int druganajwieksza = Integer.MIN_VALUE;

        for (int num : liczby){
            if(num > najwieksza){
                druganajwieksza = najwieksza;
                najwieksza = num;
            }else if(num > druganajwieksza && num != najwieksza){
                druganajwieksza = num;
            }
        }
        return druganajwieksza;
    }
}
