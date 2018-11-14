package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import businessModels.ApiModel;
import tools.Consts;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiTests {
	ApiModel api = new ApiModel();
	Consts data = new Consts();

	@Test
	public void testUserAccountUpdate() throws IOException {
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request1 = new HttpGet(data.testlinkURL + "/testlink/login.php");
		api.setHeadersForGet(request1, data.testlinkURL + "/testlink/");

		HttpPost request2 = new HttpPost(data.testlinkURL + "/testlink/login.php?viewer=");
		api.setEntitiesForLogin(request2);
		api.setHeadersForPost(request2, data.testlinkURL, data.testlinkURL + "/testlink/login.php");
		client.execute(request2);

		HttpGet request3 = new HttpGet(data.testlinkURL + "/testlink/index.php?caller=login&viewer=");
		api.setHeadersForGet(request3, data.testlinkURL + "/testlink/");

		HttpGet request4 = new HttpGet(
				data.testlinkURL + "/testlink/lib/general/navBar.php?tproject_id=0&tplan_id=0&updateMainPage=1");
		api.setHeadersForGet(request4, data.testlinkURL + "/testlink/index.php?caller=login&viewer=");

		HttpGet request5 = new HttpGet(data.testlinkURL + "/testlink/lib/general/mainPage.php");
		api.setHeadersForGet(request5, data.testlinkURL + "/testlink/index.php?caller=login&viewer=");

		HttpGet request6 = new HttpGet(data.testlinkURL + "/testlink/lib/usermanagement/userInfo.php");
		api.setHeadersForGet(request6,
				data.testlinkURL + "/testlink/lib/general/navBar.php?tproject_id=0&tplan_id=0&updateMainPage=1");

		HttpPost request7 = new HttpPost(data.testlinkURL + "/testlink/lib/usermanagement/userInfo.php");
		String entityKey = "lastName";
		String entityValue = "Administrator3";
		api.setEntitiesForEdit(request7, entityKey, entityValue);
		api.setHeadersForPost(request7, data.testlinkURL,
				data.testlinkURL + "/testlink/lib/usermanagement/userInfo.php");

		Assert.assertEquals(api.getResponseAttributeValue(client, request7, "name", "lastname", "value"),
				"Administrator4");

	}
}
