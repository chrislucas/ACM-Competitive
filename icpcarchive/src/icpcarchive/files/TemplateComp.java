package icpcarchive.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TemplateComp {
	
	static class IO {
		
		static BufferedReader reader;
		static PrintWriter writer;
		static StringTokenizer token;

		public static void init() {
			reader 		= new BufferedReader(new InputStreamReader(System.in));
			writer 		= new PrintWriter(new OutputStreamWriter(System.out), true);
			token	 	= null;
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
		
		public static int readInt() {
			return Integer.parseInt(read());
		}
		
		public static BigInteger readBInt() {
			return new BigInteger(read());
		}
		
		public static BigDecimal readBDec() {
			return new BigDecimal(read());
		}
		
		public static int[] readInts(String del) {
			int array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new int [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Integer.parseInt(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static double[] readDoubles(String del) {
			double array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new double [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Double.parseDouble(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static void println(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
	}
	
	public static void runTestIO() {
		IO.init();
		while(IO.readEOF(" ")) {
			while(IO.token.hasMoreTokens()) {
				System.out.println(IO.token.nextToken());
			}
		}
	}
	
	public static void main(String[] args) {
		runTestIO();
	}

}
