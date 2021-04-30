package entity;

public class role {
	private int id;
	private String jname;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}
  public role(){
	  
	  
  }
	public role(int id,String jname) {
	this.id=id;
	this.jname=jname;
	}
	
	

}
