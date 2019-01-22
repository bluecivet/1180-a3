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
        College langara = new College();
        Scanner input = new Scanner(System.in);
        String userInput;
        boolean keepGoing = true;

        do
        {
            showMeum();
            userInput = input.nextLine();

            if(!vaild(userInput))
            {
                continue;
            }

            int options = Integer.parseInt(userInput);
            switch(options)
            {
                case 1 : addStudent(langara);
                         break;
                case 2 : findStudent(langara);
                         break;
                case 3 :;

                case 4 :;

                case 5 :;

                case 6 : keepGoing = false;
                         break;

                default : break;

            }


        }
        while(keepGoing);


    }


    public static void showMeum()
    {
        System.out.println("enter the number for the command of the program then press enter");
        System.out.println("1 : add a studnet");
        System.out.println("2 : find a student by entering student number");
        System.out.println("3 : add course for a student");
        System.out.println("4 : get login id for a student");
        System.out.println("5 : find the student with highest GPA");
        System.out.println("6 : exit the program");
    }

    public static boolean vaild(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) > '6' || input.charAt(i) < '1')
            {
                System.out.println("invalidate input");
                return false;
            }
        }

        return true;
    }


    public static void addStudent(College c)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the name for the student");
        String name = input.nextLine();
        System.out.println("please enter the address for the student");
        String address = input.nextLine();
        Student s = new Student(name,address);
        c.add(s);
    }


    public static void findStudent(College c)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the student's number");
        int studentNumber = input.nextInt();
        Student s = c.findStudent(studentNumber);

        if(s == null)
        {
            System.out.println("does not find the student");
        }
        else
        {
            System.out.println(s.getName() + "  the GPA is " + s.calculateGPA());
        }
    }
}
