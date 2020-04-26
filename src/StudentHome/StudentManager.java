package StudentHome;

import java.util.Arrays;
import java.util.Scanner;

public class StudentManager{
	Scanner sc = new Scanner(System.in); //输入值

	Student[] students;//最多20个学生
	int num;//目前学生人数

	public StudentManager(){
		students=new Student[20];
		num=0;
		for(int i=0;i<20;i++)//预先分配空间
		{
			students[i]=new Student();
		}
	}
	public void app() {
		//控制台界面
		System.out.println("请输入你的选择：");
		System.out.println("***********************************");
		System.out.println("*              1  插入                                   *");
		System.out.println("*              2  查找                                   *");
		System.out.println("*              3  删除                                   *");
		System.out.println("*              4  修改                                   *");
		System.out.println("*              5  输出                                   *");
		System.out.println("*              6  退出                                   *");
		System.out.println("***********************************\n");
		//输入值判断
		int input=sc.nextInt();
		switch (input) {
			case 1://插入信息
				addStudent();
				break;
			case 2://查找信息
				searchStudent();
				break;
			case 3://删除信息
				deleteStudent();
				break;	
			case 4://修改信息
				updateStudent();
				break;
			case 5://输出信息
				printStudent();
				break;
			case 6://退出
				System.out.println("成功退出\n");
				System.exit(0);
				break;
			default://输入有误
				System.out.println("您的选择有误！请输入正确的选项\n");
				app();//重复出现菜单
				break;
		}
	}
	
	//插入信息
	public void addStudent() {
		if(num>=students.length) {//已存储了20个学生信息
			System.out.println("当前存储学生信息数量已达上限，若要添加学生信息请先删除\n");
		}
		else{
			System.out.println("添加学生信息");
			System.out.println("输入ID");
			int id = sc.nextInt();
			int flag=0;//学生信息是否已存在
			for(int i=0;i<students.length;i++)
			{
				Student s=students[i];
				if(id==s.getId()){
					System.out.println("该学生信息已存在！请重新输入\n");
					flag=1;
					addStudent();
					break;
				}
			}
			if(flag==0) {//没有重复的
				System.out.println("输入姓名");
				String name = sc.next();
				System.out.println("输入出生日期");
				String birDate= sc.next();
				System.out.println("输入性别");
				Boolean gender = sc.nextBoolean();
				Student s= new Student(id,name,birDate,gender);
				for(int i=0;i<students.length;i++)//找数组中的空闲空间
				{
					Student ss=students[i];
					if(ss.getId()==-1){//证明这个数组项没有存储学生信息
						students[i]=s;
						break;
					}
				}
				System.out.println("成功添加学生信息");
				num++;//当前学生数量+1
				Arrays.sort(students);//排序
				app();
			}
		}
	}
	
	//查找信息
	public void searchStudent() {
		System.out.println("请输入要查找信息的学生的姓名：");
		String name = sc.next();
		int flag=0;//判断是否有找到
		for(int i=0;i<students.length;i++)
		{
			Student s=students[i];
			if(name.equals(s.getName())&&s.getId()!=-1){//有匹配的,java中字符串的比较不能用“==”！！！
				System.out.println("ID:"+s.getId()+" Name："+s.getName()+" BirDate:"+s.getBirDate()+" Gender:"+s.getGender());
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("没有符合条件的学生！\n");
		}
		app();
	}

	//删除信息
	public void deleteStudent() {
		System.out.println("请输入要删除信息的学生的姓名：");
		String name = sc.next();
		int flag=0;//判断是否有找到
		int cnt=0;//删除的人数
		for(int i=0;i<students.length;i++)
		{
			Student s=students[i];
			if(name.equals(s.getName())&&s.getId()!=-1){//有匹配的,java中字符串的比较不能用“==”！！！
				s.setId(-1);//删除成功后将数组的id值置-1
				num--;
				cnt++;
				flag=1;
			}
			students[i]=s;
		}
		if(flag==0) {
			System.out.println("没有符合条件的学生！\n");
		}
		else {
			System.out.println("成功删除"+cnt+"条学生信息\n");
		}
		app();
	}

	//修改信息
	public void updateStudent() {
		System.out.println("请输入要修改信息的学生的姓名：");
		String name=sc.next();
		int flag=0;
		int cnt=0;
		for(int i=0;i<students.length;i++)
		{
			Student s=students[i];
			if(name.equals(s.getName())&&s.getId()!=-1){//有匹配的,java中字符串的比较不能用“==”！！！
				System.out.println("符合条件：ID:"+s.getId()+" Name："+s.getName()+" BirDate:"+s.getBirDate()+" Gender:"+s.getGender());			
				System.out.println("修改姓名：");
				s.setName(sc.next());
				System.out.println("修改出生日期：");
				s.setBirDate(sc.next());
				System.out.println("修改性别：");
				s.setGender(sc.nextBoolean());
				flag=1;
				cnt++;
			}
			students[i]=s;
		}
		if(flag==0) {
			System.out.println("无符合条件的信息！");
		}
		else {
			System.out.println("修改"+cnt+"条学生信息成功");
		}
		app();
		
	}

	//输出信息
	public void printStudent() {
		if(num==0) {//没有学生信息
			System.out.println("暂无学生信息");
		}
		else {
			System.out.println("共有"+num+"条学生信息");
			for(int i=0;i<students.length;i++)
			{
				Student s=students[i];
				if(s.getId()!=-1){//此时有学生信息
					System.out.println("ID:"+s.getId()+" Name："+s.getName()+" BirDate:"+s.getBirDate()+" Gender:"+s.getGender());			
				}
			}	
		}
		
		app();
	}
}