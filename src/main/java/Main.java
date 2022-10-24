import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Quote> list = QuoteReader.readFileBuffered();
        QuoteService qs = new QuoteService(list);
        qs.getAllQuotes();
        System.out.println("Quotes for author "+qs.getQuotesForAuthor("unknown"));
        System.out.println("List of distinct authors "+qs.getAuthors());
        System.out.println("Favourite on position "+qs.setFavourite(2));
        qs.getFavourites();
        System.out.println("Random quote "+qs.getRandomQuote());

    }


}
