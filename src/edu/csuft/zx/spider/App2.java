package edu.csuft.zx.spider;


import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="https://movie.douban.com/subject/3319755/";
		
		try {
			Document doc=Jsoup.connect(url).get();
			
			//集合
			Elements es=doc.select("#content");
			System.out.println(es.size());
			
			//创建一个存储影片的列表
			ArrayList<Film2> list=new ArrayList<>();
			
			for(Element e:es) {
				
				Film2 f=new Film2();
				
				f.rank=e.select(".top250").first().text();
				f.title=e.select("h1").first().text();
				f.poster=e.select("img").first().attr("src");
				f.director=e.select("#info").first().text();
				//f.screenwriter=e.select("#info .").first().text();
				//f.actor=e.select("#info .").first().text();
				f.rating=Double.parseDouble(e.select("strong").first().text());
				String num=e.select(".rating_people").first().text();
				f.num=Integer.parseInt(num.substring(0, num.length()-3));
				
				
				System.out.println(f);
				list.add(f);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
