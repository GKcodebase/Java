package CheatSheet.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The Input output.
 */
public class InputOutput {
    /**
     * Main.
     *
     * @param args the args
     * @throws IOException the io exception
     */
    public static void main(String args[]) throws IOException {
        // Scanner (slower but easy to use)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long l = sc.nextLong();
        System.out.println(n+"  "+l);

        // BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer =new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        System.out.println(n);

        // Quick output
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("output");
        pw.flush();

    }
}
