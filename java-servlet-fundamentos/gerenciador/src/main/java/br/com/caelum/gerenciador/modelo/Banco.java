package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	static List<Empresa> lista = new ArrayList<>();
	static List<Usuario> listaUsuarios = new ArrayList<>();
	static int counterId = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(counterId++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(counterId++);
		empresa2.setNome("Caelum");
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("pedro");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("hinara");
		u2.setSenha("12345");
		
		Banco.listaUsuarios.add(u1);
		Banco.listaUsuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(counterId++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator it = Banco.lista.iterator();
		
		while (it.hasNext()) {
			Empresa emp = (Empresa) it.next();
			
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa getEmpresaById(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public void editaEmpresa(Integer id, String nomeEmpresa, Date dataAbertura) {
		Empresa empresa = getEmpresaById(id);
		empresa.setDataAbertura(dataAbertura);
		empresa.setNome(nomeEmpresa);		
	}
	
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
