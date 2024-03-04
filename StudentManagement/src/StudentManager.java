
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class StudentManager {
    
	//arraylist of student objects for handling all the students
    private ArrayList<Student> students;
    //scanner object for taking input from the user
    private Scanner input;

    //when student manager object is created we are loading all the students in the arraylist
    public StudentManager() {
        try {
        	//initialising arraylist and scanner object
            students = new ArrayList();
            input = new Scanner(System.in);
            
            //insert all students in the list while we start the program
            Scanner sc = new Scanner(new File("students.txt"));
            while(sc.hasNext()){
                String line = sc.nextLine();
                //as student data is stored with a comma,and separated in the file and spiting the data
                String[] array = line.split(",");
               
                students.add(new Student(array[0],array[1],array[2],Integer.parseInt(array[3]),array[4],array[5]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
    }
    
    //this is method to save data in the file when program exits 
    public void saveData() throws IOException{
        
        FileWriter writer = new FileWriter("students.txt");
        for(int i=0; i<students.size(); i++){
            try{
                //saving data as comma separated
                writer.write(students.get(i).getId()+","+students.get(i).getName()+","+students.get(i).getGender()+","+students.get(i).getAge()+","+students.get(i).getEmail()+","+students.get(i).getContactNumber()+","+"\n");
            }
            catch(Exception e){
                
            }
        }
        writer.close();
    }
    
    //this is the method for getting list of all students
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    
    //this method prints all the students in the better format
    public void printAllStudents() {
    	
    	
    	System.out.println("---------------------------------------------------------------------------------------------");  
    	System.out.printf("%5s %10s %10s %8s %20s %17s", "STUDENT ID", "NAME", "GENDER", "AGE", "E-MAIL ID", "CONTACT");  
    	System.out.println();  
    	System.out.println("---------------------------------------------------------------------------------------------");  
    	//iterates over the list  
    	
    	
    	
    	for(int i=0; i<students.size(); i++) {
    		System.out.format("%7s %14s %7s %10s %25s %13s", students.get(i).getId(), students.get(i).getName(), students.get(i).getGender(), students.get(i).getAge(), students.get(i).getEmail(), students.get(i).getContactNumber());  
    		System.out.println();  
    	}
    }
    
    //method for adding new student, this will ask for all the data and it will add into the list
    public void addNewStudent() {
    	String id, name, gender, email, contact;
    	int age;
    	
    	System.out.print("Enter ID: ");
    	id = input.nextLine();
    	
    	System.out.print("Enter name: ");
    	name = input.nextLine();
    	
    	System.out.print("Enter gender: ");
    	gender = input.nextLine();
    	
    	System.out.print("Enter age: ");
    	age = input.nextInt();
    	
    	System.out.print("Enter email: ");
    	email = input.nextLine();
    	
    	if(email.equals("")) {
    		email = input.nextLine();
    	}
    	
    	System.out.print("Enter contact: ");
    	contact = input.nextLine();
    	
    	students.add(new Student(id, name, gender, age, email, contact));
    	
    	System.out.println("Student added successfully!");
    	
    }
    
    //method for searching a student data, we have added functionality for searching by the name or the ID of the student
    public void searchStudent() {
    	
    	System.out.print("1. Search by id\n"
    			+ "2. Search by name"
    			+ "\n\t Your choice: ");
    	String choice = input.nextLine();
    	String name, id; 
    	boolean found = false;
    	switch(choice) {
    	case "1":
    		System.out.print("Enter ID: ");
    		id = input.nextLine();
    		for(int i=0; i<students.size(); i++) {
    			if(students.get(i).getId().equals(id)) {
    				System.out.println("Found! Details below");
    				System.out.println("ID: " + students.get(i).getId());
    				System.out.println("Name: " + students.get(i).getName());
    				System.out.println("Gender: " + students.get(i).getGender());
    				System.out.println("Age: " + students.get(i).getAge());
    				System.out.println("Email: " + students.get(i).getEmail());
    				System.out.println("Contact: " + students.get(i).getContactNumber());
    				found = true;
    				break;
    			}
    		}
    		
    		//if student is not found then this message is printed
    		if(found==false) {
    			System.out.println("Student not found! Maybe it doesn't exist!");
    		}
    		break;
    	case "2":
    		System.out.print("Enter name: ");
    		name = input.nextLine();
    		for(int i=0; i<students.size(); i++) {
    			if(students.get(i).getName().equals(name)) {
    				System.out.println("Found! Details below");
    				System.out.println("ID: " + students.get(i).getId());
    				System.out.println("Name: " + students.get(i).getName());
    				System.out.println("Gender: " + students.get(i).getGender());
    				System.out.println("Age: " + students.get(i).getAge());
    				System.out.println("Email: " + students.get(i).getEmail());
    				System.out.println("Contact: " + students.get(i).getContactNumber());
    				found = true;
    				break;
    			}
    		}
    		//if student is not found then this message is printed
    		if(found==false) {
    			System.out.println("Student not found! Maybe it doesn't exist!");
    		}
    		break;
    	default:
    	System.out.println("Invalid choice! Try again!");		
    	}
    	
    }

    //this method will ask ID, show details and ask for the change, if user want to change anything that he/she can modify
    public void modifyStudent() {
    	String id;
    	boolean found = false;
    	String choice;
		System.out.print("Enter ID: ");
		id = input.nextLine();
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getId().equals(id)) {
				found = true;
				
				//here we are asking user what he/she want to modify in the list 
				System.out.print("Student found, what you want to modify?\n"
						+ "1. Name\n"
						+ "2. Gender\n"
						+ "3. Age\n"
						+ "4. Email\n"
						+ "5. Contact\n"
						+ "\tYour choice: ");
				
				choice = input.nextLine();
				String text = "";
				
				switch(choice) {
				case "1":
					System.out.print("Enter new name: ");
					text = input.nextLine();
					students.get(i).setName(text);
					System.out.println("Name modified successfully!");
					break;
				case "2":
					System.out.print("Enter gender: ");
					text = input.nextLine();
					students.get(i).setGender(text);
					System.out.println("Gender modified successfully!");
					break;
				case "3":
					System.out.print("Enter new age: ");
					text = input.nextLine();
					students.get(i).setAge(Integer.parseInt(text));
					System.out.println("Age modified successfully!");
					break;
				case "4":
					System.out.print("Enter new email: ");
					text = input.nextLine();
					students.get(i).setEmail(text);
					System.out.println("Email modified successfully!");
					break;
				case "5":
					System.out.print("Enter new contact: ");
					text = input.nextLine();
					students.get(i).setContactNumber(text);
					System.out.println("Contact modified successfully!");
					break;
				default:
					System.out.println("Wrong choice! Try again!");
					break;
					
				}
				
				
				break;
			}
		}
		
		//if the user is not found this message will be printed
		if(found==false) {
			System.out.println("Student not found! Maybe it doesn't exist!");
		}
    }
    
    
    //this method is for deleting the user, it will asks for students ID to remove that student from the list
    public void deleteStudent() {
    	String id;
    	boolean found = false;
    	String choice;
		System.out.print("Enter ID: ");
		id = input.nextLine();
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getId().equals(id)) {
				found = true;
				
				students.remove(students.get(i));	
				
				System.out.println("Student deleted successfully!");
				
				break;
		}
		
		if(found==false) {
			System.out.println("Student not found! Maybe it doesn't exist!");
		}
    }
		}
    
    
    
    
   
    
    

    
    
    
    
    
}
