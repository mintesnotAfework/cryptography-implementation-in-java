package classical_cipher.substitution;

public class VigeranLab {

    public static String encryption(String plain, String key){
        StringBuilder cipher = new StringBuilder();
        int keyLength = key.length();
        for( int i = 0, j = 0;i < plain.length();i++){
            char ch = plain.charAt(i);
            if (Character.isLetter(ch)){
                char base = Character.isUpperCase(ch)? 'A':'a';
                int shift = key.charAt(j % keyLength) - base;
                ch = (char)(((ch - base + shift) % 26) + base);
                j++;
            }
            cipher.append(ch);
        }
        return cipher.toString();
    }
    public static String decryption(String cipher, String key){
        StringBuilder plain = new StringBuilder();
        int keyLength = key.length();
        for( int i = 0, j = 0;i < cipher.length();i++){
            char ch = cipher.charAt(i);
            if (Character.isLetter(ch)){
                char base = Character.isUpperCase(ch)? 'A':'a';
                int shift = key.charAt(j % keyLength) - base;
                ch = (char)(((ch - base - shift + 26) % 26) + base);
                j++;
            }
            plain.append(ch);
        }
        return plain.toString();
    }
    public static void main(String[] args){
        String message = "the name is me y";
        String key = "hi";
        String cipher =  encryption(message,key);
        System.out.println("the encrypted message :" + cipher);
        System.out.println("the decryption messge is : " + decryption(cipher,key));
    }
}
