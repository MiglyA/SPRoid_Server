package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StartController {

	@FXML
	Label label1;

	@FXML
	Text title;

	@FXML
	Button btn1;

	@FXML
	protected void doAction(ActionEvent ev) {
		new Main().setPage("page2.fxml");
	}
}