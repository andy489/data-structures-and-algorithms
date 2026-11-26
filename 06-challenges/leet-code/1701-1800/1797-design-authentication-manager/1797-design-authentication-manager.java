// https://leetcode.com/problems/design-authentication-manager/

// Solution: HashMap of Expiry Times — O(1) generate/renew, O(n) count — O(n) space
class AuthenticationManager {
    private final int timeToLive;
    private final Map<String, Integer> expiry;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.expiry = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        expiry.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (expiry.containsKey(tokenId) && expiry.get(tokenId) > currentTime) {
            expiry.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int exp : expiry.values()) {
            if (exp > currentTime) {
                count++;
            }
        }
        return count;
    }
}
