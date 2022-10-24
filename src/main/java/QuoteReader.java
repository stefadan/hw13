import lombok.Cleanup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QuoteReader {

    protected static List<Quote> readFileBuffered() throws IOException, IOException {
        //System.out.println("Buffered read:");
        ArrayList<Quote> result = new ArrayList<>();
        @Cleanup BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\AFastTrack\\Proiecte\\acurs13\\src\\main\\resources\\quotes.txt"));
        String line;
        int i=0;
        while ((line = bufferedReader.readLine()) != null) {
            i++;
            //System.out.println(i+" "+line);
            result.add(quoteFromLine(i, line));
        }
        return result;
    }

    private static Quote quoteFromLine(int i, String line) {
        String[] tokens = line.split(Pattern.quote("~"));
        //System.out.println(i+" "+tokens[0]+" --> "+tokens[1]);
        return new Quote(i, tokens[0], tokens[1], false);
    }


    //    private static void readingAllFile() throws FileNotFoundException, FileNotFoundException {
    //        System.out.println("Starting to read all file!");
    //        Scanner scanner = new Scanner(new File("C:\\AFastTrack\\Proiecte\\acurs13\\src\\main\\resources", "quotes.txt"));
    //        int i = 0;
    //        while (scanner.hasNext()) {
    //            i++;
    //            System.out.println(i+" "+scanner.nextLine());
    //        }
    //    }

}
