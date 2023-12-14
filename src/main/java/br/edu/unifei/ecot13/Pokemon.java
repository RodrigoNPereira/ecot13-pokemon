package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class Pokemon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -56930302455811709L;
	private String name;
	private int health;
	private int defense;
	@ManyToOne
	private Region region;
	@ManyToOne
	private Ability ability;
	@OneToMany
	@OrderColumn
	private Attack attacks[] = new Attack[4];
	@OneToOne
	private HeldItem item;
	@OneToOne
	private Status status;
	@ManyToOne
	private Type type1;
	@ManyToOne
	private Type type2;
	@Id
	@GeneratedValue
	private int codigo;
	
	public Pokemon() {}

	public Pokemon(String name) {
		this.name = name;
	}
	
	public abstract Pokemon callEvolution();
	
}
