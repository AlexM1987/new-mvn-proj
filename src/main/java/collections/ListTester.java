package collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class ListTester {
    public static void main(String[] args) {
        List<Cat> listOfCats = new ArrayList<>();
        listOfCats.add(new Cat());
        Cat cat = new Cat();
        cat.setName("Tom");
        listOfCats.add(cat);
        listOfCats.addAll(Arrays.asList(new Cat(), new Cat(), new Cat()));
        System.out.println("listOfCats size " + listOfCats.size());


//        List rawList = new ArrayList();
//        rawList.add(1);
//        rawList.add(new Cat());
//        rawList.add("Tom");
//        rawList.add(new Object());
//        rawList.add(new StringBuilder());

//        System.out.println("rawList size " + rawList.size());


        List<Cat> cats = new ArrayList<>(Arrays.asList(new Cat(), new Cat(), new Cat()));
        cats.addAll(listOfCats);
        cats.remove(cats.size() - 1);
        System.out.println(cats.size());

        //
        Student student1 = new Student(23, "Mike", 7.8);
        Student student2 = new Student(99, "John", 9.8);
        Student student3 = new Student(13, "Bill", 6.2);

        List<Student> group1 = new ArrayList<>();
        group1.add(student1);
        group1.add(student2);
        group1.add(student2);
        group1.add(student3);

        System.out.println("First student in list: " + group1.get(0));
        System.out.println("Last student in list: " + group1.get(group1.size() - 1));
        Student justRemoved = group1.remove(2);
        System.out.println("Removed: " + justRemoved);

        group1.remove(student2);
        System.out.println(group1.removeAll(Arrays.asList(new Student(1,"Alex", 7.2),
                new Student(2, "Bob", 7.2),
                new Student(23, "Mike", 7.8))));

        group1.add(new Student(2, "Bob", 7.2));
        group1.add(new Student(23, "Mike", 9.8));
        group1.add(new Student(10,"Alex", 5.2));
        group1.add(new Student(11,"Alex", 8.2));
        group1.add(new Student(12,"Alex", 7.2));
        group1.add(new Student(13,"John", 7.2));
        group1.add(new Student(14,"Alex", 7.2));



        //walk through list
        for (int i = 0; i < group1.size(); i++){
            Student st = group1.get(i);
            if (st.getAvg() >= 8){
                System.out.println(st.getName().toUpperCase());
            }
        }

        List<Student> listToRemove = new ArrayList<>();

        for (Student s: group1){
            if(s.getAvg() < 7){
                listToRemove.add(s);
            }
        }
        System.out.println("List size to remove: " + listToRemove.size());
        group1.removeAll(listToRemove);

        System.out.println("Left students: " + group1);

        listToRemove.forEach(elem ->{
            System.out.println(elem.getName() + " : " + elem.getAvg());
        });

        //Iterator
        Iterator<Student> iterator = group1.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if(s.getName().startsWith("J")){
                iterator.remove();
                System.out.println("Student is removed.");
            }
        }
        System.out.println("Left : " + group1);


        for (Iterator<Student> iter = group1.iterator(); iter.hasNext();){
            System.out.println(iter.next().toString().toUpperCase());
        }

        System.out.println("******************************");
        group1.sort(new StudentComparator());
        group1.forEach(e ->{
            System.out.println(e);
        });




    }
}

class StudentComparator implements Comparator<Student>{

//    private boolean asc;//desc
//    public StudentComparator(boolean asc){
//        this.asc = asc;
//    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAvg() == o2.getAvg())
            return 0;
        else if(o1.getAvg() > o2.getAvg())
            return 1;
        else
            return -1;
    }
}

@Data
class Cat{
   private int id;
   private String name;
}

@Data
@AllArgsConstructor
class Student {
    private int id;
    private String name;
    private double avg;
}
