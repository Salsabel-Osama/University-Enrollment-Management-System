public class CourseList {
    Courses courseHead;
    Courses courseTail;
    int countcourses = 0;

    CourseList() {
        this.courseHead = null;
        this.courseTail = null;
    }

    public boolean isEmpty() {
        return courseHead == null;
    }

    public boolean isInList(int CourseID) {
        Courses tmp;
        for (tmp = courseHead; tmp != null && !(tmp.courseID == CourseID); tmp = tmp.next) ;
        return (tmp != null);
    }

    public void addCourse(int CourseID) {
        if (!isInList(CourseID)) {
            countcourses++;
            if (courseHead == null && courseTail == null) {
                courseHead = courseTail = new Courses(CourseID);
            } else {
                courseTail.next = new Courses(CourseID);
                courseTail = courseTail.next;
            }
            System.out.println("Course's " + CourseID + " added");
        } else {
            System.out.println("Course's " + CourseID + " is already enrolled. ");
        }
    }


    public void removeCourses(int ID) {
        if (!isEmpty()) {
            if ((courseHead == courseTail) && (ID == courseHead.courseID)) {
                countcourses--;
                courseHead = courseTail = null;
                System.out.println("Deleted successfully");
            } else if (ID == courseHead.courseID) {
                countcourses--;
                courseHead = courseHead.next;
                System.out.println("Deleted successfully");
            } else {
                Courses pred, tmp;
                for (pred = courseHead, tmp = courseHead.next; (tmp != null) && !(tmp.courseID == ID); pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {
                    countcourses--;
                    pred.next = tmp.next;
                    if (tmp == courseTail)
                        courseTail = pred;
                    System.out.println("Deleted successfully");
                } else {
                    System.out.println("Courses is not enrolled");
                }
            }
        }
    }

    public int getLastCourseAdd() {
        if (!isEmpty()) {
            System.out.print("Last Course ID is: ");
            return courseTail.courseID;
        }
        System.out.print("List is empty: ");
        return -1;  // -1 means list is empty
    }
}