import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String location;
    private int age;

    public Person(String name, String location, int age) {
        this.name = name;
        this.location = location;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }
}

public class PersonSearch {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        persons.add(new Person("Vamsi", "Dallas", 26));
        persons.add(new Person("Ajay p", "Arkansas", 24));
        persons.add(new Person("Pavan", "Wichita", 18));
        persons.add(new Person("Anil", "Kansas", 20));
        persons.add(new Person("Deepthi", "Irving", 22));
        persons.add(new Person("Sai", "Oklahoma", 28));
        persons.add(new Person("Naveen", "Huston", 27));
        persons.add(new Person("Mani", "New York", 25));

        System.out.print("Search for name or location: ");
        String filter = scanner.nextLine().toUpperCase();

        System.out.println("Search results:");
        for (Person person : persons) {
            if (person.getName().toUpperCase().contains(filter) ||
                person.getLocation().toUpperCase().contains(filter)) {
                System.out.println("Name: " + person.getName() +
                                   ", Location: " + person.getLocation() +
                                   ", Age: " + person.getAge());
            }
        }

        scanner.close();
    }
}
