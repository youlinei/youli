package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataBaseUtil {
	// ���ݿ������ַ�����
		private static String driver = ConfigManager.getProperty("driver");
		// ����URL�ַ�����
		private static String url = ConfigManager.getProperty("url");
		// ���ݿ��û�������
		private static String user = ConfigManager.getProperty("user");
		// �û����룡
		private static String password = ConfigManager.getProperty("password");

		// ��̬��������ڼ��������࣡
		static {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		/**
		 * ��ȡ���ݿ����Ӷ���
		 * 
		 * @return
		 */
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			// �������Ӷ���
			return conn;
		}
		
		/**
		 * �ر����ݿ����ӣ�
		 * @param rs ResultSet����
		 * @param pstmt PreparedStatement����
		 * @param conn Connection����
		 */
		public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			// �ر�ResultSet�������ӣ�
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			// �ر�PreparedStatement�������ӣ�
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			// �ر�Connection�������ӣ�
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

}
