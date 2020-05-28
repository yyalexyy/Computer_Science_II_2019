import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Driver for the Password Checker in JavaFx
 * @author Alex Juan
 *
 */
public class FXDriver extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException {
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 550, 330));
		stage.setTitle("Password Checker");			//Set the title of the stage
		stage.show();
	}

}
