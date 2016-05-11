package acmtimus.br.com.beginners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Besta so para ter uma submissao. Estou sem tempo para fazer um mais dificil
 * 
 * */

public class P1000 {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer tk = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
			writer.println(a + b);
		} catch(IOException ioex) {}
	}
}
