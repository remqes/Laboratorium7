package ResztaZadan;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Zadanie2 {
    private int liczba, sumaLiczb = 0;
    private long iloczynLiczb = 1;
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    public void pobieranieLiczb(){
        System.err.println("Podawanie liczb, dopóki nie zostanie podane zero.");
            do {
                System.out.print("Podaj liczbę: ");
                try {
                    liczba = scan.nextInt();
                }catch(InputMismatchException e){
                    System.err.println("Podana wartość nie jest liczbą.");
                    break;
                }
                if (liczba != 0) {
                    list.add(liczba);
                }
            } while (liczba != 0);
        for(int l : list){
            sumaLiczb += l;
            iloczynLiczb *= l;
        }
        System.out.println("Podano "+ list.size() + " liczb.");
        System.out.println("Suma liczb to " + sumaLiczb +".");
        System.out.println("Iloczyn liczb to "+ iloczynLiczb + ".");
    }
}
