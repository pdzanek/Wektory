import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

class Wektory {
	public static void main(String[] args){
	String[] wektory=new String[2];
	Scanner odczyt=new Scanner(System.in);
	int[][] wektor= new int[2][0];
	boolean equal =true;
	do{
		try{
			System.out.println("Podaj wektor nr 1:\n");
			wektory[0]=odczyt.nextLine();
			System.out.println("Podaj wektor nr 2:\n");
			wektory[1]=odczyt.nextLine();
			//TODO wektor[0]=CONVERT(wektory[1]); itd

			if(wektor[0].length!=wektor[1].length){
			//System.out.println("\n "+wektor[0].length+" "+wektor[1].length);
			//WektoryRoznejDlugosciException e=new WektoryRoznejDlugosciException(wektory[0], wektory[1],"WektoryRoznejDlugosciException");
			//throw e;
			}
		else equal=false;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}while(equal);
	int[] wynik=new int[wektor[0].length];
	System.out.println("\n "+Arrays.toString(wektor[0]));
	System.out.println("\n "+Arrays.toString(wektor[1]));
	//TODO wynik=add(wektor[0],wektor[1]);
	toFile("wynik dodawania.txt",wynik);
	}

	public static void toInt(String wektor){
	String [] extracted = wektor.split(",");
	
	}
	
	public static void toFile(String filename,int[] wektor) {
	try{
		String[] napis=new String[wektor.length];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<wektor.length;i++){
			napis[i]=Integer.toString(wektor[i]);
			sb.append(napis[i]);
			if(i!=wektor.length-1)
			sb.append(",");
		}
	
	File fileIo=new File(filename);
		fileIo.createNewFile();
		PrintWriter zapis = new PrintWriter(filename);
    		zapis.println(sb);
      		zapis.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.toString());
	}
	}
	public static boolean isNumeric(String character){
	try{
		int c=Integer.parseInt(character);
	}catch(NumberFormatException nfe){
		return false;	
	}
	return true;
	}
}

class WektoryRoznejDlugosciException extends Exception{
	int lenWektor1, lenWektor2;
	String message;
	public WektoryRoznejDlugosciException(int[] wektor1, int[] wektor2, String info){
		message=info;
		lenWektor1=wektor1.length;
		lenWektor2=wektor2.length;
		System.out.println(info+"wektor1="+wektor1.length+" wektor2="+wektor2.length+"\n");
	}
	public String getMessage(){
	String exceptionMessage;
		exceptionMessage=message+"\nwektor1="+lenWektor1+"\nwektor2="+lenWektor2+"\n";
		return exceptionMessage;
	}
}
/*Napisz program proszacy o podanie 2 wektorow. Koniec wektora oznacza sie za pomoca wcisniecia klawisza enter. Jezeli podany ciag nie jest liczba, jest ignorowany. Nastepnie nalezy sprobowac dodac wektory, jezeli sa rownej dlugosci. Jezeli nie, sa, rzucany jest wlasny wyjatek WektoryRoznejDlugosciException, za pomoca ktorego mozna podac a nastepnie odczytac dlugosci tych wektorow. Jezeli sa rownej dlugosci, wynik dodawania zapisywany jest do pliku. Jezeli nie sa rownej dlugosci, uzytkownik jest proszony o ponowne wprowadzenie tych wektorow*/
