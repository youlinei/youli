package entity;

public class StudentRole {
	private int xid;
	private int qid;
	public StudentRole(){
		
		
		
	}
	public StudentRole(int xid,int qid) {
		this.xid=xid;
		this.qid=qid;
	
	}
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}

}
