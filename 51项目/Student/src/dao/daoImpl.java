package dao;

import java.sql.Connection;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



import java.util.List;



import utils.DataBaseUtil;



import entity.Student;
import entity.button;
import entity.classs;
import entity.jiaoyuan;
import entity.menu;
import entity.role;
import entity.time;

public class daoImpl extends Basedao implements dao {

	public daoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	
	                               //��½
	@Override
	public Student denglu(String loginname) {
		// SQL��䣡
		String sql = "SELECT id,xname,loginname,'password' classid,'data',deltes,roleid FROM student WHERE loginname=?";
		// ��������Ϊռλ����ֵ��
		Object[] parms = { loginname };
		ResultSet set = null;
		// �����û���Ϣ����
		Student easybuyUserLogin = null;
		try {
			// ���÷�����
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					easybuyUserLogin = new Student();
					easybuyUserLogin.setId(set.getInt("id"));
					easybuyUserLogin.setXname(set.getString("xname"));
					easybuyUserLogin.setLoginname(set.getString("loginname"));
					easybuyUserLogin.setPassword(set.getString("password"));
					easybuyUserLogin.setClassid(set.getInt("classid"));
					easybuyUserLogin.setData(set.getDate("data"));
					easybuyUserLogin.setDeltes(set.getInt("deltes"));
					easybuyUserLogin.setRoleid(set.getInt("roleid"));	
				}
			}
		} catch (Exception e) {
		
		} finally {
			// �ͷ���Դ��
			DataBaseUtil.closeAll(set, null, null);
		}
		return easybuyUserLogin;
	}
	
	

	@Override
	public List<menu> dengluquanxian(int id) {
		List<menu> list = new ArrayList<menu>();
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu WHERE id IN(SELECT qid FROM student_role WHERE xid=?)";
		Object[] parms = { id };
		//2. ��дsql���
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
			// TODO Auto-generated catch block
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
			String sql="SELECT * FROM ls_menu WHERE TYPE=3 AND mfatherid=?";
			Object[] parms = { id };
			//2. ��дsql���
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 return list;
		}


	@Override
	public List<Student> StudentSelect(int id) {

		List<Student> list = new ArrayList<Student>();
		ResultSet rs = null;
		String sql="SELECT s.id,xname,t.data,t.deletes FROM student AS s,TIME AS t WHERE s.`id`=t.id AND s.id=? ";
		Object[] parms = { id };
		//2. ��дsql���
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String xname=rs.getString("xname");
			 Date data=rs.getDate("data");
	     	 int deltes=rs.getInt("deletes");
	     	 
			 list.add(new Student(ids, xname, null, null, 0, null, deltes, 0,data));	
			 for (Student lists : list) {
				 System.out.println( lists.getXname());
				 System.out.println( lists.getData());
				
				
			}
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return list;
	}


	@Override
	public List<classs> ClassSeletc() {

		List<classs> list = new ArrayList<classs>();
		ResultSet rs = null;
		String sql="SELECT c.`id`,c.`bname`,s.jiaoname FROM class AS c,jiaoyuan AS s WHERE c.`teacherid`=s.`id`";
		
		//2. ��дsql���
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
	          String  bname=rs.getString("bname");
	          String xname=rs.getString("jiaoname");
	        list.add(new classs(ids, bname, 0, null,xname)) ;
	    	
			 
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return list;
	}


	@Override
	public int timeadd(time time) {
		String sql="insert into time values(?,?,?)";
		Object[] parms={time.getId(),time.getData(),time.getDeltes()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int timeAjax(int id, Date data) {

	    int count=0;
		ResultSet rs = null;
		String sql="SELECT COUNT(*) FROM TIME WHERE id=? AND DATA=?";
		Object[] parms = {id, data};
		//2. ��дsql���
		rs = super.excuteQuery(sql, parms);

		 try {
				while (rs.next()) {
					count=rs.getInt(1);
				}	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return count;

	}


	@Override
	public List<jiaoyuan> jiaoyuan() {
		List<jiaoyuan> list = new ArrayList<jiaoyuan>();
		ResultSet rs = null;
		String sql="SELECT * FROM jiaoyuan";
		
		//2. ��дsql���
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			  int ids=rs.getInt("id");
	          String  bname=rs.getString("jiaoname");
	          list.add(new jiaoyuan(ids,bname)) ;
	    	
			 
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return list;
	}


	@Override
	public int classinset(classs classs) {
	String sql="INSERT INTO class (bname,teacherid) VALUES (?,?)";
	Object[] parms={classs.getName(),classs.getTeacherid()};
	return super.excuteUpdate(sql, parms);
	
	}


	@Override
	public int classdel(int id) {
		String sql="DELETE FROM class WHERE id=?";
		Object[] parms={id};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int calssxiugai(classs classs) {
		String sql="UPDATE class SET bname=?,teacherid=? WHERE id=?";
		Object[] parms={classs.getName(),classs.getTeacherid(),classs.getId()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public classs classchaxunid(int id) {
		
		// SQL��䣡
		String sql = "SELECT id,bname,teacherid FROM class WHERE id=?";
		// ��������Ϊռλ����ֵ��
		Object[] parms = { id };
		ResultSet set = null;
		// �����û���Ϣ����
		classs easybuyUserLogin = null;
		try {
			// ���÷�����
			set = super.excuteQuery(sql, parms);
			if (set != null) {
				while (set.next()) {
					easybuyUserLogin = new classs();
					easybuyUserLogin.setId(set.getInt("id"));
					easybuyUserLogin.setName(set.getString("bname"));
					easybuyUserLogin.setTeacherid(set.getInt("teacherid"));
					
					
				}
			}
		} catch (Exception e) {
		
		} finally {
			// �ͷ���Դ��
			DataBaseUtil.closeAll(set, null, null);
		}
		return easybuyUserLogin;
	}


	@Override
	public List<menu> selectall() {
		List<menu> list = new ArrayList<menu>();
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu";
		//2. ��дsql���
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
	public menu caidanxiugailist(int id) {
		menu menu=null;
		ResultSet rs = null;
		String sql="SELECT * FROM  ls_menu where id=?";
		Object[] parms = { id };
		//2. ��дsql���
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
	public List<button> button() {
		List<button> list = new ArrayList<button>();
		ResultSet rs = null;
		String sql="SELECT * FROM button";
		//2. ��дsql���
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
				int ids=rs.getInt("id");
				String button=rs.getString("bname");
				 
				
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
	public List<Student> selectallStudent() {
		List<Student> list = new ArrayList<Student>();
		ResultSet rs = null;
		String sql="SELECT s. id,s.xname,s.loginname,c.bname,PASSWORD ,s.datas FROM  student AS s,class AS c WHERE roleid=1 AND s.classid=c.id";
		
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String xname=rs.getString("xname");
			 String  bname=rs.getString("bname");
			 String loginname=rs.getString("loginname");
			 String password=rs.getString("password");
		     Date dataDate=rs.getDate("datas");
	
			 list.add(new Student(ids, xname, loginname, password, 0, bname, 0, 0, dataDate));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}


	@Override
	public int StudentAdd(Student student) {
		String sql="INSERT INTO student (xname,loginname,PASSWORD,classid,roleid) VALUES(?,?,?,?,1) ";
		Object[] parms={student.getXname(),student.getLoginname(),student.getPassword(),student.getClassid()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int StudentDel(int id) {
		String sql="DELETE FROM student WHERE id=? ";
		Object[] parms={id};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int StudentUpdate(Student student) {
		String sql="UPDATE student SET xname=?,loginname=?,PASSWORD=?,classid=? WHERE id=?  ";
		Object[] parms={student.getXname(),student.getLoginname(),student.getPassword(),student.getClassid(),student.getId()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public Student StudentUpdateSelectId(int id) {
		Student menu=null;
		ResultSet rs = null;
		String sql="SELECT id,xname,loginname,password FROM student where id=?";
		Object[] parms = { id };
		//2. ��дsql���
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
				menu=new Student();
			  menu.setId(rs.getInt(1));
			  menu.setXname(rs.getString(2));
			  menu.setLoginname(rs.getString(3));
			  menu.setPassword(rs.getString(4));
	
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
	public List<classs> banjixialkuang() {
		List<classs> list = new ArrayList<classs>();
		ResultSet rs = null;
		String sql="SELECT id,bname FROM class";
		
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String xname=rs.getString("bname");
			
	
			 list.add(new classs(ids, xname, 0, null, null));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}


	@Override
	public List<role> RoleSelect() {
		List<role> list = new ArrayList<role>();
		ResultSet rs = null;
		String sql="SELECT * FROM role";
		
		rs = super.excuteQuery(sql, null);
		 try {
			while (rs.next()) {
			 int ids=rs.getInt("id");
			 String jname=rs.getString("jname");
			
	
			 list.add(new role(ids, jname));	
}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return list;
	}


	@Override
	public int RoleAdd(role role) {
		String sql="INSERT INTO role (jname) VALUES(?) ";
		Object[] parms={role.getJname()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int RoleDel(int id) {
		String sql="DELETE FROM role WHERE id=? ";
		Object[] parms={id};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public int RoleUpd(role role) {
		String sql="UPDATE role SET jname=? WHERE id=? ";
		Object[] parms={role.getJname(),role.getId()};
		return super.excuteUpdate(sql, parms);
	}


	@Override
	public role RoleUpdSelect(int id) {
		role menu=null;
		ResultSet rs = null;
		String sql="SELECT id,jname FROM role WHERE id=?";
		Object[] parms = { id };
		//2. ��дsql���
		rs = super.excuteQuery(sql, parms);
		 try {
			while (rs.next()) {
				menu=new role();
			  menu.setId(rs.getInt(1));
			  menu.setJname(rs.getString(2));
			
	
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
	
	
	
	
	
	
