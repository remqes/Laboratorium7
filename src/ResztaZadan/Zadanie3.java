package ResztaZadan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie3 {
    private int liczba, sumaLiczb = 0;
    private long iloczynLiczb = 1, granica = 3000000;
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    public void sortowanieLiczb(){
        do{
            System.out.print("Podaj liczbę: ");
            try{
                liczba = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Podana wartosc nie jest liczbą.");
                break;
            }
            list.add(liczba);
            sumaLiczb += liczba;
            iloczynLiczb *= liczba;
            if(iloczynLiczb > granica) break;
        }while(Math.abs(sumaLiczb) < 250);
        System.out.println("Podano "+ list.size() + " liczb.");
        System.out.println("Suma liczb to " + sumaLiczb +".");
        System.out.println("Iloczyn liczb to "+ iloczynLiczb + ".");
        Collections.sort(list, Collections.reverseOrder());
        for(int l : list){
            System.out.print(l+" ");
        }
    }
}
