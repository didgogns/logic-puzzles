// https://www.youtube.com/watch?v=6w2c-myAxm4
#include <bits/stdc++.h>
using namespace std;

int arr[8][8];

int check()
{
	for (int i = 0; i < 6; i++)
	{
		for (int j = 0; j < 6; j++)
		{
			int cnt = 0;
			for (int x = 0; x < 3; x++)
			{
				for (int y = 0; y < 3; y++) cnt += arr[i + x][j + y];
			}
			if (cnt != 1) return 0;
		}
	}
	return 1;
}

int main()
{
	for (int i1 = 0; i1 < 64; i1++)
	{
		for (int i2 = i1 + 1; i2 < 64; i2++)
		{
			for (int i3 = i2 + 1; i3 < 64; i3++)
			{
				for (int i4 = i3 + 1; i4 < 64; i4++)
				{
					for (int i5 = i4 + 1; i5 < 64; i5++)
					{
						arr[i1 / 8][i1 % 8] = 1;
						arr[i2 / 8][i2 % 8] = 1;
						arr[i3 / 8][i3 % 8] = 1;
						arr[i4 / 8][i4 % 8] = 1;
						arr[i5 / 8][i5 % 8] = 1;
						if (check())
						{
							for (int i = 0; i < 8; i++)
							{
								for (int j = 0; j < 8; j++) cout << arr[i][j];
								cout << endl;
							}
							cout << endl;
						}
						for (int i = 0; i < 64; i++) arr[i / 8][i % 8] = 0;
					}
				}
			}
		}
	}
    return 0;
}
