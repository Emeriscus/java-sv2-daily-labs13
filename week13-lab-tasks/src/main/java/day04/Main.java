package day04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> myList = List.of(1, 5, 4, 6, 2, 7, 3);

        // myList.stream().sorted().collect(Collectors.toList());

        List<Human> mylist2 = List.of(new Human("ccc", 2),
                new Human("aaa", 3),
                new Human("iii", 1),
                new Human("zzz", 5),
                new Human("kkk", 2)
        );

        mylist2.stream().sorted(Comparator.comparing(Human::getName)).collect(Collectors.toList());

        mylist2.stream().sorted(Comparator.comparing(Human::getAge)).collect(Collectors.toList());
    }

    public static class Human {
        private String name;
        private int age;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
