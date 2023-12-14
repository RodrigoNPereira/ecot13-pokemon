package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Pokeball implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 179290821490490857L;
	private String name;
    private float effectviness;
    private String sideEffect;
    @OneToOne
    private Pokemon capture;
    @Id
    @GeneratedValue
    private int numeroDeSerie;

    public Pokeball(String name, int effectviness, String sideEffect) {
        this.name = name;
        this.effectviness = effectviness;
        this.sideEffect = sideEffect;
    }

    
    public void capturePokemon(Pokemon pokemon) {
        if(Math.random() <= this.effectviness/100){
            this.capture = pokemon;
            System.out.println("The Pokemon was captured!");
        }else{
            System.out.println("Effectviness: " + this.effectviness/100 + "\nThe Pokemon has run away!");
        }
    }
}