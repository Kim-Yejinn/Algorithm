#include<bits/stdc++.h>
using namespace std;

int main() {
	int T;
	string t;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> t;
		cout << t[0] << t[t.length() - 1] << endl;
	}
}