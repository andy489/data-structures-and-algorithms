// https://leetcode.com/problems/search-suggestions-system/

// Solution: Sort + Binary Search — O(n log n + m log n) time, O(n) space
// Solution: Sort + Binary Search — O(n log n + m log n) time, O(n) space
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int lo = lowerBound(products, prefix);
            List<String> suggestions = new ArrayList<>();
            for (int i = lo; i < Math.min(lo + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) suggestions.add(products[i]);
                else break;
            }
            res.add(suggestions);
        }
        return res;
    }
    private int lowerBound(String[] arr, String target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) { int mid = (lo+hi)/2; if (arr[mid].compareTo(target) < 0) lo=mid+1; else hi=mid; }
        return lo;
    }
}
