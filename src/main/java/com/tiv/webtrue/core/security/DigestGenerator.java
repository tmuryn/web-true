package com.tiv.webtrue.core.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class DigestGenerator {

  public enum Algorithm {
    MD5, SHA
  }

  public static String generate(String content, Algorithm algorithm) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA");
    byte[] bs = md.digest(content.getBytes());
    return new String(bs);
  }
  
  public static String genarateNumbers(Long long1){
    Random random = new Random();
    return random.nextInt(10000)+""+new Date().getTime()+""+random.nextInt(1000)+""+long1;
  }
  
  public static void main(String[] args) throws NoSuchAlgorithmException {
    System.out.println("DigestGenerator.main()"+genarateNumbers(1L));
  }
}
