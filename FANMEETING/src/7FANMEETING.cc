#include <iostream>
#include <bitset>
#include <string>
using namespace std;


int main()
{
	int ts, n, i;
	freopen("../test.txt", "r", stdin);
	cin >> ts;
	while( ts-- > 0 ){
		string i, f;
		cin >> i;
		cin >> f;

		int il = i.length();
		int fl = f.length();

		cout << i << endl;
		cout << f << endl;
		for (int j = 0; j < fl; ++j)
		{
			if( j < il)
				i[j] = (i[j] == 'M' ) ? '1' : '0';
			f[j] = (f[j] == 'M' ) ? '1' : '0';
		}
		// cout << i << endl;
		// cout << f << endl;
		bitset<il> idol ( i );
		bitset<fl> fan ( f );
		int total = fl - il + 1;
		int mantotal = 0;
		for (int i = 0; i < fl - il; ++i)
		{
			cout << "binary" << endl;
			cout << idol << endl;
			cout << fan << endl;
			if( ( idol & fan ) == 0 ) mantotal++;
			fan << 1;
		}
		cout << "total" << endl;
		// cout << total << endl;
		// cout << mantotal << endl;
		cout << total - mantotal << endl;
		

	}
	
}