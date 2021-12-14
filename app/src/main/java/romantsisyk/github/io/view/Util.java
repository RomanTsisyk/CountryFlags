package romantsisyk.github.io.view;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import romantsisyk.github.io.R;

public class Util {

    public static void loadImage(ImageView img, String url, CircularProgressDrawable draw) {
        RequestOptions options = new RequestOptions()
                .placeholder(draw)
                .error(R.mipmap.ic_launcher);

        Glide.with(img.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(img);

    }

    public static CircularProgressDrawable getProcessDrawable(Context contex){
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(contex);
        progressDrawable.setStrokeWidth(10f);
        progressDrawable.setCenterRadius(50f);
        progressDrawable.start();
        return progressDrawable;
    }
}
