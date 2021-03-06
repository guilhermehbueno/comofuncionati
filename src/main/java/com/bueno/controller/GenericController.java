package com.bueno.controller;

import static com.fastsql.sql.expression.LogicalComparisonExpression.id;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Id;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

import com.fastsql.sql.builder.SqlTool;
import com.fastsql.sql.reflection.util.SqlReflectionUtil;

public abstract class GenericController<T> implements Serializable{
	
	private static final long serialVersionUID = -1669146038773069514L;
	private final Result result;
	
	public GenericController(Result result) {
		super();
		this.result = result;
	}

	@Path("{id}/view")
	public void view(String id) {
		Class clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			T entidade = (T) SqlTool.getInstance()
					.select(clazz)
					.where(id(clazz).equals(id))
					.execute((T)clazz.newInstance())
					.getUniqueResult();
			result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Path("save")
	public void save(T t) {
		try {
			System.out.println("Salvando: "+t);
			SqlTool.getInstance().insert(t).execute();
			result.redirectTo("list"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Path("update")
	public void update(T t) {
		try {
			System.out.println("Atualizando: "+t);
			Field id = SqlReflectionUtil.extractFieldWithAnnotation(t.getClass(), Id.class);
			id.setAccessible(true);
			String idValue = (String) id.get(t);
			System.out.println("Recuperando id para update: "+idValue);
			id.setAccessible(false);
			SqlTool.getInstance()
				.update(t)
				.where(id(t.getClass()).equals(idValue))
				.execute();
			result.redirectTo("list"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Path("{id}/edit")
	public void edit(String id) throws Exception {
		Class clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			T entidade = (T) SqlTool.getInstance()
					.select(clazz)
					.where(id(clazz).equals(id.toString()))
					.execute((T)clazz.newInstance())
					.getUniqueResult();
			result.include("item", entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	@Path("create")
	public void create() {
	} 
	
	@Path("delete")
	public void delete(Long id) {
		Class clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			SqlTool.getInstance().delete(clazz).where(id(clazz).equals(id.toString())).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	@Path("list")
	public void list(){
		Class clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			List<T> all = SqlTool.getInstance().select(clazz).execute((T)clazz.newInstance()).getResult();
			result.include("itens", all);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
