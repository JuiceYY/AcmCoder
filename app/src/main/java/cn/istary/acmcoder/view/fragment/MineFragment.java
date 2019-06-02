package cn.istary.acmcoder.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.view.activity.HelpActivity;

/*
 * CREATED BY: Sinry
 * TIME: 2019/4/4 11:39
 * DESCRIPTION:
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private int pressCount = 0;
    private long pressTime = 0;

    private View favIcon;
    private View followIcon;
    private View callIcon;

    private final static int[] toastColors = new int[]{Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        favIcon = view.findViewById(R.id.item_mine_favourite);
        followIcon = view.findViewById(R.id.item_mine_follow);
        callIcon = view.findViewById(R.id.item_mine_contract);
        favIcon.setOnClickListener(this);
        followIcon.setOnClickListener(this);
        callIcon.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_mine_favourite:
            case R.id.item_mine_follow:
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_mine_contract:
                startEggs();
                break;

            default:
                break;
        }

    }

    private void startEggs() {
        long time = System.currentTimeMillis();
        if (time - pressTime > 1000) {
            pressCount = 1;
            pressTime = time;
            Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
        } else {
            pressCount++;
            pressTime = time;
            if (pressCount < 3) {
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
            }else if(pressCount < 8){
                Toast toast = Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT);
                LinearLayout layout = (LinearLayout) toast.getView();
                TextView v = toast.getView().findViewById(android.R.id.message);
                v.setTextColor(toastColors[pressCount-3]);
            }else{
                Toast.makeText(getActivity(), "恭喜你发现了隐藏页面", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HelpActivity.class);
                startActivity(intent);
            }

        }


    }
}
