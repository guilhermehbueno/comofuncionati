package br.com.comofuncionati;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	public void index() {
		this.result.redirectTo("/loja/produtos");
	}
}
