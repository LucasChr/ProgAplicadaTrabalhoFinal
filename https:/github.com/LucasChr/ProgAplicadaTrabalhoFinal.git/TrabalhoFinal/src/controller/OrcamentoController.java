package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;
import model.Cliente;
import model.Orcamento;
import model.Produto;

public class OrcamentoController {

	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnNovoPedido;

	@FXML
	private TableColumn<Produto, Number> tcQuantidade;

	@FXML
	private ComboBox<Produto> cbProduto;

	@FXML
	private TableColumn<Produto, String> tcProdutos;

	@FXML
	private Button btnRemItem;

	@FXML
	private Button btnSalvaPedido;

	@FXML
	private TableColumn<Orcamento, Number> tvValorTotal;

	@FXML
	private TableColumn<Cliente, String> tcCliente;

	@FXML
	private TableView<?> tvOrcamento;

	@FXML
	private ComboBox<Cliente> cbCliente;

	@FXML
	private ComboBox<Produto> cbQnt;

	@FXML
	private TableColumn<Produto, Number> tcValor;

	@FXML
	private Button btnCancelar;

	private ComboBox<Produto> cbxProduto;
	ObservableList<String> list = FXCollections.observableArrayList();
	public static ObservableList<Orcamento> orcamentoList = FXCollections.observableArrayList();

	private boolean editando;
	
	@FXML
	private void initialize() {
		tcCliente.setCellValueFactory(c -> c.getValue().getClienteProperty());
		tcProdutos.setCellValueFactory(c -> c.getValue().getProdutoProperty());
		tcQuantidade.setCellValueFactory(c -> c.getValue().getQntProperty());
		tcValor.setCellValueFactory(c -> c.getValue().getPrecoProperty());
		
		tvOrcamento.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> {
			populaText(newValue);
			editando = true;
		});
		
		
		
		cbProduto.getItems().addAll(ProdutoController.produtoList);

		// Define os valores que serão mostrados
		// quando o combobox e aberto
		cbProduto.setCellFactory((comboBox) -> {
			return new ListCell<Produto>() {
				@Override
				protected void updateItem(Produto item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getNome());
					}
				}
			};
		});

		// Define valor que renderiza quando o item é selecionado
		cbProduto.setConverter(new StringConverter<Produto>() {
			@Override
			public String toString(Produto produto) {
				if (produto == null) {
					return null;
				} else {
					return produto.getNome();
				}
			}

			@Override
			public Produto fromString(String personString) {
				return null; // No conversion fromString needed.
			}
		});

		cbCliente.getItems().addAll(ClienteController.clientes);

		// Define os valores que serão mostrados
		// quando o combobox e aberto
		cbCliente.setCellFactory((comboBox) -> {
			return new ListCell<Cliente>() {
				@Override
				protected void updateItem(Cliente item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getNome());
					}
				}
			};
		});

		// Define valor que renderiza quando o item é selecionado
		cbCliente.setConverter(new StringConverter<Cliente>() {
			@Override
			public String toString(Cliente cliente) {
				if (cliente == null) {
					return null;
				} else {
					return cliente.getNome();
				}
			}

			@Override
			public Cliente fromString(String personString) {
				return null; // No conversion fromString needed.
			}
		});
	}

	@FXML
	void onActionAdicionar(ActionEvent event) {
		Orcamento orcamento  = new Orcamento();
		Preencher(orcamento);
		tvOrcamento.getItems().addAll(orcamento);
		orcamentoList.add(orcamento);
		
	}

	@FXML
	void onActionCancelar(ActionEvent event) {

	}

	@FXML
	void onActionRemoverItem(ActionEvent event) {

	}

	@FXML
	void onActionNovoPedido(ActionEvent event) {

	}

	@FXML
	void onActionSalvarPedido(ActionEvent event) {

	}

	@FXML
	void onActionCbQnt(ActionEvent event) {

	}

	private void limparCampos() {

	}

	private void populaText(Object newValue) {

	}

	private void Preencher(Orcamento orcamento) {
		orcamento.setCliente(cbCliente.getValue());
		orcamento.setProduto(cbProduto.getValue());
	}

	// private Orcamento popularObjeto() {

	// }

	private void novo() {
		limparCampos();
		Orcamento o = new Orcamento();
		/// editando = false;
	}

}
