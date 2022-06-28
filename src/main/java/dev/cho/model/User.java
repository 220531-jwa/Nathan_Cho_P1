package dev.cho.model;

public class User {
	private String username;
	private String password;
	private int id;
	private String name;
	private int accessLevel;
	
	public User() {
		super();
	}
	
	public User(int i, String username, String password, String name, int accessLevel) {
		super();
		this.id = i;
		this.username = username;
		this.password = password;
		this.name = name;
		this.accessLevel = accessLevel;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int getAccLvl() {
		return accessLevel;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccLvl(int accessLevel) {
		this.accessLevel = accessLevel;
	}
}
