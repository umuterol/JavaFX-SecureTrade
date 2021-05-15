package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

public class passwordOperation {

    @FXML
    private VBox vboxMenuPassword;

    @FXML
    private PasswordField txtProfileNowPass;

    @FXML
    private PasswordField txtProfileNewPass;

    @FXML
    private PasswordField txtProfileNewPass2;

    public VBox getVboxMenuPassword() {
		return vboxMenuPassword;
	}

	public void setVboxMenuPassword(VBox vboxMenuPassword) {
		this.vboxMenuPassword = vboxMenuPassword;
	}

	@FXML
    private Button btnProfileChangedPassword;

    @FXML
    void btnProfileChangedPassword_Click(ActionEvent event) {

    }

}
