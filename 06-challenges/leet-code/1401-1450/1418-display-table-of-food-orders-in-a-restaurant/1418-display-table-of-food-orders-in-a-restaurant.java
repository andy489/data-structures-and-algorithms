// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

// Solution: HashMap + TreeMap — O(n log n) time, O(n) space
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foods = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> tables = new TreeMap<>();
        for (List<String> o : orders) {
            int tbl = Integer.parseInt(o.get(1));
            String food = o.get(2);
            foods.add(food);
            tables.computeIfAbsent(tbl, x -> new HashMap<>()).merge(food, 1, Integer::sum);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foods);
        res.add(header);
        for (Map.Entry<Integer, Map<String, Integer>> e : tables.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(e.getKey()));
            for (String f : foods) row.add(String.valueOf(e.getValue().getOrDefault(f, 0)));
            res.add(row);
        }
        return res;
    }
}
