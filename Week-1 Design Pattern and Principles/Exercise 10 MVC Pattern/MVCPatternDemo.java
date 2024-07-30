public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = new Student();
        model.setName("karan");
        model.setId("123");
        model.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Smith");
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
