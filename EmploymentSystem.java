import java.util.*;
class Job{
    int jbno;
    String jbname;
    String jbtype;
    String jbtime;
    public Job(int jbno,String jbname,String jbtype,String jbtime){
        this.jbno = jbno;
        this.jbname = jbname;
        this.jbtype = jbtype;
        this.jbtime = jbtime;
    }
    
    public String toString(){
        return jbno + "\t" + jbname + "\t" + jbtype + "\t" + jbtime;
    }
}
class Employee{
    int empno;
    String name;
    String pno;
    double salary;
    String addr;
    double wrhrs;
    public Employee(int empno,String name,String pno,double salary,String addr,double wrhrs){
        this.empno = empno;
        this.name = name;
        this.pno = pno;
        this.salary = salary;
        this.addr = addr;
        this.wrhrs = wrhrs;
    }
    public String toString(){
        return empno + "\t" + name + "\t" + pno +"\t" + salary + "\t" + addr + "\t" + wrhrs;
    }
    
}

class Admin{
    public Admin(){
        
    }
    
    //create employees
    // public void CreateEMploye
    
    //update employees
    
    //create job 
    
    //Allocate job 
    
    //salary processing
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        Employee[] e = new Employee[n];
        Job[] j = new Job[n];
        for(int i = 0;i<n;i++){
            int emno = sc.nextInt();
            String name = sc.next();
            String phno = sc.next();
            double sal = sc.nextDouble();
            String addr = sc.next();
            double wrhrs = sc.nextDouble();
            e[i] = new Employee(emno,name ,phno,sal,addr,wrhrs);
        }
        for(int i = 0;i<n;i++){
            j[i] = new Job(sc.nextInt(), sc.next(),sc.next(),sc.next());
        }
        
        for(int i = 0;i<n;i++){
            System.out.println(e[i].toString());
        }
        for(int i = 0;i<n;i++){
            System.out.println(j[i].toString());
        }
        
    }
}