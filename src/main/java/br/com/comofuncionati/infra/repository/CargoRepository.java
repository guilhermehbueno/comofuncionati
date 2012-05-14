package br.com.comofuncionati.infra.repository;

import br.com.comofuncionati.domain.model.Cargo;

public interface CargoRepository {
	
	public Cargo getCargoBy(String nome);

}
