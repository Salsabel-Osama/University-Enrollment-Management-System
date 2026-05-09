public class Enrollment {
    int StudentID ;
    int CourseID ;
    Enrollment next ;

    Enrollment(int StudentID , int CourseID ){
        this.StudentID = StudentID ;
        this.CourseID= CourseID;
        this.next = null ;
    }
}
