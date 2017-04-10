/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.security.provider.MD5;

/**
 *
 * @author Kilimo K Cornelius www.techflay.com
 */
public class passwordProtection {
    public static void main(String [] args){
              
    }
    public  String hashMe(String input) {
		
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}
