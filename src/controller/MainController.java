package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class MainController implements Initializable {

	@FXML
	Text subtitle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.spRoid.subtitle = subtitle;
	}
}