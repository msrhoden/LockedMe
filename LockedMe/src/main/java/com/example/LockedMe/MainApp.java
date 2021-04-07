package com.example.LockedMe;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.OperatorBetween;

@SpringBootApplication
public class MainApp {
	private static FileOperations fh = new FileOperations();

	public static void main(String[] args) throws IOException {
		mainScreen();
	}
	
	public static void mainScreen () throws IOException {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome to LockedMe.com by Lockers Pvt. Ltd");
		System.out.println("Dev Name: Mauricio Rhoden");
		System.out.println("________________________________________________________\n");		
		System.out.println("Choose an option to Start:");	
		System.out.println("________________________________________________________\n");
		System.out.println("0 - Exit Application");
		System.out.println("1 - List of Clients");
		System.out.println("2 - File Operations Menu");
		System.out.println("________________________________________________________\n");
		
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				while(s.hasNextInt()) {
					int choice = s.nextInt();
					
					switch (choice) {
					case 0 :
						System.out.println("By, see you later");
						Runtime.getRuntime().exit(0);
						break;
					case 1 :
						fh.fileList();
						System.out.println("________________________________________________________\n");
						System.out.println("type 1 to return to main screen or 0 to end application");
						int choose = s.nextInt();						
						if(choose==1) {
							mainScreen();							
						}else {
							System.out.println("By, see you later");
							Runtime.getRuntime().exit(0);
						}
						
						break;
					case 2 :
						fileOperationMenu();
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Choose an option to Start:");	
						System.out.println("________________________________________________________");
						System.out.println("0 - Exit Application");
						System.out.println("1 - List of Clients");
						System.out.println("2 - File Operations Menu");
						System.out.println("________________________________________________________");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Choose an option to Start:");	
				System.out.println("________________________________________________________");
				System.out.println("0 - Exit Application");
				System.out.println("1 - List of Clients");
				System.out.println("2 - File Operations Menu");
				System.out.println("________________________________________________________");
				s.next();
			}
		}
	}
	
	public static void fileOperationMenu() throws IOException { //usei
		Scanner s = new Scanner(System.in);

		System.out.println("________________________________________________________");
		System.out.println("File Options Menu");
		System.out.println("________________________________________________________\n");		
		System.out.println("Choose an option to continue:");	
		System.out.println("________________________________________________________");
		System.out.println("0 - Return to Main Menu");
		System.out.println("1 - Add a new File");
		System.out.println("2 - Search an existent File");
		System.out.println("3 - Delete an existent File");
		System.out.println("________________________________________________________");;
		
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				while(s.hasNextInt()) {
					int choice = s.nextInt();
					
					switch (choice) {
					case 0 :
						mainScreen();
						break;
					case 1 :						
						fh.createFile();
						break;
					case 2 :
						fh.searchFile();
						break;
					case 3 :
						fh.delete();
						break;
					case 4 :
						
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue:");	
						System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						System.out.println("0 - Return to Main Menu");
						System.out.println("1 - Add File");
						System.out.println("2 - Search File");
						System.out.println("3 - Delete File");
						System.out.println("4 - Update Your Current Locker");
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Please type the numer of desired option to continue:");	
				System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("0 - Return to Main Menu");
				System.out.println("1 - Add File");
				System.out.println("2 - Search File");
				System.out.println("3 - Delete File");
				System.out.println("4 - Update Your Current Locker");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
	}
}
