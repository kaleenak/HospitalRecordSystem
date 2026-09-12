package unit3ExampleCode;

import java.util.Arrays;
import java.util.Objects;
/**
 *RecentContact object for Hospital Record System <br>
 * Dec 7, 2025 
 * @author Kaleena Kanagarajan
 *
 */

public class RecentContact { 
	//Fields
	private String firstName;
	private String lastName;
	private String [] middleNames;
	private String telNum;
	private String dateOfContact;
	
	//Getters
	/**
	 Description: This method gets the value of the firstName field.
	 @return value of the firstName field
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 Description: This method gets the value of the lastName field.
	 @return value of the lastName field
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 Description: This method gets the value of the middleNames field.
	 @return value of the middleNames field
	 */
	public String [] getMiddleNames() {
		return this.middleNames;
	}
	
	/**
	 Description: This method gets the value of the telNum feld.
	 @return value of the telNum field
	 */
	public String getTelNum() {
		return this.telNum;
	}
	
	/**
	 Description: This method gets the value of the dateOfContact field.
	 @return value of the dateOfContact field
	 */
	public String getDateOfContact() {
		return this.dateOfContact;
	}
	
	//Setters
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
	public void setMiddleNames(String [] middleNames){
		this.middleNames = middleNames;
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
	 Description: This method sets a new value for the dateOfContact field.
	 @param datofContact -> value which this.dateOfContact will be set to.
	 @throws InvalidInputException 
	 */
	public void setDateOfContact(String dateOfContact) throws InvalidInputException {
		if(dateOfContact != null) {
			dateOfContact = dateOfContact.trim();
			if(dateOfContact.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------"); 
			}
			else if(!dateOfContact.matches("\\d?\\d/\\d?\\d/\\d\\d\\d\\d")) {
				throw new InvalidInputException("ERROR!! FORMAT MUST BE MM/DD/YYYY\n------------------------------------------------------");
			}
		}
		this.dateOfContact = dateOfContact + "?";
	}
	
	//Constructors
	/**
	 Description: This is a constructor method for the RecentContact class, which sets a collected value to each field. It does not return anything
	 @param firstName -> inputed value which the field firstName will be set to.
	 @param lastName -> inputed value which the field lastName will be set to.
	 @param middleNames -> inputed value which the field middleNames will be set to.
	 @param dateOfContact -> inputed value which the field recentContacts will be set to.
	 * @throws InvalidInputException 
	 */
	public RecentContact(String firstName, String lastName, String [] middleNames, String telNum, String dateOfContact) throws InvalidInputException {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMiddleNames(middleNames);
		this.setTelNum(telNum);
		this.setDateOfContact(dateOfContact);
	}
	
	/**
	 * Description: This is a constructor method for the Patient class, which sets every field to empty. It does not return anything or take any parameters.
	 * @throws InvalidInputException 
	 */
	public RecentContact() throws InvalidInputException {
		this.setFirstName(null);
		this.setLastName(null);
		this.setMiddleNames(null);
		this.setTelNum(null);
		this.setDateOfContact(null);
	}

	//Override Object Methods
	/**
	 * Description: This method overrides the toString() Object method.
	 * @return a string with all the information currently in this recentContact object. 
	 */
	@Override
	public String toString(){
		return lastName + "|" + firstName + "|" + Arrays.toString(middleNames) + "|" + telNum + "|" + dateOfContact;
	}
	
	/**
	 * Description: This method overrides the equals() Object method.
	 * @param obj -> The object which this patient object is compared to.
	 * @return a boolean which is true when obj is same as this recentContact object and false when not.
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		RecentContact other = (RecentContact) obj;
		return this.firstName.equals(other.getFirstName()) && this.lastName.equals(other.getLastName()) && this.dateOfContact.equals(other.getDateOfContact());
	}
	
	/**
	 * Description: This method overrides the hashCode() Object method.
	 * @return an hashCode value for this object.
	 */
	@Override
	public int hashCode(){
		return Objects.hash(firstName + lastName + dateOfContact);
	}

}
