public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Gayathri Thiyagarjan", 46, 90.5);
        Student student2 = new Student("Priyanka Kannan", 20, 95.5);
        Student student3 = new Student("Aakash Kannan", 13, 98.5);
        Student stundent4 = new Student("Jeevan Thiyagarajan", 6, 98.5);

        student1.introduce();
        student2.introduce();
        student3.introduce();

        Student.printStudentCount();
    }
}