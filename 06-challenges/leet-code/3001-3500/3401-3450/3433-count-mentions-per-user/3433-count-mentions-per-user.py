# https://leetcode.com/problems/count-mentions-per-user/
class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        events.sort(key=lambda e: (int(e[1]), 0 if e[0] == "OFFLINE" else 1))

        mentions = [0] * numberOfUsers
        offline_until = [0] * numberOfUsers

        for event in events:
            event_type = event[0]
            time = int(event[1])
            data = event[2]

            if event_type == "OFFLINE":
                user_id = int(data)
                offline_until[user_id] = time + 60
            else:
                if data == "ALL":
                    for i in range(numberOfUsers):
                        mentions[i] += 1
                elif data == "HERE":
                    for i in range(numberOfUsers):
                        if offline_until[i] <= time:
                            mentions[i] += 1
                else:
                    for token in data.split():
                        user_id = int(token[2:])
                        mentions[user_id] += 1

        return mentions
