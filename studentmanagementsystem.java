import java.util.*;
public class studentmanagementsystem {
    static class student{
        int id;
        String name;
        double marks;

        student(int id,String name,double marks){
            this.id=id;
            this.name=name;
            this.marks=marks;
        }
        public String toString(){
             return "id:" + id +", name:" + name + ",marks" + marks;
        }

    }
    private static final Scanner sc=new Scanner(System.in);
    private static final ArrayList<student> students=new ArrayList<>();

    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n--------student record management system---------");
            System.out.println("1.add students");
            System.out.println("2.view students");
            System.out.println("3.update student");
            System.out.println("4.delete student");
            System.out.println("5.exit");
            System.err.println("enter your choice");
            choice = sc.nextInt();
            switch(choice){
                case 1 -> addstudent();
                case 2 -> viewstudent();
                case 3 -> updatestudent();
                case 4 -> deletestudent();
                case 5 -> System.out.println("existing......");
                default -> System.out.println("invalid choice please try again");
            }

        }while(choice !=5);
    }
       private static void addstudent(){
        System.out.print("enter id");
        int id=sc.nextInt();
        sc.nextLine();//consume newline
        System.out.print("eneter name");
        String name = sc.nextLine();
        System.out.println("enetr marks");
        double marks =sc.nextDouble();
        students.add(new student(id,name,marks));
        System.out.println("student added successfully");

       } 
        private static void viewstudent(){
            if(students.isEmpty()){
                System.out.println("no student records found");
                return;
            }
            System.out.println("\n------------student research-------------");
            for(student s : students){
                System.out.println(s);
            }
        }
        private static void updatestudent(){
            System.out.println("enter student id to update");
            int id=sc.nextInt();
            for(student s: students){
                if(s.id==id){
                    sc.nextInt();
                    System.out.println("enter new name");
                    s.name=sc.nextLine();
                    System.out.println("eneter new marks");
                    s.marks=sc.nextDouble();
                    System.out.println("student update succesfull");
                    return;
                }
            }
            System.out.println("student with id"+ id+"not found");
        }
        private static void deletestudent(){
            System.out.println("enter student id to delete");
            int id=sc.nextInt();
            Iterator<student> iterator =students.iterator();
            while(iterator.hasNext()){
                if(iterator.next().id==id){
                    iterator.remove();
                    System.out.println("student deleted sucessfully");
                    return;
                }
            }
            System.out.println("student with id"+ id+"not found");
        }

    }


