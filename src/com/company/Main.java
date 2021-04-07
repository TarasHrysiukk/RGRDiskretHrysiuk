package com.company;

import java.util.*;

class ComponentsBound
{
    private static int[][] G;
    private static int N;

    private static boolean[] visited;

    // обхід графа в глибину з заданної вершини vertex
    private static void dfs(int vertex)
    {
        System.out.print(vertex + " ");

        visited[vertex] = true;

        for (int i = 0; i < N; i++)
        {
            if (!visited[i] && G[vertex][i] == 1) // якщо i-та вершина не пройдена и є шлях vertex -> i
            {
                dfs(i);
            }
        }
    }

    // пошук компонент і вивід їх  на екран
    private static void findComponents()
    {
        visited = new boolean[ N ]; //масив пройденних вершин, true - значить пройдена, false ні
        Arrays.fill(visited, false);

        System.out.println("Компоненти: ");

        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                System.out.print("[ ");

                dfs(i);

                System.out.println("]");
            }
        }
    }

    public static void main(String[] args)
    {
        Random r = new Random();

        N = 5;

       // G = new int[ N ][ N ]; // матриця суміжності( G - Graph )
        G = new int[][]{{0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
       /* for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ( r.nextInt(N) == j ) {
                    G[i][j] = 1;
                }
                else {
                    G[i][j] = 0;
                }
            }
        }*/

        //результат
        System.out.println("Матриця Суміжності:");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                System.out.print(G[i][j] + " ");
            }

            System.out.println();
        }

        findComponents();
    }
}
