package com.lacviet.surenews.Tags;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lacviet.surenews.Tags.TagsRCVAdapter;
import com.lacviet.surenews.Model.CommentModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;

import java.util.List;

public class TagsRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> tagList;
    private Context mContext;
    private TagsRCVAdapter.PostItemListener mItemListener;

    public TagsRCVAdapter(Context mContext, List<String> homeNewsList, TagsRCVAdapter.PostItemListener itemListener) {
        tagList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_tags, parent, false);

        TagsRCVAdapter.VHItem viewHolder = new TagsRCVAdapter.VHItem(postView, this.mItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String item = tagList.get(position);
        ((VHItem) holder).tvTag.setText(item);
    }


    @Override
    public int getItemCount() {
        return tagList.size();
    }


    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void updateAnswers(List<String> items) {
        tagList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<String> items) {
        tagList.addAll(items);
        notifyDataSetChanged();
    }

    private String getItem(int adapterPosition) {
        return tagList.get(adapterPosition);
    }


    public List<String> getList() {
        return tagList;
    }


    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvTag;
        TagsRCVAdapter.PostItemListener mItemListener;
        public VHItem(View itemView, TagsRCVAdapter.PostItemListener mItemListener) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tvTag);
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item);
        }
    }


    public interface PostItemListener {
        void onPostClick(String tag);
    }
}