package week3.assignments;

//Implementing the interface in a Concrete class
public abstract class JavaConnection implements DatabaseConnection {

	// Providing concrete implementations for the abstract methods in the Concrete
	// class
	@Override
	public void connect() {
		System.out.println("Java is connected");

	}

	@Override
	public void disconnect() {
		System.out.println("Java is disconnected");

	}

	@Override
	public void executeUpdate() {
		System.out.println("Excecute and update the value");

	}

}
