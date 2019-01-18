package application;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class Main extends Application {

	private static Stage stage;
	private Parent root;

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;
		setPage("./Start.fxml");
		Main.stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setPage(String path) {
		try {
			root = FXMLLoader.load(new File(path).toURI().toURL());
			stage.setScene(new Scene(root, 600, 600));
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
