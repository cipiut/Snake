/** 
Snake(Windows).cpp : Defines the entry point for the console application.
@author Buciuman Mihai Catalin
Aplicatie facuta in clasa a X-a :)
*/

#include "stdafx.h"
#include"Snake.h"

int main()
{
	int vf = 0;
	system("title Snake");
	ifstream G("HighScore.in");
	G >> h;
	G.close();
	ofstream H("HighScore.in");
	buf();
meniu:
	c = 0;
	v = 0;
	go = 0;
	Menu();
	if (n == '1')goto game;
	else if (n == '2')goto dif;
	else if (n == '3')goto HighScore;
	else if (n == '4') { H << h; H.close(); return 0; }
	else goto meniu;
HighScore:
	HIGH();
	if (n == '1')goto meniu;
	else goto HighScore;
dif:
	difficulty();
	if (n == '1') { slap = 125; vf = 1; sc1 = 1; }
	else if (n == '2') { slap = 100; vf = 1; sc1 = 3; }
	else if (n == '3') { slap = 50; vf = 1; sc1 = 6; }
	else if (n == '4')goto meniu;
	else goto dif;
game:
	if (vf == 0) { slap = 125; sc1 = 1; }
	sc = 0;
	nrM = 0;
	init();
	contur();
	mancare();
	afis();
	cit();
	for (;;)
	{
		miscare();
		if (k == 0)v = c;
		if (go == 1) { if (sc>h)h = sc; goto meniu; }
	}
}


