package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		String acao = request.getParameter("acao");
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo da ação " + acao + ": " + (depois - antes));
	}
}
