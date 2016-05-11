package acmtimus.br.com.links;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;

public class Main {
	
	static Reader reader;
	static Writer writer;
	static StreamTokenizer tk;
	static PrintWriter print;
	
	public static void init() throws IOException {
		boolean oj 	= System.getProperty("ONLINE_JUDGE") != null;
		reader 		= oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
		writer 		= oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
		
		tk 		= new StreamTokenizer(new BufferedReader(reader));
		print 	= new PrintWriter(writer, true);
	}
}
