package com.example.myfirstapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static Context appContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	ActionBar actionbar = getActionBar();
	actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	ActionBar.Tab OverviewTab = actionbar.newTab().setIcon(R.drawable.ic_action_drawing);
	//OverviewTab.setText("Overview");
	ActionBar.Tab PurchasesTab = actionbar.newTab().setIcon(R.drawable.ic_purchases);
	//.setText("Purchases");
	ActionBar.Tab RecipesTab = actionbar.newTab().setIcon(R.drawable.ic_recipes);
	//.setText("Recipes");
	ActionBar.Tab CalculatorTab = actionbar.newTab().setIcon(R.drawable.ic_calculator);
	//.setText("Calculator");
	
	Fragment OverviewFragment = new AFragment();
	Fragment PurchasesFragment = new BFragment();
	Fragment RecipesFragment = new CFragment();
	Fragment CalculatorFragment = new DFragment();

	OverviewTab.setTabListener(new MyTabsListener(OverviewFragment));
	PurchasesTab.setTabListener(new MyTabsListener(PurchasesFragment));
	RecipesTab.setTabListener(new MyTabsListener(RecipesFragment));
	CalculatorTab.setTabListener(new MyTabsListener(CalculatorFragment));
	
	actionbar.addTab(OverviewTab);
	actionbar.addTab(PurchasesTab);
	actionbar.addTab(RecipesTab);
	actionbar.addTab(CalculatorTab);
	
}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		//EditText editText = (EditText) findViewById(R.id.edit_message);
		//String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

}

class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
    this.fragment = fragment;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    //Toast.makeText(MainActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    ft.remove(fragment);
    }

	}  
