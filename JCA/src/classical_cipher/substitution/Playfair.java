package classical_cipher.substitution;

import java.util.ArrayList;

public class Playfair {
    public static char[] convertor(char[] message){
        for (int i = 0;i < message.length;i++){
            if(message[i] == 'i'){
                message[i] = 'j';
            }
        }
        return message;
    }
    public static int[][] matrix(char[] message){
        message = convertor(message);
        int[][] matrix_value = new int[5][5];
        int index = 0;
        ArrayList<Character> key = new ArrayList<Character>();
        for (char c : message) {
            if (!key.contains(c)) {
                key.add(c);
            }
        }
        for (char i ='a';i <= 'z';i++){
            if(!key.contains(i) && i != 'i') {
                key.add(i);
            }
        }
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                matrix_value[i][j] = key.get(index++);
            }
        }
        return matrix_value;
    }
    private static char[] encrypt_individually(char[] message, int[][] key){
        convertor(message);
        int indexes[] = new int[4];
        int key_index = 0;
        for(int k = 0;k < 2;k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((int)message[k] == key[i][j]) {
                        indexes[key_index++] = i;
                        indexes[key_index++] = j;
                    }
                }
            }
        }

        if ( indexes[0] == indexes[2]){
            message[0] = (char)(key[(indexes[0] + 1) % 5][indexes[1]]);
            message[1] = (char)(key[(indexes[2] + 1) % 5][indexes[3]]);
        }
        else if(indexes[1] == indexes[3]){
            message[0] = (char)key[indexes[0]][(indexes[1] + 1) % 5];
            message[1] = (char)key[indexes[2]][(indexes[3] + 1) % 5];
        }
        else{
            message[0] = (char)(key[indexes[0]][indexes[3]]);
            message[1] = (char)(key[indexes[2]][indexes[1]]);
        }
        return message;
    }
    public static String encrypt(String message, String key){
        int[][] matrix_key = matrix(key.toCharArray());
        StringBuilder cipher = new StringBuilder();
        char[] temp = new char[2];
        for (int i = 0;i < message.length();i++){
            if (message.charAt(i) == ' '){
                cipher.append(" ");
                continue;
            }
            else if ( i == message.length() - 1){
                temp[0] = message.charAt(i);
                temp[1] = 'x';
            }
            else if(i + 1 != message.length()){
                if( message.charAt(i + 1) == ' '){
                    temp[0] = message.charAt(i);
                    temp[1] = 'x';
                    temp = encrypt_individually(temp,matrix_key);
                    for(char ch : temp) {
                        cipher.append(ch);
                    }
                    continue;
                }
                else{
                    temp[0] = message.charAt(i);
                    temp[1] = message.charAt(i+1);
                }
            }
            else{
                temp[0] = message.charAt(i);
                temp[1] = message.charAt(i+1);
            }
            if(temp[0] != temp[1]){
                i++;
            }
            else {
                temp[1] = 'x';
            }
            temp = encrypt_individually(temp,matrix_key);
            for(char ch : temp) {
                cipher.append(ch);
            }
        }
        return cipher.toString();
    }

    private static char[] decrypt_individually(char[] message, int[][] key) {
        convertor(message);
        int indexes[] = new int[4];
        int key_index = 0;
        for(int k = 0;k < 2;k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((int)message[k] == key[i][j]) {
                        indexes[key_index++] = i;
                        indexes[key_index++] = j;
                    }
                }
            }
        }

        if ( indexes[0] == indexes[2]){
            message[0] = (char)(key[( 5 + indexes[0] - 1) % 5][indexes[1]]);
            message[1] = (char)(key[( 5 + indexes[2] - 1) % 5][indexes[3]]);
        }
        else if(indexes[1] == indexes[3]){
            message[0] = (char)key[indexes[0]][( 5 + indexes[1] - 1) % 5];
            message[1] = (char)key[indexes[2]][( 5 + indexes[3] - 1) % 5];
        }
        else{
            message[0] = (char)(key[indexes[0]][indexes[3]]);
            message[1] = (char)(key[indexes[2]][indexes[1]]);
        }
        return message;
    }
    public static String decrypt(String cipher, String key){
        int[][] matrix_key = matrix(key.toCharArray());
        StringBuilder plain = new StringBuilder();
        char[] temp = new char[2];
        for (int i = 0;i < cipher.length();i++){
            if (cipher.charAt(i) == ' '){
                plain.append(" ");
                continue;
            }
            else{
                temp[0] = cipher.charAt(i);
                temp[1] = cipher.charAt(i+1);
            }
            i++;
            temp = decrypt_individually(temp,matrix_key);
            for(char ch : temp) {
                plain.append(ch);
            }
        }
        return plain.toString();
    }


}