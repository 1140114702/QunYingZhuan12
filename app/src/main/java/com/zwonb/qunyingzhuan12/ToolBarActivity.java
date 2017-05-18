package com.zwonb.qunyingzhuan12;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
//        toolbar.setTitle("这是一个ToolBar");
//        toolbar.setSubtitle("副标题");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置坐边的返回按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            //不显示自带的Title
            actionBar.setDisplayShowTitleEnabled(false);
        }

        frameLayout = (FrameLayout) findViewById(R.id.tool_bar_bottom_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;

    }

}
