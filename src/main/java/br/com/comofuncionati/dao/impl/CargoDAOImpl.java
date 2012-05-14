package br.com.comofuncionati.dao.impl;

import java.util.List;

import br.com.comofuncionati.dao.CargoDAO;
import br.com.comofuncionati.domain.model.Cargo;

import com.fastsql.sql.builder.SqlTool;
import static com.fastsql.sql.command.expression.LogicalComparisonExpression.attribute;

public class CargoDAOImpl implements CargoDAO {
	
	@Override
	public Cargo getCargoByNome(String nome) {
		Cargo example = Cargo.newCargo().create();
		example = SqlTool.getInstance().select(Cargo.class).where(attribute("nome").equals(nome)).build(example).getUniqueResult();
		return example;
	}

	@Override
	public List<Cargo> getAllCargos(String nome) {
		Cargo example = Cargo.newCargo().create();
		List<Cargo> cargos = SqlTool.getInstance().select(Cargo.class).build(example).getResult();
		return cargos;
	}

}
