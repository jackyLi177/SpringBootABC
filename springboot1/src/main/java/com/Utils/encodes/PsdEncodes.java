package com.Utils.encodes;

/**
 * @author lyj
 * @date 2018/3/28 0830
 */
public class PsdEncodes {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return EncodesUtil.encodeHex(salt) + EncodesUtil.encodeHex(hashPassword);
    }

    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param password      密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        byte[] salt = EncodesUtil.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
                    return password.equals(EncodesUtil.encodeHex(salt) + EncodesUtil.encodeHex(hashPassword));
    }

  /*public static void main(String[] args) {
      System.out.println(PsdEncodes.entryptPassword("admin"));
      boolean b = validatePassword("admin", "7da747f87f6aaf4c687684c370c243de67840a18ac808801bef60263");
      System.out.println(b);
  }*/
}
