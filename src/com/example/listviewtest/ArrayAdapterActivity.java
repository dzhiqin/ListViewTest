package com.example.listviewtest;

import java.util.ArrayList;

import com.example.listviewtest.adapter.MyArrayAdapter;
import com.example.listviewtest.model.Fruit;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends Activity{
	private ListView mListView;
	private String[] list2={"Java","编","程","思","想","2"};
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listview);
		mListView=(ListView)findViewById(R.id.mListView);
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item_img1, R.id.tv_item,getData());
		MyArrayAdapter adapter=new MyArrayAdapter(this,R.layout.list_item_img2,getFruitEntities());
		mListView.setAdapter(adapter);
	}
	private ArrayList<String> getData(){
		ArrayList<String> list=new ArrayList<String>();
		list.add("android");
		list.add("经");
		list.add("典");
		list.add("项");
		list.add("目");
		list.add("开");
		list.add("发");
		list.add("实");
		list.add("战");		
		return list;
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
}
