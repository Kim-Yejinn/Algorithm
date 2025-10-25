#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	int T, N, max,min, temp;
	cin >> T;

	for (int tc = 0; tc < T; tc++) {
		cin >> N;
		temp = 0;
		max = INT_MIN;
		min = INT_MAX;
		
		for (int i = 0; i < N; i++) {
			cin >> temp;

			if (temp > max) {
				max = temp;
			}
			if (temp < min) {
				min = temp;
			}
		}
		cout << min << " " << max << "\n";
	}
}