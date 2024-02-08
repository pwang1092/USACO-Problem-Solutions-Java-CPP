
#include <iostream>

using namespace std;

int main()
{
    int numCases;
    cin >> numCases;
    
    for (int i = 0; i < numCases; i++) {
        int numCows;
        cin >> numCows;
        int cows[numCows];
        bool solutions[numCows+1]; 
        for (int j = 1; j <= numCows; j++) {
            solutions[j] = false; 
        }
        
        for (int j = 0; j < numCows; j++) {
            cin >> cows[j]; 
        }
        
        for (int j = 0; j + 2 < numCows; j++) {
            if (cows[j] == cows[j+1]) {
                solutions[cows[j]] = true;
            }
            else if (cows[j] == cows[j+2]) {
                solutions[cows[j]] = true;
            }
            else if (cows[j+1] == cows[j+2]) {
                solutions[cows[j+1]] = true;
            }
        }
        
        int num = 0;
        for (int j = 1; j <= numCows; j++) {
            if (solutions[j]) num++; 
        }
        bool solved = false;
        int count = 0; 
        for (int j = 1; j <= numCows; j++) {
            if (solutions[j]) {
                if (count == num-1) {
                    count++;
                    cout << j;
                    solved = true; 
                }
                else {
                    count++; 
                    cout<< j << " "; 
                    solved = true; 
                }
            }
        }
        if (numCows == 1) cout << cows[0];
        else if (numCows == 2 && cows[0] == cows[1]) cout << cows[0];
        else if (!solved) {
            cout << -1; 
        }
        cout << endl;
    }
}