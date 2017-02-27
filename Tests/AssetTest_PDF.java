
/*
 * Tests a pdf asset for correct url and response
 */

package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AssetTest_PDF extends AbstractTest
{
	@Test
	public void runTest() throws Exception
	{
		// Login
    		app.login.login(props.getProperty("defaultTL"), props.getProperty("defaultpassword"));
		driver.get(this.baseUrl + "/assetpage");
		
		String assetName = "PDF Asset";
		String grabDbUrl = "https://www.test.com/assets/testasset.pdf";
		
		// Verify asset url
		String url = app.assetPage.verifyClickAsset_pdf(assetName, this.driver, this.baseUrl);
		assertThat(url, is(grabDbUrl));
		
		// Verify asset url response
		String response = app.assetPage.verifyURLConnection(grabDbUrl);
		assertThat(response, is("OK"));
		
		// Logout
		app.login.logout();
	}
}
