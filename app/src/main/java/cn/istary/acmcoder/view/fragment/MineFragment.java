package cn.istary.acmcoder.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.istary.acmcoder.R;

/*
 * CREATED BY: Sinry
 * TIME: 2019/4/4 11:39
 * DESCRIPTION:
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private View favIcon;
    private View followIcon;
    private View callIcon;

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
        Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
    }
}
