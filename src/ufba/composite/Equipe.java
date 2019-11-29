package ufba.composite;

import java.util.ArrayList;

public class Equipe implements Membro{
	private String nome;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private ArrayList<Equipe> subequipes = new ArrayList<>();
	
	public Equipe(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	void addPessoa(Pessoa pessoa){
		pessoas.add(pessoa);
	}
	void addSubequipe(Equipe subequipe){
		subequipes.add(subequipe);
	}
	
	public double getSalario(){
		double total = 0;

		for (Pessoa pessoa : pessoas){
			total += pessoa.getSalario();
		}

		for (Equipe subequipe : subequipes){
			total += subequipe.getSalario();
		}

		return total;
	}	
}