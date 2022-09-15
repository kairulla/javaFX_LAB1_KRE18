package lab1_kre18;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIController implements Initializable {

    @FXML
    private TextField textFieldA;
    @FXML
    private TextField textFieldB;
    @FXML
    private TextField textFieldX;
    @FXML
    private Button buttonSolve;
    @FXML
    private Button buttonClean;
    @FXML
    private Button buttonExit;
    @FXML
    private Label labelOtvet;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void buttonSolveAction(ActionEvent event) {
        double a = 0, b = 0, x = 0, y = 0;
        try {
            a = Double.parseDouble(textFieldA.getText());
            b = Double.parseDouble(textFieldB.getText());
            x = Double.parseDouble(textFieldX.getText());          
        } catch (Exception ex) {
            buttonCleanAction(null);
            textFieldA.requestFocus();
//            ex.printStackTrace();
        }
        
        if (x > 6) {
            y = (6 * x * x - a * b) / (2 * x * x);
        } else {
            y = 4 * (x + a * a + b * b);
        }
        
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            //labelOtvet.setText("Ответ: " + String.format("%.2f", y));
            labelOtvet.setText(String.valueOf(y));
        } else {
            labelOtvet.setText("Нет решения!");
        }
    }

    @FXML
    private void buttonCleanAction(ActionEvent event) {
        labelOtvet.setText("Ответ: ");
        textFieldA.setText("");
        textFieldB.setText("");
        textFieldX.setText("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }
    
}
