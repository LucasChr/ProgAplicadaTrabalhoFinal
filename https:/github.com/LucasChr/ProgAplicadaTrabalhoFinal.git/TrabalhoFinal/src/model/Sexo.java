package model;

import lombok.Getter;

@Getter
public enum Sexo {

	MASCULINO(true, false), FEMININO(false, true);

	Sexo(boolean masculino, boolean feminino) {
		this.masculino = masculino;
		this.feminino = feminino;
	}

	private boolean masculino;
	private boolean feminino;
}
