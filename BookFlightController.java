
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class  BookFlightController{

    @FXML
    private Label BookFlightTitle;

    @FXML
    private Label DateLabel;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TableColumn<?, ?> FlightTable;

    @FXML
    private Label FlightsLabel;

    @FXML
    private Label LocationLabel;

    @FXML
    private TextField LocationText;

    @FXML
    private Pane Pane;

    @FXML
    private TableColumn<?, ?> Table;

    @FXML
    private Button UpdateButton;

}
