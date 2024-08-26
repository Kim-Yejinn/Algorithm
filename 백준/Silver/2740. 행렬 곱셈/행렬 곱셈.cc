#include<bits/stdc++.h>
using namespace std;

int main() {
	int A[101][101];
	int B[101][101];
	int ans[101][101];

	int N, M, K;
	cin >> N >> M;

	for (int r = 0; r < N; r++) {
		for (int c = 0; c < M; c++) {
			cin >> A[r][c];
		}
	}

	cin >> M >> K;

	for (int r = 0; r < M; r++) {
		for (int c = 0; c < K; c++) {
			cin >> B[r][c];
		}
	}
	
	for (int r = 0; r < N; r++) {
		for (int c = 0; c < K; c++) {
			ans[r][c] = 0;
			for (int i = 0; i < M; i++) {
				ans[r][c] += A[r][i] * B[i][c];
			}
		}
	}

	for (int r = 0; r < N; r++) {
		for (int c = 0; c < K; c++) {
			cout << ans[r][c] << " ";
		}
		cout << endl;
	}
}