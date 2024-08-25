#include<bits/stdc++.h>
using namespace std;

long long mul(long long A, long long B, long long C) {
	
	if (B == 1) {
		return A % C;
	}

	long long temp = mul(A, B / 2, C) % C;
	
	if (B % 2 == 1) {
		return (A % C) * ((temp * temp )% C) %C;
	}
	else {
		return (temp * temp) % C;
	}
}

int main() {
	long long A, B, C;

	cin >> A >> B >> C;

	cout << mul(A, B, C);
}