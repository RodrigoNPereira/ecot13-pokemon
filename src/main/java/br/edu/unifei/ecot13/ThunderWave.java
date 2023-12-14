package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class ThunderWave extends Attack{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2425074626605658171L;
	private int powerPoints = 20;
    private final int attackPrecision = 100;

    public ThunderWave(){}

    @Override
    public int attack(int health, int defense) {
        if (Math.random() <= attackPrecision/100 & powerPoints > 0) {

            System.out.println("The attack was successful!");
            System.out.println("The pokemon is paralyzed!");
            System.out.println("The pokemon health is: "+ health);
            this.powerPoints -= 1;
            return health;
        }
        else{
            System.out.println("Oh, you missed the attack!");
            this.powerPoints -= 1;
            return health;
        }
    }
    
}
