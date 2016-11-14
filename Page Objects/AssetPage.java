package page_objects;

import java.net.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetPage
{
	@FindBy(id = "tipvideosrc")
	private WebElement tipvideosrc;
	
	public AssetPage(WebDriver driver) throws Exception 
	{
		PageFactory.initElements(driver, this);
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
}
