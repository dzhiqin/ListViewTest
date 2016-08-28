package com.example.listviewtest.adapter;

import java.util.List;

import com.example.listviewtest.R;
import com.example.listviewtest.model.Fruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyArrayAdapter extends ArrayAdapter<Fruit>{
	
	public MyArrayAdapter(Context context, int resource, List<Fruit> objects) {
		super(context, resource, objects);
	}
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		Fruit fruit=(Fruit) getItem(position);
		ViewHolder viewHolder=null;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_item_img2,null);
			viewHolder=new ViewHolder();
			viewHolder.imgFruit=(ImageView)convertView.findViewById(R.id.img_fruit);
			viewHolder.tvDescription=(TextView)convertView.findViewById(R.id.tv_describe);
			viewHolder.tvName=(TextView)convertView.findViewById(R.id.tv_name);
			convertView.setTag(viewHolder);
		}else{			
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.imgFruit.setImageResource(fruit.getImageId());
		viewHolder.tvDescription.setText(fruit.getDescription());
		viewHolder.tvName.setText(fruit.getName());
		return convertView;
	}
	class ViewHolder{
		private TextView tvName;
		private TextView tvDescription;
		private ImageView imgFruit;
	}
}
