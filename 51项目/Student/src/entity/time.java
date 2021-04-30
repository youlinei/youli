package entity;

import java.util.Date;

public class time {
	private int id;
	private Date data;
	private int deltes;
	public time(){
		
		
	}
	public time(int id,Date data,int deltes) {
		this.id=id;
		this.data=data;
		this.deltes=deltes;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDeltes() {
		return deltes;
	}
	public void setDeltes(int deltes) {
		this.deltes = deltes;
	}
	
	

}
