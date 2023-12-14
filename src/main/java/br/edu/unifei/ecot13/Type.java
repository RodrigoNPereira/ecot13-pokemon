package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Type implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9141904369578764306L;
	@Id
    private String name;

    public Type(String name) {
        this.name = name;
    }
}