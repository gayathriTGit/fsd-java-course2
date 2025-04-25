public class Student {
    private String name;
    private int age;
    private double grade;
    static int studentCount;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        studentCount++;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double newGrade) {
        //(Add a check: grade must be between 0 and 100)
        if (newGrade >0 && newGrade <= 100) {
            grade = newGrade;
        }
    }
    //→ prints something like:
    //       "Hi, I'm Alice, age 20, grade: 89.5"
    public void introduce() {
        System.out.println("Hi I'm " + name + ", age " + age + ", grade: " + grade);
    }

    public static void printStudentCount(){
        System.out.println("Total students: " + studentCount);
    }
}
