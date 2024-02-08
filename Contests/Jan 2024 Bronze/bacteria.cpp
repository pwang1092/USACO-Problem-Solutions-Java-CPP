

#include <iostream>

using namespace std;

int main()
{
    int length;
    cin >> length;
    long long arr[length];
    
    for (int i = 0; i < length; i++) {
        cin >> arr[i]; 
    }
    
    int sum = 0; 
    for (int i = 0; i < length; i++) {
        long long val = -arr[i];
        long long temp = val; 
        sum += abs(val); 
        
        if (temp != 0) {
            for (int j = i; j < length; j++) {
                arr[j] += val;
                val += temp; 
            }
        }
    }
    
    cout << sum; 
}