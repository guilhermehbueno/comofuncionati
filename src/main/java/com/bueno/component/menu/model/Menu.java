package com.bueno.component.menu.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idmenu")
	private String id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="link")
	private String link;
	
	@Enumerated
	@Column(name="status")
	private MenuStatusEnum status;
	
	@Enumerated
	@Column(name="tipo")
	private MenuTipoEnum tipo;
	
	@Column(name="pai")
	private String pai; 
	
	@OneToMany
	@JoinColumn(table="menu", referencedColumnName="pai")
	private List<Menu> menu;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public MenuStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MenuStatusEnum status) {
		this.status = status;
	}

	public MenuTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(MenuTipoEnum tipo) {
		this.tipo = tipo;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", label=" + label + ", link=" + link
				+ ", status=" + status + ", tipo=" + tipo + ", menu=" + menu
				+ "]";
	}
}
