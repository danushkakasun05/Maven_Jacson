package Assignment_02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            Map<String, Integer> maps = new HashMap<>();
            Scanner input = new Scanner(System.in);
            Student_main student = new Student_main();
            Subjects_main subject = new Subjects_main();
            ObjectMapper mapper = new ObjectMapper();
            student.StudentMain();
            subject.subjectMain();
            System.out.println("Add marks to students");
            System.out.println(subject.getSubjectslist());
            System.out.println(student.getStudentList());
            int mark = 0;
            for (int i = 0; i < student.getStudentList().size(); i++) {
                System.out.println("Enter " + student.getStudentList().get(i).getName() + " marks");

                for (int j = 0; j < subject.getSubjectslist().size(); j++) {

                    System.out.print("subject " + subject.getSubjectslist().get(j).getSub() + " Marks: ");
                    mark = input.nextInt();
                    maps.put(subject.getSubjectslist().get(j).getSub(), mark);
                    System.out.println(maps);
                    Path filePath = Paths.get("E:\\assignment 1\\Subjects\\" + student.getStudentList().get(i).getName() + ".txt");


                }
                Path filePath = Paths.get("E:\\assignment 1\\Subjects\\" + student.getStudentList().get(i).getName() + ".txt");
                mapper.writeValue(filePath.toFile(), maps);


            }
            Map<String, Integer> all_student = new HashMap<>();
            Map<String, Integer> studentVar = new HashMap<>();
            System.out.println(student.getStudentList());
            int total = 0;
            for (int i = 0; i < student.getStudentList().size(); i++) {
                Path filepath2 = Paths.get("E:\\assignment 1\\Subjects\\" + student.getStudentList().get(i).getName() + ".txt");
                studentVar = mapper.readValue(filepath2.toFile(), Map.class);
                total = 0;
                System.out.println(studentVar);
                for (int k = 0; k < studentVar.size(); k++) {
                    total = total + studentVar.get(subject.getSubjectslist().get(k).getSub());
                }
                all_student.put(student.getStudentList().get(i).getName(), total);
            }
            List<Student> stdList = new ArrayList<>();
            System.out.println(all_student);
            for (int a = 0; a < all_student.size(); a++) {
                int marks = all_student.get(student.getStudentList().get(a).getName());
                Student stdNew = new Student(student.getStudentList().get(a).getName(), marks);
                stdList.add(stdNew);
            }
            List<Student> editStdList = stdList;
            for (int b = 0; b < editStdList.size() - 1; b++) {
                for (int c = b + 1; c < editStdList.size(); c++) {
                    if (editStdList.get(b).getMarks() < editStdList.get(c).getMarks()) {
                        Student st1 = new Student();
                        Student st2 = new Student();
                        st1 = editStdList.get(b);
                        st2 = editStdList.get(c);
                        editStdList.set(b, st2);
                        editStdList.set(c, st1);

                    }
                }
            }
            System.out.println("Student marks list");
            for (int j = 0; j < editStdList.size(); j++) {
                System.out.println("Rank "+j+" "+editStdList.get(j).getName());
            }

        }catch(Exception e){
            System.out.println("erro"+e);
        }

    }
}
