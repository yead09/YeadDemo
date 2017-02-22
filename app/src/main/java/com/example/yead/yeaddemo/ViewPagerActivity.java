package com.example.yead.yeaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yead.yeaddemo.adapter.ViewPagerAdapter;
import com.example.yead.yeaddemo.bean.Book;
import com.example.yead.yeaddemo.fragment.ContentFragment;
import com.example.yead.yeaddemo.fragment.Fragment1;
import com.example.yead.yeaddemo.fragment.HistoryFragment;
import com.example.yead.yeaddemo.fragment.LoginFragment;
import com.example.yead.yeaddemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer",0);
        int fakeNumber = bundle.getInt("fake",0);
        Book book = (Book)bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ", message);
        UtilLog.logD("ViewPagerActivity, number is: ", ""+number);
        UtilLog.logD("ViewPagerActivity, fake number is: ", String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is: ", book.getAuthor());
        initial();
    }



    private void initial() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new ContentFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        //tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message", "viewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }
}
