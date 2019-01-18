package application;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class SPRoid {

	public String subscribe_string = null;
	public boolean launch = false;
	public Label label;

	public SPRoid(Label label_Output) {
		this.label = label_Output;
	}

	public boolean isLaunch() {
		return launch;
	}

	public void launch() {

		// スレッド
		new Thread(new Runnable() {
			@Override
			public void run() {

				launch = true;

				System.out.println(System.getProperty("file.encoding"));

				MobileSocket mobileSocket = new MobileSocket();

				mobileSocket.client(12345);

				while (true) {
					subscribe_string = mobileSocket.subscribe();
					if (subscribe_string != null) {
						System.out.println(subscribe_string);
						Platform.runLater(() -> {
							label.setText(subscribe_string);
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
