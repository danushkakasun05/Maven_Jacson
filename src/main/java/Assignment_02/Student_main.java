package Assignment_02;
import java.util.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Student_main{
    public List<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<Student> studentList) {
        StudentList = studentList;
    }

    private List<Student>StudentList;
    public  void StudentMain() {

            List<Student> stlst = new ArrayList<>();
            while (true) {
                try {
                Scanner input = new Scanner(System.in);
                System.out.println("Students detais");
                System.out.println(1 + " Add Student:");
                System.out.println(2 + " view Students:");
                System.out.println(3 + " search Student:");
                System.out.println(4 + " Remove Student:");
                //System.out.println(5 + " Add Subject Marks:");
                System.out.println("Enter your option:");


                int option = input.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter student name: ");
                        Student st = new Student(input.next());
                        st.createFile();
                        stlst.add(st);
                        System.out.println();

                        break;
                    case 2:
                        System.out.println("Student name list: ");
                        for (int i=0; i< stlst.size();i++) {
                            System.out.println(stlst.get(i).getName());
                        }
                        break;
                    case 3:
                        System.out.println("Enter name: ");
                        String name = input.nextLine();
                        Path stdpath = Paths.get("E:\\assignment 1\\Subjects\\"+name+".txt");
                        if (Files.exists(stdpath)) {
                            System.out.println("there is a matching student");
                        }else{
                            System.out.println("there is not a student");
                            }
                        break;
                    case 4:
                        System.out.println("Enter delete name: ");
                        String name2 = input.next();
                        Path stdpath2 = Paths.get("E:\\assignment 1\\Subjects\\"+name2+".txt");
                        Files.delete(stdpath2);
                        for (int j=0;j< stlst.size();j++){
                            if (stlst.get(j).getName().equals(name2)){
                                stlst.remove(j);
                                System.out.println("delete completed");

                            }

                            }
                        System.out.println("No such name");
                        break;


                    default:
                        this.StudentList =stlst;
                        return;
                }


            }catch(Exception e){
                    e.getStackTrace();
        }


        }



    }
}

