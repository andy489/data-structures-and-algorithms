// https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

// Solution: Set Subset Check — O(n^2 * m) time, O(n * m) space
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> sets = new ArrayList<>();
        for (List<String> fc : favoriteCompanies) sets.add(new HashSet<>(fc));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++) {
            boolean isSubset = false;
            for (int j = 0; j < sets.size(); j++) {
                if (i != j && sets.get(j).containsAll(sets.get(i))) { isSubset = true; break; }
            }
            if (!isSubset) res.add(i);
        }
        return res;
    }
}
