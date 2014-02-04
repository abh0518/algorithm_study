#include <iostream>
using namespace std;
int solve(int* a, int n) {
	int s=0, t=0, b=0, ret=0, h;
	while( s<=t && t<n )
	{
		int d=1;
		h = a[s];
		while(t+1<n && a[++t]>=h) d++;
		while(b>0 && a[--b]>=h) d++;
		ret = (d*h > ret) ? d*h : ret;
		b = t = ++s;
	}
	return ret;
}

int main()
{
	int ts, n, i;
	freopen("../test.txt", "r", stdin);
	cin >> ts;
	while( ts-- > 0 ){
		cin >> n;
		int* a = new int[n+1];
		for (int i = 0; i < n; ++i)
		{
			std::cin >> a[i];
		}
		cout << solve(a, n) << endl;
		delete[] a;
	}
	
}