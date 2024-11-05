#include<bits/stdc++.h>
using namespace std;

int main() {

	string str;
	int cnt = 0;

	for (int r = 0; r < 8; r++) {
		cin >> str;
		for (int c = 0; c < 8; c++) {
			if ((r + c) % 2 == 0 && str[c] == 'F') {
				cnt++;
			}
		}
	}
	cout << cnt;
}