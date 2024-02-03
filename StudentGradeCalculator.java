import java.util.Scanner;

public class NewStudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*****NEW STUDENT GRADE CALCULATOR*****");

        System.out.println("\nEnter your name: ");

        String studentName = scanner.nextLine();

        int numberOfSubjects = 0;

        System.out.println("\nEnter number of Subjects:");

        numberOfSubjects = scanner.nextInt();

        int[] subjectMarks = new int[numberOfSubjects];

        for (int i = 0; i < subjectMarks.length; i++) {

            System.out.println("\nEnter Mark for Subject " + (i + 1) + ":");

            subjectMarks[i] = scanner.nextInt();

            while (subjectMarks[i] < 0 || subjectMarks[i] > 100) {

                System.out.println("\nEnter Marks for Subject " + (i + 1) + ":");

                subjectMarks[i] = scanner.nextInt();
            }
        }

        int totalMarks = 0;

        double averageMarks = 0.0;

        String grade = "";

        for (int i = 0; i < subjectMarks.length; i++) {

            totalMarks += subjectMarks[i];
        }

        averageMarks = (double) totalMarks / numberOfSubjects;

        if (averageMarks >= 80) {
            grade = "A";
        } else if (averageMarks >= 70 && averageMarks < 80) {
            grade = "B";
        } else if (averageMarks >= 60 && averageMarks < 70) {
            grade = "C";
        } else if (averageMarks >= 50 && averageMarks < 60) {
            grade = "D";
        } else if (averageMarks >= 40 && averageMarks < 50) {
            grade = "E";
        } else if (averageMarks >= 30 && averageMarks < 40) {
            grade = "F";
        } else {
            grade = "FF";
        }

        System.out.printf("\n\nStudent Name: %s\n\nTotal Subjects: %d\nTotal Marks: %d\nAverage Marks: %.2f\nGrade: %s",
                studentName, numberOfSubjects, totalMarks, averageMarks, grade);

        scanner.close();
    }
}
