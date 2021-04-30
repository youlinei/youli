package service;

import java.sql.Connection;
import java.sql.Date;


import java.util.List;

import dao.daoImpl;

import utils.DataBaseUtil;

import entity.Student;
import entity.button;
import entity.classs;
import entity.jiaoyuan;
import entity.menu;
import entity.role;
import entity.time;

public class ServiceImpl implements Service {

	@Override
	public Student denglus(String loginname) {
		// 获得连接对象！
		Connection conn = null;
		Student list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).denglu(loginname);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<menu> dengluquanxians(int id) {
		// 获得连接对象！
		Connection conn = null;
	   List<menu> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).dengluquanxian(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<menu> selectlistids(int id) {
		// 获得连接对象！
				Connection conn = null;
			   List<menu> list=null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).selectlistid(id);
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public List<Student> StudentSelects(int id) {
		// 获得连接对象！
		Connection conn = null;
	   List<Student> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).StudentSelect( id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<classs> ClassSeletcs() {
		// 获得连接对象！
				Connection conn = null;
			   List<classs> list=null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).ClassSeletc();
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public int timeadds(time time) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).timeadd(time);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int timeAjaxs(int id, Date data) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).timeAjax(id, data);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public List<jiaoyuan> jiaoyuans() {
		// 获得连接对象！
		Connection conn = null;
	   List<jiaoyuan> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).jiaoyuan();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public int classinsets(classs classs) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).classinset(classs);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int classdels(int id) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).classdel(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int calssxiugais(classs classs) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).calssxiugai(classs);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public classs classchaxunids(int id) {
		// 获得连接对象！
		Connection conn = null;
		classs list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).classchaxunid(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
		
	}

	@Override
	public List<menu> selectalls() {
		// 获得连接对象！
		Connection conn = null;
	   List<menu> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).selectall();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public int caidanadds(menu menu) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).caidanadd(menu);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int caidandeletes(int id) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).caidandelete(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public menu caidanxiugailists(int id) {
		// 获得连接对象！
				Connection conn = null;
				menu list = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).caidanxiugailist(id);
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
				
	}

	@Override
	public int candanxiugais(menu menu) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).candanxiugai(menu);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public List<button> buttons() {
		// 获得连接对象！
		Connection conn = null;
	   List<button> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).button();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<menu> typelists(int id) {
		// 获得连接对象！
		Connection conn = null;
	   List<menu> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).typelist(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<Student> selectallStudents() {
		// 获得连接对象！
				Connection conn = null;
			   List<Student> list=null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).selectallStudent();
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public int StudentAdds(Student student) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).StudentAdd(student);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int StudentDels(int id) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).StudentDel(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int StudentUpdates(Student student) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).StudentUpdate(student);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public Student StudentUpdateSelectIds(int id) {
		// 获得连接对象！
				Connection conn = null;
				Student list = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).StudentUpdateSelectId(id);
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public List<classs> banjixialkuangs() {
		// 获得连接对象！
		Connection conn = null;
	   List<classs> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).banjixialkuang();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<role> RoleSelects() {
		// 获得连接对象！
		Connection conn = null;
	   List<role> list=null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).RoleSelect();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public int RoleAdds(role role) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).RoleAdd(role);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int RoleDels(int id) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).RoleDel(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public int RoleUpds(role role) {
		// 获得连接对象！
		Connection conn = null;
	 int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).RoleUpd(role);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return count;
	}

	@Override
	public role RoleUpdSelects(int id) {
		// 获得连接对象！
		Connection conn = null;
		role list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).RoleUpdSelect(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	
}
