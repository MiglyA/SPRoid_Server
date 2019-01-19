package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

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
		new Main().setPage("./Wait.fxml", StageStyle.UNDECORATED);
	}

	@FXML
	protected void onClick_android(ActionEvent ev) {
		android_adb(System.getProperty("os.name").toLowerCase());
		new Main().setPage("./Wait.fxml", StageStyle.UNDECORATED);
	}

	public static void printInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			String line;
			do {
				line = br.readLine();
				System.out.println(line);
			} while (line != null);
		} finally {
			br.close();
		}
	}

	private void android_adb(String os) {
		ProcessBuilder pb = null;
		try {
			switch (os) {
			case "windows":
				pb = new ProcessBuilder("../android_adb/linux/adb", "forward", "tcp:12345", "tcp:12345");
				break;
			case "mac":
				pb = new ProcessBuilder("../android_adb/linux/adb", "forward", "tcp:12345", "tcp:12345");
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
					System.out.println("adb Error");
					System.exit(1);
				}
			}
		} catch (Exception e) {
			System.out.println("adb Error");
			System.exit(1);
		}

	}
}