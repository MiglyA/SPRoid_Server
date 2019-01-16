package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FormController {
	@FXML private TextField field_Name;
	@FXML private Button button_Enter;
	@FXML private Label label_Output;

	@FXML public void onButtonClicked() {
		label_Output.setText("Hello "+ field_Name.getText()+ " !!");
	}
}