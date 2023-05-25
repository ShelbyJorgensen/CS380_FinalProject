package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserLoginController {
	
	@FXML
	private TextField CustomerUsernameText;
	@FXML
	private Label UserLoginSuccess;
	
	public void UserLogin(ActionEvent event) throws Exception {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    PreparedStatement p = null;
	    ResultSet rs = null;

	    String sql = "SELECT * FROM users";
	    p = connection.prepareStatement(sql);
	    rs = p.executeQuery();
	    
	    boolean isValid = false;
	    // Check database for valid username
	    while (rs.next()) {
	        String name = rs.getString("username");
	        if(name.equals(CustomerUsernameText.getText())) {
	        	isValid = true;
	        	UserLoginSuccess.setText("Successful Login!");
	        }
	    }
		
	    if(isValid) {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/User.fxml"));
			Scene scene = new Scene(root, 700, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	    }
	}
}
