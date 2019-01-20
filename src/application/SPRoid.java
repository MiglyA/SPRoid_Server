package application;

import controller.WaitController;
import javafx.application.Platform;
import javafx.scene.text.Text;

public class SPRoid {

	public String subscribe_string = null;
	public boolean launch = false;
	public Text subtitle;
	public boolean connected = false;

	public SPRoid(Text label_Output) {
		this.subtitle = label_Output;
	}

	public SPRoid() {
	}

	public boolean isLaunch() {
		return launch;
	}

	public void launch(WaitController waitController) {

		// スレッド
		new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println(System.getProperty("file.encoding"));

				MobileSocket mobileSocket = new MobileSocket();

				mobileSocket.client(12345);

				waitController.nextPage();

				while (true) {
					subscribe_string = mobileSocket.subscribe();
					if (subscribe_string != null) {
						System.out.println(subscribe_string);
						Platform.runLater(() -> {
							subtitle.setText(subscribe_string);
						});
					}

					try {
						Thread.sleep(10); // 0.01秒停止
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
