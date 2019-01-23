/**
 * File:        College.java
 * Author:      Zhilong Gan
 * ID:          100331942
 * Date:        2019.01.21
 * class:       CPSC 1181-03
 * instructor:  Hengameh Hamavand
 * title        college class
 * Compiler:    java JDK 10.2
 */

/**
 * this class is a students collection which represent a college
 * it can add student
 * look up student base on the student number
 * add GPA and credit for a student
 * get the log in id
 * find the highest gpa
 */

import java.util.ArrayList;
public class College
{
   private ArrayList<Student>students;


   //---------------------------------------------------------------------

    /**
     * constructor
     * to create the container for students
     * using arralist
     */
    public College()
    {
        students = new ArrayList<Student>();
    }

    //---------------------------------------------------------------------

    /**
     * the method will add a student to the array list
     * mean add the student to the college
     * @param s
     */
    public void add(Student s)
    {
        students.add(s);
    }


    ////////////////////////////////////////////////////////////////////////

    /**
     * the method return a Student type that the student number is the same in the list
     * @param studentNumber an integer tyoe represent the student number
     * @return the target student if not find return null
     */
    public Student findStudent(int studentNumber)
    {
        for(Student s : students)  // look in the list
        {
            if(s.getStudentNumber() == studentNumber)  // if the student number is the same
                return s;
        }

        return null;
    }

    ///////////////////////////////////////////////////////////////////////

    public void deleteStudent(int studentNumber)
    {
        Student s = findStudent(studentNumber);

        if(s == null)
        {
            System.out.println("the student is not exit");
            return;
        }
        students.remove(s);
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     * the method add credit and gp for a student
     * @param studentNumber a integer type that represent student number
     * @param credit a double type show the credit need to add
     * @param gp a double type show the gp need to add
     */
    public void addCourse(int studentNumber, double credit, double gp)
    {
        Student s = findStudent(studentNumber);

        if(s == null)
        {
            System.out.println("the student is not exist");
            return;
        }
        else
        {
            s.addCourse(credit,gp);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    /**
     * the method find the student and get the login id
     * @param studentNumber a integer type that represent student number
     * @return string type show the log in id for student
     */
    public String getLogInId(int studentNumber)
    {
        Student s = findStudent(studentNumber);

        if(s == null)
        {
            System.out.println("the student is not exist");
            return null;
        }
        else
        {
            return s.getLoginId();
        }
    }

    /////////////////////////////////////////////////////////////////////////

    public Student highestGPA()
    {
        if(students.size() < 1)
        {
            System.out.println("there are no student in the college");
            return null;
        }

        Student s = students.get(0);
        double max = s.calculateGPA();
        for(int i = 1; i < students.size(); i++)
        {
            double temp = students.get(i).calculateGPA();

            if(temp > max)
            {
                max = temp;
                s = students.get(i);
            }
        }
        return s;
    }

}
