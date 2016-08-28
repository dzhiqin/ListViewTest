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
		//��map�����ƺ����ݶ�Ӧ��������from��to�����ƺ�id��Ӧ����
		/*adapter=new SimpleAdapter(this,getData(),android.R.layout.simple_list_item_1,  
				new String[]{"name"}, new int[]{android.R.id.text1});*/
		adapter=new SimpleAdapter(this,getFruitMaps(),R.layout.list_item_img2,  
				new String[]{"name","description","img"},new int[]{R.id.tv_name,R.id.tv_describe,R.id.img_fruit});
		
		//adapter������ͼƬ
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
		map.put("description", "�㽶���Ž��ưŽ���ֲ��ȴ������㷺����ʳ�á��㽶ζ�㡢����Ӫ����������ջ����´�����Ҳ��������");
		map.put("img",R.drawable.banana_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Coco");
		map.put("description", "Ҭ�ӣ���鵿�Ҭ����ֲ�ֲ��ߴ���ľ״����15-30�ף�������״������Σ���ǻ�������飨�������⡱�����ʣ����ߺ�֭Һ��Ҭ��ˮ��");
		map.put("img",R.drawable.cocco_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Lime");
		map.put("description", "��ȣ��޻���Ŀ��ܿ��ơ������ǿ�ֲ����ɺ�Ҷ��Ϊ��ɫ��Ҷ��Բ������״,�������ĳȻ�ɫ��Բ�ι�ʵ��������֦�����������");
		map.put("img",R.drawable.lime_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Strawberry");
		map.put("description", "��ݮ��Ǿޱ�Ʋ�ݮ��ֲ��������ݱ�����10-40���ס���ݮӪ����ֵ�ߣ����ж���Ӫ������ �����б�����Ч��");
		map.put("img",R.drawable.strawberry_64px);
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","Tomato");
		map.put("description", "���������ѿ�����ֲ�һ������������ݱ�ֲ����0.6-2�ף���������״�����״�����ʶ���֭Һ�����ӻ�ɫ�����������＾");
		map.put("img",R.drawable.tomato_64px);
		list.add(map);
		return list;
	}
	/**
	 * ��ȡ����ͼƬ��Դ������������Bitmap�����ڷ���listView��
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
		map.put("description", "�е��Ʊʼ�");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);		
		map=new HashMap<String,Object>();
		map.put("name","2");
		map.put("description", "�е��Ʊʼ�");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);
		map=new HashMap<String,Object>();
		map.put("name","3");
		map.put("description", "�е��Ʊʼ�");
		map.put("img",getBitmap("http://note.youdao.com/favicon.ico"));
		list.add(map);
		return list;
	}
	/**
	 * ʵ��ViewBinder�ӿ�
	 */
	class MyViewBinder implements ViewBinder
	{
		/**
	     * view��Ҫ�嶥���ݵ���ͼ
	     * data��Ҫ�󶨵���ͼ������
	     * textRepresentation��һ����ʾ��֧�����ݵİ�ȫ���ַ����������data.toString()����ַ�������������Null
	     * ����ֵ��������ݰ󶨵���ͼ�����棬���򷵻ؼ�
	     */
		@Override
		public boolean setViewValue(View view, Object data,
				String textRepresentation) {
			//���������(instanceof)�����ж�һ�������Ƿ�����ĳ��ָ��������������ʵ��������ǣ�������(true)�����򷵻ؼ�(false)��
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
