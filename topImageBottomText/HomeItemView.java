package cn.com.oomall.kktown.activity.seller.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.oomall.kktown.R;


/**
 * 首页item类
 * Yang pengtao
 * Created by root on 16-8-10.
 */
public class HomeItemView extends RelativeLayout {

    private TextView mTopTv;
    private TextView mBottomTv;
    private ImageView mTopImg;

    public HomeItemView(Context context) {
        super(context);
    }

    public HomeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public HomeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }


    private void initView(Context context, AttributeSet attrs) {
        TypedArray types = context.obtainStyledAttributes(attrs, R.styleable.homeItem);
        boolean imgVisible = types.getBoolean(R.styleable.homeItem_imgVisible, true);
        boolean topTvVisible = types.getBoolean(R.styleable.homeItem_topTvVisible, true);
        String bottomText = types.getString(R.styleable.homeItem_bottomText);
        int bottomColor = types.getInt(R.styleable.homeItem_bottomTextColor, R.color.colorPrimary);
        float bottomSize = types.getDimension(R.styleable.homeItem_bottomTextSize, 12);
        String topText = types.getString(R.styleable.homeItem_topText);
        int topColor = types.getInt(R.styleable.homeItem_topTextColor, R.color.colorPrimary);
        float topSize = types.getDimension(R.styleable.homeItem_topTextSize, 12);
        int img = types.getResourceId(R.styleable.homeItem_topImg, R.drawable.home_add);

        mTopTv = new TextView(context);
        mBottomTv = new TextView(context);
        mTopImg = new ImageView(context);


        LinearLayout ll_content = new LinearLayout(context);
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(ll_content, lp);
        ll_content.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams childLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        childLp.gravity = Gravity.CENTER;
        if (!imgVisible) {
            mTopImg.setVisibility(View.GONE);
        }
        mTopImg.setImageResource(img);
        ll_content.addView(mTopImg, childLp);
        if (topTvVisible) {
            mTopTv.setText(topText);
            mTopTv.setTextColor(topColor);
            mTopTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, topSize);
            ll_content.addView(mTopTv, childLp);
        }
        childLp.setMargins(0, 10, 0, 0);
        mBottomTv.setText(bottomText);
        mBottomTv.setTextColor(bottomColor);
        mBottomTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, bottomSize);
        ll_content.addView(mBottomTv, childLp);
    }


    public HomeItemView setImgVisible(boolean imgVisible) {
        if (imgVisible) {
            mTopImg.setVisibility(View.VISIBLE);
        } else {
            mTopImg.setVisibility(View.GONE);
        }
        return this;
    }

    public HomeItemView setTopTvVisible(boolean topTvVisible) {
        if (topTvVisible) {
            mTopTv.setVisibility(View.VISIBLE);
        } else {
            mTopTv.setVisibility(View.GONE);
        }
        return this;
    }

    public HomeItemView setBottomText(String str) {
        mBottomTv.setText(str);
        return this;
    }

    public HomeItemView setBottomColor(int color) {
        mBottomTv.setTextColor(color);
        return this;
    }

    public HomeItemView setBottomSize(float size) {
        mBottomTv.setTextSize(size);
        return this;
    }

    public HomeItemView setTopText(String str) {
        mTopTv.setText(str);
        return this;
    }

    public HomeItemView setTopColor(int color) {
        mTopTv.setTextColor(color);
        return this;
    }

    public HomeItemView setTopSize(float size) {
        mTopTv.setTextSize(size);
        return this;
    }

    public HomeItemView setBottomTvTopMargin(int left, int top, int right, int bottom) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mBottomTv.getLayoutParams();
        layoutParams.setMargins(left, top, right, bottom);
        mBottomTv.setLayoutParams(layoutParams);
        return this;
    }

    public HomeItemView setTopImg(int drawable) {
        mTopImg.setImageResource(drawable);
        return this;
    }

}
