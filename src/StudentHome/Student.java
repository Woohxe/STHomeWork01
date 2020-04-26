package StudentHome;

public class Student implements Comparable<Student>{
	//私有变量
	private int ID;
	private String name;
	private String birDate;
	private Boolean gender;
	
	public Student() {
		this.ID=-1;
	}
	
	public Student(int id,String name,String birDate,Boolean gender) {
		this.ID=id;
		this.name=name;
		this.birDate=birDate;
		this.gender=gender;
	}
	@Override
	public String toString() {
		return "Student [id=" + ID + ", name=" + name + ", birDate=" + birDate
				+ ", gender=" + gender + "]";
	}
	static final int USER_STUDENT = 2;
	
	
	public Integer getId() {
		return ID;
	}

	public void setId(Integer id) {
		this.ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirDate() {
		return birDate;
	}

	public void setBirDate(String birDate) {
		this.birDate = birDate;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Override
	public int compareTo(Student arg0) {//按学生id值排序
		return this.ID - arg0.ID;
	}
}
