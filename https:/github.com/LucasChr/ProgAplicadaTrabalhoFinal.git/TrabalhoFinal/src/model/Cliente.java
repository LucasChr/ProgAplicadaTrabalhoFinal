package model;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente {

	private StringProperty nome;
	private ObjectProperty<Sexo> sexo;
	private ObjectProperty<LocalDate> nascimento;
	private IntegerProperty telefone;
	private StringProperty endereco;
	private IntegerProperty numero;

	public Cliente() {
		nome = new SimpleStringProperty();
		sexo = new SimpleObjectProperty<>();
		nascimento = new SimpleObjectProperty<>();
		telefone = new SimpleIntegerProperty();
		endereco = new SimpleStringProperty();
		numero = new SimpleIntegerProperty();
	}

	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public Sexo getSexo() {
		return sexo.get();
	}
	public void setSexo(Sexo sexo) {
		this.sexo.set(sexo);
	}

	public LocalDate getNascimento() {
		return nascimento.get();
	}
	public void setNascimento(LocalDate localDate) {
		this.nascimento.set(localDate);
	}

	public Integer getTelefone() {
		return telefone.get();
	}
	public void setTelefone(Integer telefone) {
		this.telefone.set(telefone);
	}

	public String getEndereço() {
		return endereco.get();
	}

	public void setEndereco(String endereço) {
		this.endereco.set(endereço);
	}

	public Integer getNumero() {
		return numero.get();
	}

	public void setNumero(Integer numero) {
		this.numero.set(numero);
	}

	public StringProperty getClienteProperty() {
		return nome;
	}

	public IntegerProperty getTelefoneProperty() {
		return telefone;
	}
	
	public ObjectProperty<LocalDate> getDataNascimentoProperty() {
		return nascimento;
	}

	public ObjectProperty<Sexo> getSexoProperty() {
		return sexo;
	}
	
	public StringProperty getDataNascimentoFormatada() {
		return new SimpleStringProperty(nascimento.get().format(ofPattern("dd/MM/yyyy")));
	}
}