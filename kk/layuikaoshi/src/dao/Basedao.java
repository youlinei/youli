package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DataBaseUtil;




public class Basedao {
	// ����Connection�������ԣ�
		private Connection conn = null;

		/**
		 * ���ι��췽����
		 * 
		 * @param conn
		 */
		public Basedao(Connection conn) {
			// ͨ�����췽������ʽ��Connection��ֵ��
			this.conn = conn;
		}

		/**
		 * ����ɾ���ģ���������
		 * 
		 * @param sql
		 * @param parms
		 * @return
		 */
		protected int excuteUpdate(String sql, Object[] parms) {
			// ����PreparedStatement����
			PreparedStatement pstms = null;
			// ��������������Ӱ��������
			int result = -1;
			try {
				// ִ��SQL��䣡
				pstms = conn.prepareStatement(sql);
				// �жϷ���ֵ����Ƿ�Ϊ�գ�
				if (parms != null) {
					// ѭ������Object���飡
					for (int i = 0; i < parms.length; i++) {
						// ѭ��ΪSQL��丳ֵ��
						pstms.setObject(i + 1, parms[i]);
					}
					// ������ɾ�ķ�����
					result = pstms.executeUpdate();

				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} finally {
				// �ر���Դ��
				DataBaseUtil.closeAll(null, pstms, null);
			}
			return result;
		}

		/**
		 * ��ѯ������
		 * 
		 * @param sql
		 * @param parms
		 * @return
		 * 
		 */
		protected ResultSet excuteQuery(String sql, Object[] parms) {
			// ����PreparedStatement����
			PreparedStatement pstms = null;
			// ����ResultSet�������ڷ��ز�ѯ���Ľ������
			ResultSet result = null;
			try {
				// ִ��SQL��䣡
				pstms = conn.prepareStatement(sql);
				// �жϷ���ֵ����Ƿ�Ϊ�գ�
				if (parms != null) {
					// ѭ������Object���飡
					for (int i = 0; i < parms.length; i++) {
						// ѭ��ΪSQL��丳ֵ��
						pstms.setObject(i + 1, parms[i]);
					}
				}
				// ���ò�ѯ������
				result = pstms.executeQuery();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return result;
		}
}
