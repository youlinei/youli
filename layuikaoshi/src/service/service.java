package service;

import java.util.List;

import entity.bumengbiao;
import entity.button;
import entity.gongzibiao;
import entity.juese;
import entity.menu;
import entity.menutwo;
import entity.page;

import entity.tree;
import entity.yuangong;
import entity.zhichengbiao;

public interface service {
	public List<menu> selectlistids(int id) ;
	public List<yuangong> selects(); 
	public List<menu> selectids();

	public int  inserts(yuangong yuangong);
	public int yuangongdels(int id);
	public int yuangongUpdates(yuangong yuangong);
	
	
	public List<bumengbiao> bumengbiaos();
	public List<juese> juesesbiaos();
	public List<zhichengbiao> zhichengbiaos();
	public yuangong xiugaichaxuns(int id);
	
	
	public menu caidanxiugailists(int id);
	public int candanxiugais( menu menu);
	public int caidanadds(menu menu) ;
	public int caidandeletes(int id) ;
	public List<button> buttons();
	
	public List<menu> typelists(int id);
	public List<juese> jueseslists();
	public page<tree> treemenu();
	public List<menutwo> treeids();
	
	
	public List<menutwo> yonghuidquanxians(int id);
	public int quanxiandeletes(int userid) ;
	public int quanxianaddxinzengs(int userid, int menuid) ;
	public int quanxianadds(int userid,String[] array) ;
	
	
	
	public List<gongzibiao> gongzichaxuns();
	public int gongziadds(gongzibiao gongzibiao);
	public int gongzidels(int id);
	public int gongzixiugais(gongzibiao gongzibiao);
	public gongzibiao gongzixiiugaichaxun(int  id);
	
	

}
