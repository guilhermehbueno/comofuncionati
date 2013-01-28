package com.bueno.component.pagina.model;

import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

public class PaginacaoUtil {
	
	public static void order(List<Paginacao> paginacao){
		for (int i = 0; i < paginacao.size(); i++) {
			Paginacao pag = paginacao.get(i);
			pag.setLabel(i+1+"");
		}
	}
	
	
	public static void active(List<Paginacao> paginacao, int index){
		if(paginacao==null){
			return;
		}
		
		if(paginacao.size()<=index){
			return;
		}
		
		for (Paginacao paginacao2 : paginacao) {
			paginacao2.setEstado("inative");
		}
		
		Paginacao pag = paginacao.get(index);
		pag.setEstado("active");
	}
	
	public static Paginacao getNext(List<Paginacao> paginacao){
		if(paginacao==null || paginacao.size()<=0){
			return null;
		}
		
		Paginacao active = getActive(paginacao);
		Paginacao result = null;
		if(active!=null){
			int index = paginacao.indexOf(active);
			if(index>=paginacao.size()){
				result = active;
			}else{
				result = paginacao.get(index);
			}
		}
		return result;
	}
	
	public static Paginacao getPrev(List<Paginacao> paginacao){
		if(paginacao==null || paginacao.size()<=0){
			return null;
		}
		
		//TODO: REFATORAR
		Paginacao active = getActive(paginacao);
		Paginacao result = null;
		if(active!=null){
			int index = paginacao.indexOf(active);
			System.out.println("index: "+index);
			if(index==0){
				result = paginacao.get(index);
			}else{
				System.out.println("paginacao.size(): "+paginacao.size());
				if(paginacao.size()<=index){
					result = active;
				}else{
					System.out.println("index-1: "+(index-1));
					result = paginacao.get(index-1);
				}
			}
		}
		return result;
	}
	
	
	public static Paginacao getActive(List<Paginacao> paginacao){
		for (Paginacao paginacao2 : paginacao) {
			if(paginacao2.getEstado().equalsIgnoreCase("active")){
				return paginacao2;
			}
		}
		return null;
	}
}
