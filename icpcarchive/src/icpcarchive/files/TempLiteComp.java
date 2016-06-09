package icpcarchive.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class TempLiteComp {
	static class IO {		
		private static BufferedReader reader;
		private static PrintWriter writer;
		private static StringTokenizer token;
		public static void init()  {
			boolean oj 	= System.getProperty("ONLINE_JUDGE") == null;
			try {
				reader 		= oj ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader("input.txt"));
				writer 		= oj ? new PrintWriter(new OutputStreamWriter(System.out), true) : new PrintWriter(new FileWriter("output.txt"));
				token 		= null;
			} catch (IOException e) {}
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static String read(String del) {
			StringBuilder builder = new StringBuilder();
			try {
				StringTokenizer tokenize = new StringTokenizer(reader.readLine(), del);
				while(tokenize.hasMoreTokens()) {
					builder.append(tokenize.nextToken());
				}
			} catch (IOException e) {}
			return builder.toString();
		}
		
		public static boolean readEOF() {
			while (  token == null || ! token.hasMoreTokens() ) {
				String line = null;
				if( (line = read()) == null )
					return false;
				token = new StringTokenizer(line);
			}
			return true;
		}
		
		public static boolean readEOF(String del) {
			while (  token == null || ! token.hasMoreTokens() ) {
				String line = null;
				if( (line = read()) == null )
					return false;
				token = new StringTokenizer(line, del);
			}
			return true;
		}
				
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	public static void runTestIO() {
		IO.init();
		while(IO.readEOF(" "))
			while(IO.token.hasMoreTokens())
				System.out.println(IO.token.nextToken());
	}
	
	public static void main(String[] args) {
		runTestIO();
	}

}
