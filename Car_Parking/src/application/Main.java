package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	
	 private Parent root;
	
	@Override
	public void start(Stage stage){
		
			try {
					
					FXMLLoader loader=  new FXMLLoader(getClass().getResource("Scene1.fxml"));
					root= loader.load();
				
					Scene scene = new Scene (root);
					
					String css=this.getClass().getResource("application.css").toExternalForm();							
					scene.getStylesheets().add(css);					
					Image icon = new Image("download.png");		
					
					stage.getIcons().add(icon);					
					stage.setTitle("Smart Parking Portal");
					stage.setScene(scene);
					stage.setResizable(false);
					stage.show();
					
					stage.setOnCloseRequest(event-> {
						event.consume();
						logout(stage);
					});
				
		}catch(Exception e) {
			
		e.printStackTrace();
	}
}
	
 public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout!");
		alert.setContentText("Are you sure you want to exit?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
			
			//stage = (Stage) sceneExit.getScene().getWindow();
			System.out.println("You have successfully logged out!!");
			stage.close();
		}
		
 }
		
	public static void main (String[] args) {
		launch(args);

	}
		
}
	
	
		

