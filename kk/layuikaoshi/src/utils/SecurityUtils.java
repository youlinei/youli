package utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {
	 /**
     * md5����
     *
     * @param value Ҫ���ܵ�ֵ
     * @return md5���ܺ��ֵ
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * 3��md5����
     * @param value
     * @return
     */
    public static String md5Hex3(String value) {
    	for (int i = 0; i < 3; i++) {
    		value = DigestUtils.md5Hex(value);
    	}
    	return value;
    }
    
    
    /**
     * sha256����
     *
     * @param value Ҫ���ܵ�ֵ
     * @return sha256���ܺ��ֵ
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }

    public static String sha512Hex(String value) {
        return DigestUtils.sha512Hex(value);
    }
    
    public static void main(String[] args) {
    	System.out.println(SecurityUtils.md5Hex("123456"));
	}

}
