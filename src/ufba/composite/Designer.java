package ufba.composite;

public class Designer extends Pessoa {

    Designer(String nome, double experiencia){
		this.nome = nome;

		this.experiencia = experiencia;
	}
	public double getSalario() {
		return 800 * experiencia;
	}
}