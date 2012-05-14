package br.com.comofuncionati.infra.repository.impl;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.ioc.Component;
import br.com.comofuncionati.dao.CargoDAO;
import br.com.comofuncionati.dao.impl.CargoDAOImpl;
import br.com.comofuncionati.domain.model.Cargo;
import br.com.comofuncionati.infra.repository.CargoRepository;

@Component
public class CargoRepositoryImpl implements CargoRepository {
	
	private static final Map<String, Cargo> CARGOS = new HashMap<String, Cargo>();
	private final CargoDAO cargoDAO;
	
	public CargoRepositoryImpl(){
		cargoDAO = new CargoDAOImpl();
	}

	@Override
	public Cargo getCargoBy(String nome) {
		Cargo cargo = CARGOS.get(nome);
		if(cargo==null){
			cargo = cargoDAO.getCargoByNome(nome);
			CARGOS.put(nome, cargo);
		}
		return cargo;
	}

}
