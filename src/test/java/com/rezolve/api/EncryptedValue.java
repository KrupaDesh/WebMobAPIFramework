package com.rezolve.api;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptedValue {
    public static String enc = "";

    public static String genratedEncryptedValue(String arg1, String publicKey) {
        {
                String Original_String1 = publicKey;
                String Trim2 = Original_String1.replaceFirst("-----BEGIN PUBLIC KEY-----", "");
                String Trim3 = Trim2.replaceFirst("-----END PUBLIC KEY-----", "");
                String final_string = Trim3.replaceAll("\\n", "");
                String input = arg1;
                enc = "";

                try {
                    byte[] byteKey = Base64.getDecoder().decode(final_string.getBytes());
                    X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
                    KeyFactory kf = KeyFactory.getInstance("RSA");
                    Key k = kf.generatePublic(X509publicKey);
                    Security.addProvider(new BouncyCastleProvider());
                    Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPPadding", "BC");
                    cipher.init(1, k);
                    byte[] encryptedBytes = cipher.doFinal(input.getBytes());
                    enc = Base64.getEncoder().encodeToString(encryptedBytes);
                } catch (Exception var13) {
                }

                System.out.println(enc);
            }
            return enc;

/*        String jarPath = "lib/encrypt.jar";
        String argument1 = arg1;
        String argument2 = publicKey;
        try{
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, argument1, argument2);

            Process process = processBuilder.start();// Read the output of the command
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((encValue = reader.readLine()) != null) {
                //System.out.println("value"+EncryptedValue);
            }// Wait for the command to finish
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return encValue;*/
    }
}
