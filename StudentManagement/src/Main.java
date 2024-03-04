import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	//this method is for displaying the menu on screen
	public static void displayMenu() {
		System.out.println("**************************** Welcome to Student Management ****************************");
		System.out.print(""
				+ "1. Add new students \n"
				+ "2. Search for student \n" 
				+ "3. Modify student \n"
				
				+ "4. Delete student \n"
				+ "5. Show all students \n"
				+ "6. Exit and Save \n"
				+ "       Your choice: ");
		
	}

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		String choice = "";
		
		//when student manager object is created then all the students are loaded from file
		StudentManager manager = new StudentManager();
		
		boolean loop = true;
		
		//loop will run until user presses exit button
		while(loop) {
			
			displayMenu();
			choice = keyboard.nextLine();
			
			switch(choice) {
			case "1":
				manager.addNewStudent();
				break;
			case "2":
				manager.searchStudent();
				break;
			case "3":
				manager.modifyStudent();
				break;
			case "4":
				manager.deleteStudent();
				break;
			case "5":
				manager.printAllStudents();
				break;
			case "6":
				//when pressing exit, data will be saved and loop will end here
				loop = false;
				manager.saveData();
				// saving successfully message
				System.out.println("Data saved successfully! Bye Bye");
				// closing message
				System.out.print("Hope you have a wonderful day ahead");
			default:
				break;
			}
			
		}

	}

}
