package com.lifegrip.genericUtility;
/**
 * this enum contains propertyfilekeys
 * @author 91958
 *
 */
public enum PropertyFileKeys {

	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout"),RANDOM_NUMBER_LIMIT("randomNumberLimit");
	
	private String keys;
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
	}
	public String convertToString() {
		
		return keys.toString(); 
	}
	
}
