package com.lacviet.surenews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lacviet.surenews.Model.NewsModel;
import com.lacviet.surenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeTabRCVAdapterTemp extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<NewsModel> HomeNewsList;
    private Context mContext;
    private HomeTabRCVAdapterTemp.PostItemListener mItemListener;

    public HomeTabRCVAdapterTemp( Context mContext,List<NewsModel> homeNewsList, HomeTabRCVAdapterTemp.PostItemListener itemListener) {
        HomeNewsList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View postView = inflater.inflate(R.layout.item_rcv_tab_home, parent, false);

            HomeTabRCVAdapterTemp.VHItem viewHolder = new HomeTabRCVAdapterTemp.VHItem(postView,this.mItemListener);
            return viewHolder;
        } else if (viewType == TYPE_HEADER) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View postView = inflater.inflate(R.layout.item_header_rcv_tab_home, parent, false);

            HomeTabRCVAdapterTemp.VHHeader viewHolder = new HomeTabRCVAdapterTemp.VHHeader(postView,this.mItemListener);
            return viewHolder;
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HomeTabRCVAdapterTemp.VHItem) {
            NewsModel item = HomeNewsList.get(position);
            ((HomeTabRCVAdapterTemp.VHItem) holder).tvTittle.setText(item.getNewsTittle());
            ((HomeTabRCVAdapterTemp.VHItem) holder).tvTime.setText(item.getNewsTime());

            if (item.getNewsImage() != null) {
                showImage(item.getNewsImage(), (HomeTabRCVAdapterTemp.VHItem) holder);
            } else {
                ((HomeTabRCVAdapterTemp.VHItem) holder).imvAvatar.setImageDrawable(null);

            }
        } else if (holder instanceof HomeTabRCVAdapterTemp.VHHeader) {
            NewsModel item = HomeNewsList.get(position);
            ((HomeTabRCVAdapterTemp.VHHeader) holder).tvTittleHot.setText(item.getNewsTittle());
            ((HomeTabRCVAdapterTemp.VHHeader) holder).tvSubTitleHot.setText(item.getNewsSubTittle());
            ((HomeTabRCVAdapterTemp.VHHeader) holder).tvTimeHot.setText(item.getNewsTime());

            if (item.getNewsImage() != null) {
                showHeaderImage(item.getNewsImage(), (HomeTabRCVAdapterTemp.VHHeader) holder);
            } else {
                ((HomeTabRCVAdapterTemp.VHHeader) holder).imvAvatarHot.setImageDrawable(null);
            }
        }
    }


    @Override
    public int getItemCount() {
        return HomeNewsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
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

    private void showImage(String imageString, HomeTabRCVAdapterTemp.VHItem holder) {
        try {
            /*Bitmap bmp = Util.StringToBitMap(imageString);
            holder.imvAvatar.setImageBitmap(bmp);*/
            Picasso.with(mContext).load(imageString).into(holder.imvAvatar);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    private void showHeaderImage(String imageString, HomeTabRCVAdapterTemp.VHHeader holder) {
        try {
            Picasso.with(mContext).load(imageString).into(holder.imvAvatarHot);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTittle, tvTime;
        public ImageView imvAvatar;
        public RelativeLayout loImage;
        HomeTabRCVAdapterTemp.PostItemListener mItemListener;

        public VHItem(View itemView, HomeTabRCVAdapterTemp.PostItemListener mItemListener) {
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
            this.mItemListener.onPostClick(item.getNewsId(),item.getNewsTittle(),item.getNewsTime(),item.getNewsSubTittle());

        }
    }

    class VHHeader extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTittleHot, tvTimeHot, tvSubTitleHot;
        public ImageView imvAvatarHot;
        HomeTabRCVAdapterTemp.PostItemListener mItemListener;

        public VHHeader(View itemView, HomeTabRCVAdapterTemp.PostItemListener mItemListener) {
            super(itemView);
            tvTittleHot = itemView.findViewById(R.id.tvTitleHot);
            tvSubTitleHot = itemView.findViewById(R.id.tvSubTittleHot);
            tvTimeHot = itemView.findViewById(R.id.tvTimeHot);
            imvAvatarHot = itemView.findViewById(R.id.imgHotNews);
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NewsModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getNewsId(),item.getNewsTittle(),item.getNewsTime(),item.getNewsSubTittle());
        }
    }

    public interface PostItemListener {
        void onPostClick(int id, String title, String time, String subTitle);
    }
}