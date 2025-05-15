import java.util.ArrayList;
import java.util.Scanner;
class Student{
    private int rollNo;
    private String name;
    private String course;
    private int age;
    private String address;

    public Student(int rollNo,String name,String course,int age){
        this.rollNo=rollNo;
        this.name=name;
        this.course=course;
        this.age=age;
        this.address=address;
    }

    public int getRollNo(){
        return rollNo;
    }
    public String getName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    public void display(){
        System.out.println("Roll No :" + rollNo+",Name :"+name+",Course :"+course+",Age :"+age);
    }

}
public class Main{
    private static ArrayList<Student> studentList=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String args[]){
        int choice;
        do{
            System.out.println("\n***** STUDENT MANAGEMENT SYSTEM *****");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by Roll No");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice :");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    addStudent();break;
                case 2:
                    displayStudents();break;
                case 3:
                    searchStudent();break;
                case 4:
                    deleteStudent();break;
                case 5:
                    System.out.println("Warning ! Exiting the System");break;
                default:
                    System.out.println("invalid Choice");

            }
        }while (choice!=5);
    }
    private static void addStudent(){
        System.out.println("Enter Student Roll Number :");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name :");
        String name =sc.nextLine();

        System.out.println("Enter Course :");
        String course=sc.nextLine();
        System.out.println("Enter Age :");
        int age = sc.nextInt();



        studentList.add(new Student(roll,name,course,age));
        System.out.println("Student Added Successfully");
    }
    private static void displayStudents(){
        if (studentList.isEmpty()){
            System.out.println("No Students Found !");
            return;
        }
        System.out.println("Student Records :");
        for (Student s :studentList){
            s.display();
        }
    }
    private static void searchStudent(){
        System.out.println("Enter Roll Number :");
        int roll = sc.nextInt();
        for(Student s:studentList){
            if(s.getRollNo()==roll){
                System.out.println("Student Found");
                s.display();
                return;
            }

        }
        System.out.println("Student Not Found");
    }
    private static void deleteStudent(){
        System.out.println("Enter Roll Number to be Deleted :");
        int roll = sc.nextInt();
        for(Student s:studentList){
            if(s.getRollNo()==roll){
                studentList.remove(s);
                System.out.println("Student Deleted Successfully");
            }
        }
        System.out.println("Student not Found");
    }

}