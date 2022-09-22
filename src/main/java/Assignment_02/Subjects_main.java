package Assignment_02;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Subjects_main {
    public List<Subjects> getSubjectslist() {
        return subjectslist;
    }

    public void setSubjectslist(List<Subjects> subjectslist) {
        this.subjectslist = subjectslist;
    }

    private List<Subjects> subjectslist;
    public void subjectMain()throws Exception{
        Scanner input = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Subjects> subs = new ArrayList<>();
        while (true) {
            System.out.println("subject details");
            System.out.println(1 + " add subjects: ");
            System.out.println(2 + " subject details: ");
            System.out.println(3 + " delete subject: ");
            System.out.print("Enter your option:");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("enter your Subject name: ");
                    String subject = input.next();
                    Subjects sbjt = new Subjects(subject);
                    System.out.println("hi");
                    subs.add(sbjt);
                    Path paths = Paths.get("E:\\assignment 1\\Students\\"+subject+".txt");
                    Files.createFile(paths);
                    mapper.writeValue(paths.toFile(),sbjt);
                    System.out.println("hi");
                    break;
                case 2:
                    System.out.println("Subject List: ");
                    for (int k = 0; k < subs.size(); k++) {
                        System.out.println(subs.get(k).getSub());
                    }
                    break;
                case 3:
                    System.out.println("Enter Delete subject: ");
                    String delete = input.nextLine();
                    Path path =Paths.get("E:\\assignment 1\\Students\\"+delete+".txt");
                    Files.delete(path);
                    for (int p = 0; p < subs.size(); p++) {
                        if (subs.get(p).getSub().equals(delete)) {
                            subs.remove(p);

                            }

                        }
                    break;
                default:
                    this.subjectslist = subs;
                    return;

                    }



            }

        }


    }

