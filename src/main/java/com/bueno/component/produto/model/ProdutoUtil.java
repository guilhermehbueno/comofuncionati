package com.bueno.component.produto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class ProdutoUtil implements Serializable{
	
	private static final long serialVersionUID = -8840466365427556417L;
	private final HttpSession session;

	public ProdutoUtil(HttpSession session) {
		super();
		this.session = session;
	}

	public List<Produto> getProdutos(){
		//List<Produto> produtos = (List<Produto>) this.session.getAttribute("produtos");
		List<Produto> produtos = null;
		if(produtos==null){
			produtos = new ArrayList<Produto>();
		}
		this.session.setAttribute("produtos", produtos);
		return produtos;
	}
	
	public boolean addProduto(Produto produto){
		//List<Produto> produtos = getProdutos();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto);
		this.session.setAttribute("produtos", produtos);
		return true;
	}

}
