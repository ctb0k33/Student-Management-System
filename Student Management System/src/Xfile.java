import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
public class Xfile  {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> readFile() throws IOException{
		ArrayList<Student> studentList= new ArrayList<Student>();
		FileInputStream file = null;
		DataInputStream data = null;
		try {
			file= new FileInputStream("students.txt");
			data= new DataInputStream(file);
			while (data.available()>0){
				Student addStudent= new Student();
				addStudent.setName(data.readUTF());
				addStudent.setMark(data.readFloat());
				addStudent.setEmail(data.readUTF());
				addStudent.setRank(data.readUTF());
				addStudent.setID(data.readUTF());
				data.readUTF();
				studentList.add(addStudent);
			} 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		} 
		finally {
			file.close();
			data.close();
		}
		return studentList;
			
	}
	
	public static void writeFile(Student addStudent) {
		try {
			FileOutputStream file= new FileOutputStream("students.txt",true);
			DataOutputStream data = new DataOutputStream(file);	
			System.out.println("Success add student to file \n");
			data.writeUTF(addStudent.getName());
	        data.writeFloat(addStudent.getMark());
	        data.writeUTF(addStudent.getEmail());
	        data.writeUTF(addStudent.getRank());
	        data.writeUTF(addStudent.getID());
	        data.writeUTF("\n");
			data.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fail to add student to file \n File not found \n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fail to add student to file \n Wrong Input!");
			e.printStackTrace();
		}
	}
	
}
