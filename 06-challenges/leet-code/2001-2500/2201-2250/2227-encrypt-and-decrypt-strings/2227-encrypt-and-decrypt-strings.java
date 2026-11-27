// https://leetcode.com/problems/encrypt-and-decrypt-strings/
class Encrypter {
    private Map<Character, String> encryptMap;
    private Map<String, Integer> decryptCount;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encryptMap = new HashMap<>();
        decryptCount = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            encryptMap.put(keys[i], values[i]);
        }
        for (String word : dictionary) {
            String encrypted = encrypt(word);
            if (!encrypted.isEmpty()) {
                decryptCount.merge(encrypted, 1, Integer::sum);
            }
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) {
            if (!encryptMap.containsKey(c)) {
                return "";
            }
            sb.append(encryptMap.get(c));
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return decryptCount.getOrDefault(word2, 0);
    }
}
