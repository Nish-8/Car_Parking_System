package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller implements Initializable{
	
	private Parent root;
	Stage stage;
	Scene scene;
	 
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
	
    @FXML
    private Button btnok;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;

    @FXML
    void login(ActionEvent event) throws IOException {
    	
    	 String passDB= null;   	
    	 String uname = txtuname.getText();
    	 String pass = txtpass.getText();
    	 
    	 if (uname.equals("") && pass.equals("")) {
    		 
    		 JOptionPane.showMessageDialog(null, "UserName or Password Blank");
    	
    	 } else {
    		 
    		try {
    			 
				Class.forName("org.postgresql.Driver");
				
				try {
					
					con= DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","nd123");
					pst=con.prepareStatement("select * from Login where username=?");
					pst.setString(1, uname);
					//pst.setString(2, pass);
					
					rs=pst.executeQuery();
					
					while(rs.next()) {
						
						 passDB=rs.getString("password");
					
					}
					
					if(passDB.equals(pass)) {
						
						String username = txtuname.getText();
						FXMLLoader loader =new FXMLLoader(getClass().getResource("Scene2.fxml"));
						root=loader.load();
						
						Scene2Controller scene2Controller=loader.getController();
						scene2Controller.displayName(username);
						
						//Parent root = (Parent) FXMLLoader.load(getClass().getResource("Scene2.fxml"));
						stage =(Stage)((Node)event.getSource()).getScene().getWindow();
						scene=new Scene(root);
						stage.setScene(scene);
						stage.show();

					}else {
						
						JOptionPane.showMessageDialog(null, "Login Failed");
				
						txtuname.setText("");
						txtpass.setText("");
							txtuname.requestFocus();
					
					}
				
				} catch (SQLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			
			} catch (ClassNotFoundException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

    		 catch (Exception e) {
    			 
    			e.printStackTrace();
    			 
    			JOptionPane.showMessageDialog(null, "Login Failed");
 				
				txtuname.setText("");
				txtpass.setText("");
				txtuname.requestFocus();
    			 
    			 
    		 }
    	 }
    		 
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
