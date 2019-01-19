package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

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
		Main main = new Main();
		main.transparent();
	
		main.setPage("./Wait.fxml");
	}

	@FXML
	protected void onClick_android(ActionEvent ev) {
		new Main().setPage("Android.fxml");
	}
}