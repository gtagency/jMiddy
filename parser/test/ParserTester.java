package parser.test;

import java.io.File;
import java.io.IOException;
import parser.Parser;

public class ParserTester {
	public static void main(String[] args) throws IOException {
		Parser p = new Parser(new File(args[0]));
		p.parse();
	}
}
