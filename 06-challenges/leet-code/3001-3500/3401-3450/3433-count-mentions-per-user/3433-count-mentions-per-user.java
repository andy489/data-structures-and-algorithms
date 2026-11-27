// https://leetcode.com/problems/count-mentions-per-user/
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) {
                return ta - tb;
            }
            // OFFLINE before MESSAGE at same time
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        for (List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String data = event.get(2);

            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(data);
                offlineUntil[userId] = time + 60;
            } else {
                if (data.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (data.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (offlineUntil[i] <= time) {
                            mentions[i]++;
                        }
                    }
                } else {
                    for (String token : data.split(" ")) {
                        int userId = Integer.parseInt(token.substring(2));
                        mentions[userId]++;
                    }
                }
            }
        }

        return mentions;
    }
}
