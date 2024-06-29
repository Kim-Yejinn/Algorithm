#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	int N;
	cin >> N;

	int arr[101];

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	int find, cnt;
	cin >> find;
	cnt = 0;
	
	for (int i = 0; i < N; i++) {
		if (arr[i] == find) {
			cnt++;
		}
	}
	
	cout << cnt;
}