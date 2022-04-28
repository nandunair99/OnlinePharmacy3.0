package com.narola.pharmacy.customer;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoClass {

	/*
	 * public static void main(String[] args) {
	 * 
	 * try { HttpClient client = new DefaultHttpClient(); HttpGet request = new
	 * HttpGet("https://www.google.com/account/about/"); HttpResponse response;
	 * response = client.execute(request); BufferedReader rd; rd = new
	 * BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	 * String textView = ""; String line = ""; while ((line = rd.readLine()) !=
	 * null) { textView = textView+line; } System.out.println(textView); } catch
	 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * catch (UnsupportedOperationException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void main(String[] args) {

		/*
		 * HttpGet request = new HttpGet("https://httpbin.org/get");
		 * 
		 * // add request headers request.addHeader("custom-key", "mkyong");
		 * request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
		 * 
		 * try (CloseableHttpClient httpClient = HttpClients.createDefault();
		 * CloseableHttpResponse response = httpClient.execute(request)) {
		 * 
		 * // Get HttpResponse Status System.out.println(response.getProtocolVersion());
		 * // HTTP/1.1 System.out.println(response.getStatusLine().getStatusCode()); //
		 * 200 System.out.println(response.getStatusLine().getReasonPhrase()); // OK
		 * System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK
		 * 
		 * HttpEntity entity = response.getEntity(); if (entity != null) { // return it
		 * as a String String result = EntityUtils.toString(entity);
		 * System.out.println(result); }
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * try { String result = sendPOST("https://httpbin.org/post");
		 * System.out.println(result); } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * private static String sendPOST(String url) throws IOException {
		 * 
		 * String result = ""; HttpPost post = new HttpPost(url);
		 * 
		 * // add request parameters or form parameters List<NameValuePair>
		 * urlParameters = new ArrayList<>(); urlParameters.add(new
		 * BasicNameValuePair("username", "abc")); urlParameters.add(new
		 * BasicNameValuePair("password", "123")); urlParameters.add(new
		 * BasicNameValuePair("custom", "secret"));
		 * 
		 * post.setEntity(new UrlEncodedFormEntity(urlParameters));
		 * 
		 * try (CloseableHttpClient httpClient = HttpClients.createDefault();
		 * CloseableHttpResponse response = httpClient.execute(post)){
		 * 
		 * result = EntityUtils.toString(response.getEntity()); }
		 * 
		 * return result;
		 */
		/*
		 * try { String result = sendPOST("https://httpbin.org/post");
		 * System.out.println(result); } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * private static String sendPOST(String url) throws IOException {
		 * 
		 * String result = ""; HttpPost post = new HttpPost(url);
		 * 
		 * StringBuilder json = new StringBuilder(); json.append("{");
		 * json.append("\"name\":\"mkyong\","); json.append("\"notes\":\"hello\"");
		 * json.append("}");
		 * 
		 * RequestConfig requestConfig = RequestConfig.custom()
		 * .setConnectionRequestTimeout(5000) .setConnectTimeout(5000)
		 * .setSocketTimeout(5000) .build();
		 * 
		 * post.setConfig(requestConfig); // send a JSON data post.setEntity(new
		 * StringEntity(json.toString()));
		 * 
		 * try (CloseableHttpClient httpClient = HttpClients.createDefault();
		 * CloseableHttpResponse response = httpClient.execute(post)) {
		 * 
		 * result = EntityUtils.toString(response.getEntity()); }
		 * 
		 * return result; }
		 */
		/*
		 * ObjectMapper mapper = new ObjectMapper(); OrderBean ob = new OrderBean();
		 * CustomerBean cb = new CustomerBean(); ob.setTestId(1); ob.setMedId(1);
		 * ob.setOrderId(1); cb.setFirstName("nandakrishnan nair");
		 * cb.setLastName("nair"); cb.setGender("male");
		 * cb.setEmailId("nun@narola.email"); ob.setCustomerBean(cb);
		 * 
		 * try { String result =
		 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ob);
		 * System.out.println(result);
		 * 
		 * CustomerBean cb2 = mapper.readValue(result, CustomerBean.class);
		 * System.out.println(cb2);
		 * 
		 * } catch (JsonProcessingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://www.boredapi.com/api/activity");
		
	    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
	}

}
