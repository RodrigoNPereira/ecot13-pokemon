package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class FirePunch extends Attack{

    /**
	 * 
	 */
	private static final long serialVersionUID = -815085517528765073L;
	private int powerPoints = 15;
    private final int attackPrecision = 100;
    private final int power = 75;

    public FirePunch(){}

    @Override
    public int attack(int health, int defense) {
        if (Math.random() <= attackPrecision/100 & powerPoints > 0) {
            double newHealth = health-(power/(0.01*defense));
            int newHealthInt = (int) newHealth;
            

            if(Math.random() > 0.7){
                System.out.println("The pokemon has burn!");
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
