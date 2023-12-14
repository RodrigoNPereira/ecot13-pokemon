package br.edu.unifei.ecot13;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class AlolanRaichu extends Pokemon {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4357446609547651658L;
	
	public AlolanRaichu() {}
	
	public AlolanRaichu(String name) {
        super(name);
    }

    @Override
    public Pokemon callEvolution() {
        System.out.println("There is a new Egg!");
        return new EggPichu(this.getName());

    }
}