package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Sexo;
import view.componente.Alerta;

public class ClienteController {

	@FXML
	private TableColumn<Cliente, String> tcNome;

	@FXML
	private RadioButton rbMasculino;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TableView<Cliente> tvCliente;

	@FXML
	private Button btnApagar;

	@FXML
	private RadioButton rbFeminino;

	@FXML
	private TextField tfNumero;

	@FXML
	private TextField tfTelefone;

	@FXML
	private TableColumn<Cliente, Number> tcTelefone;

	@FXML
	private Button btnNovo;

	@FXML
	private TextField tfNome;

	@FXML
	private DatePicker dpNascimento;

	@FXML
	private Button btnSalvar;

	// public static List<Cliente> clientes = new ArrayList<>();
	public static ObservableList<Cliente> clientes = FXCollections.observableArrayList();
	private Cliente cliente;
	private boolean editando;

	@FXML
	private void initialize() {
		tcNome.setCellValueFactory(c -> c.getValue().getClienteProperty());
		tcTelefone.setCellValueFactory(c -> c.getValue().getTelefoneProperty());

		tvCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			populaText(newValue);
			editando = true;
		});
	}

	@FXML
	void onActionCadastrar(ActionEvent event) {
		Cliente cliente = new Cliente();
		Preencher(cliente);
		tvCliente.getItems().add(cliente);
		clientes.add(cliente);
		novo();
		limparCampos();
	}

	@FXML
	void onActionNovo(ActionEvent event) {
		novo();
		limparCampos();
	}

	@FXML
	void onActionApagar(ActionEvent event) {
		if (new Alerta().excluir()) {
			int posicaoTabela = tvCliente.getSelectionModel().getSelectedIndex();
			tvCliente.getItems().remove(posicaoTabela);
		}
	}

	@FXML
	void onActionSalvar(ActionEvent event) {
		Cliente cliente  = populaObjeto();
		if(editando){
			int linhaTabela = tvCliente.getSelectionModel().getSelectedIndex();
			tvCliente.getItems().remove(linhaTabela);
		}
		Preencher(cliente);
		tvCliente.getItems().add(cliente);
		clientes.add(cliente);
		limparCampos();
	}

	private void limparCampos() {
		tfEndereco.setText("");
		tfNome.setText("");
		tfNumero.setText("");
		tfTelefone.setText("");
		dpNascimento.setValue(null);
		;
		if (rbMasculino.isSelected()) {
			rbMasculino.setSelected(false);
		} else {
			rbFeminino.setSelected(false);
		}
	}

	private void populaText(Cliente newValue) {
		tfEndereco.setText(newValue.getEndereço());
		tfNome.setText(newValue.getNome());
		tfNumero.setText(newValue.getNumero().toString());
		tfTelefone.setText(newValue.getTelefone().toString());
		dpNascimento.setValue(newValue.getNascimento());
		if (rbMasculino.isSelected()) {
			newValue.setSexo(Sexo.MASCULINO);
		} else {
			newValue.setSexo(Sexo.FEMININO);

		}
	}

	private void Preencher(Cliente cliente) {
		cliente.setEndereco(tfEndereco.getText());
		cliente.setNascimento(dpNascimento.getValue());
		cliente.setNome(tfNome.getText());
		cliente.setNumero(Integer.valueOf(tfNumero.getText()));
		cliente.setTelefone(Integer.valueOf(tfTelefone.getText()));
		if (rbMasculino.isSelected()) {
			cliente.setSexo(Sexo.MASCULINO);
		} else {
			cliente.setSexo(Sexo.FEMININO);
		}
	}

	private Cliente populaObjeto(){
		tfEndereco.setText(cliente.getEndereço());
		tfNome.setText(cliente.getNome());
		tfNumero.setText(cliente.getNumero().toString());
		tfTelefone.setText(cliente.getTelefone().toString());
		dpNascimento.setValue(cliente.getNascimento());
		if (rbMasculino.isSelected()) {
			cliente.setSexo(Sexo.MASCULINO);
		} else {
			cliente.setSexo(Sexo.FEMININO);
		}
		return cliente;
	}
	
	
	private void novo() {
		limparCampos();
		cliente = new Cliente();
		editando = false;
	}
	
}
