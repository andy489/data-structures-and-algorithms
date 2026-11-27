# https://leetcode.com/problems/design-event-manager/

import heapq

class EventManager:
    def __init__(self, events: list[list[int]]):
        # max-heap by priority then min eventId
        # store (-priority, eventId)
        self.heap = []
        self.priorities = {}
        self.active = set()
        for event_id, priority in events:
            heapq.heappush(self.heap, (-priority, event_id))
            self.priorities[event_id] = priority
            self.active.add(event_id)

    def updatePriority(self, eventId: int, newPriority: int) -> None:
        self.priorities[eventId] = newPriority
        heapq.heappush(self.heap, (-newPriority, eventId))

    def pollHighest(self) -> int:
        while self.heap:
            neg_pri, event_id = heapq.heappop(self.heap)
            pri = -neg_pri
            if event_id in self.active and self.priorities[event_id] == pri:
                self.active.discard(event_id)
                del self.priorities[event_id]
                return event_id
        return -1
