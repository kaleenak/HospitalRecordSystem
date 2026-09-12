package unit3ExampleCode;

import java.util.Objects;

/**
 *Address Object for the Hospital Record system <br>
 * Dec 7, 2025 
 * @author Kaleena Kanagarajan
 *
 */
public class Address {
	//Fields
	private String streetAddress;
	private String city;
	private String province;
	private String postalCode;
	
	//Constants
	static final String [] provinces = {"AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"};

	//Behaviors 
	
	//Getters
	
	/**
	 Description: This method gets the value of the streetAddress field.
	 @return value of the streetAddress field
	 */
	public String getStreetAddress() {
		return this.streetAddress;
	}
	
	/**
	 Description: This method gets the value of the city field.
	 @return value of the city field
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 Description: This method gets the value of the province field.
	 @return value of the province field.
	 */
	public String getProvince() {
		return this.province;
	}
	
	/**
	 Description: This method gets the value of the postalCode field.
	 @return value of the postalCode field.
	 */
	public String getPostalCode() {
		return this.postalCode;
	}
	
	//Setter
	
	/**
	 Description: This method sets a new value for the streetAddress field.
	  @param streetAddress -> value which this.streetAddress will be set to.
	  @throws InvalidInputException 
	 */
	public void setStreetAddress(String streetAddress) throws InvalidInputException {
		if(streetAddress != null) {
			streetAddress = streetAddress.trim();
			if(streetAddress.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------");
			}
		}
		this.streetAddress = streetAddress;
	}
	
	/**
	 Description: This method sets a new value for the city field.
	  @param city -> value which this.city will be set to.
	  @throws InvalidInputException 
	 */
	public void setCity(String city) throws InvalidInputException {
		if(city != null) {
			city = city.trim();
			if(city.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------");
			}
			city = city.replaceFirst(Character.toString(city.charAt(0)), Character.toString(Character.toUpperCase(city.charAt(0))));
		}
		
		this.city = city;
	}
	
	/**
	 Description: This method sets a new value for the province field.
	  @param province -> value which this.province will be set to.
	 * @throws InvalidInputException 
	 */
	public void setProvince(String province) throws InvalidInputException {
		if(!(province == null)) {
			province = province.toUpperCase().trim();
			if(province.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------");
			}
			if((province.length() != 2)){
				throw new InvalidInputException("ERROR!! \nPLEASE ONLY ENTER 2 LETTERS. FOR EXAMPLE, ENTER \"ON\" FOR ONTARIO.\n------------------------------------------------------");
			}
			else {
				boolean isProvince = false;
				for(int i = 0; i < provinces.length; i++) {
					if(province.equals(provinces[i])) {
						isProvince = true;
					}
				}
				if(!isProvince) {
					throw new InvalidInputException("ERROR!! THAT IS NOT A PROVINCE!!\n------------------------------------------------------");
				}
			}
		}
		this.province = province;
	}
	
	/**
	 Description: This method sets a new value for the postalCode field.
	  @param postalCode -> value which this.postalCode will be set to.
	  @throws InvalidInputException 
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException {
		if(postalCode != null) {
			postalCode = postalCode.toUpperCase().trim();
			if(postalCode.equals("")) {
				throw new InvalidInputException("ERROR!! YOU MUST ENTER SOMETHING!!\n------------------------------------------------------");
			}
			if(!postalCode.matches("[A-Z]\\d[A-Z]\\s?\\d[A-Z]\\d")) {
				throw new InvalidInputException("ERROR!! THAT IS NOT A VALID POSTAL CODE!!\n------------------------------------------------------");
			}
		}
		
		this.postalCode = postalCode;
	}
	
	//Constructors
	
	/**
	 * Description: This is a constructor method for the Patient class, which sets every field to empty. It does not return anything or take any parameters.
	 * @param streetAddress -> inputed value which the streetAddress field will be set to.
	 * @param city -> inputed value which the city field will be set to.
	 * @param province -> inputed value which the province field will be set to.
	 * @param postalCode -> inputed value which the postalCode field will be set to.
	 */
	public Address(String streetAddress, String city, String province, String postalCode) {
		this.setStreetAddress(streetAddress);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
	}
	
	/**
	 * Description: This is a constructor method for the Address class, which sets every field to empty. It does not return anything or take any parameters.
	 */
	public Address() {
		this.setStreetAddress(null);
		this.setCity(null);
		this.setProvince(null);
		this.setPostalCode(null);
	}
	
	//Override Object Methods
	/**
	 * Description: This method overrides the toString() Object method.
	 * @return a string with all the information currently in this address object. 
	 */
	@Override
	public String toString(){
		return  streetAddress + "*" + city + "*" + province + "*" + postalCode;
	}
	
	/**
	 * Description: This method overrides the equals() Object method.
	 * @param obj -> The object which this address object is compared to.
	 * @return a boolean which is true when obj is same as this address object and false when not.
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		Address other = (Address) obj;
		return this.postalCode.equals(other.getPostalCode()) && this.streetAddress.equals(other.getStreetAddress());
	}
	
	/**
	 * Description: This method overrides the hashCode() Object method.
	 * @return an hashCode value for this object.
	 */
	@Override
	public int hashCode(){
		return Objects.hash(postalCode + streetAddress);
	}


}
