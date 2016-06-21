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
import view.componente.Alerta;

public class OrcamentoController {

	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnNovoPedido;

	@FXML
	private Button btnRemItem;

	@FXML
	private Button btnSalvaPedido;

	@FXML
	private Button btnCancelar;

	@FXML
	private TableView<Orcamento> tvOrcamento;

	@FXML
	private TableColumn<Orcamento, Produto> tcProdutos;
	
	@FXML
	private TableColumn<Orcamento, Cliente> tcCliente;
	
	@FXML
	private ComboBox<Cliente> cbCliente;

	@FXML
	private ComboBox<Produto> cbProduto;

	private ObservableList<Orcamento> orcamentoList = FXCollections.observableArrayList();
	private boolean editando;

	@FXML
	private void initialize() {
		tcCliente.setCellValueFactory(cellData -> cellData.getValue().getClienteProperty());
		tcProdutos.setCellValueFactory(c -> c.getValue().getProdutoProperty());
		
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
		Orcamento orcamento = new Orcamento();
		Preencher(orcamento);
		tvOrcamento.getItems().add(orcamento);
		orcamentoList.add(orcamento);
		
	}

	@FXML
	void onActionCancelar(ActionEvent event) {
		novo();
	}

	@FXML
	void onActionRemoverItem(ActionEvent event) {
		if (new Alerta().excluir()) {
			int posicaoTabela = tvOrcamento.getSelectionModel().getSelectedIndex();
			tvOrcamento.getItems().remove(posicaoTabela);
		}
	}

	@FXML
	void onActionNovoPedido(ActionEvent event) {
		novo();
	}

	@FXML
	void onActionSalvarPedido(ActionEvent event) {
		Orcamento orcamento = new Orcamento();
		if(editando){
			int linhaTabela = tvOrcamento.getSelectionModel().getSelectedIndex();
			tvOrcamento.getItems().remove(linhaTabela);
			orcamentoList.remove(orcamento);
		}
		tvOrcamento.getItems().add(orcamento);
		orcamentoList.add(orcamento);
	}
	
	private void populaText(Orcamento newValue) {
		cbCliente.setValue(tcCliente.getCellData(newValue));
		cbProduto.setValue(tcProdutos.getCellData(newValue));
	}

	private void Preencher(Orcamento orcamento) {
		orcamento.setCliente(cbCliente.valueProperty().get());
		orcamento.setProduto(cbProduto.valueProperty().get());
	}

	private void novo() {
		Orcamento o = new Orcamento();
		Preencher(o);
		editando = false;
	}

}
