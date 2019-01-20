package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.SPRoid;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.StageStyle;

public class WaitController implements Initializable {

	private SPRoid sproid;

	@FXML
	ProgressIndicator progress;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		progress.setMaxWidth(100);
		sproid = new SPRoid();
		sproid.launch(this);
	}

	public void nextPage() {
		Main main = new Main();
		main.setSPRoid(sproid);
		Platform.runLater(() -> {
			main.setPage("./Main.fxml", StageStyle.TRANSPARENT, true);
		});
	}
}