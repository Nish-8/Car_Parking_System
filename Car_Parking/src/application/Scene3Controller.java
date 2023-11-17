package application;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene3Controller  {
	
	@FXML
	Label slot_Label;
	@FXML
	Label plate_Label;
	@FXML
	Label name_Label;
	@FXML
	Label entry_Label;
	@FXML
	Label exit_Label;
	@FXML
	Label payment_Label;
	@FXML
	Label amount_Label;
	@FXML
	Label date_Label;
	
	

	@FXML
	Label slot_Label1;
	@FXML
	Label plate_Label1;
	@FXML
	Label name_Label1;
	@FXML
	Label entry_Label1;
	@FXML
	Label exit_Label1;
	@FXML
	Label payment_Label1;
	@FXML
	Label amount_Label1;
	@FXML
	Label date_Label1;
	
	@FXML
	Label slot_Label2;
	@FXML
	Label plate_Label2;
	@FXML
	Label name_Label2;
	@FXML
	Label entry_Label2;
	@FXML
	Label exit_Label2;
	@FXML
	Label payment_Label2;
	@FXML
	Label amount_Label2;
	@FXML
	Label date_Label2;
	
	@FXML
	Label slot_Label3;
	@FXML
	Label plate_Label3;
	@FXML
	Label name_Label3;
	@FXML
	Label entry_Label3;
	@FXML
	Label exit_Label3;
	@FXML
	Label payment_Label3;
	@FXML
	Label amount_Label3;
	@FXML
	Label date_Label3;
	
	public void load_Details() {
		
		
		Connection con;
		Statement st;
		
		try {
			
			Class.forName("org.postgresql.Driver");
	    	
	    	con= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","nd123");
	    	String query="Select * from Input";
			st= con.createStatement();
			int i=0;
			ResultSet rs=st.executeQuery(query);
			while (rs.next()) {
				
				String name= rs.getString("name");
				String slot_no= rs.getString("slot_no");
				String plate_no= rs.getString("plate_no");
				String entry_time= rs.getString("entry_time");
				String departure_time= rs.getString("departure_time");
				String payment_mode= rs.getString("payment_mode");
				String amount= rs.getString("amount");
				String date= rs.getString("date");
				
				i++;
				
				if(i==1) {
					
					
					name_Label.setText(name);
					slot_Label.setText(slot_no);
					plate_Label.setText(plate_no);
					entry_Label.setText(entry_time);
					exit_Label.setText(departure_time);
					payment_Label.setText(payment_mode);
					amount_Label.setText(amount);
					date_Label.setText(date);
					
				}else if(i==2) {
					
					
					name_Label1.setText(name);
					slot_Label1.setText(slot_no);
					plate_Label1.setText(plate_no);
					entry_Label1.setText(entry_time);
					exit_Label1.setText(departure_time);
					payment_Label1.setText(payment_mode);
					amount_Label1.setText(amount);
					date_Label1.setText(date);
					
				}else if (i==3) {
					
					
					name_Label2.setText(name);
					slot_Label2.setText(slot_no);
					plate_Label2.setText(plate_no);
					entry_Label2.setText(entry_time);
					exit_Label2.setText(departure_time);
					payment_Label2.setText(payment_mode);
					amount_Label2.setText(amount);
					date_Label2.setText(date);
					
					
				}else {
					
					name_Label3.setText(name);
					slot_Label3.setText(slot_no);
					plate_Label3.setText(plate_no);
					entry_Label3.setText(entry_time);
					exit_Label3.setText(departure_time);
					payment_Label3.setText(payment_mode);
					amount_Label3.setText(amount);
					date_Label3.setText(date);
					
				}
			}
			
			
			
			
		}catch (Exception e){
			
			
		e.printStackTrace();			
		}
	
	}


	@FXML
	private AnchorPane sceneExit;

	private Stage stage;
	private Scene scene;
	private Parent root;

	public void logout(ActionEvent event) throws IOException {
		
 		
		 Parent root= FXMLLoader.load(getClass().getResource("Scene1.fxml")); 
		 stage= (Stage)((Node)event.getSource()).getScene().getWindow(); 	
 		
 		scene=new Scene(root);
 		stage.setScene(scene);
 		stage.show();	 
	   		
	
}
	
	public void switchToScene2(ActionEvent event) throws IOException {
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Scene2.fxml"));
		root=loader.load();
	   	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene=new Scene(root);
	   	stage.setScene(scene);
	   	stage.show();
   		
}
	
	public void clearTable(ActionEvent event) throws IOException{
		
		Connection con;
		Statement st;
		
		try {
		Class.forName("org.postgresql.Driver");	
		con= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","nd123");
		st= con.createStatement();
		String s2="truncate table Input";
		st.executeUpdate(s2);
		
		

		name_Label.setText(null);
		slot_Label.setText(null);
		plate_Label.setText(null);
		entry_Label.setText(null);
		exit_Label.setText(null);
		payment_Label.setText(null);
		amount_Label.setText(null);
		date_Label.setText(null);
		
		
		
		name_Label2.setText(null);
		slot_Label2.setText(null);
		plate_Label2.setText(null);
		entry_Label2.setText(null);
		exit_Label2.setText(null);
		payment_Label2.setText(null);
		amount_Label2.setText(null);
		date_Label2.setText(null);
		
		
		name_Label1.setText(null);
		slot_Label1.setText(null);
		plate_Label1.setText(null);
		entry_Label1.setText(null);
		exit_Label1.setText(null);
		payment_Label1.setText(null);
		amount_Label1.setText(null);
		date_Label1.setText(null);
		
		
		name_Label3.setText(null);
		slot_Label3.setText(null);
		plate_Label3.setText(null);
		entry_Label3.setText(null);
		exit_Label3.setText(null);
		payment_Label3.setText(null);
		amount_Label3.setText(null);
		date_Label3.setText(null);
		
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
}
	
	



