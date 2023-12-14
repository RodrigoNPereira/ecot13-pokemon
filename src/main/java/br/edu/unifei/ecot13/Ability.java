package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ability implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2060095314012961601L;
	@Id
    private String name;
    private String effect;

    public Ability(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

}