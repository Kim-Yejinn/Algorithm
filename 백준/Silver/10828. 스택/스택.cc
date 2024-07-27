#include<bits/stdc++.h>
using namespace std;

int main() {
	int N;
	cin >> N;

	stack<int> st;

	for (int i = 0; i < N; i++) {
		string op;
		cin >> op;
			
		if (op == "push") {
			int num;
			cin >> num;
			st.push(num);
		}
		else if (op == "pop") {
			if (st.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << st.top() << endl;
				st.pop();
			}
		}
		else if (op == "size") {
			cout << st.size() << endl;
		}
		else if (op == "empty") {
			if (st.empty()) {
				cout << "1" << endl;
			}else{
				cout << "0" << endl;
			}
		}
		else if (op == "top") {
			if (st.empty()) {
				cout << "-1" << endl;
			}
			else {
				cout << st.top() << endl;
			}
		}
	}
}