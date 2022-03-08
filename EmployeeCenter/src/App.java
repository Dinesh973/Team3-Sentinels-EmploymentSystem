import java.sql.*;
import java.util.*;


class Job{
    int jbno;
    String jbname;
    String jbtype;
    double salary;
    String location;
    String jbtime;
    int availableSeats;
    public Job(int jbno,String jbname,String jbtype,double salary,String location,String jbtime,int availableSeats){
        this.jbno = jbno;
        this.jbname = jbname;
        this.jbtype = jbtype;
        this.salary = salary;
        this.location = location;
        this.jbtime = jbtime;
        this.availableSeats = availableSeats;
    }
    
    public void Display(){
        System.out.println(jbno + "\t" + jbname + "\t" + jbtype + "\t\t" +  salary + "\t"+"\t" + location + "\t"+jbtime);
    }
}
class Employee{
    int empno;
    String name;
    String pno;
    double salary;
    String email;
    String qualification;
    String skills;
    String appliedfor;
    String allocateJob;
    boolean isavailable;
    public Employee(int empno,String name,String pno,String email,String qualification,String skills,String appliedfor,String allocateJob,boolean isavailable,double salary){
        this.empno = empno;
        this.name = name;
        this.pno = pno;
        this.salary = salary;
        this.email = email;
        this.qualification = qualification;
        this.skills = skills;
        this.appliedfor = appliedfor;
        this.isavailable = isavailable;
        this.allocateJob = allocateJob;
    }

    
    public void Display(){
        System.out.println(empno + "\t" + name + "\t" + pno + "\t" + email + "\t" + qualification + "\t" + skills + "\t" + appliedfor);
    }
}


class App{  
    public static double SalaryProcessing(double basic){
    double da;
	double hra;
	double oth;
    da = 0.90 * basic;
    hra = 0.20 * basic;
    oth = 0.10 * basic;
    
    double total = basic + da + hra + oth;

        return total;
    }
    public static void AllocateJob(Employee emp[],Job jb[],int m,int n){
        Scanner sc = new Scanner(System.in);
        String[] allocDb = new String[m];
        int g =0;
        System.out.println("Enter the Date : ");
        String date_range = sc.nextLine();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(emp[j].appliedfor.toLowerCase().equals(jb[i].jbname.toLowerCase())){
                    if(jb[i].availableSeats != 0){
                        System.out.println(jb[i].jbname.toLowerCase() + " is Allocated for " + emp[j].name.toLowerCase());
                        System.out.println("Is " + emp[j].name.toLowerCase() + " Available for job during "+date_range+" y or n ");
                        String resp=sc.nextLine();
                        if(resp.equals("n")){
                            continue;
                        }
                        else{
                            if(jb[i].availableSeats != 0){                                
                                emp[j].salary = SalaryProcessing(jb[j].salary);
                                allocDb[g] = emp[j].name.toLowerCase() + "\t\t" + jb[i].jbname.toLowerCase()+"\t\t" + emp[j].salary;
                                g++;
                                System.out.println(jb[i].jbname.toLowerCase() + " job is Allocated for " + emp[j].name.toLowerCase());
                                
                                jb[i].availableSeats--;
                            }
                            else{
                                continue;
                            }
                            
                        }
                    }
                    
                }
            }
        }

        System.out.println("\n\nFinally The allocated Jobs and salaries Are :");
        System.out.println("S.No\t\tName\t\tJob Allocated\t\tSalary:");
        int a = 0;
        for(String l:allocDb){
            if(l!=null){
                System.out.println((a+1)+"\t\t" + l);
                a++;
            }
            

        }
        sc.close();
        
    }
    public static void main(String args[]){  
       
        try{  
            Employee emp[] = new Employee[10];
            Job jb[] = new Job[10];
            int m = 0;// for employee
            int n = 0;//for job
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/employee","root","password");    
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from task"); 
            
            System.out.println("\nList of available Jobs\n"); 
            System.out.println("JobNo \t JobName \t JobType \t Salary \t Location \t WOrking hours");

            while(rs.next()){
                jb[n] = new Job(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                n++;  
                
            } 
            for(int l = 0;l<n;l++){
                jb[l].Display();
            }
            ResultSet rs2=stmt.executeQuery("select * from jobseekers"); 
            System.out.println("\nList of Jobseekers\n"); 
            System.out.println("Sno \t Name \t phno \tEMail \t\tQualification \tSkills \t\t\t Applied for");

            while(rs2.next()){ 
                emp[m] = new Employee(rs2.getInt(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7),rs2.getString(8),rs2.getBoolean(9),0.0);
                m++;
            }

            
         for(int l = 0;l<m;l++){
            emp[l].Display();
        }
        AllocateJob(emp,jb,m,n);
            con.close(); 
            
        }
        catch(Exception excp){ 
            System.out.println(excp);
        } 
         
    }  
}  