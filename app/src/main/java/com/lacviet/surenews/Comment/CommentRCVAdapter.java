package com.lacviet.surenews.Comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lacviet.surenews.Model.CommentModel;
import com.lacviet.surenews.R;
import com.lacviet.surenews.WebAPI.ModelAPI.NewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommentRCVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CommentModel> cmtList;
    private Context mContext;
    private CommentRCVAdapter.PostItemListener mItemListener;

    public CommentRCVAdapter( Context mContext,List<CommentModel> homeNewsList, CommentRCVAdapter.PostItemListener itemListener) {
        cmtList = homeNewsList;
        this.mContext = mContext;
        mItemListener = itemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_rcv_comment, parent, false);

        CommentRCVAdapter.VHItem viewHolder = new CommentRCVAdapter.VHItem(postView,this.mItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CommentModel item = cmtList.get(position);
        ((VHItem) holder).tvName.setText(item.getName());
        ((VHItem) holder).tvTime.setText(item.getTime());
        ((VHItem) holder).tvContent.setText(item.getContent());

    }


    @Override
    public int getItemCount() {
        return cmtList.size();
    }



    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void updateAnswers(List<CommentModel> items) {
        cmtList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<CommentModel> items) {
        cmtList.addAll(items);
        notifyDataSetChanged();
    }

    private CommentModel getItem(int adapterPosition) {
        return cmtList.get(adapterPosition);
    }


    public List<CommentModel> getList() {
        return cmtList;
    }




    class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvContent, tvTime, tvName;
        CommentRCVAdapter.PostItemListener mItemListener;

        public VHItem(View itemView, CommentRCVAdapter.PostItemListener mItemListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameCmt);
            tvTime = itemView.findViewById(R.id.tvTimeCmt);
            tvContent = itemView.findViewById(R.id.tvContentCmt);
            this.mItemListener = mItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }



    public interface PostItemListener {
        void onPostClick();
    }
}