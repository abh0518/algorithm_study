#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
const int INF = 999999999;
typedef pair <double, double> dd;

dd match( double x, double y, double r)
{
	double now = fmod( atan2( x, y ) + 2*M_PI, 2*M_PI);
	double add = 2 * asin( r / 16 );
	return  make_pair( now-add, now+add );
}

int schedule(double beg, double end, int n, vector<dd> v)
{
	int used =0, idx = 0;
	while ( beg < end ){
		double maxCover = -1;
		while( idx < n && v[idx].first <= beg ) {
			maxCover = max(maxCover, v[idx].second);
			++idx;
		}
		if(maxCover <= beg) return INF;
		beg = maxCover;
		++used;
	}
	return used;
}

int main()
{

	int ts;
	freopen("./input.txt", "r", stdin);
	cin >> ts;
	while( ts-- > 0 ){
		int n, selected=INF;
		cin >> n;
		vector<dd> v;
		for (int i = 0; i < n; ++i)
		{
			double x, y, r;
			cin >> x >> y >> r;
			v.push_back( match(x, y, r) );
		}
		sort(v.begin(), v.end());

		for (int i = 0; i < n; ++i)
		{
			if(v[i].first <= 0 || v[i].second >= 2*M_PI) {
				double beg = fmod(v[i].second, 2*M_PI);
				double end = fmod(v[i].first + 2*M_PI, 2*M_PI);
				selected = min(selected, 1+schedule(beg, end, n, v));
			}
		}
		if(selected == INF)
			cout << "IMPOSSIBLE" << endl;
		else
			cout << selected << endl;
	}
}