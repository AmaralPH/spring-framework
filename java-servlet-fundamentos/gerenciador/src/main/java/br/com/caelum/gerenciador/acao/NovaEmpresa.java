package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");
		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println("NovaEmpresa " + nomeEmpresa);
		
		Empresa empresa = new Empresa(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura());
		
		return "redirect:entrada?acao=ListaEmpresas";
//		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
