package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Thunder extends Attack{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5107258592878092270L;
	private int powerPoints = 10;
    private final int attackPrecision = 70;
    private final int power = 110;

    public Thunder(){}

    @Override
    public int attack(int health, int defense) {
        if (Math.random() <= attackPrecision/100 & powerPoints > 0) {
            double newHealth = health-(power/(0.5*defense));
            int newHealthInt = (int) newHealth;

            if(Math.random() > 0.7){
                System.out.println("The pokemon is paralyzed!");
            }

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
