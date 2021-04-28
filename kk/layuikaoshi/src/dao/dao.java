package dao;

import java.util.List;

import entity.bumengbiao;
import entity.button;
import entity.gongzibiao;
import entity.juese;
import entity.menu;
import entity.menutwo;
import entity.quanxianjiaosebiao;

import entity.yuangong;
import entity.zhichengbiao;

public interface dao {
	
	public List<menu> selectid();
	public List<menu> selectlistid(int id);
	public List<yuangong> select(); 
	
	
	public int  insert(yuangong yuangong);
	public int yuangongdel(int id);
	public int yuangongUpdate(yuangong yuangong);
	
	public List<bumengbiao> bumengbiao();
	public List<juese> juesesbiao();
	public List<zhichengbiao> zhichengbiao();
	public yuangong xiugaichaxun(int id);
	
	
	public menu caidanxiugailist(int id);
	public int candanxiugai( menu menu);
	public int caidanadd(menu menu) ;
	public int caidandelete(int id) ;
	public List<button> button();
	public List<menu> typelist(int id);
	public List<juese>  jueseslist();
	public List<menutwo> treeid();
	public List<menutwo> yonghuidquanxian(int id);
	public int quanxiandelete(int userid) ;
	public int quanxianaddxinzeng(quanxianjiaosebiao quanxianjiaosebiao) ;
	public int quanxianadd(int userid,String[] array) ;
	
	
	
	
	
	
	public List<gongzibiao> gongzichaxun();
	public int gongziadd(gongzibiao gongzibiao);
	public int gongzidel(int id);
	public int gongzixiugai(gongzibiao gongzibiao);
	
	
	public gongzibiao gongzixiiugaichaxun(int  id);
		
		
		
		
	}
	
	
	

	
	
	
	
	
	
	

