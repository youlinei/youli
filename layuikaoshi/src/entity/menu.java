package entity;

public class menu {
	private int id;//id
	private String mname;//Ȩ��
	private  int mfatherid; //����id
	private  String  mfunction;//������
	private int type;//����
	private String mbtn;//���
	private String url;
	
	private String description;
	private String js;

	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public menu(int id,String mname,int mfatherid,String mfunction,int type,String mbtn,String url,String description,String icon,String js){
		this.id=id;
		this.mname=mname;
		this.mfatherid=mfatherid;
		this.mfunction=mfunction;
		this.type=type;
		this.mbtn=mbtn;
		this.description=description;
		this.url=url;
		this.icon=icon;
		this.js=js;
		
		
		
	}
	public menu() {
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	public String getMfunction() {
		return mfunction;
	}
	public void setMfunction(String mfunction) {
		this.mfunction = mfunction;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMbtn() {
		return mbtn;
	}
	public void setMbtn(String mbtn) {
		this.mbtn = mbtn;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String icon;//��֪��


}
