#include <vector>
#include <string>
#include <iostream>

using namespace std;
string fun(string s)
{
	if(s[0] != 'x') return string(1, s[0]);
	vector<string> v(4);
	int beg = 1;
	for (int idx = 0; idx < 4; ++idx)
	{
		v[idx] = fun(s.substr(beg));
		beg+=v[idx].length();
	}
	return 'x'+v[2]+v[3]+v[0]+v[1];
}

int main()
{
    freopen("input.txt", "r", stdin);
	int t;
	cin >> t;
	while( t-- > 0 ){
		string s;
		cin >> s;
		cout << fun(s) << endl;
	}
	return 0;
}