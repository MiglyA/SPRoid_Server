import java.util.Scanner;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		MobileSocket mobileSocket = new MobileSocket();

		mobileSocket.server(12345);

		while (true) {
			mobileSocket.publishe((new Scanner(System.in)).nextLine());
		}
	}
}
