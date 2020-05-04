package controllers.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
	
	public static void main(String[] args) {
		
		String password1 ="123";
		String password2 ="123";
		
		// Bcryp
		String pass1 = password1 +";ssssz1"; // SALT
		String pass2 = password1 +";*seeee"; // SALT
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String digest1 = encoder.encode(password1);
		String digest2 = encoder.encode(password2);
		System.out.println("digest1 : "+digest1);
		System.out.println("digest2 : "+digest2);

		
		
		
		
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password1.getBytes());
			byte[] digest = md.digest();
			String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			
			System.out.println(myHash);
			
			md.update(password2.getBytes());
			digest = md.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			
			System.out.println(myHash);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
