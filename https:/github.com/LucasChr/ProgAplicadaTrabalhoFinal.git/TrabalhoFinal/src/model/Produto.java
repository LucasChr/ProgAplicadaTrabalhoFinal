package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {

	private StringProperty nome;
	private IntegerProperty codigo;
	private StringProperty categoria;
	private DoubleProperty Qnt;
	private DoubleProperty preco;
	
	public Produto() {
		nome = new SimpleStringProperty();
		codigo = new SimpleIntegerProperty();
		categoria = new SimpleStringProperty();
		Qnt = new SimpleDoubleProperty();
		preco = new SimpleDoubleProperty();
	}
	
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public Integer getCodigo() {
		return codigo.get();
	}
	public void setCodigo(Integer codigo) {
		this.codigo.set(codigo);
	}
	
	public String getCategoria() {
		return categoria.get();
	}
	public void setCategoria(String categoria) {
		this.categoria.set(categoria);;
	}
	
	public Double getQnt() {
		return Qnt.get();
	}
	public void setQnt(Double qnt) {
		Qnt.set(qnt);;
	}
	
	public Double getPreco() {
		return preco.get();
	}
	public void setPreco(Double preco) {
		this.preco.set(preco);
	}

	public StringProperty getProdutoProperty() {
		return nome;
	}

	public IntegerProperty getCodProperty() {
		return codigo;
	}
	
	public DoubleProperty getQntProperty() {
		return Qnt;
	}
	
	
	public DoubleProperty getPrecoProperty() {
		return preco;
	}
	
	

	
}
