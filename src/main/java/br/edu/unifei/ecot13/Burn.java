package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Burn extends Status{
	/**
	 * 
	 */
	private static final long serialVersionUID = 765389461876693727L;
	private boolean burning;
	
	@Override
	public void effect(Pokemon pokemon) {
		this.burning = true;
		System.out.println("Your Pokemon is burning!");
	}

	public boolean getBurning() {
		return this.burning;
	}
}
