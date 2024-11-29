package week3.assignments;

public class APIClient {

	// Defining SendReuest method with one argument
	public void sendRequest(String endPoint) {
		System.out.println("URL of the page is:" + endPoint);
	}

	// Defining SendReuest method with two arguments
	public void sendRequest(String endPoint, String requestBody) {
		System.out.println("URL of the page is:" + endPoint + "\n" + "Data of the URL is:" + requestBody);

	}

	// Defining SendReuest method with three arguments
	public void sendRequest(String endPoint, String requestBody, boolean requestStatus) {
		System.out.println("URL of the page is:" + endPoint + "\n" + "Data of the URL is:" + requestBody + "\n"
				+ "Status of the URL is:" + requestStatus);

	}

	// Creating main method to overload
	public static void main(String[] args) {

		// Creating object for the class
		APIClient api = new APIClient();

		// Calling the methods with diff arguments
		api.sendRequest("www.google.com");
		api.sendRequest("www.google.com", "Data");
		api.sendRequest("www.google.com", "Data", true);
	}

}
