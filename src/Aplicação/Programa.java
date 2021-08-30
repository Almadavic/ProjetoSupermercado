package Aplicação;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Programa {

	
	static void menu() throws IOException {
		String path="c:\\temp2\\Supermercado\\menu.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
	
	static void sobre() throws IOException {
		String path="c:\\temp2\\Supermercado\\sobre.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)   {
		try {
			menu();
			int option =sc.nextInt();
			switch (option) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default : 
				System.out.println("Opção Inválida");
			
			
			
			
			
			
			
			}
			
		}
		catch(IOException e) {
			System.out.println("Erro : "+e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("Programa Finalizado!");
		}

	}

}
