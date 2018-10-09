#include <iostream>
#include <cstdlib>
#include <windows.h>
#include <conio.h>
#include <ctime>
#include <stdio.h>
#include <fstream>
using namespace std;

int x[16][31], i, j, sc = 0, t, r, k = 0, lc = 2, m1, m2, m3, m4, a[406], go = 0, timp = 35, tm3, tm4, nrM = 0, ok = 0, slap, sc1, h;
char c, v, n;
void buf()
{
	ifstream F("HighScore.txt");
	F.close();
}
void setCursor(int u, int l)
{
	COORD p = { u, l };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), p);
}
void Menu()
{
	system("cls");
	cout << "1.New Game" << endl;
	cout << "2.Difficulty" << endl;
	cout << "3.HighScore " << endl;
	cout << "4.Exit";
	n = _getch();
	fflush(stdin);
}
void difficulty()
{
	system("cls");
	cout << "1.Beginner" << endl;
	cout << "2.Medium" << endl;
	cout << "3.Advanced" << endl;
	cout << "4.Back to menu";
	n = _getch();
	fflush(stdin);
}
void HIGH()
{
	system("cls");
	cout << "Highscore : " << h << endl;
	cout << "1.Back to menu";
	n = _getch();
	fflush(stdin);
}
void init()
{
	for (int l = 1; l <= 406; l++)a[l] = 5 + l;
}
void contur()
{
	for (i = 1; i <= 15; i++)
		for (j = 1; j <= 30; j++)
		{
			if (i == 1 || j == 1 || i == 15 || j == 30)x[i][j] = 0;
			else x[i][j] = 1;
		}
	x[7][15] = 2;
	x[7][16] = a[1];
	x[7][17] = a[2];
	i = 7;
	j = 15;
	t = 7;
	r = 18;
}
void afis()
{
	setCursor(0, 0);
	for (int l = 1; l <= 15; l++)
	{
		for (int p = 1; p <= 30; p++)
		{
			if (x[l][p] == 1)cout << ' ';
			else if (x[l][p] == 2)cout << '@';
			else if (x[l][p] == 3)cout << '%';
			else if (x[l][p] == 0)cout << '#';
			else if (x[l][p] == 5)cout << '$';
			else cout << '*';
		}
		cout << endl;
	}
	cout << "SCOR : " << sc;

}
void coada(int lc)
{
	int f = i, m = j, b;
	for (b = 1; b <= lc; b++)
	{
		if (x[f - 1][m] == a[b])
		{
			x[f][m] = a[b];
			f--;
		}
		else if (x[f + 1][m] == a[b])
		{
			x[f][m] = a[b];
			f++;
		}
		else if (x[f][m - 1] == a[b])
		{
			x[f][m] = a[b];
			m--;
		}
		else if (x[f][m + 1] == a[b])
		{
			x[f][m] = a[b];
			m++;
		}
	}
	t = f;
	r = m;
}
void mancare()
{
	while (1)
	{
		m1 = rand() % 13 + 2;
		m2 = rand() % 28 + 2;
		if (x[m1][m2] == 1)
		{
			x[m1][m2] = 3;
			break;
		}
	}
}
void mancareSP()
{
	while (1)
	{
		m4 = rand() % 13 + 2;
		m3 = rand() % 28 + 2;
		if (x[m3][m4] == 1)
		{
			x[m3][m4] = 5;
			tm3 = m3;
			tm4 = m4;
			break;
		}
	}
}
void up()
{
	if (c == 'w')
	{
		if (timp == 0 && ok == 0)x[tm3][tm4] = 1;
		if (x[i - 1][j] == 0 || x[i - 1][j]>5)go = 1;
		timp--;
		if (x[i - 1][j] == 3)
		{
			nrM++;
			sc += sc1;
			lc++;
			x[t][r] = a[lc];
			mancare();
			if (nrM == 5)
			{
				mancareSP();
				ok = 0;
				timp = 35;
				nrM = 0;
			}
		}
		if (x[i - 1][j] == 5)
		{
			sc += 2 * timp*sc1;
			ok = 1;
			lc++;
			x[t][r] = a[lc];
		}
		x[i - 1][j] = 2;
		coada(lc);
		i--;
		x[t][r] = 1;
		afis();
		k = 0;
	}
	else k = 1;
}
void down()
{
	if (c == 's')
	{
		if (timp == 0 && ok == 0)x[tm3][tm4] = 1;
		if (x[i + 1][j] == 0 || x[i + 1][j]>5)go = 1;
		timp--;
		if (x[i + 1][j] == 3)
		{
			nrM++;
			sc += sc1;
			lc++;
			x[t][r] = a[lc];
			mancare();
			if (nrM == 5)
			{
				mancareSP();
				ok = 0;
				timp = 35;
				nrM = 0;
			}
		}
		if (x[i + 1][j] == 5)
		{
			sc += 2 * timp*sc1;
			ok = 1;
			lc++;
			x[t][r] = a[lc];
		}
		x[i + 1][j] = 2;
		coada(lc);
		i++;
		x[t][r] = 1;
		afis();
		k = 0;
	}
	else k = 1;
}
void left()
{
	if (c == 'a')
	{
		if (timp == 0 && ok == 0)x[tm3][tm4] = 1;
		if (x[i][j - 1] == 0 || x[i][j - 1]>5)go = 1;
		timp--;
		if (x[i][j - 1] == 3)
		{
			nrM++;
			sc += sc1;
			lc++;
			x[t][r] = a[lc];
			mancare();
			if (nrM == 5)
			{
				mancareSP();
				ok = 0;
				timp = 35;
				nrM = 0;
			}
		}
		if (x[i][j - 1] == 5)
		{
			sc += 2 * timp*sc1;
			ok = 1;
			lc++;
			x[t][r] = a[lc];
		}
		x[i][j - 1] = 2;
		coada(lc);
		j--;
		x[t][r] = 1;
		afis();
		k = 0;
	}
	else k = 1;
}
void right()
{
	if (c == 'd')
	{
		if (timp == 0 && ok == 0)x[tm3][tm4] = 1;
		if (x[i][j + 1] == 0 || x[i][j + 1]>5)go = 1;
		timp--;
		if (x[i][j + 1] == 3)
		{
			nrM++;
			sc += sc1;
			lc++;
			x[t][r] = a[lc];
			mancare();
			if (nrM == 5)
			{
				mancareSP();
				ok = 0;
				timp = 35;
				nrM = 0;
			}
		}
		if (x[i][j + 1] == 5)
		{
			sc += 2 * timp*sc1;
			ok = 1;
			lc++;
			x[t][r] = a[lc];
		}
		x[i][j + 1] = 2;
		coada(lc);
		j++;
		x[t][r] = 1;
		afis();
		k = 0;
	}
	else k = 1;
}
void miscare()
{
	char ch = 0;
	Sleep(slap);
	if (_kbhit()) {
		ch = _getch();
	}
	if ((ch == 'a' || c == 'a') && v != 'd') {
		left();
		c = 'a';
	}
	if ((ch == 'd' || c == 'd') && v != 'a') {
		right();
		c = 'd';
	}
	if ((ch == 'w' || c == 'w') && v != 's') {
		up();
		c = 'w';
	}
	if ((ch == 's' || c == 's') && v != 'w') {
		down();
		c = 's';
	}
	fflush(stdin);
}
void cit()
{
	for (;;)
	{
		c = _getch();
		if (c == 'a' || c == 'w' || c == 's')break;
		fflush(stdin);
	}
	fflush(stdin);
	v = c;
}
