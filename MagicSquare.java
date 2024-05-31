
package P1;

import java.io.*;
import java.util.*;

public class MagicSquare {

    static int[][] square;
    private static Scanner in;

    public static boolean isConSpeCharacters(String string) {
        //检查给定字符串是否包含连续的特殊字符
        if (string.replaceAll("\\d*\\t*\\n*-*.*", "").length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean generateMagicSquare(int n) {
        if (n % 2 == 0) {
            System.out.println("Please input an even number!");
            return false;
        }
        if (n <= 0) {
            System.out.println("Please input a negative number!");
            return false;
        }
        try {
            System.setOut(new PrintStream("src/P1/txt/6.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int magic[][] = new int[n][n];
        int row = 0, col = n / 2, i, j, square = n * n;			//起始位置设置为正方形的顶部中心
        for (i = 1; i <= square; i++) {
            magic[row][col] = i;
            if (i % n == 0)                                     //当填充到的数字是当前正方形的边长的倍数时，会进行位置调整，使得填充的数字在下一个正方形中正确的位置。
                row++;
            else {												//行或列超出了正方形的边界，它就会绕到相反的一侧
                if (row == 0)
                    row = n - 1;
                else
                    row--;
                if (col == (n - 1))
                    col = 0;
                else
                    col++;
            }
        }
        for (i = 0; i < n; i++) {                               //打印矩阵
            for (j = 0; j < n; j++)
                System.out.print(magic[i][j] + "\t");
            System.out.println();
        }
        return true;
    }

    public static boolean isLegalMagicSquare(String fileName) {
        File file = new File(fileName);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String string = null;
            int lines = 0;
            int rows = 0;
            string = in.readLine();
            if (!isConSpeCharacters(string)) {
                System.out.print("Contains other delimiters! ");
                return false;
            }
            String[][] ss;
            String[] temps = string.split("\t");
            rows = temps.length;
            ss = new String[rows][rows];
            ss[lines++] = temps;
            while ((string = in.readLine()) != null) {
                if (!isConSpeCharacters(string)) {
                    System.out.print("Contains other delimiters! ");
                    return false;
                }
                temps = string.split("\t");
                if (temps.length != rows | lines >= rows) {
                    System.out.print("The number of rows is not equal to the number of columns. ");
                    return false;
                }
                ss[lines++] = temps;
            }
            if (lines != rows) {
                System.out.print("The number of rows is not equal to the number of columns. ");
                return false;
            }
            square = new int[lines][rows];
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < rows; j++) {
                    try {
                        square[i][j] = Integer.valueOf(ss[i][j]);
                    } catch (NumberFormatException e) {
                        System.out.print("Square" + "[" + i + "]" + "[" + j + "]" + "is not integer. ");
                        return false;
                    }
                    if (square[i][j] <= 0) {
                        System.out.print("Square" + "[" + i + "]" + "[" + j + "]" + " is negative integer. ");
                        return false;
                    }
                }
            }
            int res = 0;
            int lres = 0;
            int rres = 0;
            int dia = 0;
            int b_dia = 0;
            for (int j = 0; j < rows; j++) {
                res += square[0][j];
            }
            for (int i = 1; i < lines; i++) {
                for (int j = 0; j < rows; j++) {
                    lres += square[i][j];
                }
                if (lres != res) {
                    System.out.println("The sum of the " + i + " line don't match that of first line");
                    return false;
                }

                lres = 0;
            }
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < lines; i++) {
                    rres += square[i][j];
                    if (i == j) {
                        dia += square[i][j];
                    }
                    if ((i + j + 2) == (rows + 1)) {
                        b_dia += square[i][j];
                    }
                }
                if (rres != res) {
                    System.out.println("The sum of the " + j + " row don't match that of first line");
                    return false;
                }
                rres = 0;
            }
            if (b_dia != res || dia != res) {
                System.out.println("The sum of diagnoal don't match that of back-diagnoal.");
                return false;
            }
            in.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans;
        String s;
        PrintStream out = System.out;
        in = new Scanner(System.in);
        int n = 0;
        for (int i = 1; i <= 5; i++) {
            s = "src/P1/txt/" + String.valueOf(i) + ".txt";
            ans = isLegalMagicSquare(s);
            System.out.println(String.valueOf(i) + ".txt" + " " + ans);
        }
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Something input is not an integer!");
            return;
        }
        ans = generateMagicSquare(n) & isLegalMagicSquare("src/P1/txt/6.txt");
        System.setOut(out);
        if (!ans) {
            System.out.println(ans);
        } else
            System.out.println("6.txt " + ans);
    }
}
