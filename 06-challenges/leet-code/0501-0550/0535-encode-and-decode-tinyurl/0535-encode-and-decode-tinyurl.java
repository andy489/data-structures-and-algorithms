// https://leetcode.com/problems/encode-and-decode-tinyurl/

// Solution: HashMap with counter — O(1) encode/decode, O(n) space
public class Codec {
    private Map<Integer, String> codeToUrl = new HashMap<>();
    private int counter = 0;

    public String encode(String longUrl) {
        codeToUrl.put(++counter, longUrl);
        return "http://tinyurl.com/" + counter;
    }

    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return codeToUrl.get(key);
    }
}
