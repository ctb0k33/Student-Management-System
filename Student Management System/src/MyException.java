import java.util.ArrayList;


public class MyException extends Exception{
	private static final long serialVersionUID = 1L;
	public static String message;
	public String getMessage() {
		return message;
	}
	public static void setMessage(String Message) {
		message=Message;
	}
	public MyException() {
		super(message);
	}
	
	//Check whether String is empty or only contain ' '
	public static boolean isBlank(String information) {
		boolean isBlank =true;
		for(int i=0;i<information.length();i++) {
			if(information.charAt(i)!=' ') {
				isBlank=false;
				break;
			}
		}
		return (information.isEmpty() || isBlank);
	}
	public static boolean isValidName(String name) {
		if (isBlank(name)) {
			setMessage("Name can not be an empty String");
			return false;
		}
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i)==' ') continue;
			if('A'>name.charAt(i) || ('Z'<name.charAt(i) && 'a'>name.charAt(i))
								 || name.charAt(i)>'z') {
				setMessage("Name can only contain normal character or character' '!");
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidMark(String mark) {
		boolean isValid = false;
		try {
			if(Float.parseFloat(mark)<=10 && Float.parseFloat(mark)>=0) {
				isValid=true;
			}
			else {
				setMessage("mark must be a float from 0 to 10! ");
				isValid=false;
			}
		} catch (Exception e) {
			setMessage("mark must be a float from 0 to 10! ");
			isValid=false;
		}
		return isValid;
	}
	
	public static boolean isValidEmail(String email) {
		if(isBlank(email)) {
			setMessage("Email can not be an empty String!" );
			return false;
		}
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)==' ') {
				setMessage("Email can not contain character ' ' ");
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDuplicateID(String ID, ArrayList<String>StudentsID) {
		if(StudentsID.contains(ID)) {
			setMessage("Can not have 2 student with the same ID");
			return false;
		}
		return true;
	}
	
	public static boolean isValidID(String ID) {
		 if(isBlank(ID)) {
			setMessage("ID can not be an empty String");
			return false;
		 }
		 boolean isNumeric = ID.chars().allMatch( Character::isDigit );
		 if(isNumeric) {
			 return true;
		 }
		 setMessage("ID must be a number !");
		 return false;
	}
	
	public static boolean isValidChoice(String optionChoice) {
		boolean isValid = false;
		try {
			if(Float.parseFloat(optionChoice)<13 && Float.parseFloat(optionChoice)>0) {
				isValid=true;
			}
		} catch (Exception e) {
			setMessage("option must be a float from 1 to 12! ");
			isValid=false;
		}
		return isValid;
	}
	
	public static boolean isValidRank(String rank) {
		for (Rank temp : Rank.values()) {
		        if (temp.name().equals(rank)) {
		            return true;
		        }
		    }
		setMessage("Rank can only one of these option: Yeu , TrungBinh , Kha , Gioi , XuatSac");
		return false;
	}
	
}