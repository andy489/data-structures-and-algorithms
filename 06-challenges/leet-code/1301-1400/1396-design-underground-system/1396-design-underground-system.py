# https://leetcode.com/problems/design-underground-system/

class UndergroundSystem:
    def __init__(self):
        self.trips = {}
        self.routes = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.trips[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start, start_t = self.trips.pop(id)
        key = (start, stationName)
        total, cnt = self.routes.get(key, (0, 0))
        self.routes[key] = (total + t - start_t, cnt + 1)

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total, cnt = self.routes[(startStation, endStation)]
        return total / cnt
