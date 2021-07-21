package com.harisewak.dsa.datastructures.collections;

// import collections framework
import java.util.*;
import java.util.function.Consumer;

public class StartCode {

    public static void main(String[] args) {
        System.out.println("Start coding Java Collection Framework!");

        testingListImpl();

        checkingSetImpl();

        checkingSortedSet();

        checkingCustomSortingStyles();

    }

    private static void checkingCustomSortingStyles() {
        // Checking Custom class comparisons..
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kamlesh", 12, 5, 3.50F));
        students.add(new Student("Ravi", 13, 5, 3.20F));
        students.add(new Student("Abhay", 11, 5, 3.20F));
        students.add(new Student("Jai", 13, 5, 4.10F));

        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.print(student.toString() + " ");
            }
        });

        System.out.println();

        System.out.println("-----------After natural sorting---------------");
        Collections.sort(students);
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.print(student.toString() + " ");
            }
        });

        System.out.println();

        System.out.println("-----------After age sorting---------------");
        Collections.sort(students, new AgeComparator());
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.print(student.toString() + " ");
            }
        });

        System.out.println();

        System.out.println("-----------After standard sorting---------------");
        Collections.sort(students, new ClassComparator());
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.print(student.toString() + " ");
            }
        });

        System.out.println();

        System.out.println("-----------After height sorting---------------");
        Collections.sort(students, new HeightComparator());
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.print(student.toString() + " ");
            }
        });
    }

    private static void checkingSortedSet() {
        if (false) {
            Set<Integer> set = new TreeSet<>();
            Set<Integer> unsortedSet = new HashSet<>();
            for (int i = 0; i < 50; i++) {
                Random random = new Random();
                int rand = random.ints(1, 500).findFirst().getAsInt();
                unsortedSet.add(rand);
                set.add(rand);
            }

            Iterator<Integer> iterator = unsortedSet.iterator();
            while (iterator.hasNext()) {
                System.out.println("value -> " + iterator.next());
            }
        }
    }

    private static void checkingSetImpl() {
        if (false) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                set.add(i);
            }

            set.add(1);
            set.add(1);

            System.out.println("set: "+set);
        }
    }

    private static void testingListImpl() {
        if (false) {
            LinkedList list = new LinkedList();
            list.add("Kamlesh");
            list.add(123);
            list.add(true);
            list.add(new Dialogue("Waah Taj!", Dialogue.Quality.Ok));

            ListIterator listIterator = list.listIterator();

            while (listIterator.hasNext()) {
                System.out.println("value -> "+listIterator.next());
            }
        }
    }


    static class Dialogue {
        private String text;
        private Quality quality;


        public Dialogue(String text, Quality quality) {
            this.text = text;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return text + " " + quality.toString();
        }

        enum Quality {
            Poor, Ok, Good, Great
        }
    }

}
