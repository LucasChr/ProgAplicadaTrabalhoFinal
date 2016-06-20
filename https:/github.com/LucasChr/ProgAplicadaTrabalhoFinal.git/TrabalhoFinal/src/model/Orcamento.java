package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.Cliente;
import model.Produto;

public class Orcamento {
	
	
	private ObjectProperty<Cliente> cliente;
	private ObjectProperty<Produto> produto;
	
	public Orcamento() {
		cliente = new SimpleObjectProperty<>();
		produto = new SimpleObjectProperty<>();
	}

	public ObjectProperty<Cliente> getClienteProperty() {
		return cliente;
	}

	public ObjectProperty<Produto> getProdutoProperty() {
		return produto;
	}

	public Cliente getCliente() {
		return cliente.get();
	}

	public void setCliente(Cliente cliente) {
		this.cliente.set(cliente);
	}

	public Produto getProduto() {
		return produto.get();
	}

	public void setProduto(Produto produto) {
		this.produto.set(produto);
	}

}
