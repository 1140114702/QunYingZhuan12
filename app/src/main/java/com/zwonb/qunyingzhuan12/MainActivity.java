package com.zwonb.qunyingzhuan12;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_product_yzt);
        final ImageView imageView = (ImageView) findViewById(R.id.main_img);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getLightVibrantSwatch();
                if (vibrantSwatch != null) {
                    imageView.setImageDrawable(new ColorDrawable(vibrantSwatch.getRgb()));
//                Window window = getWindow();
//                window.setStatusBarColor(vibrantSwatch.getRgb());
                }
            }
        });

        View view1 = findViewById(R.id.text_view1);
        View view2 = findViewById(R.id.text_view2);

        ViewOutlineProvider provider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        };

        ViewOutlineProvider provider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };

        view1.setOutlineProvider(provider1);
        view2.setOutlineProvider(provider2);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

    }

    public void shareImg(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class),
                ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        view, "yizongtao").toBundle());

    }

    public void startActivity(View view) {
        startActivity(new Intent(this, Main3Activity.class));
    }

    public void none(View view) {
    }

    public void circular1(final View view) {
        findViewById(R.id.circular1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(view,
                        view.getWidth() / 2, view.getHeight() / 2, view.getWidth() / 2, 0);
                circularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
                circularReveal.setDuration(300);
                circularReveal.start();
            }
        });
    }

    public void circular2(final View view) {
        findViewById(R.id.circular2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(view,
                        0, 0, 0, (float) Math.hypot(view.getWidth(), view.getWidth()));
                circularReveal.setInterpolator(new AccelerateInterpolator());
                circularReveal.setDuration(300);
                circularReveal.start();
            }
        });
    }

    public void stateAnim(View view) {
        StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(this, R.drawable.state_list_anim);
        view.setStateListAnimator(stateListAnimator);

    }

    public void starToolBar(View view) {
        startActivity(new Intent(this, ToolBarActivity.class));
    }

    public void startNotification(View view) {
        startActivity(new Intent(this, NotificationActivity.class));
    }
}
