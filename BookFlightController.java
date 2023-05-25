package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BookFlightsController {

    @FXML
    private Button BookButton;
    @FXML
    private Button FindButton;
    @FXML
    private Label BookFlightTitle;
    @FXML
    private TextField DateField;
    @FXML
    private Label DateLabel;
    @FXML
    private TextArea FlightData;
    @FXML
    private Label FlightsLabel;
    @FXML
    private TextField LocationField;
    @FXML
    private Label LocationLabel;
    @FXML
    private Label SuccessField;
    @FXML
    private Label BookingSuccess;
    
    private static final String SQL_INSERT = "INSERT INTO user_flights(id, flight_id, date, destination) VALUES(?,?,?,?)";
    
    public void BookFlight(ActionEvent event) throws Exception {
    	Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalProject", "root", "AspenBoots22");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM flights";
		PreparedStatement p = connection.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		int flight_id = 0;
		
		while(rs.next()) {
			if(rs.getString("destination").equals(LocationField.getText())) {
				flight_id = rs.getInt("flight_id");
			}
		}
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
		preparedStatement.setInt(1,1);
		preparedStatement.setInt(2, flight_id);
		preparedStatement.setString(3, DateField.getText());
		preparedStatement.setString(4, LocationField.getText());
		preparedStatement.executeUpdate();
		BookingSuccess.setText("Flight Booked!");
    }
    
    public void ShowFlights(ActionEvent event) throws Exception {
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
		        String name = rs.getString("date");
		        String dest = rs.getString("destination");
		        int capacity = rs.getInt("capacity");
		        field.append(name + " " + dest + " " + capacity + ", ");
		    }
		    FlightData.setText(field.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
