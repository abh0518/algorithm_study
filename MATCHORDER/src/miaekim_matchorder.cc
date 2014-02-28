#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{

	int ts;
	freopen("../test.txt", "r", stdin);
	cin >> ts;
	while( ts-- > 0 ){
		int n;
		cin >> n;
		vector<int> ru;
		for (int i = 0; i < n; ++i)
		{
			int rating;
			cin >> rating;
			ru.push_back(rating);
		}
		vector<int> ko;
		for (int i = 0; i < n; ++i)
		{
			int rating;
			cin >> rating;
			ko.push_back(rating);
		}
		sort(ru.begin(), ru.end());
		sort(ko.begin(), ko.end());

		int k=0, r=0;

		for (int i = 0; i < n; ++i)
		{
			if(ko[k] >= ru[r]){
				k++;
				r++;
			}
			else
				k++;
		}

		cout << r << endl;
	}
}