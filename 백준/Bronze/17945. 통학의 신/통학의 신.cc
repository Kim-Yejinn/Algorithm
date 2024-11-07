#include<bits/stdc++.h>
using namespace std;

int main() {
	int A, B;
	cin >> A >> B;

	int tA = 2 * A;
	int cal = tA * tA - 4 * B;

	int a = - tA + sqrt(cal);
	int b = -tA - sqrt(cal);

	if (a == b) {
		cout << a/2;
	}
	else if(a < b) {
		cout << a/2 << " " << b / 2;
	}
	else {
		cout << b / 2 << " " << a / 2;
	}

}