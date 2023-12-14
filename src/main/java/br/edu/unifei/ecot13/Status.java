package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class Status implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6276653888917187566L;
	private int timeToVanish;
	@Id
	@GeneratedValue
	private int codigo;
	
	public abstract void effect(Pokemon pokemon);
}
