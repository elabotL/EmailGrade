/* 
 * Author: L Castro
 * Date: 2/13/2023
 * Purpose: Validate an email and convert a test score to a letter grade 
*/
package EmailGrade;

import javax.swing.*;

public class EmailGrade 
{
	public static void main(String[] args) 
	{
		// Declare variables and initialize email requirements for comparison
		String sEmail = "",
			   sLetterGrade = "",
			   sEmpty = "",
			   sLength = "",
			   sSchool = "",
			   sAtSign = "",
			   sAlpha = "",
			   sSymbol = "",
			   sValid = ""; 
		
		float  fTestGrade = 0.0F;
		
		int    iLength = 1,
			   iAtSign = 0;
		
		boolean bEmpty = false,
				bSchool = true; 
			
		
		//Prompt the user for an email address and test score
		sEmail = JOptionPane.showInputDialog("Enter user email: ");
		fTestGrade = Float.parseFloat(JOptionPane.showInputDialog("Enter test score: "));
	
		//Validate the user's email using logical operators and string methods and store error message in string variable
		
		if (sEmail.isEmpty())
		{
			bEmpty = true;
			sEmpty = "\nEmail is empty.";//The email cannot be blank
		}
		if (sEmail.length() > 30)//
		{
			iLength = 31;
			sLength = "\nEmail must be less than 30 characters.";//Must be less than 30 characters
		}
		
		if (sEmail.endsWith("@student.stcc.edu") != true) 
		{	
			bSchool = false;
			sSchool = "\nMust end in: @student.stcc.edu";//Needs school domain
		}
		if (sEmail.indexOf("@",(sEmail.indexOf("@") + 1)) != -1) 
		{	
			iAtSign = 1;
			sAtSign = "\nCan have only one @.";//Only one @
		}
		
		if (!sEmail.isEmpty())//nest string method using index position so that the program doesn't error out when input is empty
		{
			if (sEmail.toUpperCase().charAt(0) <='A' || sEmail.toUpperCase().charAt(0)>='Z') 
			{	
				sAlpha = "\nMust start with A through Z or a through z.";//Must start with upper/lower alpha
			}
		}
		
		if(sEmail.contains("#") || sEmail.contains("$") || sEmail.contains("%") || sEmail.contains("&") || sEmail.contains(","))
		{
			sSymbol = "\nCannot have: # $ % & ,";//Cannot use these characters
		}
		
		// Verify that the email is valid if all email requirements are met. Since the input cannot be empty there is no need to check special character req.
		if ( iLength != 0 && iAtSign == 0 && bEmpty == false && bSchool == true &&(sEmail.toUpperCase().charAt(0) > 'A' || sEmail.toUpperCase().charAt(0)<'Z')
		    )
		{
			sValid = "\nEmail is: Valid\n";
		}
		else
		{
			sValid = "\n";
		}
		
		//Write if statements to assign a letter grade based on the test score
		if (fTestGrade >= 97.0)
		{
			sLetterGrade = "A+";
		}
		else if (fTestGrade >= 94.0)
		{
			sLetterGrade = "A";
		}
		else if (fTestGrade >= 90.0)
		{
			sLetterGrade = "A-";
		}
		else if (fTestGrade >= 87.0)
		{
			sLetterGrade = "B+";
		}
		else if (fTestGrade >= 84.0)
		{
			sLetterGrade = "B";
		}
		else if (fTestGrade >= 80.0)
		{
			sLetterGrade = "B-";
		}
		else if (fTestGrade >= 77.0)
		{
			sLetterGrade = "C+";
		}
		else if (fTestGrade >= 74.0)
		{
			sLetterGrade = "C";
		}
		else if (fTestGrade >= 70.0)
		{
			sLetterGrade = "C-";
		}
		else if (fTestGrade >= 67.0)
		{
			sLetterGrade = "D+";
		}
		else if (fTestGrade >= 64.0)
		{
			sLetterGrade = "D";
		}
		else if (fTestGrade >= 60.0)
		{
			sLetterGrade = "D-";
		}
		else
		{
			sLetterGrade = "F";
		}
		
		//Output 
		JOptionPane.showMessageDialog(null,
									  "For user: " + sEmail + sEmpty + sLength + sSchool + sAtSign + sAlpha + sSymbol + sValid +
									  "\nTest Score is: " + fTestGrade +
									  "\nLetter Grade is: " + sLetterGrade,
				                      "Email and Grade",
                					 JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}// end of main method

}// end of EmailGrade class



