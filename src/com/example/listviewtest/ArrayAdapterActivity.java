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
	private String[] list2={"Java","��","��","˼","��","2"};
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
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("Ŀ");
		list.add("��");
		list.add("��");
		list.add("ʵ");
		list.add("ս");		
		return list;
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
}
