#include<bits/stdc++.h>
using namespace std;

int main() {

	int left = 1, right = 1;
	int N, K, B;
	int ans = 100010;
	int cur = 0;
	bool check[100010];
	cin >> N >> K >> B;

	fill_n(check, 100010, false);
	for (int i = 0; i < B; i++) {
		int t;
		cin >> t;
		check[t] = true;
	}
	
	if (check[1]) {
		cur++;
	}
	while (right <= N) {
		int t = right - left + 1;
		if (t >= K) {
			ans = min(cur, ans);
			if (check[left]) {
				cur--;
			}
			left++;
		}
		else {
			right++;
			if (check[right]) {
				cur++;
			}
		}
	}
	cout << ans;
}