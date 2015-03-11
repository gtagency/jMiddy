package org.gtagency;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.gtagency.shared.Note;
import org.gtagency.parser.Parser;


public class ParseDemo {
    public static void main(String... args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("java ParseDemo <file1 file2 file3...>");
            System.exit(0);
        }

        for (String s : args) {
            System.out.printf("File %s:\n", s);
            System.out.println("----------------------------------");
            Parser p = new Parser(new File(s));

            ArrayList<List<Note>> allNotes = p.parse();

            for (int i = 0; i < allNotes.size(); i++) {
                List<Note> notes = allNotes.get(i);
//                System.out.printf("%d: %s\n", i, notes.toString());
            }
            System.out.println("");
        }
    }
}
