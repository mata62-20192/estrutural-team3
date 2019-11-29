package ufba.composite;

class EstatisticasFinanceiras{

	// Custo da equipe

	static void imprimeCustoProjeto(Membro membro){
		System.out.println("Custo de " + membro.getNome() + ": " + membro.getSalario());
	}

}