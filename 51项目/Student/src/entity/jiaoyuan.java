package entity;

public class jiaoyuan {
	private int id;
	private String jiaoname;
	public jiaoyuan(){
		
		
		
		
	}
	public jiaoyuan(int id,String jiaoname) {
		this.id=id;
		this.jiaoname=jiaoname;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJiaoname() {
		return jiaoname;
	}
	public void setJiaoname(String jiaoname) {
		this.jiaoname = jiaoname;
	}

}
