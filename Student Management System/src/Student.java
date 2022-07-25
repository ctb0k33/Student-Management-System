import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	transient Scanner scanner= new Scanner(System.in);
	private String name;
	private float mark;
	private String email;
	private String rank;
	private String ID;
	private static ArrayList<String>StudentsID= new ArrayList<String>();
	private static ArrayList<Student> studentList= new ArrayList<Student>();
	Student(){
		
	}
	
	Student(String name, float mark, String email,String rank,String ID){
		this.name=name;
		this.mark=mark;
		this.email=email;
		this.rank=rank;
		this.ID=ID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank=rank;
	}
	
	//@overloading
	public void setRank(float mark) {
		if(0 <= mark && mark < 5) {
			this.rank="Yếu";
		}
		else if(5<= mark && mark<6.5) {
			this.rank="Trung Bình";
		}
		else if(6.5<=mark && mark<7.5) {
			this.rank="Khá";
		}
		else if(7.5<= mark && mark<9) {
			this.rank="Giỏi";
		}
		else {
			this.rank="Xuất Sắc";
		}
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public static float getAverageMark() {
		float sum=0;
		float averageMark = 0;
		for(Student student:studentList) {
			sum+=student.getMark();
		}
		averageMark = sum/studentList.size();
		return averageMark;
	}
	ArrayList<Student> getStudentList(){
		return studentList;
	}
	public static void printStudent(Student student) {
		System.out.println("+Name: "+student.getName());
		System.out.println("+Mark: "+student.getMark());
		System.out.println("+Email: "+student.getEmail());
		System.out.println("+ID: "+student.getID());
		System.out.println("+Học lực: "+student.getRank());
	}
	public static void printStudentList() {
		int index=1;
		for(Student temp:studentList) {
			System.out.println("-Student "+index+" information:");
			printStudent(temp);
			if(index!=studentList.size()) {
				System.out.println();
			}
			index++;
		}
		if(index==1) {
			System.out.println("There has no student in the class!");
		}
	}
	
	//handle exception
	private boolean isEmpty(String information) {
		if(information.isBlank()) {
			return true;
		}
		return false;
	}
	// handle exception
	private boolean isValidName(String name) {
		if(isEmpty(name)) return false;
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i)==' ') continue;
			if('A'>name.charAt(i) || ('Z'<name.charAt(i) && 'a'>name.charAt(i))
								 || name.charAt(i)>'z' ) {
				return false;
			}
		}
		return true;
	}
	
	// handle exception
	boolean isValidMark(String mark) {
		if(isEmpty(mark)) return false;
		for(int i=0;i<mark.length();i++) {
			if(mark.charAt(i)=='.') continue;
			if(mark.charAt(i)<'0' || mark.charAt(i)>'9') {
				return false;
			}
		}
		if(Float.parseFloat(mark)>10 || Float.parseFloat(mark)<0) {
			return false;
		}
		return true;
	}
	
	//handle exception
	private boolean isValidEmail(String email) {
		if(isEmpty(email)) return false;
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)==' ') {
				return false;
			}
		}
		return true;
	}
	
	//handle exception
	boolean isValidID(String ID) {
		if(isEmpty(ID)) return false;
		for(int i=0;i<ID.length();i++) {
			if('0'>ID.charAt(i) || '9'<ID.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	//handle exception
	boolean isValidRank(String Rank) {
		List<String> Ranks = new ArrayList<String>();
		Ranks.add("Yếu");
		Ranks.add("Trung Bình");
		Ranks.add("Khá");
		Ranks.add("Giỏi");
		Ranks.add("Xuất Sắc");
		if(Ranks.contains(Rank)) {
			return true;
		}
		return false;		
	}
	// input and handle exception
	private void inputName() {
		String name;
		do {
			System.out.print("+Enter name: ");
			name=scanner.nextLine();
			if(!isValidName(name)) {
				System.out.println("Wrong input, please input again!");
				System.out.println("Name can not contain number and must contain at least 1 character");
			}
		}
		while(!isValidName(name));
		setName(name);
	}
	
	// input and handle exception
	private void inputMark() {
		String mark;
		do {
			System.out.print("+Enter mark: ");
			mark=scanner.nextLine();
			if(!isValidMark(mark)) {
				System.out.println("Wrong input,please input again!");
				System.out.println("Mark can only contain number and . ");
				System.out.println("Mark must be in the range from 0 to 10");
			}
		}
		while(!isValidMark(mark));
		setMark(Float.parseFloat(mark));
		setRank(getMark());
	}
	
	//input and handle exception
	private void inputEmail() {
		String email;
		do {
			System.out.print("+Enter email: ");
			email=scanner.nextLine();
			if(!isValidEmail(email)) {
				System.out.println("Wrong input, please input again!");
				System.out.println("Email address can not contain character ' ' and must contain at least 1 character");
			}
		}
		while(!isValidEmail(email));
		setEmail(email);
	}
	
	//input and handle exception
	private void inputID() {
		String ID;
		do {
			System.out.print("+Enter ID: ");
			ID=scanner.nextLine();
			if(!isValidID(ID)) {
				System.out.println("Wrong input,please input again!");
				System.out.println("ID only can contain number and must contain at least 1 number");
			}
		}
		while(!isValidID(ID));
		setID(ID);
	}

	public void inputStudent(){
		Scanner scanner= new Scanner(System.in);
		System.out.println("-Add new Student:");
		inputName();
		inputMark();
		inputEmail();
		inputID();
		if(StudentsID.contains(ID)) {
			System.out.println("Can not exist 2 students that have the same ID, try again!");
			inputStudent();
		}
		else {
			StudentsID.add(ID);	
			Student newStudent= new Student(name,mark,email,rank,ID);
			Xfile.writeFile(newStudent);
			studentList.add(newStudent);
		}
	}
	
	public static void getStudentByMark(float minMark, float maxMark) {
		int index=1;
		System.out.println("-List of student:");
		for(Student temp: studentList) {
			if(temp.getMark() >= minMark && temp.getMark() <= maxMark) {
				System.out.println("Student "+ index+" information: ");
				printStudent(temp);
				index++;
			}
		}
		if(index==1) {
			System.out.println("No student found!");
		}
	}
	
	//overloading
	public static void getStudentByMark(float average) {
		int index=1;
		System.out.println("-List of student:");
		for(Student temp: studentList) {
			if(temp.getMark() >= average) {
				System.out.println("Student "+ index+" information: ");
				printStudent(temp);
				index++;
			}
		}
	}
	
	public static void getStudentByID(String ID) {
		Student beChanged= new Student();
		int index=1;
		System.out.println("-List of student:");
		for(Student temp: studentList) {
			if(temp.getID().equals(ID)) {
				System.out.println("Student "+index+" information: ");
				printStudent(temp);
				beChanged = temp;
				index++;
			}
		}
		if(index!=1) {
			changeInformaion(beChanged);
		}
		if(index==1) {
			System.out.println("Can't find student with that ID");
		}
	}
	
	public static void changeInformaion(Student temp) {
		StudentsID.remove(temp.getID());
		studentList.remove(temp);
		Student newStudent=new Student();
		System.out.println();
		System.out.println("*** Update information of the student ***");
		newStudent.inputStudent();		
	}
	
	public static void getStudentByRank(String rank) {
		int index=1;
		System.out.println("-List of student:");
		for(Student temp: studentList) {
			if(temp.getRank().equals(rank)) {
				System.out.println("Student "+ index+" information: ");
				printStudent(temp);
				index++;
			}
		}
		if(index==1) {
			System.out.println("No student found!");
		}
	}
	public static void sortStudentbyMark() {
		for(int i=0;i<studentList.size()-1;i++) {
			for(int j=i+1;j<studentList.size();j++) {
				if(studentList.get(i).getMark()<studentList.get(j).getMark()) {
					Student temp= studentList.get(i);
					studentList.set(i, studentList.get(j));
					studentList.set(j, temp);
				}
			}
		}
	}
	//@overloading
	public static void sortStudentbyMark(ArrayList<Student> studentLists) {
		for(int i=0;i<studentLists.size()-1;i++) {
			for(int j=i+1;j<studentLists.size();j++) {
				if(studentLists.get(i).getMark()<studentLists.get(j).getMark()) {
					Student temp= studentLists.get(i);
					studentLists.set(i, studentLists.get(j));
					studentLists.set(j, temp);
				}
			}
		}
	}
	
	public static void PrintAllStudentInFile() {
		List<Student> studentList= new ArrayList<Student>();
		try {
			studentList=Xfile.readFile();
			if(studentList.size()==0) {
				System.out.println("There is no student in the class!");
			}
			else {
				for(Student student: studentList) {
					printStudent(student);
					System.out.println();				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
