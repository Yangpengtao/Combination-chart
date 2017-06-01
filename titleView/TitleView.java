package cn.com.oomall.kktown.activity.seller.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.oomall.kktown.R;
import cn.com.oomall.kktown.Utils.ScreenUtils;

/**
 * 标题布局文件
 * Yang pengtao
 * Created by root on 16-8-10.
 */
public class TitleView extends RelativeLayout {

    private TextView title;
    private ImageView titleImg;
    private TextView leftTextView;
    private ImageButton leftImageButton;
    private TextView rightTextView;
    private ImageButton rightImageButton;

    private LinearLayout centerLayout;
    private Context mContext;


    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    public void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        title = new TextView(context);
        titleImg = new ImageView(context);
        leftTextView = new TextView(context);
        leftImageButton = new ImageButton(context);
        rightTextView = new TextView(context);
        rightImageButton = new ImageButton(context);
        centerLayout = new LinearLayout(context);

        float density = ScreenUtils.getScreen(context).density;

        LayoutParams leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(CENTER_VERTICAL);
        leftParams.setMargins((int) (19 * density), 0, 0, 0);
        RelativeLayout.LayoutParams leftImgParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftImgParams.setMargins((int) (19 * density), 0, 0, 0);
        leftImgParams.addRule(CENTER_VERTICAL);
        addView(leftImageButton, leftImgParams);
        leftImageButton.setPadding(5, 5, 5, 5);
        addView(leftTextView, leftParams);

        LayoutParams centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerParams.addRule(CENTER_IN_PARENT);
        addView(centerLayout, centerParams);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerLayout.setGravity(Gravity.CENTER);
        llParams.setMargins(0, 0, (int) (15 * density), 0);
        centerLayout.addView(titleImg, llParams);
        centerLayout.setGravity(Gravity.CENTER_VERTICAL);
        llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParams.setMargins(0, 0, 0, 0);
        centerLayout.addView(title, llParams);

        LayoutParams rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
        rightParams.setMargins(0, 0, (int) (19 * density), 0);
        rightImageButton.setPadding(5, 5, 5, 5);
        addView(rightImageButton, rightParams);
        rightTextView.setGravity(Gravity.CENTER);
        addView(rightTextView, rightParams);


        /*获取属性值*/
        TypedArray types = context.obtainStyledAttributes(attrs, R.styleable.TitleView);

        String leftText = types.getString(R.styleable.TitleView_leftText);
        int leftColor = types.getInt(R.styleable.TitleView_leftTextColor, android.R.color.white);
        float leftSize = types.getDimension(R.styleable.TitleView_leftTextSize, 12);

        String centerText = types.getString(R.styleable.TitleView_centerText);
        int centerColor = types.getInt(R.styleable.TitleView_centerTextColor, android.R.color.white);
        float centerSize = types.getDimension(R.styleable.TitleView_centerTextSize, 12);

        String rightText = types.getString(R.styleable.TitleView_rightText);
        int rightColor = types.getInt(R.styleable.TitleView_rightTextColor, android.R.color.white);
        float rightSize = types.getDimension(R.styleable.TitleView_rightTextSize, 12);


        int centerImg = types.getResourceId(R.styleable.TitleView_centerImgButton, R.drawable.home_title);
        int leftImg = types.getResourceId(R.styleable.TitleView_leftImgButton, R.drawable.home_title);
        int rightImg = types.getResourceId(R.styleable.TitleView_rightImgButton, R.drawable.home_title);

        boolean leftImgVisible = types.getBoolean(R.styleable.TitleView_leftImgVisible, true);
        boolean leftTvVisible = types.getBoolean(R.styleable.TitleView_leftTvVisible, false);

        boolean centerImgVisible = types.getBoolean(R.styleable.TitleView_centerImgVisible, false);
        boolean centerTvVisible = types.getBoolean(R.styleable.TitleView_centerTvVisible, true);

        boolean rightImgVisible = types.getBoolean(R.styleable.TitleView_rightImgVisible, true);
        boolean rightTvVisible = types.getBoolean(R.styleable.TitleView_rightTvVisible, false);

        boolean leftImgIsBack = types.getBoolean(R.styleable.TitleView_leftImgIsBack, false);

        if (leftImgIsBack) {
            leftImageButton.setOnClickListener(backListener);
        }


        /*添加属性*/
        leftTextView.setText(leftText);
        leftTextView.setTextColor(leftColor);
        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftSize);
        if (leftTvVisible) leftTextView.setVisibility(View.VISIBLE);
        else leftTextView.setVisibility(View.GONE);

        /*添加属性*/
        leftImageButton.setImageResource(leftImg);
        leftImageButton.setBackgroundColor(Color.TRANSPARENT);
        if (leftImgVisible) leftImageButton.setVisibility(View.VISIBLE);
        else leftImageButton.setVisibility(View.GONE);

        /*添加属性*/
        title.setText(centerText);
        title.setTextColor(centerColor);
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX, centerSize);
        if (centerTvVisible) title.setVisibility(View.VISIBLE);
        else title.setVisibility(View.GONE);

        /*添加属性*/
        titleImg.setImageResource(centerImg);
        titleImg.setBackgroundColor(Color.TRANSPARENT);
        if (centerImgVisible) titleImg.setVisibility(View.VISIBLE);
        else titleImg.setVisibility(View.GONE);


         /*添加属性*/
        rightTextView.setText(rightText);
        rightTextView.setTextColor(rightColor);
        rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightSize);
        if (rightTvVisible) rightTextView.setVisibility(View.VISIBLE);
        else rightTextView.setVisibility(View.GONE);

        /*添加属性*/
        rightImageButton.setImageResource(rightImg);
        rightImageButton.setBackgroundColor(Color.TRANSPARENT);
        if (rightImgVisible) rightImageButton.setVisibility(View.VISIBLE);
        else {
            rightImageButton.setVisibility(View.GONE);
        }
    }

    /*设置标题*/
    public TitleView setTitle(String str) {
        title.setText(str);
        return this;
    }

    /*设置标题图片*/
    public TitleView setTitleImg(int res) {
        titleImg.setImageResource(res);
        return this;
    }


    public TitleView setTitleImg(ImageView titleImg) {
        this.titleImg = titleImg;
        return this;

    }

    public TitleView setLeftTextView(TextView leftTextView) {
        this.leftTextView = leftTextView;
        return this;

    }

    public TitleView setLeftImageButton(ImageButton leftImageButton) {
        this.leftImageButton = leftImageButton;
        return this;

    }

    public TitleView setRightTextView(TextView rightTextView) {
        this.rightTextView = rightTextView;
        return this;
    }

    public TitleView setRightImageButton(ImageButton rightImageButton) {
        this.rightImageButton = rightImageButton;
        return this;

    }

    public TitleView setTitle(TextView title) {
        this.title = title;
        return this;

    }

    public TextView getTitle() {
        return title;
    }

    public ImageView getTitleImg() {
        return titleImg;
    }

    public TextView getLeftTextView() {
        return leftTextView;
    }

    public ImageButton getRightImageButton() {
        return rightImageButton;
    }

    public LinearLayout getCenterLayout() {
        return centerLayout;
    }

    public ImageButton getLeftImageButton() {
        return leftImageButton;
    }

    public TextView getRightTextView() {
        return rightTextView;
    }

    public OnClickListener backListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            ((Activity) mContext).finish();
        }
    };
}