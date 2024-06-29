#include<bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	string A, B, C;

	cin >> A >> B >> C;
	cout << stoi(A) + stoi(B) - stoi(C) << endl;
	cout << stoi(A + B) - stoi(C);
}