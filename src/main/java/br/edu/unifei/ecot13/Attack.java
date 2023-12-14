package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class Attack implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -164034021896825289L;
	@ManyToOne
	private Type type;
	private int powerPoints;
    private int attackPrecision;
    private int power;
    @Id
    @GeneratedValue
    private int codigo;

    public abstract int attack(int health, int defense);
}