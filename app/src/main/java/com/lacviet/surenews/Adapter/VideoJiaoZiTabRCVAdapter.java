package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import tcking.github.com.giraffeplayer2.DefaultPlayerListener;
import tcking.github.com.giraffeplayer2.GiraffePlayer;
import tcking.github.com.giraffeplayer2.PlayerListener;
import tcking.github.com.giraffeplayer2.VideoInfo;

public class VideoJiaoZiTabRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VideoModel> VideoList;
    private Context mContext;
    private VideoJiaoZiTabRCVAdapter.PostItemListener mItemListener;



    public VideoJiaoZiTabRCVAdapter(Context mContext, List<VideoModel> homeNewsList, VideoJiaoZiTabRCVAdapter.PostItemListener itemListener) {
        VideoList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_tab_video_jiaozi, parent, false);

        VideoJiaoZiTabRCVAdapter.VHItem viewHolder = new VideoJiaoZiTabRCVAdapter.VHItem(postView, this.mItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        VideoModel item = VideoList.get(position);
        ((VideoJiaoZiTabRCVAdapter.VHItem) holder).tvTittle.setText(item.getVideoTittle());
        ((VideoJiaoZiTabRCVAdapter.VHItem) holder).tvTime.setText(item.getVideoTime());
        //
        String url = item.getVideoUrl(); // your URL here
        ((VHItem) holder).videoView.setUp(url, JZVideoPlayer.SCREEN_WINDOW_NORMAL,item.getVideoTittle());
        Picasso.with(mContext).load(item.getVideoCoverView()).into(((VHItem) holder).videoView.thumbImageView);


    }


    @Override
    public int getItemCount() {
        return VideoList.size();
    }

    public void updateAnswers(List<VideoModel> items) {
        VideoList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<VideoModel> items) {
        VideoList.addAll(items);
        notifyDataSetChanged();
    }

    private VideoModel getItem(int adapterPosition) {
        return VideoList.get(adapterPosition);
    }


    public List<VideoModel> getList() {
        return VideoList;
    }

    public class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTittle, tvTime;
        public JZVideoPlayerStandard videoView ;
        VideoJiaoZiTabRCVAdapter.PostItemListener mItemListener;

        public VHItem(View itemView, VideoJiaoZiTabRCVAdapter.PostItemListener mItemListener) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tvTitleVideo);
            tvTime = itemView.findViewById(R.id.tvTimeVideo);
            videoView = itemView.findViewById(R.id.videoplayer);
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }

    public interface PostItemListener {
        void onPostClick(long id);

    }

}