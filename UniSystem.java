import java.util.Stack;

public class UniSystem {

    StudentsList Student;
    CourseList course;
    Enrollment enrollHead;
    Enrollment enrollTail;
    Stack<Sstack> undostack ;
    Stack<Sstack> redostack ;

    UniSystem (){
        this.Student = new StudentsList();
        this.course = new CourseList();
        this.enrollHead = null;
        this.enrollTail = null;
        undostack = new Stack<>();
        redostack = new Stack<>();
    }

    public void Undo(){
        if (undostack.isEmpty()){
            System.out.println("No thing to undo");
            return ;
        }
        Sstack S = undostack.pop();

        switch (S.type){
            case "add Enrollement":
                removeEnrollment(S.studentID , S.courseID);
                break ;
            case "remove Enrollement":
                enrollStudent(S.studentID, S.courseID);
                break ;
        }
        redostack.push(S);
    }

    public void redo(){
        if (redostack.isEmpty()){
            System.out.println("No thing to redo");
            return ;
        }
        Sstack S = redostack.pop();

        switch (S.type){
            case "add Enrollement":
                enrollStudent(S.studentID , S.courseID);
                break ;
            case "remove Enrollement":
                removeEnrollment(S.studentID, S.courseID);
                break ;
        }
        undostack.push(S);
    }

    public void addStudent(int studentID){
        Student.addStudents(studentID);
    }

    public void addCourse(int ID){
        course.addCourse(ID);
    }

    public void removeStudent(int studentID){
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead ;
        while (current != null ){
            if (current.StudentID == studentID){
                removeEnrollment( studentID , current.CourseID);
            }
            current = current.next ;
        }
        Student.removeStudents(studentID);
    }

    public void removeCourse(int courseID){
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead ;
        while (current != null ){
            if (current.CourseID == courseID){
                removeEnrollment(current.StudentID , courseID);
            }
            current = current.next ;
        }
        course.removeCourses(courseID);
    }

    public int getLastStudentAdd(){
        return Student.getLastStudentAdd();
    }


    public int getLastCourseAdd() {
        return course.getLastCourseAdd();
    }

    public void removeEnrollment(int studentID, int courseID){
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return ;
        }
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead ;
        int countcourse =0 ;
        while (current != null) {
            if (current.StudentID == studentID) {
                countcourse++;
            }
            current = current.next;
        }
        boolean found = false ;
        current = enrollHead ;
        while (current != null){
            if (current.StudentID == studentID && current.CourseID == courseID){
               found = true ;
               break ;
            }
            current = current.next ;
        }
        if (!found){
            System.out.println("Student's "+studentID+ " not enrolled in this course before " );
            return ;
        }
        if (enrollHead == null) {
            System.out.println("No enrollments to remove");
            return;
        }
        if (enrollHead.StudentID == studentID && enrollHead.CourseID == courseID) {
            enrollHead = enrollHead.next;
            if (enrollHead == null) {
                enrollTail = null;
            }
            System.out.println("Enrollment of Student's " + studentID + " in Course's " + courseID + " removed successfully");
            return;
        }
        Enrollment pred = enrollHead;
        Enrollment tmp = enrollHead.next;
        while (tmp != null) {
            if (tmp.StudentID == studentID && tmp.CourseID == courseID) {
                pred.next = tmp.next;
                if (tmp == enrollTail) {
                    enrollTail = pred;
                }
                System.out.println("Enrollment of Student's " + studentID + " in Course's " + courseID + " removed successfully");
                return;
            }
            pred = pred.next;
            tmp = tmp.next;
        }
        undostack.push(new Sstack( studentID,courseID, "remove Enrollement"));
        redostack.clear();
    }

    public void enrollStudent (int studentID , int courseID){
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return ;
        }
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead ;
        while (current != null){
            if (current.StudentID == studentID && current.CourseID == courseID){
                System.out.println("Student's "+studentID+ " is enrolled in course "+courseID+" before ");
                return ;
            }
            current = current.next ;
        }
        if (isfullCourse(courseID)){
            System.out.println("The System is full ");
            return ;
        }
        if (!isNormalStudent(studentID)){
            System.out.println("you can't add courses");
            return ;
        }
        Enrollment enrollment = new Enrollment(studentID ,courseID );
        if (enrollHead  == null){
            enrollHead = enrollTail = enrollment ;
        }
        else {
            enrollTail.next = enrollment ;
            enrollTail =  enrollment;
        }
        System.out.println("Student's "+studentID+" is enrolled in course "+courseID +" Successfully");
        undostack.push(new Sstack( studentID , courseID , "add Enrollement"));
        redostack.clear();
//        if (isNormalStudent(studentID)){
//            System.out.println("The Student is not normal");
//        }
    }

    public void listCoursesByStudent(int studentID ){
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return ;
        }
        System.out.print("Student's "+studentID+" is enrolled in these courses : ");
        boolean found = false ;
        Enrollment current  = enrollHead ;
        while (current != null){
            if (current.StudentID == studentID){
                System.out.print(current.CourseID+"  ");
                found = true ;
            }
            current = current.next ;
        }
        if (!found){
            System.out.println("No courses enrolled ");
        }
        System.out.println(" ");
    }

    public void listStudentsByCourse(int courseID){
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return ;
        }
        System.out.print("Courses's "+courseID+" is enrolled in these students : ");
        boolean found = false ;
        Enrollment current  = enrollHead ;
        while (current != null){
            if (current.CourseID == courseID){
                System.out.print(current.StudentID+"  ");
                found = true ;
            }
            current = current.next ;
        }
        if (!found){
            System.out.println("No courses enrolled ");
        }
        System.out.println(" ");
    }

    public void sortStudentsByID(int courseID){
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead;
        int index = 0 ;
        int swap ;
        int []SID = new int[30];
        while (current != null){
            if (current.CourseID == courseID){
                SID[index++] = current.StudentID;
            }
            current = current.next ;
        }
        for (int i =0 ; i < index-1 ; i ++){
            for (int j =0 ; j < index-i-1 ; j++){
                if (SID[j] > SID[j+1]){
                    swap = SID[j];
                    SID[j] = SID[j+1];
                    SID[j+1] = swap ;
                }
            }
        }
        if (index==0 ){
            System.out.println("NO students enrolled in course "+courseID);
        }
        else {
            System.out.print("In course "+courseID+" Sorted Student by ID :");
           for (int i =0 ; i < index ; i++){
               System.out.print(SID[i]+" ");
            }
        }
        System.out.println(" ");
    }

    public void sortCoursesByID(int studentID){
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return ;
        }
        Enrollment current = enrollHead;
        int index = 0 ;
        int swap ;
        int []SID = new int[7];
        while (current != null){
            if (current.StudentID == studentID){
                SID[index++] = current.CourseID;
            }
            current = current.next ;
        }
        for (int i =0 ; i < index-1 ; i ++){
            for (int j =0 ; j < index-i-1 ; j++){
                if (SID[j] > SID[j+1]){
                    swap = SID[j];
                    SID[j] = SID[j+1];
                    SID[j+1] = swap ;
                }
            }
        }
        if (index==0 ){
            System.out.println("Student's "+studentID+" not enrolled in any course. ");
        }
        else {
            System.out.print("Student's"+studentID+" Sorted Student by ID :");
            for (int i =0 ; i < index ; i++){
                System.out.print(SID[i]+" ");
            }
        }
        System.out.println(" ");
    }



    public boolean isfullCourse(int courseID){
        if (!course.isInList(courseID)){
            System.out.println("Course's "+courseID+" not enrolled in the system ");
            return false;
        }
        int count =0 ;
        Enrollment Current = enrollHead ;
        while (Current != null ){
            if (Current.CourseID == courseID){
                count ++;
            }
            Current = Current.next ;
        }

        return count > 30 ;
    }

    int count ;
    public boolean isNormalStudent (int studentID){
        count =0 ;
        if (!Student.isInList(studentID)){
            System.out.println("Student's "+studentID+" not enrolled in the system ");
            return false;
        }
        Enrollment Current = enrollHead ;
        while (Current != null ){
            if (Current.StudentID == studentID){
                count ++;
            }
            Current = Current.next ;
        }
        return  count < 7 ;
    }

}