#include<bits/stdc++.h>
using namespace std;

int main() {
	bool visit[3][3];
	memset(visit, false, sizeof(visit));

	int L, t;
	cin >> L;

	bool ans = true;

	int lr, lc;

	for (int i = 0; i < L; i++) {
		cin >> t;

		int row = (t-1) / 3;
		int col = (t-1) % 3;

		if (visit[row][col]) {
			ans = false;
			break;
		}
		if (i == 0) {
			visit[row][col] = true;
			lr = row;
			lc = col;
			continue;
		}

		if (lr == row) {
			if (abs(lc - col) == 2) {
				if (lc < col) {
					if (!visit[row][lc + 1]) {
						ans = false;
						break;
					}
				}
				else {
					if (!visit[row][lc - 1]) {
						ans = false;
						break;
					}
				}
			}
		}
		if (lc == col) {
			if (abs(lr - row) == 2) {
				if (lr < row) {
					if (!visit[lr+1][col]) {
						ans = false;
						break;
					}
				}
				else {
					if (!visit[lr-1][col]) {
						ans = false;
						break;
					}
				}
			}
		}

		if (abs(lc - col) == 2 && abs(lr - row)==2) {
			if (!visit[1][1]) {
				ans = false;
				break;
			}
		}
		visit[row][col] = true;
		lr = row;
		lc = col;
	}
	if (ans) {
		cout << "YES";
	}
	else {
		cout << "NO";
	}
}