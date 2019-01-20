package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class StartController implements Initializable {

	@FXML
	Text title;

	@FXML
	Button nox_button;

	@FXML
	Button android_button;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	protected void onClick_nox(ActionEvent ev) {
		new Main().setPage("./Wait.fxml", StageStyle.UNDECORATED, false);
	}

	@FXML
	protected void onClick_android(ActionEvent ev) {
		new Main().setPage("./Wait.fxml", StageStyle.UNDECORATED, false);
		android_adb(System.getProperty("os.name").toLowerCase());
	}

	private void android_adb(String os) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				ProcessBuilder pb = null;
				try {
					switch (os) {
					case "windows":
						pb = new ProcessBuilder("../android_adb/windows/adb.exe", "forward", "tcp:12345", "tcp:12345");
						break;
					case "mac":
						pb = new ProcessBuilder("../android_adb/mac/adb", "forward", "tcp:12345", "tcp:12345");
						break;
					case "linux":
						pb = new ProcessBuilder("../android_adb/linux/adb", "forward", "tcp:12345", "tcp:12345");
						break;
					}
					pb.redirectErrorStream(true);
					Process process = pb.start();
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
					while (br.readLine() != null) {
						if (!br.readLine().contains("successfully")) {
							System.out.println("adb not successfully");
							System.exit(1);
						}
					}
				} catch (Exception e) {
					System.out.println("adb Error");
					System.exit(1);
				}
			}
		}).start();
	}
}