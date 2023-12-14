package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class FleurCannon extends Attack{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8048284191777589825L;
	private int powerPoints = 5;
    private final int attackPrecision = 90;
    private final int power = 130;

    public FleurCannon(){}

    @Override
    public int attack(int health, int defense) {
        if (Math.random() <= attackPrecision/100 & powerPoints > 0) {
            double newHealth = health-(power/(0.5*defense));
            int newHealthInt = (int) newHealth;

            System.out.println("The attack was successful!");
            this.powerPoints -= 1;
            return newHealthInt;
        }
        else{
            System.out.println("Oh, you missed the attack!");
            this.powerPoints -= 1;
            return health;
        }
        
    }
}
