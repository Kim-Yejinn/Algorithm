#include<bits/stdc++.h>
using namespace std;

int main() {
	int N;
	string input[50];

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}

	for (int i = 0; i < input[0].length(); i++) {
		char cur = input[0][i];
		bool check = true;
		for (int j = 1; j < N; j++) {
			if (cur != input[j][i]) {
				check = false;
				break;
			}
		}
		if (check) {
			cout << cur;
		}
		else {
			cout << '?';
		}
	}
}