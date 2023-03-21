package com.lifegrip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lifegrip.genericUtility.WebDriverUtility;
/**
 * this class contains the webelemnt of add client page
 */

public class AddClientPage {
	@FindBy(name="client_id")
	private WebElement clientId;
	@FindBy(name="client_password")
	private WebElement clientPasswordTxtField;
	@FindBy(name="name")
	private WebElement clientNameTxtField;
	@FindBy(name="fileToUpload")
	private WebElement imageUploadButton;
	@FindBy(name="sex")
	private WebElement clientGender;
	@FindBy(name="birth_date")
	private WebElement clientBirthDate;
	@FindBy(name="maritial_status")
	private WebElement clientMaritalStatus;
	@FindBy(name="nid")
	private WebElement clientNationalIdTextField;
	@FindBy(name="phone")
	private WebElement  clientPhoneTextField;
	@FindBy(name="address")
	private WebElement  clientAddressTextField;
	@FindBy(name="policy_id")
	private WebElement  clientPolicyIdTextField;
	@FindBy(name="nominee_name")
	private WebElement nomineeNameTextField;
	@FindBy(name="nominee_sex")
	private WebElement  nominee_sexTextField;
	@FindBy(name="nominee_birth_date")
	private WebElement  nomineeBirthDateTextField;
	@FindBy(name="nominee_nid")
	private WebElement  nomineeNationalIdTextField;
	@FindBy(name="nominee_relationship")
	private WebElement  nominee_relationshipTextField;
	@FindBy(name="priority")
	private WebElement  priorityTextField;
	@FindBy(name="nominee_phone")
	private WebElement  nomineePhoneTextField;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement  submitButton;
	public AddClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * this method is used to get the client id
	 */
	public String clientID()
	{  
		String clientid=clientId.getAttribute("value");
		return clientid;

	}
	/**
	 * this method is used to enterClientPassword
	 * @param password
	 */
	public void enterClientPassword(String password)
	{
		clientPasswordTxtField.sendKeys(password);
	}
	/**
	 * this method is used to enterClientName
	 * @param name
	 */
	public void enterClientName(String name)
	{
		clientNameTxtField.sendKeys(name);
	}
	/**
	 * this method is used to upload the file
	 * @param webUtility
	 * @param path
	 */
	public void fileUpload(WebDriverUtility webUtility,String path)
	{
		webUtility.fileUpload(imageUploadButton,path);
	}
	/**
	 * this method is used to enterClientGender
	 * @param gender
	 */
	public void enterClientGender(String gender)
	{
		clientGender.sendKeys(gender);
	}
	/**
	 * this method is used to enterClientBirthDate
	 * @param birthDate
	 */
	public void enterClientBirthDate(String birthDate)
	{
		clientBirthDate.sendKeys(birthDate);
	}
	/**
	 * this method is used to enterClientMaritalStatus
	 * @param status
	 */
	public void enterClientMaritalStatus(String status)
	{
		clientMaritalStatus.sendKeys(status);
	}
	/**
	 *  this method is used to enterClientNationalId
	 * @param id
	 */
	public void enterClientNationalId(String id)
	{
		clientNationalIdTextField.sendKeys(id);
	}
	/**
	 *  this method is used to enterClientPhone
	 * @param phone
	 */
	public void enterClientPhone(String phone)
	{
		clientPhoneTextField.sendKeys(phone);
	}
	/**
	 * 
	 *  this method is used to enterClientAddress
	 * @param address
	 */
	public void enterClientAddress(String address)
	{
		clientAddressTextField.sendKeys(address);
	}
	public void enterClientPolicyId(String policyId)
	{
		clientPolicyIdTextField.sendKeys(policyId);
	}
	public void enterNomineeName(String policyId)
	{
		nomineeNameTextField.sendKeys(policyId);
	}
	public void enterNomineeGender(String gender)
	{
		nominee_sexTextField.sendKeys(gender);
	}
	public void enterNomineeBirthDate(String birthDate)
	{
		nomineeBirthDateTextField.sendKeys(birthDate);
	}
	public void enterNomineeNationalId(String id)
	{
		nomineeNationalIdTextField.sendKeys(id);
	}
	public void enterNomineeRelationship(String relation)
	{
		nominee_relationshipTextField.sendKeys(relation);
	}
	public void enterPriority(String priority)
	{
		priorityTextField.sendKeys(priority);
	}
	public void enterNomineePhone(String phone)
	{
		nomineePhoneTextField.sendKeys(phone);
	}
	public void clickOnSubmitButton()
	{
		submitButton.click();
	}





}
