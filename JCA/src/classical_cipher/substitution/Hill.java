package classical_cipher.substitution;

public class Hill{
    private static int[] multiplication(int[][] first,char[] second) {
        int[] result = new int[second.length];
        for (int i = 0; i < first.length; i++) {
            int temp = 0;
            for (int j = 0; j < first.length; j++) {
                temp += (first[i][j] * (int)(second[j] - 'a'));
            }
            result[i] = (temp % 26) + (int)'a';
        }
        return result;
    }
    public static String encrypt(String message,int[][] key) {
        int length = key.length;
        StringBuilder cipher = new StringBuilder();
        message = message.toLowerCase();
        int block = (int)Math.floor((float) message.length() / length);
        String[] array = new String[block];
        for(int i =0; i < block;i++){
            if(i * length >= message.length()){
                continue;
            }
            else if((i  + 1) * length >= message.length() ) {
                array[i] = message.substring(i * length);
            }
            else{
                array[i] = message.substring(i * length, (i + 1) * length);
            }
        }
        for(String s : array) {
            if (s != null) {
                int[] result = multiplication(key, s.toCharArray());
                for (int r : result) {
                    cipher.append((char) r);
                }
            }
        }
        return cipher.toString();
    }
    public static void decrypt(){
    }
}