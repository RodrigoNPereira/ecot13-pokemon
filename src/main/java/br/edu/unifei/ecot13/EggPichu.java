package br.edu.unifei.ecot13;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class EggPichu extends Pokemon {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6999745370975877150L;

	public EggPichu() {}
	
	public EggPichu(String name) {
        super(name);
    }

    @Override
    public Pichu callEvolution() {
        System.out.println("The Egg has hatched!");
        return new Pichu(this.getName());
    }
}