package unit3ExampleCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *Patient Object for the Hospital Record system <br>
 * Dec 7, 2025 
 * @author Kaleena Kanagarajan
 *
 */
public class Patient implements Comparable<Patient>{
	//Fields
	private String  healthCardNum; //change to array later
	private String lastName;
	private String firstName;
	private String [] middleNames;
	private String bDay;
	private String gender;
	private String telNum;
	private Address address;
	private String email;
	private boolean isVaccinated; 
	private ArrayList<RecentContact> recentContacts = new ArrayList<RecentContact>();;
	
	//Behaviors 
	
	//Getters
	
	/**
	 Description: This method gets the value of the healthCardNum field.
	 @return value of the healthCardNum field
	 */
	public String  getHealthCardNum() {
		return this.healthCardNum;
	}
	
	/**
	 Description: This method gets the value of the lastName field.
	 @return value of the lastName field
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 Description: This method gets the value of the firstName field.
	 @return value of the firstName field
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 Description: This method gets the value of the middleNames field.
	 @return value of the middleNames field
	 */
	public String [] getMiddleNames() {
		return this.middleNames;
	}
	
	/**
	 Description: This method gets the value of the bDay field.
	 @return value of the bDay field
	 */
	public String getBDay() {
		return this.bDay;
	}
	
	/**
	 Description: This method gets the value of the gender field.
	 @return value of the gender field
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 Description: This method gets the value of the telNum field.
	 @return value of the telNum field
	 */
	public String getTelNum() {
		return this.telNum;
	}
	
	/**
	 Description: This method gets the value of the address field.
	 @return value of the address field
	 */
	public Address getAddress() {
		return this.address;
	}
	
	/**
	 Description: This method gets the value of the email field.
	 @return value of the email field
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 Description: This method gets the value of the isVaccinated field.
	 @return value of the isVaccinated field
	 */
	public boolean getIsVaccinated() {
		return this.isVaccinated;
	}
	
	/**
	 Description: This method gets the value of the recentContacts field.
	 @return value of the recentContacts field
	 */
	public ArrayList<RecentContact> getRecentContacts() {
		return this.recentContacts;
	}
	
	//Setters

	/**
	 Description: This method sets a new value for the healthCardNum field.
	 @param healthcardNum -> value which this.healthCardNum will be set to.
	 * @throws InvalidInputException 
	 */
	public void setHealthCardNum(String healthCardNum) throws InvalidInputException {

		if(!(healthCardNum == null)) {
			healthCardNum = healthCardNum.toUpperCase().trim();
			if(healthCardNum.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			if(!healthCardNum.matches("[0-9]{10}\\s?[A-Z]{2}")){
				throw new InvalidInputException("ERROR!! INVAILD HEALTH CARD NUMBER!!\n------------------------------------------------------"); 
			}
			
			//format
			if(healthCardNum.matches("[0-9]{10}\\s[A-Z]{2}")) {
				healthCardNum = healthCardNum.replace(" ", "");
			}
		}
		this.healthCardNum = healthCardNum;
	}
	
	/**
	 Description: This method sets a new value for the lastName field.
	 @param lastName -> value which this.lastName will be set to.
	 @throws InvalidInputException 
	 */
	public void setLastName(String lastName) throws InvalidInputException {
		if(lastName != null) {
			lastName = lastName.trim();
			if(lastName.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!! \n------------------------------------------------------"); 
			}
		}
		this.lastName = lastName;
	}
	
	/**
	 Description: This method sets a new value for the firstName field.
	 @param firstName -> value which this.firstName will be set to.
	 @throws InvalidInputException 
	 */
	public void setFirstName(String firstName) throws InvalidInputException {
		if(firstName != null) {
			firstName = firstName.trim();
			if(firstName.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
		}
		this.firstName = firstName;
	}
	
	/**
	 Description: This method sets a new value for the middleNames field.
	 @param middleNames -> value which this.middleNames will be set to.
	 */
	public void setMiddleNames(String [] middleNames) throws InvalidInputException {
		this.middleNames = middleNames;
	}
	
	/**
	 Description: This method sets a new value for the bDay field.
	 @param bDay -> value which this.bDay will be set to.
	 @throws InvalidInputException 

	 */
	public void setBDay(String bDay) throws InvalidInputException {
		if(bDay != null) {
			bDay= bDay.trim();
			if(bDay.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			else if(!bDay.matches("\\d?\\d/\\d?\\d/\\d\\d\\d\\d")) {
				throw new InvalidInputException("ERROR!! FORMAT MUST BE MM/DD/YYYY\n------------------------------------------------------");
			}
		}
		this.bDay = bDay;
	}
	
	/**
	 Description: This method sets a new value for the gender field.
	 @param gender -> value which this.gender will be set to.
	 @throws InvalidInputException 
	 */
	public void setGender(String gender) throws InvalidInputException {
		if(gender != null) {
			if(gender.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			if(gender.equalsIgnoreCase("f")) {
				gender = "Female";
			}
			else if(gender.equalsIgnoreCase("m")) {
				gender = "Male";
			}
			else if(gender.equalsIgnoreCase("o")) {
				gender = "Other";
			}
			else if(gender.equalsIgnoreCase("p")) {
				gender = "Prefer not to say";
			}
			else{
				throw new InvalidInputException("ERROR!! PLEASE ENTER ONE OF THE OPTIONS ABOVE!!\n------------------------------------------------------"); 
			}
		}
		this.gender = gender;
	}
	
	/**
	 Description: This method sets a new value for the telNum field.
	  @param telNum -> value which this.telNum will be set to.
	 * @throws InvalidInputException 
	 */
	public void setTelNum(String telNum)throws InvalidInputException {
		if(!(telNum == null)) {
			telNum = telNum.trim();
			if(telNum.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			if(!telNum.matches("\\d{10}")) {
				throw new InvalidInputException("ERROR!! THAT IS NOT A VALID PHONE NUMBER!!\n------------------------------------------------------");
			}
		}
		this.telNum = telNum;
	}
	
	/**
	 Description: This method sets a new value for the address field.
	  @param address -> value which this.address will be set to.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 Description: This method sets a new value for the email field.
	  @param email -> value which this.email will be set to.
	  @throws InvalidInputException 

	 */
	public void setEmail(String email) throws InvalidInputException {
		if(email != null) {
			email = email.trim();
			int index = -1;
			if(email.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			if(!email.contains("@")|| email.length() < 5) {
				throw new InvalidInputException("ERROR!! THAT IS NOT A VALID EMAIL ADDRESS!!\n------------------------------------------------------");
			}
			else if(email.contains("@")) {
				index = email.indexOf('@');
			}
			if(!email.substring(index).contains(".")) {
				throw new InvalidInputException("ERROR!! THAT IS NOT A VALID EMAIL ADDRESS!!\n------------------------------------------------------");
			}
		}
		this.email = email;
	}
	
	/**
	 Description: This method sets a new value for the isVaccinated field.
	  @param isVaccinated -> value which this.isVaccinated will be set to.
	 */
	public void setIsVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}
	
	/**
	 Description: This method sets a new value for the recentContacts field.
	  @param recentContacts -> value which this.recentContacts will be set to.
	 */
	public void setRecentContacts(ArrayList<RecentContact> recentContacts) {
		this.recentContacts = recentContacts;
	}
	
	//Constructors
	
	/**
	 Description: This is a constructor method for the Patient class, which sets a collected value to each field. It does not return anything
	 @param healthCardNum -> inputed value which the field healthCardNum will be set to.
	 @param firstName -> inputed value which the field firstName will be set to.
	 @param lastName -> inputed value which the field lastName will be set to.
	 @param middleNames -> inputed value which the field middleNames will be set to.
	 @param telNum -> inputed value which the field telNum will be set to.
	 @param address -> inputed value which the field address will be set to.
	 @param email -> inputed value which the field email will be set to.
	 @param isVaccinated -> inputed value which the field isVaccinated will be set to.
	 @param recentContacts -> inputed value which the field recentContacts will be set to.
	 * @throws InvalidInputException 
	 */
	public Patient(String healthCardNum, String lastName, String firstName, String [] middleNames, String bDay, String gender, String telNum, Address address, String email, boolean isVaccinated, ArrayList<RecentContact> recentContacts) throws InvalidInputException {
		this.setHealthCardNum(healthCardNum);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMiddleNames(middleNames);
		this.setBDay(bDay);
		this.setGender(gender);
		this.setTelNum(telNum);
		this.setAddress(address);
		this.setEmail(email);
		this.setIsVaccinated(isVaccinated);
		this.setRecentContacts(recentContacts);
	}
	
	
	
	/**
	 * Description: This is a constructor method for the Patient class, which sets every field to empty. It does not return anything or take any parameters.
	 * @throws InvalidInputException 
	 */
	public Patient() throws InvalidInputException {
		this.setHealthCardNum(null);
		this.setFirstName(null);
		this.setLastName(null);
		this.setMiddleNames(null);
		this.setBDay(null);
		this.setGender(null);
		this.setTelNum(null);
		this.setAddress(null);
		this.setEmail(null);
		this.setIsVaccinated(false);
		this.setRecentContacts(null);
	}
	
	//Override Object Methods
	/**
	 * Description: This method overrides the toString() Object method.
	 * @return a string with all the information currently in this patient object. 
	 */
	@Override
	public String toString(){
		return healthCardNum + "*" + lastName + "*" + firstName + "*" + Arrays.toString(middleNames) + "*" + bDay + "*" + gender + "*" + telNum + "*" + address.toString() + "*" + email + "*" + isVaccinated + "*" + recentContacts.toString();
	}
	
	/**
	 * Description: This method overrides the equals() Object method.
	 * @param obj -> The object which this patient object is compared to.
	 * @return a boolean which is true when obj is same as this patient object and false when not.
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		Patient other = (Patient) obj;
		return this.healthCardNum.equals(other.getHealthCardNum());
	}
	
	/**
	 * Description: This method overrides the hashCode() Object method.
	 * @return an hashCode value for this object.
	 */
	@Override
	public int hashCode(){
		return Objects.hash(healthCardNum);
	}
	
	//Compare to 
	/**
	 * Description: This method compares 2 patients.
	 * @return if equal, return 0. if this patient is before other patient, return number < 0. if other patient is before this patient, return number > 0; 
	 */
	@Override
	public int compareTo(Patient o) {
		/*
		if(this.getLastName().compareTo(o.getLastName()) == 0) {
			if(this.getFirstName().compareTo(o.getFirstName()) == 0) {
				return this.getHealthCardNum().compareTo(o.getHealthCardNum());
			}
			return this.getFirstName().compareTo(o.getFirstName());
		}
		*/
		return this.getHealthCardNum().compareTo(o.getHealthCardNum());
	}
}