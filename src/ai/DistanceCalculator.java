//package ai;
//import java.io.IOException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//public class DistanceCalculator  {
//
//    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("https://news.yahoo.co.jp").get();
//        // 各記事のaタグを取得。jQueryのセレクターと同じ感じで記載
//        Elements newsHeadlines = doc.select(".topicsList li.topicsListItem a");
//        for (Element headline : newsHeadlines) {
//            System.out.println("title: " + headline.ownText() + ",  href: " + headline.absUrl("href"));
//        }
//    }
//}
//}
