import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmmetKennellyDCOM1Project2MimisCafe {
	final static Scanner kb = new Scanner(System.in);
	final static int pointperEuro = 5;
	final static int pointsForJoining = 20;
	final static String Uncat = "Uncategorized";
	final static String Bronze = "Bronze";
	final static String Silver = "Silver";
	final static String Gold = "Gold";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] custNames = new String[10];

		String[] custEmails = new String[10];
		int[] custPointBalacne = new int[10];
		String[] custID = new String[10];
		double[] paymentPerCard = new double[10];
		int poistion = 0;
		int pointsForFree = 50;
		int amountOfmembers = 0;
		String firstName = "";
		String lastName = "";
		String email = "";
		String IDCard = "";
		boolean ValidName = true;
		boolean ValidCard = false;

		File info = new File("customerinformation.txt");
		Scanner inputFromFile = new Scanner(info);

		while (inputFromFile.hasNext()) {
		String firstline = inputFromFile.nextLine();
			custID[amountOfmembers] = firstline;
			String secondline = inputFromFile.nextLine();
			custNames[amountOfmembers] = secondline;
			String thirdline = inputFromFile.nextLine();
			custEmails[amountOfmembers] = thirdline;
			double fourthline = inputFromFile.nextDouble();
			paymentPerCard[amountOfmembers] = fourthline;
			int fifthline = inputFromFile.nextInt();
			custPointBalacne[amountOfmembers] = fifthline;
			
			amountOfmembers++;
		}
		inputFromFile.close();
	

		menu(amountOfmembers, custNames, custEmails, custID, custPointBalacne, paymentPerCard);

	}



	private static void loadFromFile() throws IOException {
		// TODO Auto-generated method stub
		int amountOfmembers = 0;

		File info = new File("customerinformation.txt");
		Scanner inputFromFile = new Scanner(info);

		while (inputFromFile.hasNext()) {

		}
		inputFromFile.close();
	}

	private static void showMenu(String[] names) {
		// TODO Auto-generated method stub

	}

	public static void menu(int amountOfmembers, String[] custName, String[] custEmail, String[] custID,
			int[] custPointBalacne, double[] paymentPerCard) throws IOException {
		// TODO Auto-generated method stub
		int menuSelection = 0;
		boolean showMenu = true;

		while (showMenu) {
			final double pointperEuro = 5;
			int pointsForFree = 50;
			final int pointsForJoining = 20;

			final double costOfCoffee = 2.50;
			double total = 0;
			System.out.print("Welcome to Mimis Café (Current #Loyalty Cards: " + amountOfmembers + ")" + "\n"
					+"===================================================="+"\n"+ "1.) Register a new customer." + "\n" + "2.) Display a customers details." + "\n"
					+ "3.) Purchase coffee" + "\n" + "4.) Generate a report for loyalty points above a certain value."
					+ "\n" + "5.) Generate reports by customer category." + "\n" + "6.) Exit ");

			System.out.println("\n" + "What will you do? : ");

			print(amountOfmembers, custName, custEmail, custID,  
					paymentPerCard, custPointBalacne);

			menuSelection = kb.nextInt();
			kb.nextLine();

			if (menuSelection == 6) {
				end(custName, custEmail, custPointBalacne, custID, paymentPerCard, amountOfmembers);
				showMenu = false;
			} else if (menuSelection == 1) {
				amountOfmembers = registerNewCustomer(amountOfmembers, custName, custEmail, custID,
						showMenu, paymentPerCard, pointsForJoining, custPointBalacne);

				print(amountOfmembers, custName, custEmail, custID,  
						paymentPerCard, custPointBalacne);

			} else if (menuSelection == 2) {

				detailsOfCurrentCustomer(custID, amountOfmembers, custName,
						custEmail, custPointBalacne, paymentPerCard);
			} else if (menuSelection == 3) {

				purchaseCoffee(costOfCoffee, total, custID, custPointBalacne, pointsForFree, pointperEuro,
						amountOfmembers,paymentPerCard);
			} else if (menuSelection == 4) {
				generateLPAbove( custID, amountOfmembers, custName,
						custEmail, custPointBalacne, paymentPerCard);
			} else if (menuSelection == 5) {
                  generateScoreAbove(custName, custEmail, custPointBalacne, custID, paymentPerCard, amountOfmembers);
			}

			if (menuSelection > 6) {
				System.out.print("Invalid option, Try again" + "\n");
			}

		} // while

	}

	private static void generateScoreAbove(String[] custNames, String[] custEmails, int[] custPointBalacne, String[] custID,
			double[] paymentPerCard, int amountOfmembers) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Genertaing file..................");
		for(int index = 0; index <= paymentPerCard.length; index++) {
			   if((paymentPerCard[index] > 30) && (paymentPerCard[index] <= 100)){
				   PrintWriter saveInfo = new PrintWriter("Bronze.txt");
					for (int index2 = 0; index2 < amountOfmembers; index2++) {
				   saveInfo.println(custID[index2]);
					saveInfo.println(custNames[index2]);
					saveInfo.println(custEmails[index2]);
					saveInfo.println(paymentPerCard[index2]);
					saveInfo.println(custPointBalacne[index2]);
			   }
					saveInfo.close();
			   }
			   else if ((paymentPerCard[index] > 100) && (paymentPerCard[index] <= 200)){
				   PrintWriter saveInfo = new PrintWriter("Silver.txt");
				   for (int index3 = 0; index3 < amountOfmembers; index3++) {
				   saveInfo.println(custID[index3]);
					saveInfo.println(custNames[index3]);
					saveInfo.println(custEmails[index3]);
					saveInfo.println(paymentPerCard[index3]);
					saveInfo.println(custPointBalacne[index3]);
                    
				   } 
				   saveInfo.close();
			        }
			   
			   else if (paymentPerCard[index] > 200){
				   PrintWriter saveInfo = new PrintWriter("Gold.txt");
				   for (int index4 = 0; index4 < amountOfmembers; index4++) {
				   saveInfo.println(custID[index4]);
					saveInfo.println(custNames[index4]);
					saveInfo.println(custEmails[index4]);
					saveInfo.println(paymentPerCard[index4]);
					saveInfo.println(custPointBalacne[index4]);
                }
				   saveInfo.close();
			   } 
			   
		}
		
	System.out.print("Done!");
	
	}
	private static void end(String[] custNames, String[] custEmails, int[] custPointBalacne, String[] custID,
			double[] paymentPerCard, int amountOfmembers) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter saveInfo = new PrintWriter("customerinformation.txt");
		System.out.print("Saving Data....." + "\n" + "......." + "\n" + ".......");
		for (int index = 0; index < amountOfmembers; index++) {
			saveInfo.println(custID[index]);
			saveInfo.println(custNames[index]);
			saveInfo.println(custEmails[index]);
			saveInfo.println(paymentPerCard[index]);
			saveInfo.println(custPointBalacne[index]);

		}
		saveInfo.close();
		System.out.print("Finished");
	}

	private static void print(int amountOfmembers, String[] custName, String[] custEmail,
			String[] custID,  double[] paymentPerCard,
			int[] custPointBalacne) {
		// TODO Auto-generated method stub
		System.out.println(" * " + custID[0]);

	}

	public static void generateLPAbove(String[] custID, int amountOfmembers, 
			String[] custNames, String[] custEmails,int[] custPointBalacne,double [] paymentPerCard) {
		// TODO Auto-generated method stub
		System.out.print("Please enter a loyalty point score : ");
		int generalpoint = kb.nextInt();
		for(int index = 0; index <= custPointBalacne.length; index++) {
			   if(custPointBalacne[index] < generalpoint){
			      System.out.println(custPointBalacne[index]);
			   }
			}
	}

	public static void purchaseCoffee(final double costOfCoffee, double total, String[] custID, int[] custPointBalacne,
			int pointsForFree,double pointperEuro, int amountOfmembers,double[] paymentPerCard) {
		// TODO Auto-generated method stub
		boolean Continue = true;

		System.out.print("How many Coffees? : " + "\n");
		double numberOfCoffee = kb.nextInt();
		total = numberOfCoffee * costOfCoffee;
		System.out.print("\n" + "Total cost of Coffee: " + total + "\n");
		double adder =total*pointperEuro;
		boolean validLetter = false;
		while (validLetter == false) {

			System.out.print("Do you have a loyalty card, Yes or No?" + "\n");

			char needLoyalty = kb.next().charAt(0);
			if ((needLoyalty == 'y') || (needLoyalty == 'Y')) {
				validLetter = true;
				Continue = true;

			} else if ((needLoyalty == 'n') || (needLoyalty == 'N')) {
				System.out.print("\n" + "Your Total will remain to : " + total + "\n"+"if you had a loyalty card, you would have recived "+ adder+"...\n");
				Continue = false;
				validLetter = true;
			}
		}
		if (Continue == true) {
			System.out.print("Enter your loyalty card number : ");

			String personsIDnumber = kb.next();

			int pos = findPersonsID(custID, personsIDnumber, amountOfmembers);
			// custID
			System.out.println("Found at " + pos);

			System.out.print("You currently have " + custPointBalacne[pos] + "\n");
			// + " in your balance"+"\n");

			boolean validLetter2 = false;
			while (validLetter2 == false) {

				System.out.print("Do you want to use your available loyalty points, Yes or No?" + "\n");

				char needloyalty = kb.next().charAt(0);
				if ((needloyalty == 'N') || (needloyalty == 'n')) {
					

					System.out.print("You have not been charged by your point balance and you have recived "
							+ total * pointperEuro + "\n");
					custPointBalacne[pos] = (int) (custPointBalacne[pos]+total*pointperEuro);
					paymentPerCard[pos] = paymentPerCard[pos]+total; 
					validLetter2 = true;
					
				}
					 else if ((needloyalty == 'Y') || (needloyalty == 'y')) {
					
					if(custPointBalacne[pos] < pointsForFree){
						System.out.print("You dont have enough points for a free coffee"+"\n");

					}
					else {
						
						validLetter2 = true;
					}
					int freeCoffeeamount = custPointBalacne[pos]/pointsForFree ;
					System.out.print("You have recived "+freeCoffeeamount +" free Coffees"+"\n");
				double costTakenOff =costOfCoffee*freeCoffeeamount;
				total = total - costTakenOff;
				System.out.print("Your total is now only "+ total+"\n");
			
			custPointBalacne[pos]= (custPointBalacne[pos] - pointsForFree*freeCoffeeamount);
			custPointBalacne[pos]=(int) (custPointBalacne[pos] + adder);
			paymentPerCard[pos] = paymentPerCard[pos]+total; 
			Math.round(custPointBalacne[pos]);
			//paymentPerCard[pos] = paymentPerCard[pos]+total; 
			System.out.print("You have recived "+ adder+" to your point balance, bringing it to a total of "+custPointBalacne[pos]+"\n");
				
				}

			}



		}
	}





	// findPersonsID(personsIDnumber,IDCard, poistion,
	// validCard,amountOfmembers);

	private static int findPersonsID(String[] custID, String iDCard, int amountOfmembers) {

		boolean ValidCard = false;
		int pos = -1;
		for (int index = 0; index < amountOfmembers; index++) {
			if (iDCard.equals(custID[index])) {

				ValidCard = true;
				pos = index;
			}
		}

		return pos;

		// TODO Auto-generated method stub

	}

	private static void detailsOfCurrentCustomer(String[] custID, int amountOfmembers, 
			String[] custNames, String[] custEmails,int[] custPointBalacne,double [] paymentPerCard) {
		int pos = -1;
		String IDCard;
		boolean ValidName = true;
		while (ValidName) {
			System.out.print("Please enter the ID of the customer you wish to find: " + "\n");
			IDCard = kb.next();
			IDCard.toUpperCase();
			int length = IDCard.length();
			if (length > 1) {
        
				pos = findPersonsID(custID, IDCard, amountOfmembers);
				if (pos == -1){
					System.out.print("Error, we could not find that ID, please try again"+"\n");
					ValidName = true;
				}
				else{
				ValidName = false;
				System.out.print(custID[pos]+"\n"+custNames[pos]+"\n"+custEmails[pos]+"\n"+paymentPerCard[pos]+"\n"+custPointBalacne[pos]+"\n");
				}
			
			}
		}

	}

	public static int registerNewCustomer(int amountOfmembers, String[] custName, String[] custEmail,
			String[] custID, boolean ValidName, double[] paymentPerCard,  int pointsForJoining,int []custPointBalacne) throws IOException {
		// TODO Auto-generated method stub
		String firstName = "";
		String lastName = "";
		String email = "";
		String IDCard = "";
		ValidName = true;
		while (ValidName) {
			System.out.print ("Enter your first name: ");
			firstName = kb.nextLine();
			int namelength = firstName.length();
			if(namelength > 1)
			{
				ValidName = false;
			}
			else 
			{
				System.out.println("Error, please enter name with more than one letter"+"\n");
				ValidName = true;
			}

		}

		ValidName = true;
		while (ValidName) {

			System.out.print("\n" + "Enter Customer's surname name : ");
			lastName = kb.nextLine();
			int  surnamelength = firstName.length();
			if(surnamelength > 1)
			{
				ValidName = false;
			}
			else 
			{
				System.out.println("Error, please enter name with more than one letter"+"\n");
				ValidName = true;
			}
		}

		ValidName = true;
		while (ValidName) { 
			System.out.print("\n" + "Enter Customer's e-mail : ");
			email = kb.nextLine();
			int  emaillength = firstName.length();
			if(emaillength > 1)
			{
				ValidName = false;
			}
			else 
			{
				System.out.println("Error, please enter email with more than one letter"+"\n");
				ValidName = true;

			}

		}	

		getInitials(lastName, email, firstName,  custID, custName, custID, paymentPerCard,amountOfmembers,custEmail,pointsForJoining,custPointBalacne );
		amountOfmembers++;
		end(custID, custName, custPointBalacne, custID, paymentPerCard, amountOfmembers);

		return amountOfmembers;		
	}

	private static void getInitials(String lastName, String email, String firstName,  String[] custID,
			String[] custName, String[] custID2, double [] paymentPerCard, int amountOfmembers, String[] custEmail,
			int pointsForJoining, int[] custPointBalacne) {

		// TODO Auto-generated method stub
		String firstName2 = firstName.toUpperCase();
		char iniFirstName = firstName2.charAt(0);
		String lastName2 = lastName.toUpperCase();
		char iniLastName = lastName2 .charAt(0);
		custID[amountOfmembers] = iniFirstName + "" + iniLastName + amountOfmembers;
		System.out.println("Adding to list " + custID[amountOfmembers]);
		custName[amountOfmembers] = firstName + " " + lastName;
		custEmail[amountOfmembers] = email;
		custPointBalacne[amountOfmembers] = pointsForJoining;
		paymentPerCard[amountOfmembers] = 0;


		/// amountSpentList[amountOfmembers] = 0.00;
	}

}
