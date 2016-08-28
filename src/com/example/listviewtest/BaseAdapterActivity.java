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
		//ʹ�õڶ���������
		adapter=new MyBaseAdapter(this,getFruitMaps());
		mListView.setAdapter(adapter);
	}
	private ArrayList<Fruit> getFruitEntities(){
		ArrayList<Fruit> list =new ArrayList<Fruit>();
		list.add(new Fruit("Banana","�㽶���Ž��ưŽ���ֲ��ȴ������㷺����ʳ�á��㽶ζ�㡢����Ӫ����������ջ����´�����Ҳ��������",R.drawable.banana_64px));
		list.add(new Fruit("Coco","Ҭ�ӣ���鵿�Ҭ����ֲ�ֲ��ߴ���ľ״����15-30�ף�������״������Σ���ǻ�������飨�������⡱�����ʣ����ߺ�֭Һ��Ҭ��ˮ��",R.drawable.cocco_64px));
		list.add(new Fruit("Lime","��ȣ��޻���Ŀ��ܿ��ơ������ǿ�ֲ����ɺ�Ҷ��Ϊ��ɫ��Ҷ��Բ������״,�������ĳȻ�ɫ��Բ�ι�ʵ��������֦�����������",R.drawable.lime_64px));
		list.add(new Fruit("Strawberry","��ݮ��Ǿޱ�Ʋ�ݮ��ֲ��������ݱ�����10-40���ס���ݮӪ����ֵ�ߣ����ж���Ӫ������ �����б�����Ч��",R.drawable.strawberry_64px));
		list.add(new Fruit("Tomato","���������ѿ�����ֲ�һ������������ݱ�ֲ����0.6-2�ף���������״�����״�����ʶ���֭Һ�����ӻ�ɫ�����������＾",R.drawable.tomato_64px));
		return list;
	}
	private ArrayList<HashMap<String,Object>> getFruitMaps(){
		ArrayList<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
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
}
