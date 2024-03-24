package classical_cipher.substitution;

public class Vigeriane {
    private static int[] charToIntConvertor(char[] array){
        int[] key_list = new int[array.length];
        for (int i = 0;i < array.length ; i++){
            key_list[i] = (int)array[i] - 32;
        }
        return key_list;
    }
    public static String encrypt(String plain, String key){
        StringBuilder cipher = new StringBuilder();
        int key_index = 0;
        int[] key_list = charToIntConvertor(key.toCharArray());
        for (char c : plain.toCharArray()) {
            if ((int) c >= 32 && (int) c <= 126 ){
                cipher.append((char) (((((int) c + key_list[key_index]) - 32) % 94) + 32));
            }
            else{
                cipher.append(c);
            }
            key_index = (key_index + 1) % key_list.length;
        }
        return cipher.toString();
    }
    public static String decrypt(String cipher,String key){
        StringBuilder plain = new StringBuilder();
        int key_index = 0;
        int[] key_list = charToIntConvertor(key.toCharArray());

        for (char c : cipher.toCharArray()) {
            if ((int) c >= 32 && (int) c <= 126 ){
                plain.append((char)(((94 + (((int) c - 32) - key_list[key_index])) % 94) + 32));
            }
            else{
                plain.append(c);
            }
            key_index = (key_index + 1) % key_list.length;
        }
        return plain.toString();
    }
}
