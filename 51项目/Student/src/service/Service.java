package service;



import java.sql.Date;
import java.util.List;

import entity.Student;
import entity.button;
import entity.classs;
import entity.jiaoyuan;
import entity.menu;
import entity.role;
import entity.time;

public interface Service {
	public Student denglus(String loginname);	
	
	public List<menu> dengluquanxians(int id);
	public List<menu> selectlistids(int id) ;//��ѯ�û�����Ӧ�İ�ť
	public List<Student> StudentSelects(int id);//ѧ��ǩ����ѯ
	
	public List<classs> ClassSeletcs();//�༶��ѯ
	public int timeadds(time time);
	public int timeAjaxs(int id, Date data);
	
	
	public List<jiaoyuan> jiaoyuans();
	
	


	public int  classinsets(classs classs);
	public int classdels(int id);
	public int calssxiugais(classs classs);
	public classs classchaxunids(int id);
	
	
	
	
	 //Ȩ��
		public List<menu> selectalls();
		public int caidanadds(menu menu);
		public int caidandeletes(int id);
		public menu caidanxiugailists(int id);
		public int candanxiugais(menu menu);
		public List<button> buttons();
		public List<menu> typelists(int id);
		
		
		
		
		
		
		
		
		public List<Student> selectallStudents();
		public int StudentAdds(Student student);
		public int StudentDels(int id);
		public int StudentUpdates(Student student);
		public Student StudentUpdateSelectIds(int id);
		public List<classs> banjixialkuangs();
		
		
		
		
		
		
		
		
		
		//��ɫ
		public List<role> RoleSelects();
		public int RoleAdds(role role);
		public int RoleDels(int id);
		public int RoleUpds(role role);
		public role RoleUpdSelects(int id);
		
		
		
		
	
	
	
}
