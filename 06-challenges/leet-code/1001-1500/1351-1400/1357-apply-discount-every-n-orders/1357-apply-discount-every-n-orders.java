// https://leetcode.com/problems/apply-discount-every-n-orders/

// Solution: HashMap + Counter — O(p) per query, O(p) space
class Cashier {
    int n, discount, count;
    Map<Integer, Integer> priceMap = new HashMap<>();
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n; this.discount = discount;
        for (int i = 0; i < products.length; i++) priceMap.put(products[i], prices[i]);
    }
    public double getBill(int[] product, int[] amount) {
        double total = 0;
        for (int i = 0; i < product.length; i++) total += (double)priceMap.get(product[i]) * amount[i];
        if (++count % n == 0) total *= (100 - discount) / 100.0;
        return total;
    }
}
