package edu.csuft.zx.spider;


import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * 
 * @author zhangxiao
 *
 */
public class App {

	//alt + /
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//目标路径 URL
		String url="https://movie.douban.com/top250";
		
		//使用JSOUP抓取文档
		try {
			Document doc=Jsoup.connect(url).get();
			
//			Elements es=doc.select("img[src]");
//			Elements es=doc.select(".grid_view img");
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//创建一个存储影片的列表
			ArrayList<Film> list=new ArrayList<>();
			
			
			for(Element e :es) {
				Film f=new Film();
				//每一部影片
				Element t=e.select(".title").first();
				String num= e.select(".star span").last().text();
				System.out.println(t.text()+","+num);
				
//				f.id
//				f.title
				list.add(f);
				
//				Element t=e.select(".title").first();
//				String s= e.select(".quote").text();
//				System.out.println(t.text()+":"+s);
				
//				System.out.println(t.text());
//				System.out.println(e.attr("src"));
			}
			
//			String title =doc.title();
//			String data = doc.title();
			
//			System.out.println(title);
//			System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
