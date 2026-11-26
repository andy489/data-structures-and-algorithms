// https://leetcode.com/problems/design-underground-system/

// Solution: Two HashMaps — O(1) all ops, O(P+R) space
class UndergroundSystem {
    Map<Integer, String[]> trips = new HashMap<>();
    Map<String, int[]> routes = new HashMap<>();
    public void checkIn(int id, String station, int t) { trips.put(id, new String[]{station, String.valueOf(t)}); }
    public void checkOut(int id, String station, int t) {
        String[] info = trips.remove(id);
        String key = info[0] + "#" + station;
        int[] r = routes.computeIfAbsent(key, k -> new int[2]);
        r[0] += t - Integer.parseInt(info[1]);
        r[1]++;
    }
    public double getAverageTime(String s, String e) { int[] r = routes.get(s+"#"+e); return (double)r[0]/r[1]; }
}
