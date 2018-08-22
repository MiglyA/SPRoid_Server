public class Client {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("file.encoding"));

		String s = null;

		MobileSocket mobileSocket = new MobileSocket();

		mobileSocket.client(12345);

		while (true) {
			s = mobileSocket.subscribe();
			//System.out.println(s);
			if(s != null) System.out.println(s);
			try {
				Thread.sleep(10);  //0.01秒停止
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
	}
}
