
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Driver main class
 * @author Alex Juan
 *
 */
public class DriverFX extends Application {  
	/**
	 * The main method for the GUI JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		//  instantiate the FXMainPane, name it root
		FXMainPane root = new FXMainPane();
		//  set the scene to hold root
		stage.setScene(new Scene(root, 600,800));
		//set stage title
		stage.setTitle("Traveling Student");
		//display the stage
		stage.show();
	
	}

}