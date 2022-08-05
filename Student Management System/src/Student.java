
import java.util.ArrayList;

public class Student {
	private String name;
	private float mark;
	private String email;
	private Rank rank;
	private String ID;
	public static ArrayList<String> StudentsID= new ArrayList<String>();
	public static ArrayList<Student> studentList= new ArrayList<Student>();
	public Student(String name, float mark, String email, String iD) {
		super();
		this.name = name;
		this.mark = mark;
		this.email = email;
		ID = iD;
		setRank();
		rank=getRank();
	}
	public Student() {
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
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank input) {
		rank=input;
	}
	public void setRank() {
		if(getMark()<5) {
			rank=Rank.Yeu;
		}
		else if(5<=getMark() && getMark()<=6.5) {
			rank=Rank.TrungBinh;
		}
		else if (6.5<=getMark() && getMark()<7.5) {
			rank=Rank.Kha;
		}
		else if (7.5<=getMark() && getMark()<9) {
			rank=Rank.Gioi;
		}
		else {
			rank=Rank.XuatSac;
		}
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + ", email=" + email + ", rank=" + rank + ", ID=" + ID + "]";
	}
}
