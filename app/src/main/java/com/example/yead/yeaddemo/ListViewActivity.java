package com.example.yead.yeaddemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yead.yeaddemo.adapter.ListViewAdapter;
import com.example.yead.yeaddemo.adapter.ViewPagerAdapter;
import com.example.yead.yeaddemo.fragment.ContentFragment;
import com.example.yead.yeaddemo.fragment.Fragment1;
import com.example.yead.yeaddemo.fragment.Fragment2;
import com.example.yead.yeaddemo.fragment.Fragment3;
import com.example.yead.yeaddemo.fragment.Fragment4;
import com.example.yead.yeaddemo.fragment.Fragment5;
import com.example.yead.yeaddemo.fragment.Fragment6;
import com.example.yead.yeaddemo.fragment.Fragment7;
import com.example.yead.yeaddemo.fragment.Fragment8;
import com.example.yead.yeaddemo.fragment.HistoryFragment;
import com.example.yead.yeaddemo.fragment.LoginFragment;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private  ListView listView;
    private ArrayList<String> listResult;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        initialView();
        listResult = new ArrayList<String>();
        creatFakeResult();
        initialView();
    }

    private void creatFakeResult(){

        listResult.add("A");
        listResult.add("B");
        listResult.add("C");
        listResult.add("D");
        listResult.add("E");
        listResult.add("F");
        listResult.add("G");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");

    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);

        LinearLayout listViewHeader = (LinearLayout)view.findViewById(R.id.list_view_header);

        viewPager = (ViewPager) view.findViewById(R.id.list_view_pager);


        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        //fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment5());
        fragmentList.add(new Fragment6());
        fragmentList.add(new Fragment7());
        fragmentList.add(new Fragment8());
        fragmentList.add(new Fragment4());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position:" +position,Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",String.valueOf(position));
    }
}
