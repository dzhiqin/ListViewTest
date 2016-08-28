package com.example.listviewtest;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

public class SimpleAdapterActivity extends Activity{

	private SimpleAdapter adapter;
	private ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listview);
		mListView=(ListView)findViewById(R.id.mListView);		
		//在map中名称和内容对应起来，在from和to中名称和id对应起来
		/*adapter=new SimpleAdapter(this,getData(),android.R.layout.simple_list_item_1,  
				new String[]{"name"}, new int[]{android.R.id.text1});*/
		adapter=new SimpleAdapter(this,getFruitMaps(),R.layout.list_item_img2,  
				new String[]{"name","description","img"},new int[]{R.id.tv_name,R.id.tv_describe,R.id.img_fruit});
		
		//adapter绑定网络图片
		/*adapter=new SimpleAdapter(this,getYouDaoData(),R.layout.list_item_img2,  
				new String[]{"name","description","img"},new int[]{R.id.tv_name,R.id.tv_describe,R.id.img_fruit});		
		adapter.setViewBinder(new MyViewBinder());*/
		mListView.setAdapter(adapter);
		//setListAdapter(adapter);
	}
	private List<HashMap<String,Object>> getData(){
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		HashMap<String ,Object> map=new HashMap<String,Object>();
		map.put("name", "banana");
		list.add(map);
		
		map=new HashMap<String,Object>();
		map.put("name", "coco");
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name", "lime");
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name", "strawberry");
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name", "tomato");
		list.add(map);
		return list;
	}
	private List<HashMap<String,Object>> getFruitMaps(){
		List<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("name","Banana");
		map.put("description", "香蕉，芭蕉科芭蕉属植物，热带地区广泛栽培食用。香蕉味香、富含营养，终年可收获，在温带地区也很受重视");
		map.put("img",R.drawable.banana_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Coco");
		map.put("description", "椰子，棕榈科椰子属植物，植株高大，乔木状，高15-30米，果卵球状或近球形，果腔含有胚乳（即“果肉”或种仁），胚和汁液（椰子水）");
		map.put("img",R.drawable.cocco_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Lime");
		map.put("description", "酸橙，无患子目、芸香科、柑橘亚科植物。树干和叶均为绿色，叶椭圆形至卵状,花后结出的橙黄色扁圆形果实，常悬于枝上数年而不凋。");
		map.put("img",R.drawable.lime_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Strawberry");
		map.put("description", "草莓，蔷薇科草莓属植物，多年生草本，高10-40厘米。草莓营养价值高，含有多种营养物质 ，且有保健功效。");
		map.put("img",R.drawable.strawberry_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Tomato");
		map.put("description", "西红柿，茄科茄属植物，一年生或多年生草本植物，体高0.6-2米，浆果扁球状或近球状，肉质而多汁液，种子黄色，花果期夏秋季");
		map.put("img",R.drawable.tomato_64px);
		list.add(map);
		return list;
	}
	/**
	 * 获取网络图片资源，返回类型是Bitmap，用于放在listView中
	 */
	public Bitmap getBitmap(String httpUrl){
		Bitmap bmp=null;
		HttpURLConnection conn=null;
		try{
			URL url=new URL(httpUrl);
			conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(8000);
			conn.setReadTimeout(8000);
			InputStream is=conn.getInputStream();
			bmp=BitmapFactory.decodeStream(url.openStream());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				conn.disconnect();
			}
		}
		return bmp;
	}
	private List<HashMap<String,Object>>getYouDaoData(){
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object>map=new HashMap<String,Object>();
		map.put("name","1");
		map.put("description", "有道云笔记");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);		
		map=new HashMap<String,Object>();
		map.put("name","2");
		map.put("description", "有道云笔记");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","3");
		map.put("description", "有道云笔记");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);
		return list;
	}
	/**
	 * 实现ViewBinder接口
	 */
	class MyViewBinder implements ViewBinder
	{
		/**
	     * view：要板顶数据的视图
	     * data：要绑定到视图的数据
	     * textRepresentation：一个表示所支持数据的安全的字符串，结果是data.toString()或空字符串，但不能是Null
	     * 返回值：如果数据绑定到视图返回真，否则返回假
	     */
		@Override
		public boolean setViewValue(View view, Object data,
				String textRepresentation) {
			//对象运算符(instanceof)用来判断一个对象是否属于某个指定的类或其子类的实例，如果是，返回真(true)，否则返回假(false)。
			if((view instanceof ImageView)&(data instanceof Bitmap)){
				ImageView v=(ImageView)view;
				Bitmap bmp=(Bitmap)data;
				v.setImageBitmap(bmp);
				return true;
			}
			return false;
		}
		
	}
}
