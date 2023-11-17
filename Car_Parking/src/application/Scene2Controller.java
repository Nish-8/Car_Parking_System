package application; 


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Scene2Controller {
	
	@FXML
	Label lable_welcome;
	
	 @FXML
	 TextField slot_Label;
	
	public void displayName(String username) {
		
		lable_welcome.setText("Welcome: "+ username);
	}
	
	
	String name ,slot_no, plate_no, entry_time, departure_time ,amount ,date,payment_mode;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
	private Label Lable1;
	
	@FXML
	private TextField slotInput;
	
	@FXML
	private TextField plateInput;
	
	@FXML
	private TextField nameInput;
	
	@FXML
	private TextField entryInput;
	
	@FXML
	
	private TextField exitInput;
	
	@FXML
	private TextField paymentInput;
	
	@FXML
	private TextField amountInput;
	
	@FXML
	private	TextField dateInput;
	

	
	public void switchToScene1(ActionEvent event) throws IOException {
				FXMLLoader loader= new FXMLLoader(getClass().getResource("Scene1.fxml"));
				root=loader.load();
	    		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	    		scene=new Scene(root);
	    		stage.setScene(scene);
	    		stage.show();	    		
	    		
	    	}
	 	 
	 public void switchToScene3(ActionEvent event) throws IOException {
		 		
		 Parent root= FXMLLoader.load(getClass().getResource("Scene4.fxml")); 
		 stage= (Stage)((Node)event.getSource()).getScene().getWindow(); 	
 		
 		scene=new Scene(root);
 		stage.setScene(scene);
 		stage.show();	 
 		
	    	}
	 

	public void insertDetails (ActionEvent event) throws IOException {
		
	String name, payment, date,amount, entry,exit,slot_no,plate_no;
	
	slot_no= slotInput.getText();
	plate_no= plateInput.getText();
	name = nameInput.getText();
	entry= entryInput.getText();
	exit= exitInput.getText();
	payment= paymentInput.getText();
	amount= amountInput.getText();
	date= dateInput.getText();
		 
    Connection con;
    PreparedStatement pst;
    Statement s;
    
    int count=0;
    
    
    try {
    	
    	Class.forName("org.postgresql.Driver");
    	
    	con= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","nd123");
    	s=con.createStatement();
    	String s1="Select COUNT(slot_no)from Input";
    	ResultSet rs=s.executeQuery(s1);
    	
    	while(rs.next()) {
    		
    		count=rs.getInt(1);
    		
    	}
    	
    	if(count<4) {
		
		pst=con.prepareStatement("insert into Input values (?,?,?,?,?,?,?,?)");
		pst.setString(1,name);
		pst.setString(2,slot_no);
		pst.setString(3,plate_no);
		pst.setString(4,entry);
		pst.setString(5,exit);
		pst.setString(6,payment);
		pst.setString(7,amount);
		pst.setString(8,date);
		
		int a = pst.executeUpdate();
		
		if (a==1) {
			
			Lable1.setText("Values inserted successfully!");
			
		}else {
			
			Lable1.setText("Insertion Unsuccessfully!!");
			
		}
    	}else {
    		
    		Lable1.setText("Slots are Full!!");
    		
    		
    	}
		
    }catch (Exception e) {
    	
    	e.printStackTrace();
    	Lable1.setText("Enter all Values");
    	
    	
    	System.out.println(updateCount(1));
    }

 }
	
	
	
	public int check_cars() {
		Connection con;
	    PreparedStatement pst;
		int num = 0;
		try {
    	Class.forName("org.postgresql.Driver"); 	
    	con= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","nd123");
		pst=con.prepareStatement("SELECT check_ FROM Verify");
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			num = rs.getInt("check_");
		}
		con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return num;
	}
		
	public int updateCount(int num) {
		int n = num+1;
		Connection conn;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres\",\"postgres\",\"nd123");
			String query = "UPDATE Verify SET count_ = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num+1);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return n;
	}


}
	
	
	
	
	
	

