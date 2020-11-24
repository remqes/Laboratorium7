package ResztaZadan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie4 {
    private int liczba, sumaLiczb, usunieta;
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    public void korekcjaSumy(){
        do{
            System.out.print("Wprowadz liczbe: ");
            try{
                liczba = scan.nextInt();
            }catch(InputMismatchException e){
                System.err.println("Podana wartośc nie jest liczbą.");
                break;
            }
            list.add(liczba);
            sumaLiczb += liczba;
            Collections.sort(list);
            if(sumaLiczb > 64){
                System.out.print("Przekroczono wartość 64. ");
                sumaLiczb -= list.get(list.size()-1);
                usunieta = list.get(list.size()-1);
                System.out.print("Usunięto pierwszą liczbę z listy. ");
                list.remove(list.size()-1);
                System.out.println("Jej wartość to "+usunieta+".");
                System.out.println("Aktualna suma: "+sumaLiczb+".");
            }
        }while(sumaLiczb != 64);
        if(sumaLiczb == 64) System.out.println("Osiągnięto wartość 64, także progam kończy działanie.");
    }
}
