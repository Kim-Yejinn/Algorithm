#include<bits/stdc++.h>
using namespace std;

int main() {
	int N, T, P;
	int arr[6];
	cin >> N;
	for (int i = 0; i < 6; i++) {
		cin >> arr[i];
	}
	cin >> T >> P;

	int cnt = 0;
	for (int i = 0; i < 6; i++) {
		if (arr[i] % T == 0) {
			cnt += arr[i] / T;
		}
		else {
			cnt += arr[i] / T + 1;
		}
	}
	cout << cnt << endl;

	cout << N / P << " " << N % P;


}