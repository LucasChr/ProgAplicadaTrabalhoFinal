package model;

import javafx.collections.ObservableList;
import model.Cliente;
import model.Produto;

public class Orcamento {
	
	
	private Cliente cliente;
	private Produto produto;

	public Cliente getCliente() {
		return this.cliente;
	}

	public Produto getProduto() {
		return this.produto;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
