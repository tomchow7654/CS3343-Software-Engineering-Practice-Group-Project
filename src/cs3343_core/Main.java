package cs3343_core;

public class Main {

	public static void main(String args[]) {
		System.out.println("Welcome to CS3343 Software Engineering Practice Group Project.");
		CentralManager.getInstance().setup();
		CentralManager.getInstance().checkNodeConnectivity();
	}

}
