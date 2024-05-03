// Task_2
import java.util.Scanner;

public class Task2_Student_Grade_Calculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number of Subjects :");
		int n=sc.nextInt();
		int total = 0;
		System.out.println("Enter marks obtained in each subject (out of 100) :");
		
		for(int i=1;i<=n;i++){
		System.out.println("Subject "+i+":");
		int s_marks=sc.nextInt();
		total=total+s_marks;
		}
		
		double avg=(total/n);
		System.out.println("Result:-");
		System.out.println("Total Marks: "+total);
		System.out.println("Average Percentage: "+avg+" %");
		if(avg>=75)
			System.out.println("Grade: A");
		else if(avg>=60)
			System.out.println("Grade: B");
		else if(avg>=45)
			System.out.println("Grade: C");
		else
			System.out.println("Grade: Fail");
		
	}

}
