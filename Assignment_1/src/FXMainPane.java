import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXMainPane is the GUI for the Password Checker application
 * @author Alex Juan
 *
 */
public class FXMainPane extends VBox{
	private Button checkPassBtn, checkPassInFileBtn, exitBtn;
	private Label passwordLbl, retypePasswordLbl;						
	private Label descr1, descr2, descr3, descr4, descr5, descr6;		//labels for the description rules
	private TextField passTxtField, retypePassTxtField;
	private HBox passHBox, retypePassHBox, checkHBox;
	private VBox vBox1;
		
	public FXMainPane(){
		
		//Set checkPasswordButton mnemonics and tool tip
		checkPassBtn = new Button();
		checkPassBtn.setText("Check _Password");
		checkPassBtn.setMnemonicParsing(true);
		checkPassBtn.setTooltip(new Tooltip("Checks the validity of your password"));
		
		//Set checkPasswordInFileButton mnemonics and tool tip
		checkPassInFileBtn = new Button();
		checkPassInFileBtn.setText("Check Password in _File");
		checkPassInFileBtn.setMnemonicParsing(true);
		checkPassInFileBtn.setTooltip(new Tooltip("Checks password from a text file"));
		
		//Set checkPasswordButton mnemonics and tool tip
		exitBtn = new Button();
		exitBtn.setText("E_xit");
		exitBtn.setMnemonicParsing(true);
		exitBtn.setTooltip(new Tooltip("Exit program"));
		
		//Create labels
		passwordLbl = new Label("Password");
		retypePasswordLbl = new Label("Re-type\nPassword");
		descr1 = new Label(" Use the following rules when creating your passwords:");
		descr2 = new Label("\t1. Length must be at least 6 characters (a string password will contain at least 10 characters)");
		descr3 = new Label("\t2. Must contain at least one upper case alpha character");
		descr4 = new Label("\t3. Must contain at least one lower case alpha character");
		descr5 = new Label("\t4. Must contain at least one numeric character");
		descr6 = new Label("\t5. May not have more than 2 of the same character in sequence");
		
		//Create textFields
		passTxtField = new TextField();
		retypePassTxtField = new TextField();
		
		//Create layout containers
		passHBox = new HBox(10);
		retypePassHBox = new HBox(10);
		checkHBox = new HBox();
		vBox1 = new VBox();
		
		
		//Set margin for the buttons
		HBox.setMargin(checkPassBtn, new Insets(5));
		HBox.setMargin(checkPassInFileBtn, new Insets(5));
		HBox.setMargin(exitBtn, new Insets(5));
		
		//Set padding
		passHBox.setPadding(new Insets(40,0,20,0));
		retypePassHBox.setPadding(new Insets(20,0,35,0));
		checkHBox.setPadding(new Insets(15,0,0,0));
		
		//Set alignment
		passHBox.setAlignment(Pos.CENTER);
		retypePassHBox.setAlignment(Pos.CENTER);
		checkHBox.setAlignment(Pos.CENTER);
		
		//Add the description labels to VBox
		vBox1.getChildren().addAll(descr1, descr2, descr3, descr4, descr5, descr6);
		//Add the password label and textfield to one of the HBoxes
		passHBox.getChildren().addAll(passwordLbl, passTxtField);
		///Add the retype password label and textfield to one of the HBoxes
		retypePassHBox.getChildren().addAll(retypePasswordLbl, retypePassTxtField);
		//Add the buttons to one of the HBoxes
		checkHBox.getChildren().addAll(checkPassBtn, checkPassInFileBtn, exitBtn);
		//Add the VBox and HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(vBox1, passHBox, retypePassHBox, checkHBox);
		setStyle("-fx-border-color: orange");							//Set border color
		
		
		checkPassBtn.setOnAction(new ButtonHandler());
		checkPassInFileBtn.setOnAction(new ButtonHandler());
		exitBtn.setOnAction(new ButtonHandler());
		
		
	}
	
	//Handle button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			//Alert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Password Status");
			alert.setHeaderText(null);
			
			if(checkPassBtn == event.getTarget()) {							//When user press checkPassword button
				String password = passTxtField.getText().trim();
				String retypePassword = retypePassTxtField.getText().trim();
				
				try {
					if(password.equals(retypePassword)) {
						PasswordCheckerUtility.isValidPassword(password);
						
						if(PasswordCheckerUtility.isWeakPassword(password)) {
							alert.setContentText("Password is OK but weak");
							alert.showAndWait();
						}
						else {
							alert.setContentText("Password is valid");
							alert.showAndWait();
						}
					}
					else {
						throw new UnmatchedException("The password do not match");
					}
				}
				catch(Exception e) {
					//Error display
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}
				
			}
			else if(checkPassInFileBtn == event.getTarget()) {				//When user press checkPassInFile button
				try {
					ArrayList<String> passwordList = new ArrayList<String>();
					FileChooser fileChooser = new FileChooser();
					File selectedFile = fileChooser.showOpenDialog(null);
					
					if(selectedFile != null) {
						Scanner scan = new Scanner(selectedFile);
						
						while(scan.hasNext()) {
							passwordList.add(scan.nextLine());
						}
						
						passwordList = PasswordCheckerUtility.invalidPasswords(passwordList);
						
						String illegalPasswords = "";
						alert.setTitle("Illegal Paawords");
						
						for(String pass: passwordList) {
							illegalPasswords += pass +"\n";
						}
						
						alert.setContentText(illegalPasswords);
						alert.showAndWait();
						scan.close();
					}
					
				}
				catch(FileNotFoundException e) {
					alert.setContentText("File Not Found");
					alert.showAndWait();
				}
				catch(Exception e) {
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}				
			}
			else if(exitBtn == event.getTarget()) {						//When user press the exit button
				Platform.exit();
				System.exit(0);
			}
		}
		
	}
	
	
}
