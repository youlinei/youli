package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigManager {
private static Properties properties = null;
	
	//��̬����飡�౻���ص�ʱ�������δ��룡
	static {
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(
                "database.properties");
		//�ж�InputStream�Ƿ�Ϊ�գ�
		if(is == null) {
			throw new RuntimeException("�Ҳ������ݿ���������ļ���");
		}
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("���ݿ����ò������ش���", e);
		}finally {
            try {
            	//���ر���Դ����
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	/**
	 * ͨ�����ҵ���Դ�ļ�����ŵ�ֵ��
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
