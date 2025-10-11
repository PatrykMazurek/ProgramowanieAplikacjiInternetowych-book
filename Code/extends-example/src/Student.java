public class Student  extends Person{

    private String studentID;

    public Student(String name, String lastname, int age, String id) {
        super(name, lastname, age);
        this.studentID = id;
    }

    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getStudentID() { return studentID; }

    @Override
    public  void present(){
        super.present();
        System.out.println("student nr " + this.studentID);
    }
}
