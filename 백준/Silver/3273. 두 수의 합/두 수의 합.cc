#include<bits/stdc++.h>
using namespace std;

int main() {
	int N, X;
	int arr[100'000];
	
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	cin >> X;
	sort(arr, arr + N);

	int left = 0, right = N-1;
	int cnt = 0;

	while (left < right) {
		int sum = arr[left] + arr[right];

		if (sum == X) {
			left++;
			cnt++;
		}
		else if (sum < X) {
			left++;
		}
		else{
			right--;
		}
	}
	cout << cnt;
}