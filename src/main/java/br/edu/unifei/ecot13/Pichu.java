package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Pichu extends Pokemon {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9159225868974523540L;

	public Pichu() {}
	
	public Pichu(String name) {
        super(name);
    }

    @Override
    public Pikachu callEvolution() {
        HeldItem item = this.getItem();
        if (item.getName().equals("Thunderstone")){
            System.out.println("The Pichu has evolved!");
            return new Pikachu(this.getName());
        }
        System.out.println("Without the Thunderstone it won't evolve!");
        return null;
    }
}