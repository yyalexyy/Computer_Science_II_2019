
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * GUI JavaFX Driver
 * @author Alex Juan
 *
 */
public class GUIDriver extends Application {
	
	private RadioButton createFromFile, createFromText;
	private ToggleGroup myToggleGroup;
	private Button createConcordanceBtn, selectInputFileBtn, selectOutputFileBtn, clearBtn, exitBtn;
	private HBox radioPane, buttonPane;
	private TextArea displayTextArea;
	
	private File inputFile, outputFile;
	private ConcordanceDataManager cDataManager = new ConcordanceDataManager();
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage stage) throws IOException {
		
		//Main Pane
		VBox mainPane = new VBox();
		
		//Create radio button
		myToggleGroup = new ToggleGroup();
		createFromFile = new RadioButton("Create Concordance from File");
		createFromText = new RadioButton("Create Concordance from Text");
		createFromFile.setToggleGroup(myToggleGroup);
		createFromText.setToggleGroup(myToggleGroup);
		
		
		//Create buttons
		createConcordanceBtn = new Button("Create Concordance");
		selectInputFileBtn = new Button("Select Input File");
		selectOutputFileBtn = new Button("Select Output File");
		clearBtn = new Button("Clear");
		exitBtn = new Button("Exit");
		
				
		//Create Text Area
		displayTextArea = new TextArea();
		displayTextArea.setMaxWidth(500);
		displayTextArea.setStyle("-fx-font-size:13");
		
				
		//Create HBox
		radioPane = new HBox(10);
		radioPane.getChildren().addAll(createFromFile, createFromText);
		radioPane.setPadding(new Insets(10, 10, 10, 10));
		
		buttonPane = new HBox(10);
		buttonPane.getChildren().addAll(createConcordanceBtn, selectInputFileBtn, selectOutputFileBtn, clearBtn, exitBtn);
		buttonPane.setPadding(new Insets(20, 10, 5, 10));
		buttonPane.setAlignment(Pos.BOTTOM_CENTER);
		
		
		TitledPane addTitlePane = new TitledPane("Please Select from Following Options:", radioPane);
		addTitlePane.setCollapsible(false);
		addTitlePane.setMaxWidth(500);
		addTitlePane.setPadding(new Insets(0, 0, 5, 0));
		
		
		TitledPane textTitlePane = new TitledPane("Enter Text:", displayTextArea);
		textTitlePane.setCollapsible(false);
		textTitlePane.setMaxWidth(500);
		textTitlePane.setPadding(new Insets(0, 0, 5, 0));
		
		
		
		
		createFromFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(createFromFile.isSelected()) {
					createConcordanceBtn.setDisable(true);
					selectInputFileBtn.setDisable(false);
					selectOutputFileBtn.setDisable(true);
					textTitlePane.setVisible(false);
				}
			}
		});
		
		createFromText.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(createFromText.isSelected()) {
					createConcordanceBtn.setDisable(false);
					selectInputFileBtn.setDisable(true);
					selectOutputFileBtn.setDisable(true);
					textTitlePane.setVisible(true);
					displayTextArea.setVisible(true);

				}
			}
		});
		
		createConcordanceBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				if(createFromFile.isSelected()) {
					try {
						cDataManager.createConcordanceFile(inputFile, outputFile);
					}
					catch(FileNotFoundException fileE) {
						fileE.printStackTrace();
					}
				}
				else {
					ArrayList<String> words = new ArrayList<String>();
					String textDaata = displayTextArea.getText();
					String concordanceText = "";
					
					words = cDataManager.createConcordanceArray(textDaata);
					
					for(int i = 0; i < words.size(); i++) {
						concordanceText += words.get(i);
					}
					
					displayTextArea.setText(concordanceText);
				}
				
			}
			
		});
				
		selectInputFileBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();	
				FileChooser.ExtensionFilter extendFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extendFilter);
				
				inputFile = fileChooser.showOpenDialog(null);

				if(inputFile != null) {
					createConcordanceBtn.setDisable(true);
					selectOutputFileBtn.setDisable(false);
				}
			}
			
		});
		
		selectOutputFileBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);
				
				outputFile = fileChooser.showOpenDialog(null);

				if(outputFile != null) {
					createConcordanceBtn.setDisable(false);

				}
			}
			
		});
						
		clearBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				displayTextArea.clear();
			}
			
		});
				
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		
		mainPane.getChildren().addAll(addTitlePane, textTitlePane, buttonPane);
		displayTextArea.setVisible(false);
		
		
		Scene scene = new Scene(mainPane, 500, 400);
		stage.setScene(scene);
		stage.setTitle("Concordance Generator");
		stage.show();
	}
}
