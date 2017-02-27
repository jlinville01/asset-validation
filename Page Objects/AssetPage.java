package page_objects;

import java.net.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page_objects.AbstractPageObject;

public class AssetPage extends AbstractPageObject
{
	@FindBy(css = "button.btn-primary.ok-button")
	private WebElement okButton;
	
	@FindBy(css = "h1")
	private WebElement header;
	
	@FindBy(css = "h3")
	private WebElement knowME;
	
	@FindBy(css = "//div[@id='content_wrapper']/div[2]/h3")
	private WebElement focusMe;
	
	@FindBy(css = "//div[@id='content_wrapper']/div[3]/h3")
	private WebElement engageMe;
	
	@FindBy(css = "//div[@id='content_wrapper']/div[4]/h3")
	private WebElement talentIntoPerformance;
	
	@FindBy(id = "tipvideosrc")
	private WebElement tipvideosrc;
	
	/**
	 * Instantiates the My Resources page object.
	 * 
	 * @param driver	the driver for this class.
	 * @throws Exception
	 */
	public AssetPage(WebDriver driver) throws Exception 
	{
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
	}
	
	/**
	 * Navigates to the My Resources page. 
	 *
	 * @param driver	the driver for this class.
	 * @param baseURL	the base url for this client.
	 * @throws Exception
	 */
	public void navigateAssetsPage(WebDriver driver, String baseURL) throws Exception
	{
		driver.get(baseURL + "/assetpage");
		wait.until(jQueryAJAXCallsHaveCompleted());
	}
	
	/**
	 * Completes onboarding for page
	 */
	public void onboardingMyResources()
	{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(okButton));
			okButton.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy("okButton")));
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	/**
	 * Pulls the current url address after clicking asset. 
	 *
	 * @param asset		the asset file being clicked.
	 * @param driver	the driver for this class.
	 * @param baseURL	the base url for this client.
	 */
	public String verifyClickAsset_pdf(String asset, WebDriver driver, String baseURL) throws Exception
	{
		String thisURL = null;
		try
		{
			driver.findElement(By.linkText(asset)).click();
			thisURL = driver.getCurrentUrl();
			driver.get(baseURL + "/assetpage");
	    	} 
	    	catch (Exception exc)
	    	{
			exc.printStackTrace();
	    	}
		return thisURL;
	}
	
	/**
	 * Pulls the current url address after clicking asset. 
	 *
	 * @param asset		the asset file being clicked.
	 * @param driver	the driver for this class.
	 * @param baseURL	the base url for this client.
	 */
	public String verifyClickAsset_video(String asset, WebDriver driver, String baseURL) throws Exception
	{
		String src = null;
		try
		{
			driver.findElement(By.linkText(asset)).click();
			src = tipvideosrc.getAttribute("src");
			driver.get(baseURL + "/assetpage");
		}
		catch (Exception exc)
	    	{
		      exc.printStackTrace();
		}
		return src;
	}
	
	/**
	 * Pulls the current url connection response message.
	 *
	 * @param Url	the url used to create a url connection.
	 */
	public String verifyURLConnection(String Url) throws Exception 
	{
		String resp = null;
		try
		{
			java.net.URL intendedUrl = new java.net.URL(Url);
			java.net.HttpURLConnection con = (HttpURLConnection) intendedUrl.openConnection();

			resp = con.getResponseMessage();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		return resp;
	}
	
	/**
	 * Returns whether the header text.
	 * 
	 * @return		string value;
	 */
	public String headerText()
	{
		try
		{
			return header.getText();
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * Returns whether the know me text.
	 * 
	 * @return		string value;
	 */
	public String knowMEText()
	{
		try
		{
			return knowME.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns whether the focus me text.
	 * 
	 * @return		string value;
	 */
	public String focusMeText()
	{
		try
		{
			return focusMe.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns whether the engage me text.
	 * 
	 * @return		string value;
	 */
	public String engageMeText()
	{
		try
		{
			return engageMe.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Returns whether the talent into performance header text.
	 * 
	 * @return		string value;
	 */
	public String talentIntoPerformanceText()
	{
		try
		{
			return talentIntoPerformance.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
}
