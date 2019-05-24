package cn.istary.acmcoder.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.istary.acmcoder.R;
import cn.istary.acmcoder.data.response.Game;
import cn.istary.acmcoder.util.MyTextUtils;
import cn.istary.acmcoder.util.TimeUtil;
import cn.istary.acmcoder.view.activity.WebViewActivity;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:07
 */

public class GameAdapter extends BaseAdapter {

    private static final String TAG = "GameAdapter";

    private Context mContext;
    private List<Game> mData;

    public GameAdapter(Context context, List<Game> data){
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        final Game game = (Game) getItem(position);

        if(null == convertView){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_game, parent, false);
            viewHolder.view = convertView;
            viewHolder.bg = convertView.findViewById(R.id.bg);
            viewHolder.title = convertView.findViewById(R.id.tv_game);
            viewHolder.platform = convertView.findViewById(R.id.tv_platform);
            viewHolder.pfCont = convertView.findViewById(R.id.platform);
            viewHolder.startTime = convertView.findViewById(R.id.tv_time);
            viewHolder.stCont = convertView.findViewById(R.id.time);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Log.d(TAG, "getView: viewholder = " + viewHolder);
        //这里viewholder滑动时报空, 强行解决一下
        //===========WRONG CODE=============
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_game, parent, false);
            viewHolder.view = convertView;
            viewHolder.bg = convertView.findViewById(R.id.bg);
            viewHolder.title = convertView.findViewById(R.id.tv_game);
            viewHolder.platform = convertView.findViewById(R.id.tv_platform);
            viewHolder.pfCont = convertView.findViewById(R.id.platform);
            viewHolder.startTime = convertView.findViewById(R.id.tv_time);
            viewHolder.stCont = convertView.findViewById(R.id.time);
        }
        //===========WRONG CODE ===========

        viewHolder.title.setText(game.getTitle());
        viewHolder.pfCont.setText(game.getPlatformName());
        viewHolder.stCont.setText(TimeUtil.stampToDate(game.getStartTime()*1000, "yyyy-MM-dd HH:mm"));

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "url = " + game.getUrl(), Toast.LENGTH_SHORT).show();
                if(mContext instanceof Activity){
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("url", game.getUrl());
                    mContext.startActivity(intent);
                }

            }
        });

        return convertView;
    }

    public class ViewHolder{
        View view;
        ImageView bg;
        TextView title;
        TextView platform;
        TextView pfCont;
        TextView startTime;
        TextView stCont;

    }
}
