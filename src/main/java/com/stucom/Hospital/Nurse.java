package com.stucom.Hospital;
 
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "nurses")

public class Nurse {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
 
	@JsonProperty("name")
	@Column(name = "name", nullable = false, length = 150)
	private String NAME;
 
	@JsonProperty("user")
	@Column(name = "user", nullable = false, unique = true, length = 50)
	private String USER;
 
	@Column(name = "password", nullable = false, length = 255)
	private String PASSWORD;
 
    public Nurse(){}
    
	public Nurse(String name,String user,String password){
        this.NAME = name;
        this.USER = user;
        this.PASSWORD = password;
    }
 
	public Integer getID(){return ID;}
    public String getName(){return NAME;}
    public String getUser(){return USER;}
    public String getPassword(){return PASSWORD;}

	public void setIDd(Integer id){this.ID = id;}
	public void setNombreCompleto(String name){this.NAME = name;}
	public void setNombreUsuario(String user) {this.USER = user;}
	public void setContrasena(String password){this.PASSWORD = password;}

    @Override 
    public String toString(){
        return "["+ NAME+","+USER+","+PASSWORD+"]";
    }

}
 