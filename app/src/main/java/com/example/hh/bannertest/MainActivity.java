package com.example.hh.bannertest;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.BannerImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import common_utils.ImageLoader;

public class MainActivity extends AppCompatActivity {

    protected Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        final List<String>urlList = new ArrayList<>();

        urlList.add(0,"http://chuantu.biz/t5/59/1491527935x2890171768.png");
        urlList.add(1,"http://chuantu.biz/t5/59/1491527935x2890171768.png");
        urlList.add(2,"http://chuantu.biz/t5/59/1491527935x2890171768.png");
        urlList.add(3,"http://chuantu.biz/t5/59/1491527935x2890171768.png");

        banner.setImages(urlList);
        banner.setImageLoader(new BannerImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                // 加载图片
                ImageLoader.load(context,path.toString(),imageView, R.drawable.default_img_banner);
            }
        });
        banner.start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position > urlList.size())
                    position = 1;

                textView.setText(position+"");

                Log.i("hh", "------------------------------------------------"+position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
