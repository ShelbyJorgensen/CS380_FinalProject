package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ManageFlightsController {

    @FXML
    private Label AddFlightLabel;

    @FXML
    private Label CancelLFlightLabel;

    @FXML
    private Label ChangeFlightTitle;

    @FXML
    private Label ClassLabel;

    @FXML
    private TextField ClassText;

    @FXML
    private Label CustomerNameLabel;

    @FXML
    private TextField CustomerNameText;

    @FXML
    private DatePicker Date1Button;

    @FXML
    private Label Date1Label;

    @FXML
    private Label Date2Label;

    @FXML
    private DatePicker Date2Picker;

    @FXML
    private Label FlightLabel;

    @FXML
    private TableColumn<?, ?> FlightTabel;

    @FXML
    private Label Location1;

    @FXML
    private TextField Location1Text;

    @FXML
    private Label Location2Label;

    @FXML
    private TextField Location2Text;

    @FXML
    private Pane Pane;

    @FXML
    private TableColumn<?, ?> Table;

    @FXML
    private Button Update1Button;

    @FXML
    private Button Update2Button;

    @FXML
    private Label UpdateFlightLabel;

    @FXML
    private Button UpdateTableButton;

}
