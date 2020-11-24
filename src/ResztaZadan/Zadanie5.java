package ResztaZadan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie5 {
    private int liczba, iloczynLiczb = 1, usunieta;
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    public void korekcjaIloczynu(){
        do{
            System.out.print("Wprowadz liczbe: ");
            try{
                liczba = scan.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Wprowadzona wartość nie jest liczbą.");
                break;
            }
            list.add(liczba);
            iloczynLiczb *= liczba;
            Collections.sort(list, Collections.reverseOrder());
            if(iloczynLiczb > 256){
                System.out.print("Przekroczono wartośc 256. ");
                usunieta = list.get(list.size()-1);
                list.remove(list.get(list.size()-1));
                iloczynLiczb /= list.get(list.size()-1);;
                System.out.println("Usunięto najmniejszą liczbę. Jej wartość to "+usunieta+".");
                System.out.println("Aktualny iloczyn: "+iloczynLiczb+".");
            }
        }while(iloczynLiczb != 256);
        if(iloczynLiczb == 256) System.out.println("Iloczyn liczby jest równy 256, także program kończy działanie.");
    }
}
