package application;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	private static Stage stage;
	private Parent root;

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;
		root = FXMLLoader.load(new File("./Start.fxml").toURI().toURL());
		Scene scene = new Scene(root);
		stage.setScene(scene);
		Main.stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setPage(String path, StageStyle style) {
		try {
			// window削除
			stage.getScene().getWindow().hide();
			// 新しく生成
			stage = new Stage();
			root = FXMLLoader.load(new File(path).toURI().toURL());
			Scene scene = new Scene(root);
			stage.initStyle(style);
			if (style == StageStyle.TRANSPARENT) {
				scene.setFill(null);
			}
			stage.setScene(scene);
			Main.stage.show();
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
