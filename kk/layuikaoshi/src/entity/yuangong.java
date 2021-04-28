package entity;

public class yuangong {
	private int id;
	private String name;
	private int bumenid;
	private int zhichengid;
	private int jueseid;
	
	private String bumen;
	private String jname;
	private String zhicheng;
	public yuangong(){
		
		
		
		
	}
	
	
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public yuangong(int id,String name,int bumenid,int zhichengid,int jueseid,String bumen,String jname,String zhicheng) {
	  this.id=id;
	  this.name=name;
	  this.bumenid=bumenid;
	  this.zhichengid=zhichengid;
	  this.jueseid=jueseid;
	  
	  this.bumen=bumen;
	  this.jname=jname;
	  this.zhicheng=zhicheng;
	  
	}
	public int getId() {
		return id;
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
	public int getBumenid() {
		return bumenid;
	}
	public void setBumenid(int bumenid) {
		this.bumenid = bumenid;
	}
	public int getZhichengid() {
		return zhichengid;
	}
	public void setZhichengid(int zhichengid) {
		this.zhichengid = zhichengid;
	}
	public int getJueseid() {
		return jueseid;
	}
	public void setJueseid(int jueseid) {
		this.jueseid = jueseid;
	}

}

