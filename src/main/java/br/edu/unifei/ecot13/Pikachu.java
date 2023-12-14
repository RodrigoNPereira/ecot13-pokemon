package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Pikachu extends Pokemon {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4224269314718849762L;	

	public Pikachu() {}
	
	public Pikachu(String name) {
        super(name);
    }

    @Override
    public AlolanRaichu callEvolution() {
        HeldItem item = this.getItem();
        if (item.getName().equals("Alolan Thunderstone")){
            System.out.println("The Pikachu has evolved!");
            return new AlolanRaichu(this.getName());
        }
        System.out.println("Without the Alolan Thunderstone it wont evolve!");
        return null;
    }
}