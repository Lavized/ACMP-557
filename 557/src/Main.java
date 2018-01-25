import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int p = 0;

    public static void main(String[] args) throws IOException {
        Main.run();
    }

    private static void run() throws IOException {
        PrintWriter pw;
        Scanner sc;

        sc = new Scanner(new File("INPUT.TXT"));
        sc.useDelimiter(System.getProperty("line.separator"));
        String[] countOfNums = sc.next().split(" ");

        int n = Integer.parseInt(countOfNums[1]);
        String[] readNums = sc.next().split(" ");
        int iel = Integer.parseInt(readNums[0]);
        int jel = Integer.parseInt(readNums[1]);
        p = sc.nextInt();
        ArrayList<int[][]> arrays = new ArrayList<>();


        while (sc.hasNext()) {
            int[][] array = new int[n][n];
            sc.next();
            for (int j = 0; j < n; j++) {
                String[] split = sc.next().split(" ");
                for (int m = 0; m < split.length; m++) {
                    array[j][m] = Integer.parseInt(split[m]);
                }
            }
            arrays.add(array);
        }
        sc.close();


        for (int i = 0; i < arrays.size() - 1; i++) {
            arrays.set(0, multyply(n, arrays.get(0), arrays.get(i + 1)));
        }

        pw = new PrintWriter(new File("OUTPUT.TXT"));
        pw.print(arrays.get(0)[iel - 1][jel - 1]);
        pw.close();

    }

    private static int[][] multyply(int n, int[][] f, int[][] s) {
        int[][] mutlyplyArray = new int[n][n];
        int[][] bt = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                bt[i][j] = s[j][i];


        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int value = 0;
                for (int k = 0; k < n; ++k)
                    value += f[i][k] * bt[j][k];
                if (value >= p) {
                    value = value % p;
                }
                mutlyplyArray[i][j] = value;
            }


        return mutlyplyArray;
    }

}
