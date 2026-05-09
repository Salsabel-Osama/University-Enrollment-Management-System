public class StudentsList {

    Students StudentHead ;
    Students StudentTail ;
    int count ;
    int size = 30  ;


    StudentsList (){
        this.StudentHead = null ;
        this.StudentTail = null;
        count = 0 ;
    }

    public boolean isEmpty() {
        return  StudentHead == null ;
    }

    public boolean isInList(int studentID) {
        Students tmp;
        for (tmp = StudentHead; tmp != null && !(tmp.studentID == studentID); tmp = tmp.next);
        return (tmp != null);
    }

    public void addStudents (int StudentID){
            if (!isInList(StudentID)) {
                count++;
                if (StudentHead == null && StudentTail == null) {
                    StudentHead = StudentTail = new Students(StudentID);
                } else {
                    StudentTail.next = new Students(StudentID);
                    StudentTail = StudentTail.next;
                }
                System.out.println("Student's " + StudentID + " added");
            }else {
                System.out.println("Sudent's "+StudentID+ " is already enrolled. ");
            }
    }

    public void removeStudents (int studentID) {
        if (!isEmpty()) {
            if ((StudentHead == StudentTail) && (studentID == StudentHead.studentID)) {
                count--;
                StudentHead = StudentTail = null;
                System.out.println("Deleted successfully");
            } else if (studentID == StudentHead.studentID) {
                count--;
                StudentHead = StudentHead.next;
                System.out.println("Deleted successfully");
            } else {
                Students pred, tmp;
                for (pred = StudentHead, tmp = StudentHead.next; (tmp != null) && !(tmp.studentID == studentID); pred = pred.next, tmp = tmp.next);
                if (tmp != null) {
                    count--;
                    pred.next = tmp.next;
                    if (tmp == StudentTail)
                        StudentTail = pred;
                    System.out.println("Deleted successfully");
                } else {
                    System.out.println("Student is not enrolled");
                }
            }
        }
    }

    public int getLastStudentAdd(){
        if(!isEmpty()){
            System.out.print("Last student ID is: ");
            return StudentTail.studentID;
        }
        System.out.print("List is empty: ");
        return -1;  // -1 means list is empty
    }

}
