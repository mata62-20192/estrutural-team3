package ufba.decorator.app;

import ufba.decorator.lib.*;

import javax.print.attribute.standard.JobOriginatingUserName;

public class Main {

	public static void main(String[] args) {

		Usuario u = new Usuario();
		u.setEmail("ab123@email.com");
		u.setNomeCompleto("Fulano");
		u.setUsername("fulano");

		Usuario v = new Usuario();
		v.setEmail("abcdef123456@email.com");
		v.setNomeCompleto("Sicr,ana");
		v.setUsername("s,i,c,r,a,n,a");

		UsuarioDAO usuario = new UsuarioDAOAutenticacaoDecorator("192.168.7.100", new UsuarioArquivoDAO());
		usuario.apagarTudo();
		usuario.inserir(u);

		u = usuario.obter("fulano");
			System.out.println(usuario.obter("fulano").getEmail());
			System.out.println(usuario.obter("fulano").getNomeCompleto());
			System.out.println(usuario.obter("fulano").getUsername());

        UsuarioDAO usuarioDAO1 = new UsuarioDAOAutenticacaoDecorator("192.168.0.100",new UsuarioArquivoDAO());
        usuarioDAO1.inserir(u);
        usuario.obter("fulano");
        System.out.println(usuarioDAO1.obter("fulano").getEmail());
        System.out.println(usuarioDAO1.obter("fulano").getNomeCompleto());
        System.out.println(usuarioDAO1.obter("fulano").getUsername());

		UsuarioDAO usuarioDAO2 = new UsuarioDAOAutenticacaoDecorator("192.168.0.100", new UsuarioMemoriaDAO());
		usuarioDAO2.inserir(u);
		System.out.println(usuarioDAO2.obter("fulano").getEmail());
		System.out.println(usuarioDAO2.obter("fulano").getNomeCompleto());
		System.out.println(usuarioDAO2.obter("fulano").getUsername());

		UsuarioDAO usuarioFiltro = new UsuarioDAOFiltroDecorator(new UsuarioMemoriaDAO());
		usuarioFiltro.inserir(v);
		System.out.println(usuarioFiltro.obter("s,i,c,r,a,n,a").getEmail());
		System.out.println(usuarioFiltro.obter("sicrana").getUsername());
	}
}