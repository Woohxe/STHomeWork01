package studenthome;

public class Student implements Comparable<Student>{
	// 私有变量
	// 问题1： 以lowerCamelCasefe风格命名   private int ID;
	private int id;
	private String name;
	private String birDate;
	private Boolean gender;
	
	public Student() {
		this.id=-1;
	}
	
	public Student(int id,String name,String birDate,Boolean gender) {
		this.id=id;
		this.name=name;
		this.birDate=birDate;
		this.gender=gender;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int compareTo(Student arg0) { // 按学生id值排序
		return this.id - arg0.id;
	}
}
