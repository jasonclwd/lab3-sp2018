import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Webscraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countword(final String weburl, final String word){
        int wordcount = 0;
        String uword = word.toUpperCase();
        String in = urlToString(weburl);
        String[] input = in.split(" ");
        for (int i = 0; i < input.length; i++) {
            if (input[i].toUpperCase().equals(uword)) {
                wordcount += 1;
            }
        }
        System.out.println(wordcount);
        return wordcount;
    }


    public static void main(String[] unused) {
        countword("http://erdani.com/tdpl/hamlet.txt" , "is");
        countword("https://www.bls.gov/tus/charts/chart9.txt" , "and");
        countword("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt", "and");

    }

}

