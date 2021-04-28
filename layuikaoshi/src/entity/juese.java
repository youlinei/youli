package entity;

public class juese {
	private int id;
	private String name;
	private String user;
	public int getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public juese(int id,String name,String user) {
		this.id=id;
		this.name=name;
		this.user=user;
		 
	}
	
	

}
