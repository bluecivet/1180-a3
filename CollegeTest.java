/**
 * the is a class for test the College class
 * it test all the methods in the College class
 */
import java.util.Scanner;
public class CollegeTest
{

    public static void main(String[] args)
    {
	// write your code here
        College langara = new College();    // create college object: langara
        Scanner input = new Scanner(System.in);
        String userInput;        // contain user input and check then change to int
        boolean keepGoing = true;    // let the program keep going until the user want to exit

        do
        {
            showMeum();         // show the option
            userInput = input.nextLine();

            if(!vaild(userInput, '1', '7'))   // check the input the input should be a number from range 1 to 7
            {
                System.out.println("there no this options please input again");
                continue;        // let user input again
            }

            int options = Integer.parseInt(userInput);
            switch(options)
            {
                case 1 : addStudent(langara);
                         break;
                case 2 : findStudent(langara);
                         break;
                case 3 : deleteStudent(langara);
                         break;
                case 4 : addCourse(langara);
                         break;
                case 5 :findHightestGPA(langara);
                         break;
                case 6  : getLoginId(langara);
                         break;
                case 7 : keepGoing = false;        // user exit the program
                         System.out.println("exiting the program");
                         break;

                default : break;
            }
        }
        while(keepGoing);
    }


    //-------------------------------------------------------------------------------------------------

    /**
     * .the method show the user the option they can choose
     */
    public static void showMeum()
    {
        System.out.println("enter the number for the command of the program then press enter");
        System.out.println("1 : add a studnet");
        System.out.println("2 : find a student by entering student number");
        System.out.println("3 : delete a student");
        System.out.println("4 : add course for a student");
        System.out.println("5 : find the student with highest GPA");
        System.out.println("6 : the the login id for a student");
        System.out.println("7 : exit the program");
    }


    ///////////////////////////////////////////////////////////////////////////

    /**
     * the method will check if the user input is vailda or not
     * if it is with in range of low to high than it is vaildate
     * if not not a vaildate input
     * @param input a string that show the input that need to check
     * @param low a character type show the lower limit
     * @param high a character type show the upper limit
     * @return true for vaildate input false for not vaildate
     */
    public static boolean vaild(String input, char low, char high)
    {
        for(int i = 0; i < input.length(); i++)   // check the string
        {
            if(input.charAt(i) > high || input.charAt(i) < low)   // within the limit
            {
                System.out.println("invalidate input");
                return false;
            }
        }

        return true;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will add a student to the students list in the college
     * let user enter the name and the address of student
     * @param c College type which is the student which college to add to
     */

    public static void addStudent(College c)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the name for the student");
        String name = input.nextLine();
        System.out.println("please enter the address for the student");
        String address = input.nextLine();

        Student s = new Student(name,address);    // create student object base on the information that the user input
        c.add(s);         // add the student to the college
        System.out.println("finish");
        System.out.println();
    }


    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let user enter the student number and find the student than show the name of the student
     * @param c College type which is the student which college to find
     */

    public static void findStudent(College c)
    {
        String userInput = getStudentNumber();    //user input
        int studentNumber = Integer.parseInt(userInput);
        Student s = c.findStudent(studentNumber);

        if(s == null)        // if can not find the student
        {
            System.out.println("does not find the student");
        }
        else        // if find the student then show the name and GPA
        {
            System.out.println(s.getName() + "  the GPA is " + s.calculateGPA());
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let user input student number then delete the student from the list of student in the college
     * @param c College type which is the student which college to delete to
     */

    public static void deleteStudent(College c)
    {
        String userInput = getStudentNumber();   //user input
        int studentNumber = Integer.parseInt(userInput);
        c.deleteStudent(studentNumber);       // delete the student

        System.out.println("finish");
        System.out.println();
    }


    //////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let user enter the student number and the program will find the student then let user enter the
     * credit and GP for the course and add to the student
     * @param c College type which is the student which college to add to
     */

    public static void addCourse(College c)
    {
        String userInput = getStudentNumber();         //user input student number
        int studentNumber = Integer.parseInt(userInput);
        Student s = c.findStudent(studentNumber);

        if(s == null)   // if can not find the student
        {
            System.out.println("the student is not exist");
            return;    // end the method
        }
         // if it find
        double credit;
        double gp;

        System.out.println("please enter the credit for the student");
        credit = getNumber();     // user enter credit for the course

        System.out.println("please enter the GP for the student");
        gp = getNumber();       // user enter GP for the course

        s.addCourse(credit,gp);          // add the course for the student

        System.out.println("finish");
        System.out.println();
    }


    ////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let the user enter student number then if it find the student it will show the
     * student login ID
     * @param c College type where is the student at
     */

    public static void getLoginId(College c)
    {
        String userInput = getStudentNumber();     // user input
        int studenNumber = Integer.parseInt(userInput);
        String id = c.getLogInId(studenNumber);

        if(id != null)   // if find the student
        System.out.println(id);  // show the login ID

        System.out.println();
    }


    //////////////////////////////////////////////////////////////////////

    /**
     * the method will the find the student who has the  highest GPA in the college
     * and show the name and student number of the student
     * @param c College type which is the college need to find in the student list
     */

    public static void findHightestGPA(College c)
    {
        Student s = c.highestGPA();
        System.out.println("the highest GPA in this college is " + s.getName() + " the student number is " + s.getStudentNumber());
    }


    ////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let the user input student number and check if the format of the number is vaild or not
     * @return the vaildate number in string format
     */
    public static String getStudentNumber()
    {
        System.out.println("please enter the student number");
        Scanner input = new Scanner(System.in);
        boolean isvaild = true;  // is the input vaild
        String userInput;  // the user input

        do
        {
            userInput = input.nextLine();

            if(!vaild(userInput,'0','9'))  // if the input not contain in range of 0 to 0
            {
                System.out.println("invaild input please input again");
                isvaild = false;  // not a validate number
            }
            else
            {
                isvaild = true;    // is a validate number
            }
        }
        while(!isvaild);  // if the input is not validate

        return userInput;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * this method will let user input a number and check if is a vaild number
     * if is not a vaild number the program will ask the user input again
     * @return a double that show the number that the user input
     */
    public static double getNumber()
    {
        Scanner input = new Scanner(System.in);
        String number;   // the user input
        boolean isvaild = true;   // use to check if the number is validate

        do
        {
            number = input.nextLine();
            isvaild = vaildNumber(number);   //find out the number is validate or not

            if(!isvaild)  // if not validate
            {
                System.out.println("invaild number please input again");
            }
        }
        while(!isvaild);

        return Double.parseDouble(number);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * this method will check if the input from the text botx that user input is vaild or not
     * a vaild input should be only contain number character except '-' and '.'
     * '-' should only be place in the first character in the text box
     * '-' '.' should contain only 1  not two ro more
     * @param input a strig type for the text that user input
     * @return
     */
    public static boolean vaildNumber(String input)
    {
        int doptCount = 0;  //count the number of '.'

        /*
         first check is the user click cancle
         second check is it contain an input
         third check if the first letter is number or not
         if not check is it a negative sign
         */

        if((input == null || input.equals(""))|| (input.charAt(0) > '9' || input.charAt(0) < '0' && input.charAt(0) != '-'))
        {
            if(input != null)     // if the user doesn't click cancle
            {
                System.out.println("invalid input");
            }
            return false;
        }

        //  look into whole array
        for(int i = 1; i < input.length(); i++)   // start from second element because already check the first element
        {
            doptCount = input.charAt(i) == '.' ? ++doptCount : doptCount;  // count the number of '.'
            if(((input.charAt(i) < '0' || input.charAt(i) > '9') && input.charAt(i) != '.') || doptCount > 1) // check any character is not number and '.'
            {
                System.out.println("invalid input");
                return false;
            }
        }

        return true;
    }
}
