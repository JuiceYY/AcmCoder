package cn.istary.acmcoder.view.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.base.BaseActivity;
import cn.istary.acmcoder.view.fragment.GameFragment;
import cn.istary.acmcoder.view.fragment.KnowFragment;
import cn.istary.acmcoder.view.fragment.MineFragment;
import cn.istary.acmcoder.widget.HeaderBar;

public class MainActivity extends BaseActivity {

    private long pressTime = 0;

    private HeaderBar mHeaderBar;

    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private final int[] iconSelected = new int[]{R.drawable.tree_y, R.drawable.enter_y, R.drawable.mine_y};
    private final int[] iconUnselected = new int[]{R.drawable.tree_n, R.drawable.enter_n, R.drawable.mine_n};
    private final String[] titles = new String[]{"智慧树", "比赛", "我的"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeaderBar = findViewById(R.id.header);
        mHeaderBar.getTitleTv().setText("智慧树");

/*        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }*/


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //兼容5.0及以上支持全透明
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) ;
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.rgb( 0xff, 0xbe, 0xd3));
        }

        init();
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new KnowFragment());
        mFragments.add(new GameFragment());
        mFragments.add(new MineFragment());

        mTabLayout = findViewById(R.id.bottom_tab_layout);

        mTabLayout.addTab(mTabLayout.newTab()
                .setIcon(getDrawable(R.drawable.tree_y))
                .setText(getString(R.string.tab1)));
        mTabLayout.addTab(mTabLayout.newTab()
                .setIcon(getDrawable(R.drawable.enter_n))
                .setText(getString(R.string.tab2)));
        mTabLayout.addTab(mTabLayout.newTab()
                .setIcon(getDrawable(R.drawable.mine_n))
                .setText(getString(R.string.tab3)));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
                int x = tab.getPosition();
                mHeaderBar.getTitleTv().setText(titles[x]);
                for (int i = 0; i < 3; i++) {
                    if(i == tab.getPosition()){
                        Objects.requireNonNull(mTabLayout.getTabAt(i)).setIcon(iconSelected[i]);
                    }else{
                        Objects.requireNonNull(mTabLayout.getTabAt(i)).setIcon(iconUnselected[i]);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        onTabItemSelected(0);

    }

    private void onTabItemSelected(int position) {
        Fragment fragment = mFragments.get(position);

        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if(time - pressTime > 2000){
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            pressTime = time;
        }else {
            finish();
/*            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            am.killBackgroundProcesses(getPackageName());
            System.exit(0);*/
        }

    }
}
