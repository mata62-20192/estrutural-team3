package ufba.decorator.lib;


import ufba.decorator.app.UsuarioUtils;


public  class UsuarioDAOAutenticacaoDecorator implements UsuarioDAO{
    private  String IP;
    UsuarioDAO UserUnico;

    public UsuarioDAOAutenticacaoDecorator(UsuarioDAO UserUnico){
        this.UserUnico = UserUnico;
    }



    @Override
    public void apagarTudo() {
        if (UsuarioUtils.ehAdministrador(IP)){
            UserUnico.apagarTudo();

        }else{
            System.out.println("Você não tem nível suficiente para liberação desta função.");
        }
    }

    @Override
    public void inserir(Usuario u) {
        if (UsuarioUtils.ehAdministrador(IP)){
            UserUnico.inserir(u);

        }else{
            System.out.println("Você não tem nível suficiente para liberação desta função.");
        }
    }

    @Override
    public Usuario obter(String username) {
        if (UsuarioUtils.ehAdministrador(IP)) {
            UserUnico.obter(username);
        }
        return null;
    }

}

