package com.example.listviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnArray;
	private Button btnSimple;
	private Button btnBase;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnArray=(Button)findViewById(R.id.btn_array);
		btnSimple=(Button)findViewById(R.id.btn_simple);
		btnBase=(Button)findViewById(R.id.btn_base);
	}
	public void use_arrayadapter(View v){
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, ArrayAdapterActivity.class);
		startActivity(intent);
	}
	public void use_simpleadapter(View v){
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, SimpleAdapterActivity.class);
		startActivity(intent);
	}
	public void use_baseadapter(View v){
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, BaseAdapterActivity.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
