package ufba.decorator.lib;


import ufba.decorator.app.UsuarioUtils;

public  class UsuarioDAOAutenticacaoDecorator implements UsuarioDAO{
    private  String IP;
    UsuarioDAO UserUnico;

    public UsuarioDAOAutenticacaoDecorator(String IP, UsuarioDAO UserUnico){
        this.UserUnico = UserUnico;
        this.IP = IP;
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
           return UserUnico.obter(username);

        }
        return null;
    }

}

