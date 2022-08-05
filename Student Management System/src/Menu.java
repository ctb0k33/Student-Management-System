import java.util.ArrayList;
import java.util.Scanner;
public class Menu extends Student {
	Scanner scanner= new Scanner(System.in);
	public void printMenu(){
		System.out.println("=======MENU=======");
		System.out.println("===== 1: Add Student =====");
		System.out.println("===== 2: Show Students =====");
		System.out.println("===== 3: Find students base on mark range =====");
		System.out.println("===== 4: Find students base on rank =====");
		System.out.println("===== 5: Find student base on ID and update student informations =====");
		System.out.println("===== 6: Sort students in ascensing order base on mark =====");
		System.out.println("===== 7: Top 5 students in the class =====");
		System.out.println("===== 8: Average score of the class =====");
		System.out.println("===== 9: Print all students who has score higher then average score =====");
		System.out.println("===== 10: Statistics the number of students according to ranks =====");
		System.out.println("===== 11: Show all students in file =====");
		System.out.println("===== 12: Exit =====");
	}
	private void createLineSpace() {
		System.out.println();
		System.out.println();
	}
	
	public boolean isEmpty() {
		return studentList.isEmpty();
	}
	
	public void implement() throws MyException {
		String optionChoose;
		do {
			System.out.print("-Select task you want to perform: ");
			optionChoose= scanner.nextLine();
			System.out.println();
			if(!MyException.isValidChoice(optionChoose)) {
				System.out.println("*** Option must be a integer number in the range from 1 to 12 ***");
			}
		}
		while(!MyException.isValidChoice(optionChoose));
		
		switch(optionChoose) {
		case "1":
			Student newStudent= new StudentMethod();
			((StudentMethod) newStudent).inputStudent();
			createLineSpace();
			printMenu();
			implement();
			break;
		case "2":
			StudentMethod.printStudentList();
			createLineSpace();
			printMenu();
			implement();
			break;
		case "3":
			String minScore;
			String maxScore;
			if(isEmpty()) {
				System.out.println("There has no student in this class");
			}
			else {
				System.out.println("*** Enter score range ***");
				do {
					System.out.print("Enter min score: ");
					minScore=scanner.nextLine();
					if(!MyException.isValidMark(minScore)) {
						System.out.println("Score must be a number in the range from 0 to 10");
						System.out.println("Score only contain number and charater '.' ");
					}
				}
				while(!MyException.isValidMark(minScore));
				do {
					System.out.print("Enter max score: ");
					maxScore=scanner.nextLine();
					if(!MyException.isValidMark(maxScore)) {
						System.out.println("Score must be a number in the range from 0 to 10");
						System.out.println("Score only contain number and charater '.' ");
					}
				}
				while(!MyException.isValidMark(maxScore));
				StudentMethod.getStudentByMark(Float.parseFloat(minScore), Float.parseFloat(maxScore));
			}
			createLineSpace();
			printMenu();
			implement();
			break;
			
		case "4":
			String rank;
			if(isEmpty()) {
				System.out.println("There has no student in this class");
			}
			else {
				do {
					System.out.print("Enter rank of group students you want to find:");
					rank=scanner.nextLine();
					System.out.println();
					if(!MyException.isValidRank(rank)) {
						System.out.println("Please try again!");
						System.out.println("You can only choose one of these option: ");
						System.out.println("1: Yếu");
						System.out.println("2: Trung Bình");
						System.out.println("3: Khá");
						System.out.println("4: Giỏi");
						System.out.println("5: Xuất Sắc");
					}
				}
				while(!MyException.isValidRank(rank));
				Rank rank2=Rank.valueOf(rank);
				StudentMethod.getStudentByRank(rank2);
			}
			createLineSpace();
			printMenu();
			implement();
			break;
		case "5":
			if(isEmpty()) {
				System.out.println("There has no student in this class");
			}
			else {
				String ID;
				do {
					System.out.print("Enter ID of the student you want to find:");
					ID=scanner.nextLine();
					if(!MyException.isValidID(ID)) {
						System.out.println("ID only can contain number");
					}
				}
				while(!MyException.isValidID(ID));
				StudentMethod temp=new StudentMethod();
				temp.getStudentByID(ID);
			}
			createLineSpace();
			printMenu();
			implement();
			break;	
		case "6":
			if(isEmpty()) {
				System.out.println("There has no student in the class");
			}
			else {
				StudentMethod.sortStudentbyMark(studentList);
				System.out.println("Student list already sorted");
			}
			createLineSpace();
			printMenu();
			implement();
			break;	
		case "7":
			ArrayList<Student> temp= new ArrayList<Student>(studentList);
			StudentMethod.sortStudentbyMark(temp);	
			if(temp.isEmpty()) {
				System.out.println("There has no student in the class");
			}
			else if(temp.size()<=5) {
				System.out.println("Not enough 5 students");
				StudentMethod.printStudentList();
			}
			else {
				for(int i=0;i<5;i++) {
					System.out.println("-Student "+(i+1)+" information:");
					StudentMethod.printStudent(temp.get(i));
				}
			}
			createLineSpace();
			printMenu();
			implement();
			break;	
		case "8":
			if(isEmpty()) {
				System.out.println("There has no student in this class");
			}
			else {
				System.out.println("Average Mark of the class: " + StudentMethod.getAverageMark());
			}
			createLineSpace();
			printMenu();
			implement();
			break;
		case "9":
			if(isEmpty()) {
				System.out.println("There has no student in this class");
			}
			else {
				StudentMethod.getStudentByMark(StudentMethod.getAverageMark());
			}
			createLineSpace();
			printMenu();
			implement();
			break;
		case "10":
			if(isEmpty()) {
				System.out.println("There has no student in the class");
			}
			else {
				StudentMethod.printStudentBaseOnRank();
			}
			createLineSpace();
			printMenu();
			implement();
			break;
		case "11":
			StudentMethod.PrintAllStudentInFile();
			createLineSpace();
			printMenu();
			implement();
			break;
		case "12":
			System.out.println("*** Thank for using our service! ***");
			return;		
		}
	}
}