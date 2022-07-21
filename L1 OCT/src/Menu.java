import java.util.ArrayList;
import java.util.Scanner;
public class Menu extends Student {
	Scanner scanner= new Scanner(System.in);
	//handle exception
	public boolean isValidChoose(String optionChoose) {
		for(int i=0;i<optionChoose.length();i++) {
			if('0'>optionChoose.charAt(i) || optionChoose.charAt(i)>'9') {
				return false;
			}
		}
		if(Integer.parseInt(optionChoose)<1 || Integer.parseInt(optionChoose)>11) {
			return false;
		}
		return true;
	}	
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
		System.out.println("===== 11: Exit =====");
	}
	
	private void createLineSpace() {
		System.out.println();
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(getStudentList().size()==0) {
			return true;
		}
		return false;
	}
	public void implement() {
		String optionChoose;
		do {
			System.out.print("-Select task you want to perform: ");
			optionChoose= scanner.nextLine();
			System.out.println();
			if(!isValidChoose(optionChoose)) {
				System.out.println("*** Option must be a integer number in the range from 1 to 11 ***");
			}
		}
		while(!isValidChoose(optionChoose));
		
		switch(optionChoose) {
		case "1":
			Student newStudent= new Student();
			newStudent.inputStudent();
			createLineSpace();
			printMenu();
			implement();
			break;
		case "2":
			Student.printStudentList();
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
					if(!isValidMark(minScore)) {
						System.out.println("Score must be a number in the range from 0 to 10");
						System.out.println("Score only contain number and charater '.' ");
					}
				}
				while(!isValidMark(minScore));
				do {
					System.out.print("Enter max score: ");
					maxScore=scanner.nextLine();
					if(!isValidMark(maxScore)) {
						System.out.println("Score must be a number in the range from 0 to 10");
						System.out.println("Score only contain number and charater '.' ");
					}
				}
				while(!isValidMark(maxScore));
				Student.getStudentByMark(Float.parseFloat(minScore), Float.parseFloat(maxScore));
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
					if(!isValidRank(rank)) {
						System.out.println("Please try again!");
						System.out.println("You can only choose one of these option: ");
						System.out.println("1: Yếu");
						System.out.println("2: Trung Bình");
						System.out.println("3: Khá");
						System.out.println("4: Giỏi");
						System.out.println("5: Xuất Sắc");
					}
				}
				while(!isValidRank(rank));
				Student.getStudentByRank(rank);
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
					if(!isValidID(ID)) {
						System.out.println("ID only can contain number");
					}
				}
				while(!isValidID(ID));
				Student.getStudentByID(ID);
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
				Student.sortStudentbyMark();
				System.out.println("Student list already sorted");
			}
			createLineSpace();
			printMenu();
			implement();
			break;	
		case "7":
			ArrayList<Student> temp= new ArrayList<Student>(getStudentList());
			Student.sortStudentbyMark(temp);	
			if(getStudentList().size()==0) {
				System.out.println("There has no student in the class");
			}
			else if(getStudentList().size()<=5) {
				System.out.println("Not enough 5 students");
				Student.printStudentList();
			}
			else {
				for(int i=0;i<5;i++) {
					System.out.println("-Student "+(i+1)+" information:");
					Student.printStudent(temp.get(i));
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
				System.out.println("Average Mark of the class: " + Student.getAverageMark());
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
				getStudentByMark(Student.getAverageMark());
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
				System.out.println("*** Rank Yếu ***");
				getStudentByRank("Yếu");
				System.out.println();
				System.out.println("*** Rank Trung Bình ***");
				getStudentByRank("Trung Bình");
				System.out.println();
				System.out.println("*** Rank Khá ***");
				getStudentByRank("Khá");
				System.out.println();
				System.out.println("*** Rank Giỏi ***");
				getStudentByRank("Giỏi");
				System.out.println();
				System.out.println("*** Rank Xuất Sắc ***");
				getStudentByRank("Xuất Sắc");
			}
			createLineSpace();
			printMenu();
			implement();
			break;
		case "11":
			System.out.println("*** Thank for using our service! ***");
			return;		
		}
	}
}
