import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

class Wektory {
	public static void main(String[] args){
	String[] wektory=new String[2];
	Scanner odczyt=new Scanner(System.in);
	int[][] wektor= new int[2][0];
	do{
		try{
			System.out.println("Podaj wektor nr 1:\n");
			wektory[0]=odczyt.nextLine();
			System.out.println("Podaj wektor nr 2:\n");
			wektory[1]=odczyt.nextLine();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}while(true);
	}
}
