
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMethod extends Student {	
	static Scanner scanner = new Scanner(System.in);
	public StudentMethod(String name, float mark, String email, String iD) {
		super(name, mark, email, iD);
	}
	public StudentMethod() {
		
	}
	public void inputName() throws MyException {
		String name=null;
		do {
			try {
				System.out.print("Enter name: ");
				name=scanner.nextLine();
				if(!MyException.isValidName(name)) {
					throw new MyException();
				}
			}catch(MyException e){
				System.out.println(e.getMessage());
			}
		}
		while(!MyException.isValidName(name));
		setName(name);
	}
	
	public void inputMark() throws MyException{
		String mark=null;
		do {
			try {
				System.out.print("Enter mark: ");
				mark=scanner.nextLine();
				if(!MyException.isValidMark(mark)) {
					throw new MyException();
				}
			}catch(MyException e) {
				System.out.println(e.getMessage());
			}
			
		}
		while(!MyException.isValidMark(mark));
		setMark(Float.parseFloat(mark));
		setRank();
	}
	
	public void inputEmail() throws MyException{
		String email=null;
		do {
			try {
				System.out.print("Enter email: ");
				email=scanner.nextLine();
				if(!MyException.isValidEmail(email)) {
					throw new MyException();
				}
			}catch(MyException e) {
				System.out.println(e.getMessage());
			}
		}
		while(!MyException.isValidEmail(email));
		setEmail(email);
	}
	
	public void inputID() throws MyException{
		String ID= null;
		do {
			try {
				System.out.print("Enter ID: ");
				ID=scanner.nextLine();
				if(!MyException.isValidID(ID)) {
					throw new MyException();
				}
				if(!MyException.isDuplicateID(ID, StudentsID)) {
					throw new MyException();
				}
			}
			catch(MyException e) {
				System.out.println(e.getMessage());
			}
		}
		while(!MyException.isValidID(ID) || !MyException.isDuplicateID(ID, StudentsID));
		setID(ID);
	}
	
	public void inputStudent() throws MyException {
		System.out.println("-Add new Student:");	
		inputName();
		inputMark();
		inputEmail();
		inputID();
		StudentsID.add(getID());
		Student newStudent = new Student(getName(),getMark(),getEmail(),getID());	
		studentList.add(newStudent);
		Xfile.writeFile(newStudent);
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
		
	public void changeInformaion(Student temp) throws MyException {
		StudentsID.remove(temp.getID());
		studentList.remove(temp);
		System.out.println();
		System.out.println("*** Update information of the student ***");
		inputStudent();		
	}
		
	public void getStudentByID(String ID) throws MyException {
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
	
	public static void getStudentByRank(Rank rank) {
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
	
	public static float getAverageMark() {
		if(studentList.isEmpty()) {
			return 0;
		}
		float sum=0;
		for(Student student:studentList) {
			sum+=student.getMark();
		}
		return sum/studentList.size();
	}
	
	public static void printStudentBaseOnRank() {		
		System.out.println("*** Rank Yếu ***");
		getStudentByRank(Rank.Yeu);
		System.out.println();
		System.out.println("*** Rank Trung Bình ***");
		getStudentByRank(Rank.TrungBinh);
		System.out.println();
		System.out.println("*** Rank Khá ***");
		getStudentByRank(Rank.Kha);
		System.out.println();
		System.out.println("*** Rank Giỏi ***");
		getStudentByRank(Rank.Gioi);
		System.out.println();
		System.out.println("*** Rank Xuất Sắc ***");
		getStudentByRank(Rank.XuatSac);
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
					System.out.println();				
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}