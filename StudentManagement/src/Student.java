
public class Student {
	
	//defined all names for the student objects
	private String id;
	private String name;
	private String gender;
	private int age;
	private String email;
	private String contactNumber;
	
	//getters and setters for the student instance variables
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	//constructor will all fields for creating new student object for ever time 
	public Student(String id, String name, String gender, int age, String email, String contactNumber) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	
	//toString method, in case if we need to print student
	public String toString() {
		
		return this.getId()+"\t"+this.getName()+"\t"+this.getGender()+"\t"+this.getAge()+"\t"+this.getEmail()+"\t\t"+this.getContactNumber()+"\n";
		
	}
	
	
	
	

}
