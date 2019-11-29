package ufba.composite;

public class Programador extends Pessoa{
	Programador(String nome, double experiencia){
		this.nome = nome;
		this.experiencia = experiencia;
	}
	public double getSalario(){
		return 1000 * experiencia;
	}
}