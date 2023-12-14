package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class HeldItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4002027616114833726L;
	@Id
	private String name;
	private int value;
	private String effect;

	public HeldItem(String name, int value, String effect) {
		this.value = value;
		this.effect = effect;
		this.name = name;
	}
	
	
}
