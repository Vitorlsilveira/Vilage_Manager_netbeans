
package securaty;

import datas.Home;
import datas.Persion;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class Security {

    //private Document document;
Cipher ecipher;
    Cipher dcipher;
    
    public Security(){

    }
    
 // 8-byte Salt
    byte[] salt = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
        };
        // Iteration count
        int iterationCount = 19;
        
        public Persion encryptPersion(Persion persion,String secretKey) throws Exception{
            
            Persion encryptedPersion = new Persion();
            
            encryptedPersion.setId(encrypt(persion.getId(),secretKey));
            encryptedPersion.setName(encrypt(persion.getName(),secretKey));
            encryptedPersion.setSex(encrypt(persion.getSex(),secretKey));
            encryptedPersion.setAddress(encrypt(persion.getAddress(),secretKey));
            encryptedPersion.setTpnum(encrypt(persion.getTpnum(),secretKey));
            encryptedPersion.setBirthday(encrypt(persion.getBirthday(),secretKey));
            
            return encryptedPersion;
        }
        
        public Persion decryptPersion(Persion persion,String secretKey) throws Exception{
            
            Persion decryptedPersion = new Persion();
            
            decryptedPersion.setId(decrypt(persion.getId(),secretKey));
            decryptedPersion.setName(decrypt(persion.getName(),secretKey));
            decryptedPersion.setSex(decrypt(persion.getSex(),secretKey));
            decryptedPersion.setAddress(decrypt(persion.getAddress(),secretKey));
            decryptedPersion.setTpnum(decrypt(persion.getTpnum(),secretKey));
	    decryptedPersion.setBirthday(decrypt(persion.getBirthday(),secretKey));
            
            return decryptedPersion;
        }

        public Home encryptPersion(Home home,String secretKey) throws Exception{
            
            Home encryptedHome = new Home();
            
            encryptedHome.setHoemnumber(encrypt(home.getHoemnumber(),secretKey));
            encryptedHome.setOwner(encrypt(home.getOwner(),secretKey));
            encryptedHome.setAddress(encrypt(home.getAddress(),secretKey));
            encryptedHome.setTpnumber(encrypt(home.getTpnumber(),secretKey));
            encryptedHome.setNumofmembers(home.getNumofmembers());
            
            return encryptedHome;
        }

       public Home decryptHome(Home home,String secretKey) throws Exception{
            
            Home decryptedHome = new Home();
            
            decryptedHome.setHoemnumber(decrypt(home.getHoemnumber(),secretKey));
            decryptedHome.setOwner(decrypt(home.setOwner(),secretKey));
            decryptedHome.setAddress(decrypt(home.setAddress(),secretKey));
            decryptedHome.setTpnumber(decrypt(home.getAddress(),secretKey));
            decryptedHome.setNumofmembers(home.getTpnum());
            
            return decryptedHome;
        }
        

    public String encrypt(String plainText,String secretKey) throws Exception{
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
         // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

        //Enc process
        ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        String charSet="UTF-8";
        byte[] in = plainText.getBytes(charSet);
        byte[] out = ecipher.doFinal(in);
        @SuppressWarnings("restriction")
String encStr= new sun.misc.BASE64Encoder().encode(out);
        return encStr;
    }
    
     /**
* @param secretKey Key used to decrypt data
* @param encryptedText encrypted text input to decrypt
* @return Returns plain text after decryption
*/
     
public String decrypt(String encryptedText, String secretKey) throws Exception{
         //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);        
         // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        //Decryption process; same key will be used for decr
        dcipher=Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key,paramSpec);
        byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
        byte[] utf8 = dcipher.doFinal(enc);
        String charSet="UTF-8";     
        String plainStr = new String(utf8, charSet);
        return plainStr;
    }    
}
