package classical_cipher.substitution;

import java.util.Scanner;

public class CaserLab {
    public static String encrypt(String plain_text,int key){
        StringBuilder result = new StringBuilder();
        for (int i = 0;i < plain_text.length();i++){
            char ch = plain_text.charAt(i);
            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch)? 'A':'a';
                ch =  (char)(((ch - base + key) % 26) + base);
            }
            result.append(ch);
        }
        return result.toString();
    }
    public static String decrypt(String text,int key){
        return encrypt(text,26 - key );
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter the plain text : ");
        String plaintext = input.nextLine();
        int key = 3;
        String cipher = encrypt(plaintext,key);
        System.out.println("the encrypted message : " + cipher);
        System.out.println("the decrypted message is :  " + decrypt(cipher,key));
    }
}
