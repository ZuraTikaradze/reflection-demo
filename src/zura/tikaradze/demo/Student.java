package zura.tikaradze.demo;

public class Student {

    @StudentNameAnnotation
    private String fullName;

    @Deprecated
    private int age;

    private void doSomethingPrivate() {
        System.out.println("Private");
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
