package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SamenewsRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsModel> HomeNewsList;
    private Context mContext;
    private SamenewsRCVAdapter.PostItemListener mItemListener;

    public SamenewsRCVAdapter( Context mContext,List<NewsModel> homeNewsList, SamenewsRCVAdapter.PostItemListener itemListener) {
        HomeNewsList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View postView = inflater.inflate(R.layout.item_rcv_tab_home, parent, false);

            SamenewsRCVAdapter.VHItem viewHolder = new SamenewsRCVAdapter.VHItem(postView,this.mItemListener);
            return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        NewsModel item = HomeNewsList.get(position);
        ((SamenewsRCVAdapter.VHItem) holder).tvTittle.setText(item.getTitle());
        ((SamenewsRCVAdapter.VHItem) holder).tvTime.setText(item.getPublishedDate());

        if (item.getItemImg() != null) {
            showImage(item.getItemImg(), (SamenewsRCVAdapter.VHItem) holder);
        } else {
            ((SamenewsRCVAdapter.VHItem) holder).imvAvatar.setImageDrawable(null);

        }

    }


    @Override
    public int getItemCount() {
        return HomeNewsList.size();
    }



    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void updateAnswers(List<NewsModel> items) {
        HomeNewsList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<NewsModel> items) {
        HomeNewsList.addAll(items);
        notifyDataSetChanged();
    }

    private NewsModel getItem(int adapterPosition) {
        return HomeNewsList.get(adapterPosition);
    }


    public List<NewsModel> getList() {
        return HomeNewsList;
    }

    private void showImage(String imageString, SamenewsRCVAdapter.VHItem holder) {
        try {

            Picasso.with(mContext).load(imageString).into(holder.imvAvatar);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }



    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTittle, tvTime;
        public ImageView imvAvatar;
        public RelativeLayout loImage;
        SamenewsRCVAdapter.PostItemListener mItemListener;

        public VHItem(View itemView, SamenewsRCVAdapter.PostItemListener mItemListener) {
            super(itemView);
            tvTittle = itemView.findViewById(R.id.tvTitleNews);
            tvTime = itemView.findViewById(R.id.tvTime);
            imvAvatar = itemView.findViewById(R.id.imgNews);
            loImage = itemView.findViewById(R.id.rlImage);
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NewsModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getId(),item.getTitle(),item.getPublishedDate(),item.getDescription(),item.getCategoryId());

        }
    }



    public interface PostItemListener {
        void onPostClick(String id, String title, String time, String subTitle, String categoryId);
    }
}
