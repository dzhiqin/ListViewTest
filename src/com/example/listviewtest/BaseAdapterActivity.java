package com.example.listviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.listviewtest.adapter.MyBaseAdapter;
import com.example.listviewtest.model.Fruit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class BaseAdapterActivity extends Activity{

	private ListView mListView;
	private MyBaseAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listview);
		mListView=(ListView)findViewById(R.id.mListView);
		//adapter=new MyBaseAdapter(this,getFruitEntities());
		//使用第二种适配器
		adapter=new MyBaseAdapter(this,getFruitMaps());
		mListView.setAdapter(adapter);
	}
	private ArrayList<Fruit> getFruitEntities(){
		ArrayList<Fruit> list =new ArrayList<Fruit>();
		list.add(new Fruit("Banana","香蕉，芭蕉科芭蕉属植物，热带地区广泛栽培食用。香蕉味香、富含营养，终年可收获，在温带地区也很受重视",R.drawable.banana_64px));
		list.add(new Fruit("Coco","椰子，棕榈科椰子属植物，植株高大，乔木状，高15-30米，果卵球状或近球形，果腔含有胚乳（即“果肉”或种仁），胚和汁液（椰子水）",R.drawable.cocco_64px));
		list.add(new Fruit("Lime","酸橙，无患子目、芸香科、柑橘亚科植物。树干和叶均为绿色，叶椭圆形至卵状,花后结出的橙黄色扁圆形果实，常悬于枝上数年而不凋。",R.drawable.lime_64px));
		list.add(new Fruit("Strawberry","草莓，蔷薇科草莓属植物，多年生草本，高10-40厘米。草莓营养价值高，含有多种营养物质 ，且有保健功效。",R.drawable.strawberry_64px));
		list.add(new Fruit("Tomato","西红柿，茄科茄属植物，一年生或多年生草本植物，体高0.6-2米，浆果扁球状或近球状，肉质而多汁液，种子黄色，花果期夏秋季",R.drawable.tomato_64px));
		return list;
	}
	private ArrayList<HashMap<String,Object>> getFruitMaps(){
		ArrayList<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
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
}
