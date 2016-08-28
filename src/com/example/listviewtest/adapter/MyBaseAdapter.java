package com.example.listviewtest.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.listviewtest.R;
import com.example.listviewtest.model.Fruit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<Fruit> list;
	private List<HashMap<String,Object>> mList;
	/*public MyBaseAdapter(Context context,ArrayList<Fruit> list){
		this.context=context;
		this.list=list;
	}*/
	//使用第二种适配器
	public MyBaseAdapter(Context context,List<HashMap<String,Object>> mList){
		this.context=context;
		this.mList=mList;
	}
	@Override
	public int getCount() {
		// How many items are in the data set represented by this Adapter
		//return list.size();
		//使用第二种适配器
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// Get the data item associated with the specified position in the data set.
		return position;
	}

	@Override
	public long getItemId(int position) {
		// Get the row id associated with the specified position in the list
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get a View that displays the data at the specified position in the data set
		ViewHolder viewHolder=null;
		//Fruit fruit=list.get(position);
		//使用第二种适配器
		HashMap<String,Object> map=mList.get(position);
		//Log.v("test",""+ getItem(position));
		if(convertView==null){//如果convertview为空，就提取item布局，
			viewHolder=new ViewHolder();//实例化viewHoder，
			convertView=LayoutInflater.from(context).inflate(R.layout.list_item_img2,null);
			viewHolder.tvDescription=(TextView)convertView.findViewById(R.id.tv_describe);
			viewHolder.tvName=(TextView)convertView.findViewById(R.id.tv_name);
			viewHolder.imgFruit=(ImageView)convertView.findViewById(R.id.img_fruit);
			convertView.setTag(viewHolder);//把viewHolder保存在convertview里
		}else{
			viewHolder=(ViewHolder)convertView.getTag();
		}
		/*viewHolder.imgFruit.setImageResource(fruit.getImageId());
		viewHolder.tvDescription.setText(fruit.getDescription());
		viewHolder.tvName.setText(fruit.getName());*/
		//使用第二种适配器
		viewHolder.imgFruit.setImageResource((Integer) map.get("img"));
		viewHolder.tvDescription.setText((String)map.get("description"));
		viewHolder.tvName.setText((String)map.get("name"));
		return convertView;
	}
	class ViewHolder{
		private TextView tvName;
		private TextView tvDescription;
		private ImageView imgFruit;
	}
}
