package ufba.decorator.lib;

//Interface

public interface UsuarioDAO {
	void apagarTudo();
	void inserir(Usuario u);
	Usuario obter(String username);
}