package com.zwonb.qunyingzhuan12;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    // 设置不同动画效果
    public void explode(View view) {
        intent = new Intent(this, Main4Activity.class);
        intent.putExtra("flag", 0);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    // 设置不同动画效果
    public void slide(View view) {
        intent = new Intent(this, Main4Activity.class);
        intent.putExtra("flag", 1);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    // 设置不同动画效果
    public void fade(View view) {
        intent = new Intent(this, Main4Activity.class);
        intent.putExtra("flag", 2);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this)
                        .toBundle());
    }

    // 设置不同动画效果
    public void share(View view) {
        View fab = findViewById(R.id.fab_button);
        intent = new Intent(this, Main4Activity.class);
        intent.putExtra("flag", 3);
        // 创建单个共享元素
//        startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation(
//                        this, fab, "fab").toBundle());
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(
                        this,
                        // 创建多个共享元素
                        Pair.create(view, "share"),
                        Pair.create(fab, "fab")).toBundle());
    }
}
