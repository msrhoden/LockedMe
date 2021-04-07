package com.example.LockedMe;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FileOperations {
	
	private static ArrayList<String> information = new ArrayList<String>();
	private static final String folderPath = "LockedMe_Users\\";

	public static void createFile() throws IOException { 
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);		
			
		System.out.println("\n________________________________________________________");
		System.out.println("Provide information for the file:");
		System.out.println("________________________________________________________\n");
		
		System.out.println("Enter your full name:");
		information.add(s.nextLine());			
	
		String fileName = information.get(0)+".txt";		
		File file = new File(folderPath+fileName);
		
		if(file.createNewFile()) {
			FileWriter writer = new FileWriter(folderPath+fileName);			
			
			System.out.println("\n________________________________________________________");
			System.out.println("File successfully Created! File Name: " + fileName);
			System.out.println("________________________________________________________");
			
		} else {
			System.out.println("\n________________________________________________________");
			System.out.println("File Already Exists ");
			System.out.println("________________________________________________________");
						
		}

		MainApp.fileOperationMenu();		
		s.close();
	}
	
	/*public static ArrayList<String> scanInfo() {
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String aux = "";
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Provide information for the file:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		aux = s.nextLine();
		information.add(aux);
		
		System.out.println("Please type your locker number:");
		aux = s.nextLine();
		information.add(aux);
			
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Thank you! We are saving your information file");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		s.close();
		
		return information;
	}*/
	
	/*public static void readFile(String fileName) {
		// Read
		List<String> lines = Collections.emptyList();
		
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			System.out.println("Lines=" + lines.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void searchFile() throws IOException {		
		
		Scanner s = new Scanner(System.in);
		File file;
		
		System.out.println("\n________________________________________________________");
		System.out.println("Search file");
		System.out.println("________________________________________________________\n");
		
		System.out.println("Enter the File Name");
		String fileName = s.nextLine();
		String ext = ".txt";
		
		if(!fileName.toLowerCase().contains(ext.toLowerCase())) {
			fileName = fileName+ext;
		}
		
		fileName = folderPath+fileName; 
		file = new File(fileName);
		
				
		if(file.exists()) {
			System.out.println("\n________________________________________________________");
			System.out.println("File Found");
			System.out.println("________________________________________________________\n");
			
		}
		else {
			System.out.println("\n________________________________________________________");
			System.out.println("Error: File not Found!!");
			System.out.println("________________________________________________________\n");
		}
		
		MainApp.fileOperationMenu();
		s.close();		
	}
	
	public static void delete() throws IOException {
		Scanner s = new Scanner(System.in);				
		System.out.println("\n________________________________________________________");
		System.out.println("Enter the file name to be deleted:");
		System.out.println("________________________________________________________\n");	
		
		String file = s.nextLine();
		String ext = ".txt";
		
		if(!file.toLowerCase().contains(ext.toLowerCase())) {
			file = file+ext;
		}
		file = folderPath+file;   
		
		System.out.println("Are you sure you want to delete the file (1)To confirm or (2)To Cancel");
		int test = s.nextInt();
		if (test==1) {
			try {
				Files.delete(Paths.get(file));
				System.out.println("\n________________________________________________________");
				System.out.println("file successfully deleted");
				System.out.println("________________________________________________________\n");
			} catch (NoSuchFileException e) {
				System.out.println("\n________________________________________________________");
				System.out.println("Error: No such file exists");
				System.out.println("________________________________________________________\n");
			} 
			
		}else {
			System.out.println("Operation Canceled");
		}	
		
		MainApp.fileOperationMenu();	
		s.close();
	}
	
	/*public static void updateFile(String fileName, String toReplace, String replacement) {
		File fileToBeModified = new File(fileName);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer2 = null;
		
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Updating your File:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		System.out.println("Old Locker Number: " + toReplace);
		System.out.println("New Locker Number: " + replacement);
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			//System.out.println("Line = " + line);
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				//System.out.println("Old Content = " + oldContent);
				line = reader.readLine();
				//System.out.println("Line = " + line);
			}
			
			String newContent = oldContent.replaceAll(toReplace, replacement);
			System.out.println("New Content = \n\n" + newContent);
			writer2 = new FileWriter(fileToBeModified);
			writer2.write(newContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer2.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("File Update Complete! File Name: " + fileName);
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
	}
	
	public static String getLocker(String fileName) {
		String locker = "";		
		File file = new File(fileName);
		BufferedReader reader = null;
		int index;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			while (!line.toLowerCase().contains("locker")) {
				line = reader.readLine();
			}
			
			index = line.toLowerCase().lastIndexOf(" ");			
			line = line.substring(index+1);
			locker = line;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return locker;
	}
	
	public static void updateFileLocker() throws IOException {
		
		Scanner s = new Scanner(System.in);
		String newLocker = "";
		String oldLocker = "";
		String fileName = "";
		
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Provide information for the file:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		fileName = s.nextLine();
		information.add(fileName);
		
		System.out.println("Please type your locker number:");
		newLocker = s.nextLine();
		information.add(newLocker);
		
		File file = new File(fileName);
		
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				while(s.hasNextInt()) {
					int choice = s.nextInt();
					
					switch (choice) {
					case 1 :
						oldLocker = getLocker(fileName);
						updateFile(fileName, oldLocker, newLocker);
						MainApp.fileOperationMenu();
						break;
					case 2 :
						MainApp.fileOperationMenu();
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue...");	
						System.out.println("Do you wish to update the current locker?");
						System.out.println("01 - Yes");
						System.out.println("02 - No");
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Please type the numer of desired option to continue...");	
				System.out.println("Do you wish to update the current locker?");
				System.out.println("01 - Yes");
				System.out.println("02 - No");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
		
	}*/

	public void fileList() { 
		
        File folder = new File("LockedMe_Users");
        
        if(folder.isDirectory())
        {
            File[] fileList = folder.listFiles();

            System.out.println("\n____________________________________________________________");           
            System.out.println("Please find below all File Names in Alphabetic order");
            System.out.println("Total number of Client Files: " + fileList.length);
            System.out.println("____________________________________________________________\n");
                    
            Arrays.sort(fileList);
            
            for(File file:fileList)
            {
                System.out.println(file.getName());
            }
        }
    }
}