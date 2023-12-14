package br.edu.unifei.ecot13;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Region implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4466491660498437251L;
	@Id
    private String name;

    public Region(String name){
        this.name = name;
    }

}