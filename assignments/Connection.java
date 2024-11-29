package week3.assignments;

//Creating  execution class that inherits subclass
public class Connection extends JavaConnection {

	public static void main(String[] args) {

		// Creating a object and calling the interface methods
		Connection data = new Connection();
		data.connect();
		data.disconnect();
		data.executeUpdate();
	}

}
