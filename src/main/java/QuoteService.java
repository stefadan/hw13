import lombok.*;

import java.util.*;

@AllArgsConstructor
@ToString

public class QuoteService {
    List<Quote> quoteList;

    public List<String> getAllQuotes() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < quoteList.size(); i++) {
            System.out.println("Quote no. "+i+" "+quoteList.get(i).getQuote());
            result.add(quoteList.get(i).getQuote());

        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (int i = 0; i < quoteList.size(); i++) {
            if (author.equals(quoteList.get(i).getAuthor())) {
                result.add(new Quote(quoteList.get(i).getId(),
                                quoteList.get(i).getAuthor(),
                                quoteList.get(i).getQuote(),
                                quoteList.get(i).isFavourite()
                        )
                );
                System.out.println(quoteList.get(i).getAuthor() + " " + quoteList.get(i).getQuote());
            }
        }
        return result;
    }

    //distinct authors
    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < quoteList.size(); i++) {
            result.add(i, quoteList.get(i).getAuthor());
        }

        HashSet<String> hashSet = new HashSet<String>(result);
        System.out.println("Unique Values of ArrayList");
        for (String str : hashSet) {
            System.out.println(str);
        }
        System.out.println("Number of quotes: " + quoteList.size());
        System.out.println("Number of distinct authors: " + hashSet.size());

        return new ArrayList<>(hashSet);

    }

    public Quote setFavourite(int id) {
        Quote result = null;
        for (int i = 0; i < quoteList.size(); i++) {
            if (id == quoteList.get(i).getId()) {
                quoteList.get(i).setFavourite(true);
                result = new Quote(quoteList.get(i).getId(),
                        quoteList.get(i).getAuthor(),
                        quoteList.get(i).getQuote(),
                        quoteList.get(i).isFavourite());

            }
        }
        System.out.println("My favourite quote on position "
                //+ result.isFavourite() + " "
                + result.getId() + ": "
                + result.getQuote());
        return result;

    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        HashSet<Quote> hashSet = new HashSet<Quote>();
        int[] arr = {100, 200, 300, 400};
        for (int i = 0; i < quoteList.size(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    Quote favourite = setFavourite(arr[j]);
                    hashSet.add(new Quote(favourite.getId(), favourite.getAuthor(),
                            favourite.getQuote(), favourite.isFavourite()));
                }
            }
        }
        result = new ArrayList<>(hashSet);
        return result;
    }

    public String getRandomQuote() {
        String result = null;
        Random random = new Random();
        Integer position = random.nextInt(quoteList.size());
        for (int i = 0; i < quoteList.size(); i++) {
            if (position == i) {
                result = quoteList.get(i).getQuote();
            }
        }
        return result;
    }

}
