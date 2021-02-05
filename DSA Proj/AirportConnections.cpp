#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <stack>

using namespace std;

class DirectedMultiGraph {
private:
    unordered_map<string, int> airportId;
    vector<string> airports;
    vector<int> representativeAirports, inDegree;
    vector<vector<int>> adjacencyList, reversedAdjacencyList;
    stack<int> stackUtil;
    vector<bool> visited1, visited2;
    vector<pair<string, string>> connections;

    int n, startingAirportId;

public:
    DirectedMultiGraph(int mxN = 1e4) {
        airportId.reserve(mxN);
        airports.reserve(mxN);
    };

    void processInput() {
        string airportCode;

        while (cin >> airportCode) {
            if (airportCode == "0")
                break;
            airports.push_back(airportCode);
        }

        n = airports.size();

        for (int i = 0; i < n; ++i) {
            airportId[airports[i]] = i;
        }

        adjacencyList.resize(n);
        representativeAirports.resize(n);
        inDegree.resize(n);
        visited1.resize(n);
        visited2.resize(n);
        string from, to;

        while (cin >> from >> to) {
            if (from == "0") {
                startingAirportId = airportId[to];
                break;
            }
            adjacencyList[airportId[from]].push_back(airportId[to]);
        }

        startingAirportId = airportId[to];
    }

    void printList(const vector<int> &list) {
        for (const int &id: list)
            cout << id << ' ';
        cout << '\n';
    }

    void displayAns() {
        cout << "Minimum Charter Flights is " << connections.size() << ":\n";
        for (const auto &flight:connections) {
            cout << "From " << flight.first << " to " << flight.second << '\n';
        }
    }

    void displayInput() {
        for (const auto &kvp: airportId) {
            cout << kvp.first << ' ';
        }
        cout << "\n\nAdjacency List:\n";
        for (int i = 0; i < n; ++i) {
            cout << i << ": ";
            printList(adjacencyList[i]);
        }
        cout << "\nReversed Adjacency List:\n";
        for (int i = 0; i < n; ++i) {
            cout << i << ": ";
            printList(reversedAdjacencyList[i]);
        }
        cout << "\nStarting airport: " << airports[startingAirportId] << '\n';
        cout << "\nRepresentatives: \n";
        for (int i = 0; i < n; ++i) {
            if (representativeAirports[i] == i) {
                cout << airports[i] << ' ';
            }
        }
        cout << "\n\n";
    }

    void dfsUtil1(int u) {
        visited1[u] = true;
        for (int v: adjacencyList[u]) {
            if (!visited1[v]) {
                dfsUtil1(v);
            }
        }
        stackUtil.push(u);
    }

    void dfsUtil2(int u, int rep) {
        visited2[u] = true;
        representativeAirports[u] = rep;

        for (int v: reversedAdjacencyList[u]) {
            if (!visited2[v]) {
                dfsUtil2(v, rep);
            }
        }
    }

    void Kosaraju() {
        reversedAdjacencyList.resize(n);
        for (int i = 0; i < n; ++i) {
            for (int j: adjacencyList[i]) {
                reversedAdjacencyList[j].push_back(i);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited1[i]) {
                dfsUtil1(i);
            }
        }

        while (!stackUtil.empty()) {
            int u = stackUtil.top();
            stackUtil.pop();
            if (!visited2[u]) {
                dfsUtil2(u, u);
            }
        }
    }

    int solution() {
        for (int i = 0; i < n; ++i) {
            for (int j:adjacencyList[i]) {
                if (representativeAirports[i] != representativeAirports[j]) {
                    ++inDegree[representativeAirports[j]];
                }
            }
        }

        int minFlights = 0;

        for (int i = 0; i < n; ++i) {
            if (representativeAirports[i] == i && inDegree[i] == 0 &&
                i != representativeAirports[startingAirportId]) {
                ++minFlights;
                connections.emplace_back(airports[startingAirportId], airports[i]);
            }
        }

        return minFlights;
    }
};

int main() {
    //pwd: /Users/andreystoev/Desktop/
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    DirectedMultiGraph algoAir(100);

    algoAir.processInput();
    algoAir.Kosaraju();

    int res = algoAir.solution();

    //algoAir.displayInput(); // uncomment to display data structures in output.txt
    algoAir.displayAns();

    return 0;
}
