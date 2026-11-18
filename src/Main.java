import Exe.ValidationException;

import java.awt.print.Book;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<Department> departments = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Administrator> administrators = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Classroom> classrooms = new ArrayList<>();
    static ArrayList<Enrollment> enrollments = new ArrayList<>();
    static ArrayList<Assessment> assessments = new ArrayList<>();
    static ArrayList<FeePayment> payments = new ArrayList<>();
    static ArrayList<LibraryBook> books = new ArrayList<>();
    static ArrayList<BookLoan> loans = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n============== AUCA ID SCHOOL MANAGEMENT ==============");
            System.out.println("1. Register Department");
            System.out.println("2. Register Student");
            System.out.println("3. Register Teacher");
            System.out.println("4. Register Administrator");
            System.out.println("5. Register Course");
            System.out.println("6. Register Classroom");
            System.out.println("7. Enroll Student");
            System.out.println("8. Record Assessment");
            System.out.println("9. Record Fee Payment");
            System.out.println("10. Register Library Book");
            System.out.println("11. Borrow Library Book");
            System.out.println("12. Return Library Book");
            System.out.println("13. View All Records");
            System.out.println("14. Search Record by ID");
            System.out.println("15. Update Existing Record");
            System.out.println("16. Student Academic Summary");
            System.out.println("17. Student Payment History");
            System.out.println("18. View Available Books");
            System.out.println("19. Demonstrate Polymorphism");
            System.out.println("0. Exit");

            System.out.print("Select Option: ");

            try {

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        registerDepartment();
                        break;

                    case 2:
                        registerStudent();
                        break;

                    case 3:
                        registerTeacher();
                        break;

                    case 4:
                        registerAdministrator();
                        break;

                    case 5:
                        registerCourse();
                        break;

                    case 6:
                        registerClassroom();
                        break;

                    case 7:
                        enrollStudent();
                        break;

                    case 8:
                        recordAssessment();
                        break;

                    case 9:
                        recordFeePayment();
                        break;

                    case 10:
                        registerLibraryBook();
                        break;

                    case 11:
                        borrowBook();
                        break;

                    case 12:
                        returnBook();
                        break;

                    case 13:
                        viewAllRecords();
                        break;

                    case 0:
                        System.out.println("Application Closed.");
                        break;

                    default:
                        System.out.println("Invalid Option.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }


    public static void registerDepartment() {
        try {

            System.out.print("Department ID: ");
            String id = sc.nextLine();

            System.out.print("Department Name: ");
            String name = sc.nextLine();

            System.out.print("Department Code: ");
            String code = sc.nextLine();

            System.out.print("Office Location: ");
            String office = sc.nextLine();

            System.out.print("Contact Email: ");
            String email = sc.nextLine();

            Department department = new Department(id, name, code, office, email, null);

            department.validate();

            departments.add(department);

            System.out.println("Department Registered");

        } catch(Exception e) {

            System.out.println(e.getMessage());
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }


    public static void registerStudent() {

        try {

            if (Main.departments.isEmpty()) {

                System.out.println(
                        "Register a Department First.");

                return;
            }

            System.out.print("Person ID: ");
            String personId = Main.sc.nextLine();

            System.out.print("First Name: ");
            String firstName = Main.sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = Main.sc.nextLine();

            System.out.print("Email: ");
            String email = Main.sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = Main.sc.nextLine();

            System.out.print("Date Of Birth (YYYY-MM-DD): ");
            LocalDate dob = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Member Number: ");
            String memberNumber = Main.sc.nextLine();

            System.out.println("\nSelect Department");

            for(int i = 0;
                i < Main.departments.size();
                i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + Main.departments.get(i));
            }

            int depChoice = Integer.parseInt(Main.sc.nextLine());

            Department department =
                    Main.departments.get(depChoice - 1);

            System.out.print("Join Date: ");
            LocalDate joinDate = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Academic Status: ");
            String academicStatus = Main.sc.nextLine();

            System.out.print("Institutional Email: ");
            String institutionalEmail = Main.sc.nextLine();

            System.out.print("Advisor Name: ");
            String advisorName = Main.sc.nextLine();

            System.out.print("Student Number: ");
            String studentNumber = Main.sc.nextLine();

            System.out.print("Program Name: ");
            String programName = Main.sc.nextLine();

            System.out.print("Admission Date: ");
            LocalDate admissionDate = LocalDate.parse(
                            Main.sc.nextLine());

            System.out.print("Study Year: ");
            int studyYear = Integer.parseInt(Main.sc.nextLine());

            System.out.print("Guardian Phone: ");
            String guardianPhone = Main.sc.nextLine();

            System.out.print("Scholarship Status (true/false): ");

            boolean scholarship = Boolean.parseBoolean(
                            Main.sc.nextLine());

            Student student = new Student(
                            personId,
                            firstName,
                            lastName,
                            email,
                            phone,
                            dob,
                            memberNumber,
                            department,
                            joinDate,
                            academicStatus,
                            institutionalEmail,
                            advisorName,
                            studentNumber,
                            programName,
                            admissionDate,
                            studyYear,
                            guardianPhone,
                            scholarship
                    );

            student.validate();

            Main.students.add(student);

            Main.people.add(student);

            System.out.println("Student Registered Successfully.");

        }
         catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerTeacher() {
            try {

                if (Main.departments.isEmpty()) {

                    System.out.println(
                            "No Department Exists.");

                    System.out.println(
                            "Register Department First.");

                    return;
                }

                System.out.print("Person ID: ");
                String personId = Main.sc.nextLine();

                System.out.print("First Name: ");
                String firstName = Main.sc.nextLine();

                System.out.print("Last Name: ");
                String lastName = Main.sc.nextLine();

                System.out.print("Email: ");
                String email = Main.sc.nextLine();

                System.out.print("Phone Number: ");
                String phone = Main.sc.nextLine();

                System.out.print("Date Of Birth (YYYY-MM-DD): ");
                LocalDate dob = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Member Number: ");
                String memberNo = Main.sc.nextLine();

                System.out.println(
                        "\nSelect Department");

                for(int i = 0;
                    i < Main.departments.size();
                    i++) {

                    System.out.println(
                            (i + 1)
                                    + ". "
                                    + Main.departments.get(i));
                }

                int depChoice =
                        Integer.parseInt(Main.sc.nextLine());

                Department department = Main.departments.get(depChoice - 1);

                System.out.print("Join Date: ");
                LocalDate joinDate = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Academic Status: ");
                String academicStatus = Main.sc.nextLine();

                System.out.print("Institutional Email: ");
                String instEmail = Main.sc.nextLine();

                System.out.print("Advisor Name: ");
                String advisorName = Main.sc.nextLine();

                System.out.print("Employee Number: ");
                String employeeNumber = Main.sc.nextLine();

                System.out.print("Specialization: ");
                String specialization = Main.sc.nextLine();

                System.out.print("Hire Date: ");
                LocalDate hireDate = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Salary: ");
                BigDecimal salary = new BigDecimal(Main.sc.nextLine());

                System.out.print("Office Number: ");
                String officeNumber = Main.sc.nextLine();

                System.out.print("Employment Type: ");
                String employmentType = Main.sc.nextLine();

                Teacher teacher = new Teacher(
                                personId,
                                firstName,
                                lastName,
                                email,
                                phone,
                                dob,
                                memberNo,
                                department,
                                joinDate,
                                academicStatus,
                                instEmail,
                                advisorName,
                                employeeNumber,
                                specialization,
                                hireDate,
                                salary,
                                officeNumber,
                                employmentType
                        );

                teacher.validate();

                Main.teachers.add(teacher);

                Main.people.add(teacher);

                System.out.println(
                        "Teacher Registered Successfully.");

            }
             catch (ValidationException e) {
                throw new RuntimeException(e);
            }
    }

    public static void registerAdministrator() {
        try {

            System.out.print("Person ID: ");
            String personId = Main.sc.nextLine();

            System.out.print("First Name: ");
            String firstName = Main.sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = Main.sc.nextLine();

            System.out.print("Email: ");
            String email = Main.sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = Main.sc.nextLine();

            System.out.print("Date Of Birth: ");
            LocalDate dob = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Staff Number: ");
            String staffNumber =Main.sc.nextLine();

            System.out.print("Job Title: ");
            String jobTitle = Main.sc.nextLine();

            System.out.print("Assigned Office: ");
            String office = Main.sc.nextLine();

            System.out.print("Employment Date: ");
            LocalDate employmentDate = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Access Level: ");
            int accessLevel = Integer.parseInt(Main.sc.nextLine());

            System.out.print("Active (true/false): ");
            boolean active = Boolean.parseBoolean(Main.sc.nextLine());

            Administrator admin = new Administrator(
                            personId,
                            firstName,
                            lastName,
                            email,
                            phone,
                            dob,
                            staffNumber,
                            jobTitle,
                            office,
                            employmentDate,
                            accessLevel,
                            active
                    );

            admin.validate();

            Main.administrators.add(admin);

            Main.people.add(admin);

            System.out.println("Administrator Registered Successfully.");

        }
        catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerCourse() {
            try {

                if (departments.isEmpty()) {
                    System.out.println(
                            "Register a Department First.");
                    return;
                }

                if (teachers.isEmpty()) {
                    System.out.println(
                            "Register a Teacher First.");
                    return;
                }

                System.out.print("Course ID: ");
                String courseId = sc.nextLine();

                System.out.print("Course Code: ");
                String courseCode = sc.nextLine();

                System.out.print("Course Title: ");
                String courseTitle = sc.nextLine();

                System.out.print("Credit Hours: ");
                int creditHours = Integer.parseInt(sc.nextLine());

                System.out.println("\nSelect Department");

                for(int i = 0;
                    i < departments.size();
                    i++) {

                    System.out.println(
                            (i + 1) + ". "
                                    + departments.get(i));
                }

                int depChoice = Integer.parseInt(sc.nextLine());

                Department department = departments.get(depChoice - 1);

                System.out.println("\nSelect Teacher");

                for(int i = 0;
                    i < teachers.size();
                    i++) {

                    System.out.println(
                            (i + 1) + ". "
                                    + teachers.get(i)
                                    .getDisplayName());
                }

                int teacherChoice = Integer.parseInt(sc.nextLine());

                Teacher teacher = teachers.get(teacherChoice - 1);

                Course course = new Course(
                                courseId,
                                courseCode,
                                courseTitle,
                                creditHours,
                                department,
                                teacher
                );

                course.validate();

                courses.add(course);

                System.out.println(
                        "Course Registered Successfully");

            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }


    }

    public static void registerClassroom() {

        try {

            System.out.print("Classroom ID: ");
            String classroomId =
                    sc.nextLine();

            System.out.print(
                    "Building Name: ");

            String buildingName =
                    sc.nextLine();

            System.out.print(
                    "Room Number: ");

            String roomNumber =
                    sc.nextLine();

            System.out.print(
                    "Capacity: ");

            int capacity =
                    Integer.parseInt(
                            sc.nextLine());

            System.out.print(
                    "Floor Number: ");

            int floorNumber =
                    Integer.parseInt(
                            sc.nextLine());

            System.out.print(
                    "Available (true/false): ");

            boolean available =
                    Boolean.parseBoolean(
                            sc.nextLine());

            Classroom classroom =
                    new Classroom(
                            classroomId,
                            buildingName,
                            roomNumber,
                            capacity,
                            floorNumber,
                            available
                    );

            classroom.validate();

            classrooms.add(classroom);

            System.out.println(
                    "Classroom Registered Successfully");


        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void enrollStudent() {
        try {

            if (students.isEmpty()) {System.out.println("Register Students First.");
                return;
            }

            if (courses.isEmpty()) {System.out.println("Register Courses First.");
                return;
            }

            System.out.print("Enrollment ID: ");
            String enrollmentId = sc.nextLine();

            System.out.println("\nSelect Student");

            for (int i = 0;
                 i < students.size();
                 i++) {

                System.out.println(
                        (i + 1) + ". "
                                + students.get(i)
                                .getDisplayName());
            }

            int studentChoice = Integer.parseInt(sc.nextLine());

            Student student = students.get(studentChoice - 1);

            System.out.println("\nSelect Course");

            for (int i = 0;
                 i < courses.size();
                 i++) {

                System.out.println(
                        (i + 1) + ". "
                                + courses.get(i)
                                .getDisplayName());
            }

            int courseChoice = Integer.parseInt(sc.nextLine());

            Course course = courses.get(courseChoice - 1);

            System.out.print("Enrollment Date (YYYY-MM-DD): ");

            LocalDate enrollmentDate = LocalDate.parse(sc.nextLine());

            System.out.print("Semester: ");

            String semester = sc.nextLine();

            System.out.print("Enrollment Status: ");

            String status = sc.nextLine();

            Enrollment enrollment = new Enrollment(
                            enrollmentId,
                            student,
                            course,
                            enrollmentDate,
                            semester,
                            status
            );

            enrollment.validate();

            enrollments.add(enrollment);

            System.out.println("Enrollment Successful");

        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void recordAssessment() {

            try {

                if (enrollments.isEmpty()) {

                    System.out.println("Enroll Students First.");

                    return;
                }

                System.out.print("Assessment ID: ");

                String assessmentId = sc.nextLine();

                System.out.println("\nSelect Enrollment");

                for (int i = 0;
                     i < enrollments.size();
                     i++) {

                    System.out.println(
                            (i + 1)
                                    + ". "
                                    + enrollments.get(i));
                }

                int choice = Integer.parseInt(sc.nextLine());

                Enrollment enrollment = enrollments.get(choice - 1);

                System.out.print("Assessment Type: ");

                String type = sc.nextLine();

                System.out.print("Maximum Score: ");

                double max = Double.parseDouble(sc.nextLine());

                System.out.print("Obtained Score: ");

                double obtained = Double.parseDouble(sc.nextLine());

                System.out.print("Assessment Date: ");

                LocalDate date = LocalDate.parse(sc.nextLine());

                Assessment assessment = new Assessment(
                                assessmentId,
                                enrollment,
                                type,
                                max,
                                obtained,
                                date
                );

                assessment.validate();

                assessments.add(
                        assessment);

                System.out.println(
                        "Assessment Recorded");

            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }

    }

    public static void recordFeePayment() {
        try {

            if (students.isEmpty()) {

                System.out.println("Register Students First.");

                return;
            }

            System.out.print("Payment ID: ");

            String paymentId = sc.nextLine();

            System.out.println("\nSelect Student");

            for(int i = 0;
                i < students.size();
                i++){

                System.out.println(
                        (i + 1)
                                + ". "
                                + students.get(i)
                                .getDisplayName());
            }

            int choice = Integer.parseInt(sc.nextLine());

            Student student = students.get(choice - 1);

            System.out.print("Amount: ");

            BigDecimal amount = new BigDecimal(sc.nextLine());

            System.out.print("Payment Date: ");

            LocalDate date = LocalDate.parse(sc.nextLine());

            System.out.print("Payment Method: ");

            String method = sc.nextLine();

            System.out.print("Receipt Number: ");

            String receipt = sc.nextLine();

            FeePayment payment = new FeePayment(
                            paymentId,
                            student,
                            amount,
                            date,
                            method,
                            receipt
            );

            payment.validate();

            payments.add(payment);

            System.out.println("Payment Recorded");

        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void registerLibraryBook() {
        try {

            System.out.print("Book ID: ");

            String bookId = sc.nextLine();

            System.out.print("ISBN: ");

            String isbn = sc.nextLine();

            System.out.print("Title: ");

            String title = sc.nextLine();

            System.out.print("Author: ");

            String author = sc.nextLine();

            System.out.print("Total Copies: ");

            int totalCopies = Integer.parseInt(sc.nextLine());

            System.out.print("Available Copies: ");

            int availableCopies = Integer.parseInt(sc.nextLine());

            LibraryBook book = new LibraryBook(
                            bookId,
                            isbn,
                            title,
                            author,
                            totalCopies,
                            availableCopies
            );

            book.validate();

            books.add(book);

            System.out.println(
                    "Book Registered Successfully");

        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void borrowBook() {
        try {

            if (students.isEmpty()) {

                System.out.println("Register Students First.");

                return;
            }

            if (books.isEmpty()) {

                System.out.println("Register Books First.");

                return;
            }

            System.out.print("Loan ID: ");

            String loanId = sc.nextLine();

            System.out.println("\nSelect Student");

            for (int i = 0;
                 i < students.size();
                 i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + students.get(i)
                                .getDisplayName());
            }

            int studentChoice = Integer.parseInt(sc.nextLine());

            Student student = students.get(studentChoice - 1);

            System.out.println("\nSelect Book");

            for (int i = 0;
                 i < books.size();
                 i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + books.get(i)
                                .getTitle()
                                + " (Available: "
                                + books.get(i)
                                .getAvailableCopies()
                                + ")");
            }

            int bookChoice = Integer.parseInt(sc.nextLine());

            LibraryBook book = books.get(bookChoice - 1);

            if (book.getAvailableCopies() <= 0) {

                System.out.println("No copies of this book are available.");

                return;
            }

            System.out.print("Borrow Date (YYYY-MM-DD): ");

            LocalDate borrowDate = LocalDate.parse(sc.nextLine());

            System.out.print("Due Date (YYYY-MM-DD): ");

            LocalDate dueDate = LocalDate.parse(sc.nextLine());

            BookLoan loan = new BookLoan(
                            loanId,
                            student,
                            book,
                            borrowDate,
                            dueDate,
                            null
            );

            loan.validate();

            loans.add(loan);

            book.setAvailableCopies(book.getAvailableCopies() - 1);

            System.out.println("Book Borrowed Successfully.");

        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public static void returnBook() {

        try {

            if (loans.isEmpty()) {

                System.out.println("No borrowed books found.");

                return;
            }

            System.out.println("\nSelect Loan To Return");

            int count = 0;

            for (int i = 0;
                 i < loans.size();
                 i++) {

                if (loans.get(i).getReturnDate() == null) {

                    count++;

                    System.out.println(
                            count + ". "
                                    + loans.get(i).getLoanId()
                                    + " - "
                                    + loans.get(i)
                                    .getBook()
                                    .getTitle()
                                    + " - "
                                    + loans.get(i)
                                    .getStudent()
                                    .getDisplayName());
                }
            }

            if (count == 0) {

                System.out.println("All books have already been returned.");

                return;
            }

            int choice = Integer.parseInt(sc.nextLine());

            int activeIndex = -1;
            int currentCount = 0;

            for (int i = 0;
                 i < loans.size();
                 i++) {

                if (loans.get(i).getReturnDate() == null) {

                    currentCount++;

                    if (currentCount == choice) {

                        activeIndex = i;
                        break;
                    }
                }
            }

            BookLoan selectedLoan =
                    loans.get(activeIndex);

            System.out.print("Return Date (YYYY-MM-DD): ");

            LocalDate returnDate = LocalDate.parse(sc.nextLine());

            selectedLoan.setReturnDate(returnDate);

            LibraryBook book = selectedLoan.getBook();

            book.setAvailableCopies(book.getAvailableCopies() + 1);

            System.out.println("Book Returned Successfully.");

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());
        }

    }

    public static void viewAllRecords() {
        for (Department department: departments){
            System.out.println(department.getRegistrationSummary());
        }
        for (Student student: students){
            System.out.println(student.getRegistrationSummary());
        }
        for (Teacher teacher: teachers){
            System.out.println(teacher.getRegistrationSummary());
        }
        for (Administrator administrator: administrators){
            System.out.println(administrator.getRegistrationSummary());
        }
        for (LibraryBook book: books){
            System.out.println(book.getRegistrationSummary());
        }
        for (FeePayment payment: payments){
            System.out.println(payment.getRegistrationSummary());
        }
        for (BookLoan loan: loans){
            System.out.println(loan.getRegistrationSummary());
        }

    }

}
