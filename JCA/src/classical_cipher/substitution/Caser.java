package classical_cipher.substitution;

public class Caser{
    public static String encrpt(String plain,int key){
        char[] character_list = plain.toCharArray();
        StringBuilder cipher = new StringBuilder();
        for (char c : character_list) {
            if ((int) c >= 32 && (int) c <= 126 ){
                cipher.append((char) (((((int) c + key) - 32) % 94) + 32));
            }
            else{
                cipher.append(c);
            }
        }
        return cipher.toString();
    }
    public static String decrypt(String cipher,int key){
        char[] character_list = cipher.toCharArray();
        StringBuilder demo_plain_text = new StringBuilder();
        for (char c : character_list) {
            if ((int) c >= 32 && (int) c <= 126) {
                demo_plain_text.append((char) (((94 + (((int) c - 32)) - key) % 94) + 32));
            }
            else{
                demo_plain_text.append(c);
            }
        }
        return demo_plain_text.toString();
    }
}
