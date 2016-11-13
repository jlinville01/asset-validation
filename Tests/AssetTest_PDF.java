/*
 * Tests a pdf asset for correct url and response
 */

package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_objects.Login;
import page_objects.MyResources;
import page_objects.StandOut;

public class AssetTest_PDF extends StandOut
{
	@Before
	public void setUp()
	{
		super.setUp();
	}
    
	@Test
	public void runTest() throws Exception
	{
		// Login
	    this.login = new Login();
	    this.login.initialize(this.props, this.driver, this.baseUrl);
	    this.login.login(props.getProperty("defaultTL"), props.getProperty("defaultpassword"));
		driver.get(this.baseUrl + "/assetpage");
		
		String assetName = "PDF Asset";
		String grabDbUrl = "https://www.test.com/assets/testasset.pdf";
		
		// Instantiate AssetPage page object
		AssetPage assetpage = new AssetPage(this.driver);
		
		// Verify asset url
		String url = assetpage.verifyClickAsset_pdf(assetName, this.driver, this.baseUrl);
		assertEquals(grabDbUrl, url);
		
		// Verify asset url response
		String response = assetpage.verifyURLConnection(grabDbUrl);
		assertEquals("OK", response);
		
		// Logout
		this.login.logout();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}