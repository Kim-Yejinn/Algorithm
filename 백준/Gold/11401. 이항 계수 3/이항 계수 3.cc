#include<bits/stdc++.h>
using namespace std;

#define MOD 1000000007

long long fac[4000001];

void fact() {
	fac[0] = 1;
	for (int i = 1; i <= 4000000; i++) {
		fac[i] = fac[i-1] * i % MOD;
	}
}

long long power(long long A, long long B) {
	// A의 B 제곱
	if (B == 1) {
		return A % MOD;
	}

	long long res = power(A, B / 2) % MOD;
	if (B % 2 == 1) {
		return (A % MOD) * (res * res % MOD);
	}
	else {
		return res * res % MOD;
	}
}

int main() {
	int N, K;
	cin >> N >> K;
	fact();

	long long res1 = fac[N];
	long long res2 = fac[K] * fac[N - K] % MOD;
	long long res3 = power(res2, MOD - 2) % MOD;

	cout << res1 * res3 % MOD;
}