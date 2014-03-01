#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair <int, int> ii;

int main()
{

	int ts;
	freopen("../test.txt", "r", stdin);
	cin >> ts;
	while( ts-- > 0 ){
		int n, ret = 0, sum = 0, m, e;
		cin >> n;
		vector<ii> v(n);
		for (int i = 0; i < n; ++i)
		{
			cin >> m;
			v[i].second = m;
		}

		for (int i = 0; i < n; ++i)
		{
			cin >> e;
			v[i].first = e*-1;
		}
		sort(v.begin(), v.end());


		for (int i = 0; i < n; ++i)
		{
			sum+=v[i].second;
			ret = max(ret, sum - v[i].first);
		}

		cout << ret << endl;
	}
}