package entity;

public class tree {
	private Integer id;
	private Integer parentId;
	private String title;
	private String checkArr ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCheckArr() {
		return checkArr;
	}
	public void setCheckArr(String checkArr) {
		this.checkArr = checkArr;
	}
	 

}
