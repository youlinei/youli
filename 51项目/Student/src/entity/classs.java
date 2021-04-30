package entity;

import java.sql.Date;

public class classs {
	private int id;
	private String name;
	private int teacherid;
	private Date data;
	private String xname;
	public classs(){
		
		
		
	}
 	public classs(int id,String name,int teacherid,Date date,String xname) {
		this.id=id;
		this.name=name;
		this.teacherid=teacherid;
		this.data=date;
		this.xname=xname;
	
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
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
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
