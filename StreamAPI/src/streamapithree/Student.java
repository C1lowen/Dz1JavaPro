package streamapithree;

public class Student implements Comparable {
    private String name;
    private String lastName;
    private int age;

    public Student() {
    }

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object student) {
        Student studentRes = (Student) student;
        return this.lastName.compareTo(studentRes.getLastName());
    }
}
