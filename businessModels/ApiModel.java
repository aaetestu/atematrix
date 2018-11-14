package businessModels;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import tools.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;

public class ApiModel {
	Consts data = new Consts();
	public ApiModel setEntitiesForEdit(HttpPost request, String entity, String value) throws UnsupportedEncodingException {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add(new BasicNameValuePair("CSRFName", "CSRFGuard_439317756"));
		  nameValuePairs.add(new BasicNameValuePair("CSRFToken", "832feab8561095a43c0fb67ae523eca7753ecc4f0fbf905afd39e256df85438ea70d9b34d66026d7413e5347f821756c0e8379cd48cac65399deffa505638970"));
		  nameValuePairs.add(new BasicNameValuePair("doAction", "editUser"));
		  nameValuePairs.add(new BasicNameValuePair("emailAddress", data.userEmail));
		  nameValuePairs.add(new BasicNameValuePair("firstName", "Admin"));
		  nameValuePairs.add(new BasicNameValuePair(entity, value));
		  nameValuePairs.add(new BasicNameValuePair("locale", "en_US"));
		  request.setEntity(new UrlEncodedFormEntity(nameValuePairs));	
		return this;
		
	}
	
	public ApiModel setEntitiesForLogin(HttpPost request) throws UnsupportedEncodingException {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add(new BasicNameValuePair("CSRFName", "CSRFGuard_439317756"));
		  nameValuePairs.add(new BasicNameValuePair("CSRFToken", "832feab8561095a43c0fb67ae523eca7753ecc4f0fbf905afd39e256df85438ea70d9b34d66026d7413e5347f821756c0e8379cd48cac65399deffa505638970"));
		  nameValuePairs.add(new BasicNameValuePair("tl_login", data.userName));
		  nameValuePairs.add(new BasicNameValuePair("tl_password", data.userPassword));
		  request.setEntity(new UrlEncodedFormEntity(nameValuePairs));	
		return this;
		
	}
	
	public ApiModel setHeadersForPost(HttpPost request, String origin, String referer) throws UnsupportedEncodingException {
	  request.addHeader("origin", origin);
	  request.addHeader("upgrade-insecure-requests", "1");
	  request.addHeader("content-type", "application/x-www-form-urlencoded");
	  request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
	  request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	  request.addHeader("referer", referer);
	  request.addHeader("accept-encoding", "gzip, deflate");
	  request.addHeader("accept-language", "en-US,en;q=0.9");
	  request.addHeader("cookie", "PHPSESSID=gv475ficrqp5hud9qbukrd9ol1; TESTLINK_USER_AUTH_COOKIE=e08c732dd9f1c643ee327f389e0ee120374af8dbd6b8c4caa340b626acfdd32a; PHPSESSID=gv475ficrqp5hud9qbukrd9ol1; TESTLINK_USER_AUTH_COOKIE=e08c732dd9f1c643ee327f389e0ee120374af8dbd6b8c4caa340b626acfdd32a");
	  request.addHeader("cache-control", "no-cache");
	return this;
	}
	
	public ApiModel setHeadersForGet(HttpGet request, String referer) throws UnsupportedEncodingException {
		  request.addHeader("upgrade-insecure-requests", "1");
		  request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
		  request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		  request.addHeader("referer", referer);
		  request.addHeader("accept-encoding", "gzip, deflate");
		  request.addHeader("accept-language", "en-US,en;q=0.9");
		  request.addHeader("cookie", "PHPSESSID=gv475ficrqp5hud9qbukrd9ol1; TESTLINK_USER_AUTH_COOKIE=e08c732dd9f1c643ee327f389e0ee120374af8dbd6b8c4caa340b626acfdd32a; PHPSESSID=gv475ficrqp5hud9qbukrd9ol1; TESTLINK_USER_AUTH_COOKIE=e08c732dd9f1c643ee327f389e0ee120374af8dbd6b8c4caa340b626acfdd32a");
		  request.addHeader("cache-control", "no-cache");
			return this;
		}
	
	public String getResponseAttributeValue(HttpClient client, HttpPost request, String flagKey, String flagValue, String attribute) throws ClientProtocolException, IOException {
		HttpResponse response = client.execute(request);
	      String body = EntityUtils.toString(response.getEntity());  
		  org.jsoup.nodes.Document doc = Jsoup.parse(body);
		  String value = doc.getElementsByAttributeValue(flagKey, flagValue).attr(attribute);
		return value;
		}
	
	public String getResponseElementText(HttpClient client, HttpPost request, String flagKey, String flagValue) throws ClientProtocolException, IOException {
		HttpResponse response = client.execute(request);
	      String body = EntityUtils.toString(response.getEntity());  
		  org.jsoup.nodes.Document doc = Jsoup.parse(body);
		  String value = doc.getElementsByAttributeValue(flagKey, flagValue).text();
		return value;
		}
}
