import java.util.*;
import java.io.*;

class Employee implements Serializable{
    public String name;
    public int id;
    public int age;
    public double sal;
    Employee(){}
    
    Employee(String name,int id,int age,double sal){
        this.name = name;
        this.id = id;
        this.age = age;
        this.sal = sal;
    }
    public void setName(String Name){
        name = Name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setId(int Id){
        id = Id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setAge(int Age){
        age = Age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setSalary(double salary){
        sal = salary;
    }
    
    public double getSalary(){
        return sal;
    }
    
    @Override
    public String toString() {
	return id + " " + name + " " + age + " " + sal;
    }

}

public class testEmp {
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
        int c;
        int id,age;
        String name;
        double d;
        
        Scanner sc = new Scanner(System.in);
        File f1 = new File("emp.txt");
        //List <Object> al = new ArrayList<>();
        FileOutputStream fos = new FileOutputStream(f1);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        FileInputStream fis = new FileInputStream(f1);
        ObjectInputStream ois = new ObjectInputStream(fis);
        do{
            System.out.println("Main Menu ");
            System.out.println("1. Add an Employee ");
            System.out.println("2. Display All ");
            System.out.println("3. Exit ");
            c = sc.nextInt();
            switch(c){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter Employee ID : ");
                    id = sc.nextInt();
                    System.out.println("Enter Employee Name : ");
                    name = sc.next();
                    System.out.println("Enter Employee Age : ");
                    age = sc.nextInt();
                    System.out.println("Enter Employee Salary : ");
                    d = sc.nextDouble();
                    
                    emp.setId(id);
                    emp.setAge(age);
                    emp.setName(name);
                    emp.setSalary(d);
                    oos.writeObject(emp);
                    break;
                case 2:
                    System.out.println("-------- Report ---------");
                    //List<Object> input = (List<Object>)ois.readObject();
                   
                    while(fis.available()>0){
                        emp = (Employee) ois.readObject();
                        System.out.println(emp);
                        //System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
                    }
                    System.out.println("----- End of Report -----");
                    break;
                case 3:
                    System.out.println("Existing application");
                    break;
            }
        }
        while(c!=3);
        oos.flush();
        oos.close();
        ois.close();
        sc.close();
    }
}
