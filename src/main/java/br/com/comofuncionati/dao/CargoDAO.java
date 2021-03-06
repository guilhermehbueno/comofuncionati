package br.com.comofuncionati.dao;

import java.util.List;

import br.com.comofuncionati.domain.model.Cargo;

public interface CargoDAO {
	
	public Cargo getCargoByNome(String nome)  throws Exception;
	public List<Cargo> getAllCargos(String nome)  throws Exception;

}
