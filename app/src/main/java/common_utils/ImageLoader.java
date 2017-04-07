package common_utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class ImageLoader {

    public static void load( Context context, String url, ImageView view, int defultId){
        if(TextUtils.isEmpty(url)) return;

        Picasso.with(context).load(url).error(defultId).into(view);
    }
}
