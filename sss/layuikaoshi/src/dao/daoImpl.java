package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class daoImpl extends Basedao implements dao {

	public daoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<yuangong> select() {
		List<yuangong> list = new ArrayList<yuangong>();
		ResultSet rs = null;
		String sql="SELECT  y.id, y.name, b.bumen,j.jname, z.zhicheng FROM yuangongbiao AS Y, bumenbiao AS b,juese AS j,zhichengbiao AS z WHERE bumenid=b.`id` AND jueseid=j.`id` AND zhichengid=z.`id`";
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {	
			 int ids=rs.getInt("id");
			 String bumen=rs.getString("bumen");
			 String name=rs.getString("name");
			 String jname=rs.getString("jname");
			 String zhicheng=rs.getString("zhicheng");
			list.add(new yuangong(ids, name, 0, 0, 0, bumen, jname, zhicheng));
			
			
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public List<menu> selectlistid(int id) {
		List<menu> list = new ArrayList<menu>();
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu where mfatherid=?";
		Object[] parms = { id };
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("mname");
			 int mfatherid=rs.getInt("mfatherid");
			 String mfunction=rs.getString("mfunction");
			 int type=rs.getInt("type");
			 String mbtn=rs.getString("mbtn");
			 String url=rs.getString("url");
			 String description=rs.getString("description");
			 String icon=rs.getString("icon");
			 String js=rs.getString("js");
			 list.add(new menu(ids,mname,mfatherid,mfunction,type,mbtn,url,description,icon,js ));	
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
		
		
		
	}

	@Override
	public List<menu> selectid() {
		List<menu> list = new ArrayList<menu>();
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu ";
	
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("mname");
			 int mfatherid=rs.getInt("mfatherid");
			 String mfunction=rs.getString("mfunction");
			 int type=rs.getInt("type");
			 String mbtn=rs.getString("mbtn");
			 String url=rs.getString("url");
			 String description=rs.getString("description");
			 String icon=rs.getString("icon");
			 String js=rs.getString("js");
			 list.add(new menu(ids,mname,mfatherid,mfunction,type,mbtn,url,description,icon,js ));	
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public int insert(yuangong yuangong) {
		String sql="INSERT INTO  yuangongbiao (NAME,bumenid,zhichengid,jueseid) VALUES(?,?,?,?)";
		Object[] parms={yuangong.getName(),yuangong.getBumenid(),yuangong.getJueseid(),yuangong.getZhichengid()};
	    return super.excuteUpdate(sql, parms);
	}

	@Override
	public int yuangongdel(int id) {
		String sql="DELETE FROM yuangongbiao WHERE id=?";
		Object[] parms={id};
			return super.excuteUpdate(sql, parms);
		
	}

	@Override
	public int yuangongUpdate(yuangong yuangong) {
		String sql="UPDATE yuangongbiao SET NAME=?,zhichengid=?,bumenid=?,jueseid=? WHERE id=?";
		Object[] parms={yuangong.getName(),yuangong.getBumenid(),yuangong.getJueseid(),yuangong.getZhichengid(),yuangong.getId()};
	    return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<bumengbiao> bumengbiao() {
		List<bumengbiao> list = new ArrayList<bumengbiao>();
		ResultSet rs = null;
		String sql="SELECT * FROM bumenbiao";
	
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("bumen");
			
			 list.add(new bumengbiao(ids,mname));	
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public List<juese> juesesbiao() {
		List<juese> list = new ArrayList<juese>();
		ResultSet rs = null;
		String sql="SELECT * FROM juese";
	
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("jname");
			
			 list.add(new juese(ids,mname,null));	
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public List<zhichengbiao> zhichengbiao() {
		List<zhichengbiao> list = new ArrayList<zhichengbiao>();
		ResultSet rs = null;
		String sql="SELECT * FROM zhichengbiao";
	
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("zhicheng");
			
			 list.add(new zhichengbiao(ids,mname));	
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public yuangong xiugaichaxun(int id) {
		yuangong yuangong=new yuangong();
		ResultSet rs = null;
		Object[] parms={id};
		String sql="SELECT id,name FROM yuangongbiao WHERE id=?";
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {	
				yuangong=new yuangong();
				yuangong.setId(rs.getInt(1));
				yuangong.setName(rs.getString(2));
				
				
			
			
			
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return yuangong;
	}

	@Override
	public menu caidanxiugailist(int id) {
		menu menu=null;
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu where id=?";
		Object[] parms = { id };
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
				menu=new menu();
			  menu.setId(rs.getInt(1));
			  menu.setMname(rs.getString(2));
			  menu.setMfatherid(rs.getInt(3));
			  menu.setMfunction(rs.getString(4));
			  menu.setUrl(rs.getString(5));
			  menu.setIcon(rs.getString(6));
			  menu.setType(rs.getInt(7));
			  menu.setJs(rs.getString(8));
			  menu.setDescription(rs.getString(9));
			  menu.setMbtn(rs.getString(10));
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return menu;
	}

	@Override
	public int candanxiugai(menu menu) {
		String sql="UPDATE ls_menu SET mname=?,mfunction=?,TYPE=?,icon=?,mbtn=?,mfatherid=? WHERE id=? ";
		Object[] parms={menu.getMname(),menu.getMfunction(),menu.getType(),menu.getIcon(),menu.getMbtn(),menu.getMfatherid(),menu.getId()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public int caidanadd(menu menu) {
		String sql="INSERT INTO `ls_menu`(`mname`,`mfatherid`,`mfunction`,`type`,`mbtn`,`icon`) VALUES(?,?,?,?,?,?)";
		Object[] parms={menu.getMname(),menu.getMfatherid(),menu.getMfunction(),menu.getType(),menu.getMbtn(),menu.getIcon()};
	    return super.excuteUpdate(sql, parms);
	}

	@Override
	public int caidandelete(int id) {
		String sql="delete from ls_menu where id=? ";
		Object[] parms={id};
	    return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<button> button() {
		List<button> list = new ArrayList<button>();
		ResultSet rs = null;
		String sql="SELECT * FROM ls_button";
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
				int ids=rs.getInt("id");
				String button=rs.getString("button");
				 
				
				 list.add(new button(ids,button));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
		
	}
	
	
	
	public List<menu> typelist(int id) {
		List<menu> list = new ArrayList<menu>();
		ResultSet rs = null;
		String sql="SELECT * FROM ls_menu WHERE TYPE=?";
		Object[] parms={id};
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("mname");
			 int mfatherid=rs.getInt("mfatherid");
			 String mfunction=rs.getString("mfunction");
			 int type=rs.getInt("type");
			 String mbtn=rs.getString("mbtn");
			 String url=rs.getString("url");
			 String description=rs.getString("description");
			 String icon=rs.getString("icon");
			 String js=rs.getString("js");
			 list.add(new menu(ids,mname,mfatherid,mfunction,type,mbtn,url,description,icon,js));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	
	}

	@Override
	public List<juese> jueseslist() {
		List<juese> list = new ArrayList<juese>();
		ResultSet rs = null;
		String sql="SELECT j.`id`,j.`jname`,y.`name`  FROM juese AS j,yuangongbiao AS Y WHERE j.`id`=y.`jueseid`  ORDER BY id";
	
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("jname");
			 String name=rs.getString("name");	 
			 list.add(new juese(ids,mname,name));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}
	
	
	
	@Override
	public List<menutwo> treeid() {
		List<menutwo> list = new ArrayList<menutwo>();
		ResultSet rs = null;
		String sql="SELECT id,mname,mfatherid from ls_menu";
		
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("mname");
			 int mfatherid=rs.getInt("mfatherid");
			
			 list.add(new menutwo(ids, mfatherid, mname));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public List<menutwo> yonghuidquanxian(int id) {
		List<menutwo> list = new ArrayList<menutwo>();
		ResultSet rs = null;
		Object[] parms = { id };
		String sql="SELECT * FROM `ls_menu` WHERE id IN (SELECT quanxianid FROM `quanxianjiaosebiao` WHERE jueseid=?)";
		
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String mname=rs.getString("mname");
			 int mfatherid=rs.getInt("mfatherid");
			
			 list.add(new menutwo(ids, mfatherid, mname));
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public int quanxiandelete(int userid) {
		String sql="DELETE FROM `quanxianjiaosebiao` WHERE jueseid =?";
		Object[] parms={userid};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public int quanxianaddxinzeng(quanxianjiaosebiao quanxianjiaosebiao) {

		String sql="insert into quanxianjiaosebiao values(?,?) ";
		Object[] parms={quanxianjiaosebiao.getJueseid(),quanxianjiaosebiao.getQuanxianid()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public int quanxianadd(int userid, String[] array) {

		String sql="insert into quanxianjiaosebiao values(?,?) ";
		Object[] parms={userid,array};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<gongzibiao> gongzichaxun() {
		List<gongzibiao> list = new ArrayList<gongzibiao>();
		ResultSet rs = null;
		String sql="SELECT * FROM gongzi";
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {	
			 int ids=rs.getInt("id");
			 String bumen=rs.getString("name");
			 int money=rs.getInt("money");
		
			list.add(new gongzibiao(ids, bumen,money));
			
			
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}

	@Override
	public int gongziadd(gongzibiao gongzibiao) {
		String sql="INSERT INTO gongzi (NAME,money) values(?,?) ";
		Object[] parms={gongzibiao.getMoney(),gongzibiao.getName()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public int gongzidel(int id) {
		String sql="DELETE  FROM gongzi WHERE id=? ";
		Object[] parms={id};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public int gongzixiugai(gongzibiao gongzibiao) {
		String sql="UPDATE gongzi SET NAME=?,money=? WHERE id=? ";
		Object[] parms={gongzibiao.getMoney(),gongzibiao.getName(),gongzibiao.getId()};
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public gongzibiao gongzixiiugaichaxun(int id) {
		gongzibiao menu=null;
		ResultSet rs = null;
		String sql="SELECT * FROM gongzi WHERE id=?";
		Object[] parms = { id };
		//2. ±‡–¥sql”Ôæ‰
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
				menu=new gongzibiao();
			  menu.setId(rs.getInt(1));
			  menu.setName(rs.getString(2));
			  menu.setMoney(rs.getInt(3));
			 
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return menu;
	}

	

	
	

}
