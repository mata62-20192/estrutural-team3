package ufba.decorator.lib;

import ufba.decorator.app.UsuarioUtils;

public class UsuarioDAOFiltroDecorator implements UsuarioDAO {
    UsuarioDAO UserCaracter;

    public UsuarioDAOFiltroDecorator(UsuarioDAO UserCaracter){
        this.UserCaracter = UserCaracter;
    }


    @Override
    public void apagarTudo() {
        UserCaracter.apagarTudo();
    }

    @Override

    public void inserir(Usuario u) {
        UserCaracter.inserir(UsuarioUtils.filtraEntrada(u));
    }

    @Override
    public Usuario obter(String username) {

        return UserCaracter.obter(username);
    }
}
