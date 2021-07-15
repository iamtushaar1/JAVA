/*
 *  Name: Tushar Chaudhary
 */

import java.util.Random;
import java.util.Scanner;


public class superlotto {

	/**
	 * Program which helps to generate 5 random numbers amongst a set of 47 numbers and 1 "MEGA" random number amongst a set of 27 numbers.
	 * 
	 * @version 1.0
	 * @author Tushar Chaudhary
	 */
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int [] arrayOfTicket = new int[6];
		String  yesOrNo;


		do {
			System.out.println("Welcome to the Quicky Mart. What is your name?");
			String Nameofperson = scnr.next();
			System.out.println("Hi "+ Nameofperson+ " , how many Super Lotto tickets would you like?");
			int ticketcount = scnr.nextInt();

			for (int j = 1; j<= ticketcount; ++j)
			{

				quickPick();
				arrayOfTicket = quickPick();
				printTicket(arrayOfTicket);

			}

			System.out.println("");
			System.out.println("Good luck! Would you like to run the program again?");

			yesOrNo = scnr.next();



		} while(yesOrNo.equals("Yes"));

		System.out.println("Goodbye!");
	}

	/** 
	 * Loop made to execute 5 numbers and 1 Mega number
	 * @return a loop which consist of 5 numbers and 1 Mega number.
	 */

	public static void printTicket(int[] arrayToPrint) {

		for (int k =0; k < 6; ++k )
		{
			if(k <= 4) {
				System.out.print(arrayToPrint[k] + " ");
			}
			else 
			{
				System.out.print("(MEGA: " + arrayToPrint[k] + ")");
				System.out.println("");
			}
		}

	}
	/**
	 * Following code produces 6 random numbers which includes  the 6th number being a MEGA number.
	 * @ return produced array
	 */
	public static int[] quickPick()
	{
		Random randNum = new Random();
		int[] myArray = new int[6];
		for(int z = 0; z < myArray.length; ++z)
		{
			if( z<= 4)
			{
				myArray[z] = randNum.nextInt(47) + 1;
			}
			else 
			{
				myArray[z] = randNum.nextInt(27) + 1;
			}
		}
		myArray = sameNumberCheck(myArray);
		
		return myArray;

	}
	/**
	 *  This method looks for any duplicate number in a single array and changes them.
	 * @param array
	 * @return an array which does not have any duplicate number
	 */

	public static int[] sameNumberCheck(int[] array)
	{
		boolean sameNumber = true;

		while(sameNumber)
		{
			for(int a =0; a<5; ++a)
			{
				for (int b=0; b<5; ++b)
				{
					if(b!=a)
					{
						if(array[a] == array[b])
						{
							array[b] = array[b]+1;
						}
					}
				}
			}
			sameNumber = false;
		}
		return array;
	}
}
