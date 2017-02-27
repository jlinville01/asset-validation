/*
 * Tests a video asset for correct url and response
 */

package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AssetTest_Video extends AbstractTest
{
	@Test
	public void runTest() throws Exception
	{
		// Login
    		app.login.login(props.getProperty("defaultTL"), props.getProperty("defaultpassword"));
		driver.get(this.baseUrl + "/assetpage");
		
		String assetName = "Video Asset";
		String grabDbUrl = "https://www.test.com/assets/testasset.mp4";
		
		// Verify asset url
		String url = app.assetPage.verifyClickAsset_video(assetName, this.driver, this.baseUrl);
		assertThat(url, is(grabDbUrl));
		
		// Verify asset url response
		String response = app.assetPage.verifyURLConnection(grabDbUrl);
		assertThat(response, is("OK"));
		
		// Logout
		app.login.logout();
	}
}
