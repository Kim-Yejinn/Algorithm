#include<bits/stdc++.h>
using namespace std;

#define MAX 64
int arr[MAX][MAX];



void rec(int R, int C, int len) {

	if (len == 1) {
		cout << arr[R][C];
	}
	else {
		bool isOne = false;
		bool isZero = false;

		for (int r = R; r < R + len; r++) {
			for (int c = C; c < C + len; c++) {
				if (arr[r][c] == 1) {
					isOne = true;
				}
				else {
					isZero = true;
				}
			}
		}

		if (isOne && isZero) {
			cout << "(";
			rec(R, C, len / 2);
			rec(R, C + len/2, len / 2);
			rec(R + len/2, C, len / 2);
			rec(R + len/2, C + len/2, len / 2);
			cout << ")";
		}
		else {
			if (isOne) {
				cout << 1;
			}
			else {
				cout << 0;
			}
		}
	}
}
int main() {
	int N;
	cin >> N;

	string str;
	for (int r = 0; r < N; r++) {
		cin >> str;
		for (int c = 0; c < N; c++) {
			arr[r][c] = str[c] - '0';
		}
	}

	rec(0, 0, N);
	return 0;
}