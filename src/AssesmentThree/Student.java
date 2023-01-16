package AssesmentThree;
//class to get the Student details  
class Student {  
   // declaring variables  
   int Stu_id;  
   String name;  
   String subject;
   float marks;  
 
   // using constructor to initialize the variables  
  Student (int id, String n, String d, float mar){  
       this.Stu_id = id;  
       this.name = n;  
       this.subject = d;  
       this.marks = mar;  
   }  
 
   // method to display the Student details  
   void display() {  
       System.out.println("Student id: " + Stu_id );  
       System.out.println("Student name: " + name );  
       System.out.println("Student subject: " + subject );  
       System.out.println("Student marks: " + marks);  
   }  

   public static void main(String[] args) {  
       // creating objects of class Student  
   Student e1 = new Student(1001, "Anne", "Maths", 100); 
   Student e2 = new Student(1002, "Cate", "Physics",90);  
   Student e3 = new Student(1003, "Rhea", "Chemistry",85);     
 
   e1.display();    
   e2.display();    
   e3.display();    
   }  
}  