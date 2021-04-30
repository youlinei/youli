package entity;

import java.util.Date;






public class Student {
	private int id;
	private String xname;
	private String loginname;
	private String password;
	private int classid;
	private String bname;
	private int deltes;
    private int roleid;
    public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	private Date data;
    public Student(){
    	
    	
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}

	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getDeltes() {
		return deltes;
	}
	public void setDeltes(int deltes) {
		this.deltes = deltes;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Student(int id,String xname,String loginname,String password,int classid,String bname,int deltes,int roleid,Date data) {
	
		
		this.id=id;
		this.xname=xname;
		this.loginname=loginname;
		this.password=password;
		this.classid=classid;
		this.bname=bname;
		this.deltes=deltes;
		this.data=data;
		this.roleid=roleid;
	}
 	

}
