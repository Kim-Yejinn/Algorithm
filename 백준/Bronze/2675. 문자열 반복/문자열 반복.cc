#include <bits/stdc++.h>
using namespace std;

int main() {
	int T;
	cin >> T;

	for (int tc = 0; tc < T; tc++) {
		int R;
		string S;
		cin >> R;
		cin >> S;

		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < R; j++) {
				cout << S[i];
			}
		}
		cout << endl;
	}
}