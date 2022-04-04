package br.com.caelum.produtos.controller;

import br.com.caelum.produtos.dao.ProdutoDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {

	@Path("/")
	public void index() {
		new ProdutoDao().lista();
	}

}
