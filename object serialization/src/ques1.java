import java.util.*;
import java.io.*;

class Employee implements Serializable{
    String name;
    String dob;
    String dept;
    String desn;
    double sal;
    Employee(){}
    
    Employee(String name,String dob,String dept,String desn,double sal){
        this.name = name;
        this.dept = dept;
        this.dob = dob;
        this.desn = desn;
        this.sal = sal;
    }
    public void setName(String Name){
        name = Name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setdob(String d){
        dob = d;
    }
    
    public String getdob(){
        return dob;
    }
    
    public void setdept(String department){
        dept = department;
    }
    
    public String getdept(){
        return dept;
    }
    
    public void setdesn(String desgn){
        desn = desgn;
    }
    
    public String getdesn(){
        return desn;
    }
    
    public void setSalary(double salary){
        sal = salary;
    }
    
    public double getSalary(){
        return sal;
    }
}


public class ques1{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
	Scanner sc = new Scanner(System.in);
	Employee emp = new Employee();
	System.out.print("Enter name: ");
	emp.setName(sc.nextLine());
        System.out.print("Enter D.O.B.: ");
	emp.setdob(sc.nextLine());

	System.out.print("Enter department: ");
	emp.setdept(sc.nextLine());
	System.out.print("Enter designation: ");
	emp.setdesn(sc.nextLine());
        System.out.print("Enter salary: ");
	emp.setSalary(sc.nextDouble());
        sc.nextLine();
	try{
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.flush();
            oos.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee emp2 = (Employee) ois.readObject();
            System.out.println("Name: " + emp2.getName());
            System.out.println("D.O.B.: " + emp2.getdob());
            System.out.println("Department: " + emp2.getdept());
            System.out.println("Designation: " + emp2.getdesn());
            System.out.println("Salary: " + emp2.getSalary());
            ois.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
	sc.close();
    }
}