/**
 * File:        Student.java
 * Author:      Zhilong Gan
 * ID:          100331942
 * Date:        2019.01.15
 * class:       CPSC 1181-03
 * instructor:  Hengameh Hamavand
 * title        student class
 * Compiler:    java JDK 10.2
 */

/**
 * this class is a student class and each student object will have
 * name as String
 * address as String
 * login id as String
 * total gpa as double
 * student number as int
 */
public class Student
{
    // elements
    private String name;
    private String address;
    private String loginId;
    private double totalGpa;
    private double totalCredit;
    private int studentNumber;
    private static int initalStudentNumber = 10000;

    //-----------------------------constructor------------------------------------------------------------

    /**
     * this is a no argument constructor which set everything by default
     * everything will null meaning telling the user that they didn't set all the thing
     * the student should not be exits
     */
    public Student()
    {
        name = "student";
        studentNumber = 00000000;
        address = "no sign";
        loginId = "no";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * this constructor will give the student name and it will sign the student basic element
     * name
     * student number
     * no address
     * because the student may be changing the address and moving into somewhere
     * @param stuName String type identify the name of student
     */
    public Student(String stuName)
    {
        name = vaildateName(stuName);
        studentNumber = ++initalStudentNumber;
        address = "no sign";
        loginId = createLoginId();

    }

    ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * this constructor will set all the element that a student have and will let user set
     * the number
     * address
     * @param stuName a String type identify the student name
     * @param stuAddress a String type identify the student address
     */
    public Student(String stuName, String stuAddress)
    {
        name = vaildateName(stuName);
        address = stuAddress;
        studentNumber = ++initalStudentNumber;
        loginId = createLoginId();
    }


    //------------------------------------private method --------------------------------------------------

    /**
     * the method is a private method which only allow to use in this class
     * the method will give the Login ID to a student object
     * it take the first letter from the first name
     * then take the first 3 letters from the last name
     * then take the last 2 digits from student number
     * @return a String type identify the login id
     */
    private String createLoginId()
    {
        String names[] = name.trim().split("\\s+");  // split into first name and last name and user array to contain
        String letters;        // the letter part of the login id

        if(names[1].trim().length() < 3)  // if not enough letter
        {
            letters = names[0].trim().charAt(0) + names[1].trim();  // first letter of first name + last name
        }
        else
        {
            //  first letter of first name + first 3 letter of last name
            letters = names[0].trim().charAt(0) + names[1].trim().substring(0,3);
        }

        String number = String.valueOf(studentNumber);    // convert student number to a string
        number = number.substring(number.length() - 2);    // take the last 2 digit

        return (letters + number).toLowerCase();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will check the validation for the name input from the constructor and remove the extra blank
     * if the name in not validated it return ***** ***** for student name
     * @param oldName a String type that represent the the name of the student
     * @return if the name is validated return the removed blank name if not return **** ****
     */
    private String vaildateName(String oldName)
    {
        if(oldName.equals("")|| oldName.equals("\\s+"))   // if empty input
        {
            return "***** *****";
        }

        String names[] = oldName.trim().split("\\s+");  // remove blank

        if(names.length != 2)   // // if incorrect input
        {
            return "**** **** " + oldName + " ****the name should only contain first and last name";
        }

        return names[0] + " " + names[1];

    }


    //------------------------------public methods---------------------------------------------------------

    /**
     * this method will give the student name
     * @return the String type the student name
     */
    public String getName()
    {
        return name;
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will give the address of student
     * @return the String type the student address
     */
    public String getAddress()
    {
        return address;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method allow a student to add a course
     * @param courseCredit a double type the credit of the course
     * @param courseGp a double type the final grade for the course
     */
    public void addCourse(double courseCredit, double courseGp)
    {
        totalCredit += courseCredit;  // add to total credit
        totalGpa += courseGp;       // add to total gpa
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will calculate the gpa for the student
     * @return a double type the GPA for the student
     */
    public double calculateGPA()
    {
        return totalGpa / totalCredit;
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method give the student number
     * @return a int type return the student number
     */
    public int getStudentNumber()
    {
        return studentNumber;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method give the login id for the student
     * @return a string type identify the student login id
     */
    public String getLoginId()
    {
        return loginId;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * if a student change or conform the place that they live
     * this method will change the address for the student
     * @param addr a String type which set the address for the student
     */
    public void setAddress(String addr)
    {
        if(studentNumber != 0)
        {
            address = addr;
        }
    }

}
