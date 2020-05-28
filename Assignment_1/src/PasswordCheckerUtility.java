import java.util.ArrayList;

/**
 * This class has static methods that work with a password to check
 * its validity, save the invalid passwords, and identify whether it is weak.
 * @author Alex Juan
 *
 */
public class PasswordCheckerUtility {

	/**
	 * isValidPassword method returns true if password is valid and throws exceptions when it is not.
	 * @param passwordString string to be checked for validity
	 * @return returns true if password is valid and false otherwise
	 * @throws LengthException If length is less than 6 characters in the password
	 * @throws NoUpperAlphaException If there is no upper case letter in the password
	 * @throws NoLowerAlphaException If there is no lower case letter in the password
	 * @throws NoDigitException If there is no digit in the password
	 * @throws InvalidSequenceException If there is a 3 consecutively repeating characters in the password
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException{
		boolean isUpperCase = false;
		boolean isLowerCase = false;
		boolean isDigit = false;
		boolean isInvalidSequence = false;
		
		//Check for the length of the password first
		if(passwordString.length() < 6) {
			throw new LengthException("The password must be at least 6 characters long");
		}
		else {
			for(int i = 0; i < passwordString.length(); i++) {
				//Check for uppercase
				if(Character.isUpperCase(passwordString.charAt(i))) {
					isUpperCase = true;
				}
				
				//Check for lowercase
				if(Character.isLowerCase(passwordString.charAt(i))) {
					isLowerCase = true;
				}
				
				//Check for digit
				if(Character.isDigit(passwordString.charAt(i))) {
					isDigit = true;
				}
			}
			
			//Check for password containing more than 2 of the same character in a sequence
			for(int i = 0; i < (passwordString.length()-2); i++){
				if(passwordString.charAt(i) == passwordString.charAt(i+1) && passwordString.charAt(i) == passwordString.charAt(i+2)) {
					isInvalidSequence = true;
				}
			}
			
			
			//Throws exceptions based on the requirements
			if(isUpperCase == false) {
				throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
			}
			else if(isLowerCase == false) {
				throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
			}
			else if(isDigit == false) {
				throw new NoDigitException("The password must contain at least one digit");
			}
			else if(isInvalidSequence == true) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
		}
		
		return true;
	}
	
	/**
	 * isWeakPassword method returns true if length of password is 
	 * greater than or equal to 6 but less than or equal to 9.
	 * @param passwordString string to be checked if weak password
	 * @return returns true if length of password is greater than or equal to 6 but less than or equal to 9
	 */
	public static boolean isWeakPassword(String passwordString) {
		boolean isWeakPass = false;
		
		if(passwordString.length() >= 6 && passwordString.length() <= 9) {
			isWeakPass = true;
		}
		
		return isWeakPass;
	}
	
	/**
	 * invalidPasswords method returns an arraylist of invalid passwords
	 * @param passwords arraylist of passwords to check for validity
	 * @return returns arraylist of invalid passwords with their respective errors
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords){
		//ArrayList for invalid passwords and their exceptions
		ArrayList<String> invalidPass = new ArrayList<String>();
		
		for(int i = 0; i < passwords.size(); i++) {
			
			//Get passwords that are invalid and their exceptions
			try {
				isValidPassword(passwords.get(i));
			}
			catch(Exception e) {
				invalidPass.add(passwords.get(i) +" " +e.getMessage());
			}
		}
		
		return invalidPass;
	}
	
	
}
