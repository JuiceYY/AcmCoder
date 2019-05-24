package cn.istary.acmcoder.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.util.StyleUtil;

public class SplashActivity extends AppCompatActivity {

    private final static int LAUNCH_MESS = 10;

    private TextView mTextView;

    //这么做会内存泄漏, 不推荐
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LAUNCH_MESS:
                    //闪屏两秒后台逻辑
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isTaskRoot()) {
            Intent i = getIntent();
            String action = i.getAction();
            if (i.hasCategory(Intent.CATEGORY_APP_CALENDAR)
                    && !TextUtils.isEmpty(action)
                    && Objects.equals(action, Intent.ACTION_MAIN)) {

                finish();
                return;
            }
        }

        setContentView(R.layout.activity_splash);
        mTextView = findViewById(R.id.splash_textview);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //兼容5.0及以上支持全透明
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.WHITE);
        }

        handler.sendEmptyMessageDelayed(LAUNCH_MESS, 2000);

        StyleUtil.setFont(this, mTextView);
    }

    @Override
    public void onBackPressed() {
    }
}
