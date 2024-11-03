#include<bits/stdc++.h>
using namespace std;

struct Student {
	string name;
	int korean;
	int math;
	int english;
};

// ture일때 왼쪽
bool compare(const Student& s1, const Student& s2){
	if (s1.korean == s2.korean) {
		if (s1.english == s2.english) {
			if (s1.math == s2.math) {
				return s1.name < s2.name;
			}
			else {
				return s1.math > s2.math;
			}
		}
		else {
			return s1.english < s2.english;
		}
	}
	else {
		return s1.korean > s2.korean;
	}

}

Student st[100'000];

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> st[i].name >> st[i].korean >> st[i].english >> st[i].math;
	}

	sort(st, st + N, compare);

	for (int i = 0; i < N; i++) {
		cout << st[i].name << "\n";
	}
}