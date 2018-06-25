package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.lacviet.surenews.Model.VideoModel;
import com.lacviet.surenews.R;

import java.util.List;

public class VideoTabRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VideoModel> VideoList;
    private Context mContext;
    private PostItemListener mItemListener;


    public VideoTabRCVAdapter(Context mContext, List<VideoModel> homeNewsList, PostItemListener itemListener) {
        VideoList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_tab_video, parent, false);

        VHItem viewHolder = new VHItem(postView, this.mItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        VideoModel item = VideoList.get(position);
        ((VHItem) holder).tvTittle.setText(item.getVideoTittle());
        ((VHItem) holder).tvTime.setText(item.getVideoTime());
        /***get clicked view and play video url at this position**/
        try {
            //play video using android api, when video view is clicked.
            String url = item.getVideoUrl(); // your URL here
            Uri videoUri = Uri.parse(url);
            ((VHItem) holder).videoView.setVideoURI(videoUri);
            ((VHItem) holder).videoView.seekTo(10);
            ((VHItem) holder).videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    ((VHItem) holder).videoView.setZOrderOnTop(true);
                    mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                        @Override
                        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                            /*
                             * add media controller
                             */
                            MediaController mc = new MediaController(mContext);
                            ((VHItem) holder).videoView.setMediaController(mc);
                            /*
                             * and set its position on screen
                             */
                            mc.setAnchorView(((VHItem) holder).videoView);
                        }
                    });
                }
            });


        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

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

    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTittle, tvTime;
        public VideoView videoView;
        PostItemListener mItemListener;

        public VHItem(View itemView, PostItemListener mItemListener) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tvTitleVideo);
            tvTime = itemView.findViewById(R.id.tvTimeVideo);
            videoView = itemView.findViewById(R.id.videoView);
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