package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Produto;
import view.componente.Alerta;

public class ProdutoController {

	@FXML
	private Button btnAdicionar;

	@FXML
	private TextField tfPreco;

	@FXML
	private Button btnEcluir;

	@FXML
	private TextField tfProduto;

	@FXML
	private TextField tfCodigo;

	@FXML
	private TextField tfCategoria;

	@FXML
	private Button btnEditar;

	@FXML
	private TextField tfQnt;

	@FXML
	private TableView<Produto> tvProdutos;

	@FXML
	private TableColumn<Produto, String> tcProduto;

	@FXML
	private TableColumn<Produto, Number> tcQnt;

	@FXML
	private TableColumn<Produto, Number> tcCod;

	@FXML
	private TableColumn<Produto, Number> tcPreco;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnSalvar;

	//public static List<Produto> produtos = new ArrayList<>();
	public static ObservableList<Produto> produtoList = FXCollections.observableArrayList();
	
	private Produto produto;
	private boolean editando;

	// Verificar o campo salvar, não está atualizando a lista no listview

	@FXML
	private void initialize() {

		tcCod.setCellValueFactory(c -> c.getValue().getCodProperty());
		tcProduto.setCellValueFactory(c -> c.getValue().getProdutoProperty());
		tcQnt.setCellValueFactory(c -> c.getValue().getQntProperty());
		tcPreco.setCellValueFactory(c -> c.getValue().getPrecoProperty());
		
		tvProdutos.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					populaText(newValue);
					editando = true;
				});
	}

	@FXML
	void onActionAdicionar(ActionEvent event) {
		Produto produto = new Produto();
		Preencher(produto);
		tvProdutos.getItems().add(produto);
		produtoList.add(produto);
		novo();
		limparCampos();
	}

	@FXML
	void onActionSalvar(ActionEvent event) {
		Produto produto = popularObjeto();
		if(editando){
			int linhaTabela = tvProdutos.getSelectionModel().getSelectedIndex();
			tvProdutos.getItems().remove(linhaTabela);
		}
		tvProdutos.getItems().add(produto);
		novo();
	}

	@FXML
	void onActionExcluir(ActionEvent event) {
		if (new Alerta().excluir()) {
			int posicaoTabela = tvProdutos.getSelectionModel().getSelectedIndex();
			tvProdutos.getItems().remove(posicaoTabela);
		}
	}

	@FXML
	void onActionNovo(ActionEvent event) {
		novo();
		limparCampos();
	}

	@FXML
	void onActionEditar(ActionEvent event) {
		Produto produto = tvProdutos.getSelectionModel().getSelectedItem();
		populaText(produto);
	}

	private void limparCampos() {
		tfProduto.setText("");
		tfCodigo.setText("");
		tfPreco.setText("");
		tfCategoria.setText("");
		tfQnt.setText("");
	}

	private void populaText(Produto newValue) {
		tfCodigo.setText(produto.getCodigo().toString());
		tfProduto.setText(produto.getNome());
		tfQnt.setText(produto.getQnt().toString());
		tfPreco.setText(produto.getPreco().toString());
		tfCategoria.setText(produto.getCategoria());
	}

	private void Preencher(Produto produto) {
		produto.setNome(tfProduto.getText());
		produto.setCodigo(Integer.valueOf(tfCodigo.getText()));
		produto.setCategoria(tfCategoria.getText());
		produto.setQnt(Double.valueOf(tfQnt.getText()));
		produto.setPreco(Double.valueOf(tfPreco.getText()));
	}

	private Produto popularObjeto() {
		produto.setCategoria(tfCategoria.getText());
		produto.setCodigo(Integer.valueOf(tfCodigo.getText()));
		produto.setNome(tfProduto.getText());
		produto.setPreco(Double.valueOf(tfPreco.getText()));
		produto.setQnt(Double.valueOf(tfQnt.getText()));
		return produto;
	}

	private void novo() {
		limparCampos();
		produto = new Produto();
		editando = false;
	}

}
