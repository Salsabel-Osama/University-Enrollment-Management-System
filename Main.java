public class Main {
    public static void main(String[] args) {

        UniSystem system = new UniSystem();

        // 25 students added
        system.addStudent(101);
        system.addStudent(102);
        system.addStudent(103);
        system.addStudent(104);
        system.addStudent(105);
        system.addStudent(106);
        system.addStudent(107);
        system.addStudent(108);
        system.addStudent(109);
        system.addStudent(110);
        system.addStudent(111);
        system.addStudent(112);
        system.addStudent(113);
        system.addStudent(114);
        system.addStudent(115);
        system.addStudent(116);
        system.addStudent(117);
        system.addStudent(118);
        system.addStudent(119);
        system.addStudent(120);
        system.addStudent(121);
        system.addStudent(122);
        system.addStudent(123);
        system.addStudent(124);
        system.addStudent(125);
        system.addStudent(126);
        system.addStudent(127);
        system.addStudent(128);
        system.addStudent(129);
        system.addStudent(130);
        system.addStudent(131);
        system.addStudent(132);
        system.addStudent(133);
        system.addStudent(134);
        System.out.println(" ");
        // 9 courses added
        system.addCourse(501);
        system.addCourse(502);
        system.addCourse(503);
        system.addCourse(504);
        system.addCourse(505);
        system.addCourse(506);
        system.addCourse(507);
        system.addCourse(508);
        system.addCourse(509);
        system.addCourse(510);

        // wrong student id
        system.enrollStudent(11, 501);
        System.out.println(" ");
        // wrong course id
        system.enrollStudent(101, 5);
        System.out.println(" ");
        // studnt is not normal
        system.enrollStudent(101, 501);
        System.out.println(" ");
        //you can't enroll the same course
        system.enrollStudent(101, 501);
        System.out.println(" ");
        // each student can enroll from 2 to 7 courses
        system.enrollStudent(102, 509);
        system.enrollStudent(102, 504);
        system.enrollStudent(102, 502);
        system.enrollStudent(102, 505);
        system.enrollStudent(102, 506);
        system.enrollStudent(102, 508);
        system.enrollStudent(102, 507);
        // you can't add more than 7 courses
        system.enrollStudent(102, 503);
        System.out.println(" ");
        // you can't enroll more than 30 student's in the same course
        system.enrollStudent(115, 501);
        system.enrollStudent(105, 501);
        system.enrollStudent(104, 501);
        system.enrollStudent(106, 501);
        system.enrollStudent(107, 501);
        system.enrollStudent(120, 501);
        system.enrollStudent(109, 501);
        system.enrollStudent(110, 501);
        system.enrollStudent(111, 501);
        system.enrollStudent(112, 501);
        system.enrollStudent(113, 501);
        system.enrollStudent(114, 501);
        system.enrollStudent(103, 501);
        system.enrollStudent(116, 501);
        system.enrollStudent(117, 501);
        system.enrollStudent(122, 501);
        system.enrollStudent(119, 501);
        system.enrollStudent(108, 501);
        system.enrollStudent(121, 501);
        system.enrollStudent(118, 501);
        system.enrollStudent(123, 501);
        system.enrollStudent(124, 501);
        system.enrollStudent(128, 501);
        system.enrollStudent(126, 501);
        system.enrollStudent(127, 501);
        system.enrollStudent(125, 501);
        system.enrollStudent(129, 501);
        system.enrollStudent(130, 501);
        system.enrollStudent(131, 501);
        system.enrollStudent(132, 501);
        system.enrollStudent(133, 501);
        System.out.println("     ");
        //sort students by course ID
        system.removeEnrollment(108 , 501);
        system.sortStudentsByID(501);
        system.sortStudentsByID(330);
        System.out.println("     ");
        //sort courses by student ID
        system.sortCoursesByID(102);
        system.sortCoursesByID(44);
        // last student , last course
        System.out.println("     ");
        System.out.println(system.getLastCourseAdd());
        System.out.println(system.getLastStudentAdd());
        // remove student
        System.out.println("     ");
        system.removeStudent(134);
        system.removeCourse(510);
        // isfull
        System.out.println("     ");
        system.enrollStudent(108, 501);
        System.out.print("Is the system full ? ");
        System.out.println(system.isfullCourse(301));
        System.out.print("Is the system full ? ");
        System.out.println(system.isfullCourse(501));
        //  isnormal
        System.out.println("     ");
        System.out.print("Is the student normal ? ");
        System.out.println(system.isNormalStudent(10));
        System.out.print("Is the student normal ? ");
        System.out.println(system.isNormalStudent(102));
        //list of student , list of courses
        System.out.println("    ");
        system.listStudentsByCourse(501);
        system.listCoursesByStudent(102);
        // undo
        System.out.println("    ");
        system.Undo();
        // redo
        system.redo();
        System.out.println("    ");
        // remove enrollement
        system.removeEnrollment(99,501);
        system.removeEnrollment(102,51);
        system.removeEnrollment(103,504);
        system.removeEnrollment(103,501);
        system.removeEnrollment(103,501);
        system.listStudentsByCourse(501);
        system.listCoursesByStudent(103);

    }
}
