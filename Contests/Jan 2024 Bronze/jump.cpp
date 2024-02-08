
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int length, loc;
    cin >> length >> loc; 
    loc--; 
    
    // 0 for jump pad, 1 for target
    int type[length];
    int value[length];
    
    bool visited[length];
    vector<vector<int>> prevDir;
    vector<vector<int>> prevVal;
    
    
    for (int i = 0; i < length; i++) {
        cin >> type[i] >> value[i]; 
        visited[i] = false;
        vector<int> temp; 
        prevDir.push_back(temp);
        prevVal.push_back(temp); 
    }
    
    int direction = 1; 
    int power = 1;
    int score = 0; 
    bool infinite = false;
    while (true) {
        if (loc < 0 || loc >= length) break; 
        if (type[loc] == 0) {
            if (direction == 1) {
                direction = 0;
                power = power + value[loc];
            }
            else if (direction == 0) {
                direction = 1;
                power = power + value[loc]; 
            }
        }
        else if (type[loc] == 1) {
            if (!visited[loc] && power >= value[loc]) {
                score++;
                visited[loc] = true;
            }
        }
        
        for (int j = 0; j < prevDir[loc].size(); j++) {
            if (prevDir[loc][j] == direction && prevVal[loc][j] == power) {
                infinite = true;
                break; 
            }
        }
        if (infinite) break; 
        
        prevDir[loc].push_back(direction);
        prevVal[loc].push_back(power);
        if (direction == 1) {
            loc += power;
        }
        else {
            loc -= power; 
        }
    }
    
    cout << score; 
}