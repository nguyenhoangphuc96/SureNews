package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import tcking.github.com.giraffeplayer2.DefaultPlayerListener;
import tcking.github.com.giraffeplayer2.GiraffePlayer;
import tcking.github.com.giraffeplayer2.PlayerListener;
import tcking.github.com.giraffeplayer2.VideoInfo;

public class VideoPlayerTabRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VideoModel> VideoList;
    private Context mContext;
    private PostItemListener mItemListener;
    private PlayerListener playerListener = new DefaultPlayerListener() {//example of using playerListener
        @Override
        public void onPreparing(GiraffePlayer giraffePlayer) {
        }

        @Override
        public void onCompletion(GiraffePlayer giraffePlayer) {
        }
    };


    public VideoPlayerTabRCVAdapter(Context mContext, List<VideoModel> homeNewsList, PostItemListener itemListener) {
        VideoList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_tab_video_player, parent, false);

        VHItem viewHolder = new VHItem(postView, this.mItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        VideoModel item = VideoList.get(position);
        ((VHItem) holder).tvTittle.setText(item.getVideoTittle());
        ((VHItem) holder).tvTime.setText(item.getVideoTime());
        //
        String url = item.getVideoUrl(); // your URL here
        if (((VHItem) holder).videoView.getCoverView() != null) {
            Picasso.with(mContext).load(item.getVideoCoverView()).into(((VHItem) holder).videoView.getCoverView());
        }

        ((VHItem) holder).videoView.getVideoInfo().setBgColor(Color.BLACK).setAspectRatio(VideoInfo.AR_ASPECT_FIT_PARENT);
        ((VHItem) holder).videoView.setVideoPath(url).setFingerprint(item.hashCode());
        ((VHItem) holder).videoView.getVideoInfo().setFullScreenAnimation(true);
        ((VHItem) holder).videoView.getVideoInfo().setPortraitWhenFullScreen(false);


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
        public tcking.github.com.giraffeplayer2.VideoView videoView;
        PostItemListener mItemListener;

        public VHItem(View itemView, PostItemListener mItemListener) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tvTitleVideo);
            tvTime = itemView.findViewById(R.id.tvTimeVideo);
            videoView = itemView.findViewById(R.id.video_view);
            if (videoView != null) {
                videoView.setPlayerListener(playerListener);

            }
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
        public void pauseVideo(){
        videoView.getPlayer().pause();
        }
    }

    public interface PostItemListener {
        void onPostClick(long id);

    }

}