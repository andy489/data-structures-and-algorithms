// https://leetcode.com/problems/product-of-the-last-k-numbers/

// Solution: Prefix Products with Zero Reset — O(1) time, O(n) space
class ProductOfNumbers {
    private final List<Integer> prefix = new ArrayList<>();

    public ProductOfNumbers() {
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}
