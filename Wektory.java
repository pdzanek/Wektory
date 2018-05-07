import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

class Wektory {
	public static void main(String[] args){
	String[] wektory=new String[2];
	Scanner odczyt=new Scanner(System.in);
	int[][] wektor= new int[2][0];
	boolean equal =true;
	do{
		try{
			System.out.println("Podaj wektor nr 1(jako separatora użyj ',' ):\n");
			wektory[0]=odczyt.nextLine();
			System.out.println("Podaj wektor nr 2 (jako separatora użyj ',' ):\n");
			wektory[1]=odczyt.nextLine();
			wektor[0]=toInt(wektory[0]);
			wektor[1]=toInt(wektory[1]);
			if(wektor[0].length!=wektor[1].length){
			System.out.println("\n "+wektor[0].length+" "+wektor[1].length);
			WektoryRoznejDlugosciException e=new WektoryRoznejDlugosciException(wektor[0],wektor[1],"WektoryRoznejDlugosciException");
			throw e;
			}
		else equal=false;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}while(equal);
	try{
	int[] resultAdd=new int[wektor[0].length];
	System.out.println("\n "+Arrays.toString(wektor[0]));
	System.out.println("\n "+Arrays.toString(wektor[1]));
	resultAdd=addVectors(wektor[0],wektor[1]);
	toFile("wynik dodawania.txt",resultAdd);
	}catch(Exception ex) {
		System.out.println(ex.toString());
	}
	System.out.println("Wynik dodawania wektorów zapisano do pliku");
	}
	
	private static int[] addVectors(int[] wektor1,int[] wektor2) {
		int[] resultAddVectors=new int [wektor1.length];
		for(int i=0;i<wektor1.length;i++){
			resultAddVectors[i]=wektor1[i]+wektor2[i];
		}
		return resultAddVectors;
	}

	public static int[] toInt(String wektor){
		String [] extracted = wektor.split(",");
		int[] resultToInt=new int[extracted.length];
		int i=0;
		for(int j=0;j<extracted.length;j++){
			if(isNumeric(extracted[j])){
				resultToInt[i]=Integer.parseInt(extracted[j]);
				i++;
			}
		}
		int[] rightResult=new int[i];
		for(int j=0;j<i;j++)
			rightResult[j]=resultToInt[j];
		return rightResult;
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
		System.out.println(info+" wektor1="+wektor1.length+" wektor2="+wektor2.length+"\n");
	}
	public String getMessage(){
	String exceptionMessage;
		exceptionMessage=message+"\nwektor1="+lenWektor1+"\nwektor2="+lenWektor2+"\n";
		return exceptionMessage;
	}
}
