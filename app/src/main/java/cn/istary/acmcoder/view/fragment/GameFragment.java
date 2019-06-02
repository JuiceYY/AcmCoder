package cn.istary.acmcoder.view.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.adapter.GameAdapter;
import cn.istary.acmcoder.base.MessCode;
import cn.istary.acmcoder.contract.IGameContract;
import cn.istary.acmcoder.data.response.Game;
import cn.istary.acmcoder.presenter.GamePresenter;

/*
 * CREATED BY: Sinry
 * TIME: 2019/4/4 11:43
 * DESCRIPTION:
 */

public class GameFragment extends Fragment implements IGameContract.IView {

    private static final String TAG = "GameFragment";

    private boolean isVisble;
    private boolean isPrepared = false;

    private IGameContract.IPresenter mPresenter;

    private ListView mListView;

    private ProgressDialog mDialog;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private TextView mTvEmpty;

    private TextView mTvServerError;

    private final static int MSG_DISMISS_DIALOG = 1000;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_DISMISS_DIALOG:
                    if (null != mDialog) {
                        if (mDialog.isShowing()) {
                            Log.d(TAG, "handler get mess");
                            mDialog.dismiss();
                            Toast.makeText(getActivity(), "服务器无响应", Toast.LENGTH_SHORT).show();
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GamePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        mListView = view.findViewById(R.id.lv_game);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mTvEmpty = view.findViewById(R.id.tv_no_game);
        mTvServerError = view.findViewById(R.id.tv_server_error);

        //设置刷新
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.queryGame();
            }
        });


        mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage("正在加载");
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);

        isPrepared = true;
        mPresenter.queryGame();
        return view;
    }

    @Override
    public void showProcessDialog() {
        mHandler.sendEmptyMessageDelayed(MSG_DISMISS_DIALOG, 5000);
        mDialog.show();
    }

    @Override
    public void closeProcessDialog() {
        mDialog.dismiss();
    }

    /**
     * 没用
     *
     * @param presenter
     */
    @Override
    public void setPresenter(IGameContract.IPresenter presenter) {
        if (null != presenter) {
            this.mPresenter = presenter;
        }
    }

    @Override
    public void showGame(List<Game> gameList) {
        mSwipeRefreshLayout.setRefreshing(false);
        GameAdapter adapter = new GameAdapter(getActivity(), gameList);
        mListView.setAdapter(adapter);

    }

    @Override
    public void showError(String errorMsg) {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), "error: " + errorMsg, Toast.LENGTH_SHORT).show();
        mTvServerError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmpty(int reason) {
        switch (reason) {
            case MessCode.EMPTY_RESPONSE:
                mTvEmpty.setVisibility(View.VISIBLE);
                break;
            case MessCode.SERVER_ERROR:
                mTvServerError.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

    }
}
