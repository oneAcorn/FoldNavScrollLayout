package com.acorn.foldnavscrolllayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private String[] imageUrls;

    public TestAdapter(Context context, String[] imageUrls) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.imageUrls = imageUrls;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup group, int i) {
        return new TestViewHolder(mInflater.inflate(R.layout.item_test, group, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        Glide.with(mContext).load(imageUrls[position]).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return imageUrls == null ? 0 : imageUrls.length;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = (ImageView) itemView;
        }
    }
}
