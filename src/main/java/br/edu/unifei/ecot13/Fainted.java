package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Fainted extends Status{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4044859606838244019L;
	private Boolean unspawn;
	
	@Override
	public void effect(Pokemon pokemon) {
		if (pokemon.getHealth() <= 0){
			unspawn = true;
		}
	}

}
