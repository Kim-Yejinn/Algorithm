#include<bits/stdc++.h>
using namespace std;

int main() {
	string a, b, c;
	cin >> a >> b >> c;

	int num = 0;
	if (a.compare("Fizz") == 0|| a.compare("Buzz") == 0 || a.compare("FizzBuzz") == 0) {
		if (b.compare("Fizz")==0 || b.compare("Buzz")==0 || b.compare("FizzBuzz")==0) {
			num = stoi(c) + 1;
		}
		else {
			num = stoi(b) + 2;
		}
	}
	else {
		num = stoi(a) + 3;
	}

	if (num % 3 == 0 && num % 5 == 0) {
		cout << "FizzBuzz";
	}
	else {
		if (num % 3 == 0) {
			cout << "Fizz";
		}
		else {
			if (num % 5 == 0) {
				cout << "Buzz";
			}
			else {
				cout << num;
			}
		}
	}
}