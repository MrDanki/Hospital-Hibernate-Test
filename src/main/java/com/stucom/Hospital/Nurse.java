package com.stucom.Hospital;

import jakarta.persistence.*;

@Entity
@Table(name = "Nurse")

public class Nurse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NurseID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "User")
    private String user;

    @Column(name = "Password")
    private String password;

    // Constructor vacío obligatorio para JPA
    public Nurse() {
    }

    public Nurse(int id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    // getters y setters igual que ya los tienes

	public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
