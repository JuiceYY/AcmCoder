package cn.istary.acmcoder.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.istary.acmcoder.R;

/**
 * @author Sinry
 * @version 2019/5/24 14:10
 * @describe $desc$
 */

public class HeaderBar extends FrameLayout {

    TextView mTitleTv;
    ImageView mLeftIv;
    TextView mRightTv;
    View mView;

    public HeaderBar( Context context) {
        super(context);
    }

    public HeaderBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true);
        mTitle = typedArray.getString(R.styleable.HeaderBar_titleText);
        mRightText = typedArray.getString(R.styleable.HeaderBar_rightText);
        typedArray.recycle();
        initview(context);

    }

    private void initview(final Context context) {
        mView = View.inflate(context, R.layout.layout_header_bar, this);
        mLeftIv = mView.findViewById(R.id.mLeftIv);
        mTitleTv = mView.findViewById(R.id.mTitleTv);
        mRightTv = mView.findViewById(R.id.mRightTv);

        if(mTitle != null){
            mTitleTv.setText(mTitle);
        }
        if (mRightText != null){
            mRightTv.setText(mRightText);
            mRightTv.setVisibility(View.VISIBLE);
        }

        mLeftIv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof Activity){
                    ((Activity) context).finish();
                }
            }
        });

        mLeftIv.setVisibility(View.GONE);


    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private boolean isShowBack = true; //是否显示返回按钮

    private String mTitle;

    private String mRightText;


    public void setTitle(String title){
        this.mTitle = title;
        invalidate();
    }

    public ImageView getLeftIv(){
        return mLeftIv;
    }

    public TextView getTitleTv() {
        return mTitleTv;
    }

    public TextView getRightTv() {
        return mRightTv;
    }
}
