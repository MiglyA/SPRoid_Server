package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;

public class WaitController implements Initializable {

	@FXML
	ProgressIndicator progress;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress.setMaxWidth(100);
	}
}