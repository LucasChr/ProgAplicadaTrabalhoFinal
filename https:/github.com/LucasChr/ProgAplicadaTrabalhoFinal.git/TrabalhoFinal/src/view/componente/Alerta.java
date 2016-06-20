package view.componente;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Alerta {

	public boolean excluir() {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente excluir?", ButtonType.CANCEL, ButtonType.OK);
		Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		final Optional<ButtonType> result = alerta.showAndWait();
		return result.get() == ButtonType.OK;
	}
}
