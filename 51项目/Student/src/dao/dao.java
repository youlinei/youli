package dao;






import java.util.Date;
import java.util.List;

import entity.Student;
import entity.button;
import entity.classs;
import entity.jiaoyuan;
import entity.menu;
import entity.role;
import entity.time;

public interface dao {
	public Student denglu(String loginname);//��½
	public List<menu> dengluquanxian(int id);//�û���½Ȩ��
	public List<menu> selectlistid(int id) ;//��ѯ�û�����Ӧ�İ�ť
	
	
	//ǩ��
	public List<Student> StudentSelect(int id) ;//ѧ��ǩ����ѯ
	public List<classs> ClassSeletc();
	public int timeadd(time time);
	public int timeAjax(int id,Date data);
	
	
	 //�༶��ɾ�Ĳ�
	public List<jiaoyuan> jiaoyuan();
	public int  classinset(classs classs);
	public int classdel(int id);
	public int calssxiugai(classs classs);
	public classs classchaxunid(int id);
	
	
	
	//Ȩ��
	public List<menu> selectall();
	public int caidanadd(menu menu);
	public int caidandelete(int id);
	public menu caidanxiugailist(int id);
	public int candanxiugai(menu menu);
	public List<button> button();
	public List<menu> typelist(int id);
	
	
	//ѧ������
	public List<Student> selectallStudent();
	public int StudentAdd(Student student);
	public int StudentDel(int id);
	public int StudentUpdate(Student student);
	public Student StudentUpdateSelectId(int id);
	public List<classs> banjixialkuang();
	
	
	//��ɫ
	public List<role> RoleSelect();
	public int RoleAdd(role role);
	public int RoleDel(int id);
	public int RoleUpd(role role);
	public role RoleUpdSelect(int id);
	
	

}
