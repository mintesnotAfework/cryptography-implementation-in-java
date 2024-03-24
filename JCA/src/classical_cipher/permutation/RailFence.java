package classical_cipher.permutation;

public class RailFence {
    public static String encrypt(String message, int key) {
        Character[][] chars = new Character[message.length()][key];
        StringBuilder cipher = new StringBuilder();
        int index = 0;
        for (int i = 0; i < message.length(); i++, index++) {
            chars[i][index % key] = message.charAt(i);
        }
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                if (chars[j][i] != null) {
                    cipher.append(chars[j][i]);
                }
            }
        }
        return cipher.toString();
    }
}
