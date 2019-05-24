package cn.istary.acmcoder.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Toast;

import com.just.agentweb.AgentWeb;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.base.Constant;
import cn.istary.acmcoder.view.activity.WebViewActivity;

/*
 * CREATED BY: Sinry
 * TIME: 2019/4/4 11:42
 * DESCRIPTION:
 */

public class KnowFragment extends Fragment implements View.OnClickListener {

    private View mBtnBasic;
    private View mBtnSearch;
    private View mBtnDynamic;
    private View mBtnString;
    private View mBtnMath;
    private View mBtnDataStructure;
    private View mBtnGraph;
    private View mBtnJSJH;
    private View mBtnOther;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tree, container, false);
        mBtnBasic = view.findViewById(R.id.icon1);
        mBtnSearch = view.findViewById(R.id.icon2);
        mBtnDynamic = view.findViewById(R.id.icon3);
        mBtnString = view.findViewById(R.id.icon4);
        mBtnMath = view.findViewById(R.id.icon5);
        mBtnDataStructure = view.findViewById(R.id.icon6);
        mBtnGraph = view.findViewById(R.id.icon7);
        mBtnJSJH = view.findViewById(R.id.icon8);
        mBtnOther = view.findViewById(R.id.icon9);
        mBtnBasic.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);
        mBtnDynamic.setOnClickListener(this);
        mBtnString.setOnClickListener(this);
        mBtnMath.setOnClickListener(this);
        mBtnDataStructure.setOnClickListener(this);
        mBtnGraph.setOnClickListener(this);
        mBtnJSJH.setOnClickListener(this);
        mBtnOther.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon1:
                openWebView(Constant.URL_BASIC, 0);
                break;
            case R.id.icon2:
                openWebView(Constant.URL_SEARCH, 0);
                break;
            case R.id.icon3:
                openWebView(Constant.URL_DP, 0);
                break;
            case R.id.icon4:
                openWebView(Constant.URL_STRING, 0);
                break;
            case R.id.icon5:
                openWebView(Constant.URL_MATH, 0);
                break;
            case R.id.icon6:
                openWebView(Constant.URL_DS, 0);
                break;
            case R.id.icon7:
                openWebView(Constant.URL_GRAPH, 0);
                break;
            case R.id.icon8:
                openWebView(Constant.URL_GEOMETRY, 0);
                break;
            case R.id.icon9:
                openWebView(Constant.URL_MISC, 0);
                break;
            default:
                break;
        }
    }


    public void openWebView(String url, int arg){
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

}
