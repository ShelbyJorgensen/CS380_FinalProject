package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageFlightsController {

    @FXML
    private Button CancelButton;
    @FXML
    private TextField CancelCustomerID;
    @FXML
    private TextField CancelFlightID;
    @FXML
    private TextField UpdateCustomerID;
    @FXML
    private TextArea FlightView;
    @FXML
    private TextField OldFlightID;
    @FXML
    private Button UpdateFlights;
    @FXML
    private TextField NewFlightID;
    @FXML
    private Button ViewFlightsButton;
    
    private static final String SQL_INSERT = "INSERT INTO user_flights(id, flight_id, date, destination) VALUES(?,?,?,?)";
    
    @FXML
    void CancelFlight(ActionEvent event) {
    	Connection connection = null;
		PreparedStatement p1 = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "");
			int customer_id = Integer.parseInt(CancelCustomerID.getText());
			int flight_id = Integer.parseInt(CancelFlightID.getText());
			
			// Drop old flight from user database
			String dropSql = "DELETE FROM user_flights WHERE flight_id = ?";
			p1 = connection.prepareStatement(dropSql);
			p1.setInt(1, flight_id);
			p1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }

    @FXML
    void UpdateFlight(ActionEvent event) throws SQLException {
    	Connection connection = null;
		PreparedStatement p1 = null;
	    ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int customer_id = Integer.parseInt(UpdateCustomerID.getText());
		int old_flight_id = Integer.parseInt(OldFlightID.getText());
		int new_flight_id = Integer.parseInt(NewFlightID.getText());
		
		// Drop old flight from user database
		String dropSql = "DELETE FROM user_flights WHERE flight_id = ?";
		p1 = connection.prepareStatement(dropSql);
		p1.setInt(1, old_flight_id);
		p1.executeUpdate();
		
		// Add new flight based on flight ID
		String selectSql = "SELECT * FROM flights";
		PreparedStatement p2 = connection.prepareStatement(selectSql);
		rs = p2.executeQuery();
		PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
		preparedStatement.setInt(1,1);
		preparedStatement.setInt(2, new_flight_id);
		while(rs.next()) {
			if(rs.getInt("flight_id") == new_flight_id) {
				preparedStatement.setString(3, rs.getString("date"));
				preparedStatement.setString(4, rs.getString("destination"));
			}
		}
		preparedStatement.executeUpdate();
    }

    @FXML
    void ViewFlights(ActionEvent event) {
    	Connection connection = null;
		PreparedStatement p = null;
	    ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StringBuilder field = new StringBuilder();
		String sql = "SELECT * FROM flights";
		field.append("Date Location Capacity ");
	    try {
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
		    
		    // Check database for all available flights
		    while (rs.next()) {
		    	int flight_id = rs.getInt("flight_id");
		        String name = rs.getString("date");
		        String dest = rs.getString("destination");
		        int capacity = rs.getInt("capacity");
		        field.append(flight_id + " " + name + " " + dest + " " + capacity + ", ");
		    }
		    FlightView.setText(field.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
