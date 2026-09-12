package unit3ExampleCode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *Hospital Record system where information is can be set and gotten. It references the Patient and Address objects <br>
 * Dec 7, 2025 
 * @author Kaleena Kanagarajan
 *
 */
public class HospitalSystem {
	/**
	 * This is the entry point to the program.
	 * @param args unused
	 */
	static ArrayList<Patient> patients = new ArrayList<Patient>(); //global array list which will store all the references for the patient objects
	static Scanner sc = new Scanner(System.in); //globally declare scanner so it can be used in many methods
	public static void main(String[] args) throws Exception {
		
		String doAgain = "n";
		
		System.out.println("Welcome to the Hospital Record System!\n--------------------------------------"); //Title
		
		do {
			System.out.println("\nWhat would you like to do?\n\nEnter \"1\" to create a new patient\nEnter \"2\" to print a patient's information\nEnter \"3\" to print all the patient records\nEnter \"4\" to save current patient list\nEnter \"5\" to load patient list\nEnter \"6\" to sort patient list\nEnter \"7\" to find a patient");
			
			
			String user = sc.nextLine();
			if(user.equals("1")) {
				createNewPatient();	
			}
			else if(user.equals("2")) {
				System.out.println("\nPlease enter the index of the patient.");
				int index = sc.nextInt();
				sc.nextLine(); //get rid of scanner error
				printPatient(patients.get(index));
				
			}
			else if(user.equals("3")) {
				printAll(patients);	
			}
			else if(user.equals("4")) {
				save(patients);
			} 
			else if(user.equals("5")) {
				load(patients);
			}
			else if(user.equals("6")) {
				Collections.sort(patients);
			}
			else if(user.equals("7")) {
				int index;
				boolean flag = true;
				
				do {
					flag = false;
					System.out.println("\nHow would you like to search for the patient?\nEnter \"1\" to search by Health Card Num\nEnter \"2\" to search by Full Name");
					String user1 = sc.nextLine();
					
					if(user1.equals("1")) {
						index = searchHealthCard();
						if(index > -1) {
						System.out.println("Patient with health card number, " + patients.get(index).getHealthCardNum() + ", was found");
						printPatient(patients.get(index));
						}
						else {
							System.out.println("Paitent was not found");
						}
						
					}
					else if(user1.equals("2")) {
						index = searchName();
						if(index > -1) {
							System.out.println("Patient with name, " + patients.get(index).getFirstName()  + " " + patients.get(index).getLastName() + ", was found");
							printPatient(patients.get(index));
						}
						else {
							System.out.println("Patient with was not found");
						}
					}
					else {
						System.out.println("ERROR!! INCORRECT INPUT!! PLEASE TRY AGAIN.");
						flag = true;
					}
				}while(flag);

				
			}
			else {
				System.out.println("ERROR!!!");
			}
			
			System.out.println("\nWould you like to continue? (input \"y\" for yes or \"n\" for no)");
			
			doAgain = sc.nextLine();
			
			
		}while(doAgain.equalsIgnoreCase("y"));
		
		System.out.println("\nBye! :)");
		sc.close();
	}
	
	/**
	 Description: This method creates a new Patient object for a new patient.
	 @return the reference of the Patient object
	 */
	public static Patient createNewPatient(){
		Patient p = new Patient();
		Address a = new Address();
		boolean flag = false;
		boolean isReplacing = false;
		
		//Set health card number
		do{
			try {
				System.out.println("\nWhat is the patient's healthcard number (10 digits + 2 Letter Version Code)?");
				p.setHealthCardNum(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
				
		}while(flag);
		
		Patient tempPatient = new Patient();
		tempPatient.setHealthCardNum(p.getHealthCardNum());
		Collections.sort(patients); // make sure array list is sorted before searching
		int index = Collections.binarySearch(patients, tempPatient);
		if(index > -1) {
			do {
				flag = false;
				System.out.println("ERROR!! A PATIENT RECORD WITH THIS HEALTH CARD NUMBER ALREADY EXISTS!!\nEnter \"1\" if you would like to start again\nEnter \"2\" if you would like to continue and replace existing patient");
				String user = sc.nextLine();
				if(user.equalsIgnoreCase("1")) {
					return p;
				}
				else if(!user.equalsIgnoreCase("2")) {
					System.out.println("ERROR!! PLEASE TRY AGAIN");
					flag = true;
				}
				else {
					isReplacing = true;
				}
			}while(flag);
		}
		
		
		//Set last name
		do {
			try {
				System.out.println("\nWhat is the patient's last name?");
				p.setLastName(sc.nextLine());
				flag = false;
			}
			catch(Exception e){
				flag = true;
				System.out.println(e.getMessage());
			}
		}while(flag);
		
		//Set first name
		do {
			try {
				System.out.println("\nWhat is the patient's first name?");
				p.setFirstName(sc.nextLine());
				flag = false;
			}
			catch(Exception e){
				flag = true;
				System.out.println(e.getMessage());
			}
		}while(flag);
		
		//Set middle name(s)
		int n = 0;
		
		//check number of middle names input
		do {
			try {
				System.out.println("\nWhat is/are " + p.getFirstName() + "'s middle name(s)? \nPlease enter number of middle names first. If none, please enter \"0\".");
				n = Integer.parseInt(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println("ERROR! PLEASE ENTER NUMBER OF MIDDLE NAMES FIRST. IF NONE, PLEASE ENTER \"0\".\n------------------------------------------------------");
				flag = true;
			}
		}while(flag);
		
		
		String[] middleNames = new String[n];
		String middleName = "";
		for(int i = 0; i < n; i++) {
			do{
				System.out.println("Middle Name #" + (i+1) + ":");
				middleName = sc.nextLine().trim();
				if(middleName.equals("")) {
					flag = true;
					System.out.println("ERROR!! YOU MUST ENTER SOMETHING!! \n------------------------------------------------------");
				}
				else {
					flag = false;
				}
			}while(flag);
			middleNames[i] = middleName;
		}
		p.setMiddleNames(middleNames);
		
		//Set Birthday
		do {
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s birthday? Please enter in MM/DD/YYYY.");
				p.setBDay(sc.nextLine());
				flag = false;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set Gender
		do {
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s gender? Please enter one of the following options. \nEnter \"f\" for Female\nEnter \"m\" for Male\nEnter \"o\" for Other\nEnter \"p\" for Prefer not to say");
				p.setGender(sc.nextLine());
				flag = false;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set phone number
		do{
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s telphone number (10 digits) ?");
				p.setTelNum(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set street address
		do{
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s street address?");
				a.setStreetAddress(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set city
		do{
			try {
				System.out.println("\nWhat city does " + p.getFirstName() + " live in?");
				a.setCity(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set province
		do {
			try {
				System.out.println("\nWhat province or territory does " + p.getFirstName() + " live in? \nPlease enter only 2 letters. For example, enter \"ON\" for Ontario.");
				a.setProvince(sc.nextLine());
				flag = false;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				flag = true;
			}
		}while (flag);
		
		//Set postal code
		do {
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s postal code?");
				a.setPostalCode(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set address
		p.setAddress(a);
		
		//Set email address
		do {
			try {
				System.out.println("\nWhat is " + p.getFirstName() + "'s email address?");
				p.setEmail(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		//Set isVaccinated
		do {
			System.out.println("\nIs " + p.getFirstName() + " vaccinated? Please enter \"y\" for yes or \"n\" for no.");
			String isVaccinated = sc.nextLine();
			if(isVaccinated.equalsIgnoreCase("y") || isVaccinated.equalsIgnoreCase("yes")) {
				p.setIsVaccinated(true);
				flag = false;
			}
			else if(isVaccinated.equalsIgnoreCase("n")|| isVaccinated.equalsIgnoreCase("no")){
				p.setIsVaccinated(false);
				flag = false;
			}
			else {
				flag = true;
				System.out.println("ERROR!! PLEASE ONLY ENTER \"y\" FOR YES OR \"n\" FOR NO.");
			}
		}while(flag);
		
		
		//Set recent contacts
		System.out.println("\nWho was in recent contact with " + p.getFirstName() + "? \nPlease enter number of people first. If none, please enter \"0\".");
		do {
			try {
				n = Integer.parseInt(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println("ERROR! PLEASE ENTER NUMBER OF CONTACTS FIRST. IF NONE, PLEASE ENTER \"0\".\n------------------------------------------------------");
				flag = true;
			}
		}while(flag);

		ArrayList<RecentContact> recentContacts = new ArrayList<RecentContact>(); //Array list which will store all the references for the recentContact objects
		
		for(int i = 0; i < n; i++) {
			System.out.println("\nContact #" + (i+1) + ":");
			recentContacts.add(createRecentContact());
		}
		p.setRecentContacts(recentContacts);
		
		//Done
		System.out.println("\nNew record for " + p.getFirstName() + " has been created.");
		
		//If an
		if(isReplacing) {
			patients.set(index, p);
			return p;
		}
		
		patients.add(p);
		return p;
	}
	
	/**
	 Description: This method creates a new RecentContact object for a the new patient.
	 @return the reference of the RecentContact object
	 */
	public static RecentContact createRecentContact() {
		RecentContact r = new RecentContact();
		boolean flag = false;
		
		//Set first name
		System.out.println("\nWhat is the contacts's last name?");
		r.setLastName(sc.nextLine());
		
		//Set last name
		System.out.println("\nWhat is the contact's first name?");
		r.setFirstName(sc.nextLine());

		//Set middle name(s)
		int n = 0;
		
		//check number of middle names input
		do {
			try {
				System.out.println("\nWhat is/are " + r.getFirstName() + "'s middle name(s)? \nPlease enter number of middle names first. If none, please enter \"0\".");
				n = Integer.parseInt(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println("ERROR! PLEASE ENTER NUMBER OF MIDDLE NAMES FIRST. IF NONE, PLEASE ENTER \"0\".\n------------------------------------------------------");
				flag = true;
			}
		}while(flag);
		
		String[] middleNames = new String[n];
		String middleName = "";
		for(int i = 0; i < n; i++) {
			do{
				System.out.println("Middle Name #" + (i+1) + ":");
				middleName = sc.nextLine().trim();
				if(middleName.equals("")) {
					flag = true;
					System.out.println("ERROR!! YOU MUST ENTER SOMETHING!! \n------------------------------------------------------");
				}
				else {
					flag = false;
				}
			}while(flag);
			middleNames[i] = middleName;
		}
		r.setMiddleNames(middleNames);
		
		//Set telNum
		do {
			try {
				System.out.println("\nWhat is " + r.getFirstName() +"'s telephone number (10 digits) ?");
				r.setTelNum(sc.nextLine());
				flag = false;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
				
		//Set date of contact
		do {
			try {
				System.out.println("\nWhen did the patient contact this person?\nPlease enter in MM/DD/YYYY format.");
				r.setDateOfContact(sc.nextLine());
				flag = false;
			}
			catch (Exception e){
				System.out.println(e.getMessage());
				flag = true;
			}
		}while(flag);
		
		return r;
	}
	
	/**
	 Description: This method prints the record of a patient.
	 @param p -> the patient that will be printed
	 */
	public static void printPatient(Patient p) {
		Address a = p.getAddress();
		
		ArrayList<RecentContact> recentContacts = p.getRecentContacts();
		System.out.println("\nPatient Record of " + p.getFirstName() + " " + p.getLastName() + "\n------------------------------------------------------\n");
		
		System.out.println("Personal Information\n------------------------------------------------------");
		System.out.println("First Name: " + p.getFirstName());
		System.out.println("Last Name: " + p.getLastName());
		System.out.print("Middle Name(s): ");
		String [] middleNames = p.getMiddleNames();
		
		if(middleNames.length > 0) {
			for(int i = 0; i < middleNames.length; i++) {
				System.out.print(middleNames[i]);
				if(i + 1 != middleNames.length) {
					System.out.print(", ");
				}
			}
		}
		else {
			System.out.print("None");
		}
		
		System.out.println("\nDate of Birth: " + p.getBDay());
		System.out.println("Gender: " + p.getGender());
		
		System.out.println("\nContact Information\n------------------------------------------------------");
		System.out.println("Telephone: " + p.getTelNum());
		System.out.println("Email: " + p.getEmail());
		
		System.out.println("\nAddress\n------------------------------------------------------");
		System.out.println("Street Address: " + a.getStreetAddress());
		System.out.println("City: " + a.getCity());
		System.out.println("Province: " + a.getProvince());
		System.out.println("Postal Code: " + a.getPostalCode());
		
		System.out.println("\nMedical Information\n------------------------------------------------------");
		
		System.out.println("Health Card Number: " + p.getHealthCardNum());
		
		if(p.getIsVaccinated()) {
			System.out.println("Vaccination Status: Vaccinated");
		}
		else {
			System.out.println("Vaccination Status: Not Vaccinated");
		}
	
		System.out.println("\nRecent Contacts\n------------------------------------------------------");
		if(recentContacts.size() > 0) {
			for(int i = 0; i < recentContacts.size(); i++) {
				System.out.println("Contact #" + (i + 1) + ":");
				RecentContact r = recentContacts.get(i);
				System.out.println("First Name: " + r.getFirstName());
				System.out.println("Last Name: " + r.getLastName());
				System.out.print("Middle Name(s): ");
				String [] middleNamesRC = r.getMiddleNames();
				
				if(middleNamesRC.length > 0) {
					for(int j = 0; j < middleNamesRC.length; j++) {
						System.out.print(middleNamesRC[j]);
						if(j + 1 != middleNamesRC.length) {
							System.out.print(", ");
						}
					}
				}
				
				System.out.println("\nTelephone: " + r.getTelNum());
				
				System.out.println("Date of Contact: " + r.getDateOfContact().replace("?", "") + "\n");
			}
		}
		else {
			System.out.print("None");
		}
		
	}
	
	/**
	 Description: This method prints all the patients in the current list.
	 @param patients -> the current list of all the patients.
	 */
	public static void printAll(ArrayList<Patient> patients) {
		for(int i = 0; i < patients.size(); i++) {
			Patient p = patients.get(i);
			
			System.out.println("Patient at Index " + i);
			printPatient(p);
		}
	}
	
	/**
	 Description: This method takes the data saved in the separate patient data file and saves it to the current list
	 @param patients -> the current patient list where the previous records will be saved when loaded
	 */
	public static void load(ArrayList<Patient> patients) {
		
		try {
			File file = new File("src/unit3ExampleCode/data.txt");
			Scanner fsc = new Scanner(file);
			int num = fsc.nextInt();
			fsc.nextLine();
			while(num > 0) {
			String [] data = fsc.nextLine().split("\\*");
			
			//Middle names
			data[3] = data[3].substring(1, data[3].length() -1);
			String [] middleNames = data[3].split(", ");
			
			//Gender
			String gender = data[5];
			if(gender.equalsIgnoreCase("Female")) {
				gender = "f";
			}
			else if(gender.equalsIgnoreCase("male")) {
				gender = "m";
			}
			else if(gender.equalsIgnoreCase("other")) {
				gender = "o";
			}
			else if(gender.equalsIgnoreCase("prefer not to say")) {
				gender = "p";
			}

			
			//Convert isVaccinated to boolean
			boolean isVaccinated;
			if(data[12].equals("true"))
				isVaccinated = true;
			else
				isVaccinated = false;
			
			
			//Convert Recent Contact
			ArrayList<RecentContact> recentContacts = new ArrayList<RecentContact>();
				if(!data[13].equals("[]")) {
				data[13] = data[13].substring(1, data[13].length() - 2);
				
				String[] list = data[13].split("\\?, ");
				
				for(int i = 0; i < list.length; i ++) {
					String [] recentContact = list[i].split("\\|");
					
					//find num of middleNames
					
					int numOfMiddles = recentContact.length - 4;
				
					String [] middleNamesRC = new String[numOfMiddles];
					//Middle Names
					
					for(int j = 0; j < numOfMiddles; j++) {
						middleNamesRC[j] = recentContact[j + 2];
					}
					
					middleNamesRC[0] = middleNamesRC[0].replaceFirst("\\[", "");
					middleNamesRC[middleNamesRC.length - 1] = middleNamesRC[middleNamesRC.length - 1].replaceFirst("\\]", "");
					RecentContact r = new RecentContact(recentContact[0], recentContact[1], middleNamesRC, recentContact[3], recentContact[4]);
					recentContacts.add(r);
				}
			}
			
			Patient p = new Patient(data[0], data[1], data[2], middleNames, data[4], gender, data[6], new Address(data[7], data [8], data[9], data [10]), data[11], isVaccinated, recentContacts);
			patients.add(p);
			num --;
			}
			fsc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR!! FILE DOES NOT EXIST!!");
		}
		
	}
	
	/**
	 Description: This method saves all the patient records in the current list onto the separate data file
	 @param patients -> This is the current patient list
	 */
	public static void save(ArrayList<Patient> patients) {
	
		//Save to file
		try {
			PrintStream fps;
			fps = new PrintStream(new File("src/unit3ExampleCode/data.text"));
			
			fps.println(patients.size());
			
			for(int i = 0; i < patients.size(); i++) {
				Patient p = patients.get(i);
				fps.println(p.toString());
			}
			fps.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR!! FILE DOES NOT EXIST!!");
		}

		
	}
	
	/**
	 Description: This method searches for a patient in the current list by health card number
	 @return the index of the patient in the current list. If not there, return a number < 0.
	 */
	public static int searchHealthCard(){
	boolean flag = true;
		
		do{
			try {
				System.out.println("\nPlease enter the patient's Health Card Number in XXXXXXXXXXAB format ");
				Patient temp = new Patient();
				temp.setHealthCardNum(sc.nextLine());
				return Collections.binarySearch(patients, temp);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
				
		}while(flag);
		
		return -1;
	}
	
	/**
	 Description: This method searches for a patient in the current list by name
	 @return the index of the patient in the current list. If not there, return a number < 0.
	 */
	public static int searchName(){
		boolean flag;
		String firstName;
		String lastName;
		do {
			flag = false;
			System.out.println("\nPlease enter the patient's last name");
			lastName = sc.nextLine();
			if(lastName == null|| lastName.equals("")) {
				System.out.println("ERROR!! YOU MUST ENTER SOMETHING!!");
				flag = true;
			}
		}while(flag);
		
		do {
			flag = false;
			System.out.println("\nPlease enter the patient's last name");
			firstName = sc.nextLine();
			if(firstName == null|| firstName.equals("")) {
				System.out.println("ERROR!! YOU MUST ENTER SOMETHING!!");
				flag = true;
			}
		}while(flag);
		
		ArrayList<Integer> possiblePatients = new ArrayList<Integer>();
		for(int i = 0; i < patients.size(); i++) {
			Patient p = new Patient();
			p = patients.get(i);
			
			if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
				possiblePatients.add(i);
			}
		}
		
		int numPatients = possiblePatients.size();
		if(numPatients == 1) {
			return possiblePatients.get(0);

		}
		else if(numPatients == 0) {
			return -1;
		}
		else {
			System.out.println(numPatients + " patients with name, " + firstName + " " + lastName + ", were found.");
			return searchHealthCard();
		}	
		
	}
	

}
