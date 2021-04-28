package entity;



public class menutwo {
	
	private int id;//id
	private String mname;//È¨ÏŞ
	private  int mfatherid; //¸¸Ààid
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMfatherid() {
		return mfatherid;
	}
	public void setMfatherid(int mfatherid) {
		this.mfatherid = mfatherid;
	}
	
	public menutwo(int id,int mfatherid,String mname){
		this.id=id;
		this.mfatherid=mfatherid;
		this.mname=mname;
				
		
		
		
		
		
		
	}

}
