package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.daoImpl;



import utils.DataBaseUtil;
import utils.TransferArray;


import entity.bumengbiao;
import entity.button;
import entity.gongzibiao;
import entity.juese;
import entity.menu;
import entity.menutwo;
import entity.page;
import entity.quanxianjiaosebiao;
import entity.tree;

import entity.yuangong;
import entity.zhichengbiao;

public class serviceImpl implements service {

	
	@Override
	public List<yuangong> selects() {
		// 获得连接对象！
				Connection conn = null;
				List<yuangong> list = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).select();
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
		List<menu> list = null;
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
	public List<menu> selectids() {
		// 获得连接对象！
				Connection conn = null;
				List<menu> list = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).selectid();
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public int inserts(yuangong yuangong) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).insert(yuangong);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int yuangongdels(int id) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).yuangongdel(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int yuangongUpdates(yuangong yuangong) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).yuangongUpdate(yuangong);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public List<bumengbiao> bumengbiaos() {
		// 获得连接对象！
		Connection conn = null;
		List<bumengbiao> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).bumengbiao();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<juese> juesesbiaos() {
		// 获得连接对象！
		Connection conn = null;
		List<juese> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).juesesbiao();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<zhichengbiao> zhichengbiaos() {
		// 获得连接对象！
		Connection conn = null;
		List<zhichengbiao> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).zhichengbiao();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public yuangong xiugaichaxuns(int id) {
		// 获得连接对象！
		yuangong yuangong=new yuangong();
		Connection conn = null;
	
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			yuangong = new daoImpl(conn).xiugaichaxun(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return yuangong;
	}

	@Override
	public menu caidanxiugailists(int id) {
		// 获得连接对象！
		menu menu=new menu();
				Connection conn = null;
			
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					menu = new daoImpl(conn).caidanxiugailist(id);
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return menu;
	}

	@Override
	public int candanxiugais(menu menu) {
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
	public int caidanadds(menu menu) {
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
	public List<button> buttons() {
		// 获得连接对象！
				Connection conn = null;
				List<button> list = null;
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
		List<menu> list = null;
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
	public List<juese> jueseslists() {
		// 获得连接对象！
		Connection conn = null;
		List<juese> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).jueseslist();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public page<tree> treemenu() {
		List<menutwo>  menus=treeids();
		  page<tree> treePage=new page<tree>();
		  
		  treePage.setCode(0);
		  treePage.setCount(0);
		  treePage.setMsg("");
		  
		  List<tree> lisTrees=new ArrayList<tree>();
		  for (menutwo menutwo : menus) {
			  tree date=new tree();
			  date.setId(menutwo.getId());
			  date.setParentId(menutwo.getMfatherid());
			  date.setTitle(menutwo.getMname());
			  date.setCheckArr("0");
	       
			  lisTrees.add(date);
		}
		 
		  treePage.setData(lisTrees);
		  

			return treePage;
	}

	@Override
	public List<menutwo> treeids() {
		// 获得连接对象！
		Connection conn = null;
		List<menutwo> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).treeid();
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public int quanxiandeletes(int userid) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).quanxiandelete(userid);
			} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int quanxianaddxinzengs(int userid, int menuid) {
		Connection conn = null;
		quanxianjiaosebiao user=new quanxianjiaosebiao(userid,menuid);
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).quanxianaddxinzeng(user);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int quanxianadds(int userid, String[] array) {
	Connection conn = null;
	   
		
		int count=this.quanxiandeletes(userid);
		
		int[] arrs = TransferArray.StringToInt(array);
	
		try {
			conn = DataBaseUtil.getConnection();
			
			if(count != -1) {
				for (int i = 0; i < arrs.length; i++) {
					int menus=this.quanxianaddxinzengs(userid, arrs[i]);
					if(menus > 0) {	
						menus++;
					}
				}
			}
			// 调用数据访问层代码！
			
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public List<menutwo> yonghuidquanxians(int id) {
		// 获得连接对象！
		Connection conn = null;
		List<menutwo> list = null;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			list = new daoImpl(conn).yonghuidquanxian(id);
		} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

	@Override
	public List<gongzibiao> gongzichaxuns() {
		// 获得连接对象！
				Connection conn = null;
				List<gongzibiao> list = null;
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					list = new daoImpl(conn).gongzichaxun();
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return list;
	}

	@Override
	public int gongziadds(gongzibiao gongzibiao) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).gongziadd(gongzibiao);
			} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int gongzidels(int id) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).gongzidel(id);
			} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public int gongzixiugais(gongzibiao gongzibiao) {
		Connection conn = null;
		int count=0;
		try {
			conn = DataBaseUtil.getConnection();
			// 调用数据访问层代码！
			count = new daoImpl(conn).gongzixiugai(gongzibiao);
			} catch (Exception e) {
		
		} finally {
			// 释放资源！
			DataBaseUtil.closeAll(null, null, conn);
		}

		return count;
	}

	@Override
	public gongzibiao gongzixiiugaichaxun(int id) {
		// 获得连接对象！
		gongzibiao menu=new gongzibiao();
				Connection conn = null;
			
				try {
					conn = DataBaseUtil.getConnection();
					// 调用数据访问层代码！
					menu = new daoImpl(conn).gongzixiiugaichaxun(id);
				} catch (Exception e) {
				
				} finally {
					// 释放资源！
					DataBaseUtil.closeAll(null, null, conn);
				}
				return menu;
	}

}
