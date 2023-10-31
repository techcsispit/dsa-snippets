#include <stdio.h>
#include <string.h>

int d = 23;

void search(char P[], char T[], int q)
{
    int m = strlen(P);
    int n = strlen(T);
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < m - 1; i++)
        h = (h * d) % q;

    for (i = 0; i < m; i++)
    {
        p = (d * p + P[i]) % q;
        t = (d * t + T[i]) % q;
    }

    for (i = 0; i <= n - m; i++)
    {

        if (p == t)
        {
            for (j = 0; j < m; j++)
            {
                if (T[i + j] != P[j])
                    break;
            }

            if (j == m)
                printf("Pattern found at index %d \n", i);
        }

        if (i < n - m)
        {
            t = (d * (t - T[i] * h) + T[i + m]) % q;

            if (t < 0)
                t = (t + q);
        }
    }
}

int main()
{
    char P[200], T[200];
    printf("Enter the text: \n");
    gets(T);
    printf("The text is %s \n", T);
    printf("Enter the pattern: \n");
    gets(P);
    printf("The pattern is %s \n", P);

    int q = 13;

    search(P, T, q);
    return 0;
}

