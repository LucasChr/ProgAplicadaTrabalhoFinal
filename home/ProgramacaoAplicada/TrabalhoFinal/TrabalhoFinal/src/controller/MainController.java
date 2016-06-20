package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Menu mnCadastro;

    @FXML
    private MenuItem miOrcamento;

    @FXML
    private MenuItem miProduto;

    @FXML
    private MenuItem miCliente;

    @FXML
    private Menu mnPedidos;

    @FXML
    public void onActionOrcamento(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(Main.PATH_VIEW + "Orcamento.fxml"));
		try {
			AnchorPane orcamentoView = (AnchorPane) loader.load();
			panelPrincipal.setCenter(orcamentoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    public void onActionCliente(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(Main.PATH_VIEW + "Cliente.fxml"));
		try {
			AnchorPane clienteView = (AnchorPane) loader.load();
			panelPrincipal.setCenter(clienteView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    public void onActionProduto(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(Main.PATH_VIEW + "Produto.fxml"));
		try {
			AnchorPane produtoView = (AnchorPane) loader.load();
			panelPrincipal.setCenter(produtoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

}
