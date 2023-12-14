package br.edu.unifei.ecot13;
import java.util.Random;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Paralyzed extends Status{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6997794313946086709L;
	private Boolean mayAttack;
	
	public Boolean getMayAttack() {
		return mayAttack;
	}

	@Override
	public void effect(Pokemon pokemon) {
		Random random = new Random();
		mayAttack = random.nextBoolean();
		System.out.println("Your Pokemon is paralyzed!");
	}
}
