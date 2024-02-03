import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegistration
  {
    private List<String> availableSubjects;
    private List<String> enrolledSubjects;

    public StudentRegistration() 
  {
        availableSubjects = new ArrayList<>();
        enrolledSubjects = new ArrayList<>();
        initializeSubjects();
    }

    private void initializeSubjects() 
  {
        availableSubjects.add("Algebra");
        availableSubjects.add("Biology");
        availableSubjects.add("Programming Fundamentals");
        availableSubjects.add("Organic Chemistry");
    }

    public void start() 
  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to New Student Registration System!");

        while (true)
          {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) 
            {
                case 1:
                    displayAvailableSubjects();
                    break;
                case 2:
                    enrollInSubject(scanner);
                    break;
                case 3:
                    displayEnrolledSubjects();
                    break;
                case 4:
                    System.out.println("Exiting Student Course Registration System...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu()
  {
        System.out.println("1. Display All the Courses");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Display the Courses Enrolled");
        System.out.println("4. Exit");
    }

    private int getUserChoice(Scanner scanner)
  {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt())
          {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void displayAvailableSubjects() 
  {
        System.out.println("Available Courses:");
        for (int i = 0; i < availableSubjects.size(); i++)
          {
            System.out.println((i + 1) + ". " + availableSubjects.get(i));
        }
    }

    private void enrollInSubject(Scanner scanner) 
  {
        displayAvailableSubjects();
        System.out.print("Enter the Course number you want to enroll in: ");
        while (!scanner.hasNextInt())
          {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int subjectNumber = scanner.nextInt();

        if (subjectNumber >= 1 && subjectNumber <= availableSubjects.size()) 
        {
            String selectedSubject = availableSubjects.get(subjectNumber - 1);
            enrolledSubjects.add(selectedSubject);
            System.out.println("Enrollment in " + selectedSubject + " successful.");
        }
        else
        {
            System.out.println("Invalid subject number. Please try again.");
        }
    }

    private void displayEnrolledSubjects()
  {
        if (enrolledSubjects.isEmpty()) 
        {
            System.out.println("You are not enrolled in any of the Course.");
        } else 
        {
            System.out.println("Enrolled Subjects:");
            for (String subject : enrolledSubjects)
              {
                System.out.println("- " + subject);
            }
        }
    }

    public static void main(String[] args) 
  {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.start();
    }
}
