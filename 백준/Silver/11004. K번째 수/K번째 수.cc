#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	int N, K;
	cin >> N >> K;

	vector<int> v;

	int t;
	for (int i = 0; i < N; i++) {
		cin >> t;
		v.push_back(t);
	}

	sort(v.begin(), v.end());
	
	cout << v[K-1];

}