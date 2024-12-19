import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://magnit.ru/product/1000483001-vici_krabovye_palochki_s_myas_nat_kr_okhl_170g_vichyunay_rus?shopCode=992301&shopType=6").get();
        Elements priceEl = doc.selectXpath("//*[@id=\"magnit-root\"]/div/div/main/div/div[1]/section/div/div/div/div[2]/section[1]/meta[1]");
        Elements nameEl = doc.selectXpath("//*[@id=\"magnit-root\"]/div/div/main/div/div[1]/section/div/div/div/div[2]/div[1]");
        String str = nameEl.get(0).text();
        String[] strs = str.split(" ");

        double price = Double.parseDouble(priceEl.get(0).attribute("content").getValue());
        String name = str.substring(0, str.lastIndexOf(" "));
        String size = strs[strs.length - 1];
        System.out.println(name);
        System.out.println(size);
        System.out.println(price);
    }
}