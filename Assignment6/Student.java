/**
 * @author Christopher
 */
public class Student {

    /**
     * The total number of students.
     */
    private static final int numOfStudents = 100;

    /**
     * The name of the student.
     */
    private String name;

    /**
     * The student's exam score.
     */
    private int score;

    /**
     * Constructor for if no name was supplied on instantiation.
     */
    public Student() {
        this("name missing");
    }

    /**
     * Initialize the Student class.
     * 
     * @param name the name of the student
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Set the score of the student.
     * 
     * @param score the score to be set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get the score of the student.
     * 
     * @return the student's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Determine whether the student's score is higher than a minimum score.
     * 
     * @return <code>true</code> if higher than minimum; <code>false</code> otherwise
     */
    public boolean getStatus() {
        return score > 55;
    }

    /**
     * Get the student's name.
     * 
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Compare the student's score with another student's score.
     * 
     * @param anotherStudent the student class of another student
     * @return int based on if the student's score is higher, lower or the same
     */
    public int compare(Student anotherStudent) {
        int score = anotherStudent.getScore();

        if (this.score == score) return 0;

        return (this.score > score) ? 1 : -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create 100 fake students
        Student[] students = new Student[Student.numOfStudents];
        for(int i = 0; i<=Student.numOfStudents-1; i++) {
            if (Math.random()>0.5) {
                students[i] = new Student("Student " + (int)(Math.random()*100+1));
            } else {
                students[i] = new Student();
            }
            students[i].setScore((int)(Math.random()*100+1));
        }

        // compute average fake score
        int averageScore = 0;
        for(Student student:students) {
            averageScore+=student.getScore();
        }
        System.out.println("Average score is "+((double)averageScore/Student.numOfStudents));

        // compute the number of students who passed the fake exam
        int numOfPasses = 0;
        for(Student student:students) {
            if (student.getStatus()) {
                numOfPasses ++;
            }
        }
        System.out.println("Number of passes is "+numOfPasses);

        // find the highest score
        Student max = new Student("fake");
        for(Student student:students) {
            if (student.compare(max)==1) {
                max = student;
            }
        }
        System.out.println(max.getName()+" gets the highest score of "+max.getScore());
    }

}
