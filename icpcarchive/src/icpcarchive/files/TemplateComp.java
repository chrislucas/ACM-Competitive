package icpcarchive.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TemplateComp {
	
	static class IO {
		/*
		 * http://acm.timus.ru/help.aspx?topic=java
		 * */
		
		private static BufferedReader reader;
		private static PrintWriter writer;
		private static StringTokenizer token;
		private static StreamTokenizer stoken;

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
		
		public static void println(String fmt, Object data) {
			writer.printf(fmt, data);
		}
		
		public static void close() {
			writer.flush();
			writer.close();
			/*
			try {
				reader.close();
			} catch (IOException e) {}
			*/
		}
	}
	
	public static void runTestIO() {
		try {
			IO.init();
			while(IO.readEOF(" ")) {
				while(IO.token.hasMoreTokens()) {
					System.out.println(IO.token.nextToken());
				}
			}
		} catch (IOException e) {}
	}
		
	public static void main(String[] args) {
		//runTestIO();
		runTime();
	}
	/**
	 * http://tutorials.jenkov.com/java-io/streamtokenizer.html
	 * Ler
	 * http://tutorials.jenkov.com/java-io/stringreader.html
	 * https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
	 * */
	public static void runTime() {
		String address [] = {
			"http://norvig.com/big.txt"
			,"http://textfiles.com/"
			,"http://textfiles.com/100/914bbs.txt"
		};
		long s = System.currentTimeMillis();
		BR(address[0]);
		System.out.println( (System.currentTimeMillis() - s) / 1000);
		s = System.currentTimeMillis();
		ST(address[0]);
		System.out.println( (System.currentTimeMillis() - s) / 1000);
	}
	
	public static void BR(String address) {
		try {
			URL url = new URL(address);
			Reader reader = new InputStreamReader(url.openStream());
			BufferedReader buffer = new BufferedReader(reader);
			String line = null;
			ArrayList<String> sList = new ArrayList<>();
			while ( (line = buffer.readLine()) != null) {
				sList.add(line);
				if(sList.size() > 200000)
					break;
			}
			System.out.println(sList.size());
		} catch ( IOException e) {
			System.out.println(e);
		}
		return;
	}
	public static void ST(String address) {
		URL url;
		try {
			url = new URL(address);
			/**
			 * a classe StreamTokenizer possibilta quebrar uma string em tokens
			 * a partir de um Objeto da classe Reader
			 * Podemos ler token por token ate o final do Stream usando a constante
			 * StreamTokenizer.TT_EOF || ate ao final da linha usanto StreamTokenizer.TT_EOL
			 * Podemos veriticar se o token eh do tipo String StreamTokenizer.TT_WORD ou
			 * numerico com StreamTokenizer.TT_NUMBER
			 * */
			
			StreamTokenizer st = new StreamTokenizer(new InputStreamReader(url.openStream()));
			ArrayList<String> sList = new ArrayList<>();
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				sList.add(st.toString());
				if(sList.size() > 200000)
					break;
			}
			System.out.println(sList.size());
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
