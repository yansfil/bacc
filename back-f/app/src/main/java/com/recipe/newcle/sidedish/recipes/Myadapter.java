package com.recipe.newcle.sidedish.recipes;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recipe.newcle.sidedish.R;
import com.recipe.newcle.sidedish.datas.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016. 7. 6..
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    public interface onItemClickListener{
        public <T> void onItemClick(View view, T result);
    }
    public interface onItemLongClickListener{
        public void onItemClick(View view, int position);
    }
    onItemClickListener mlistener;
    onItemLongClickListener mLongListener;
    public void setOnItemClickListener(onItemClickListener listener){
        mlistener =  listener;
    }
    public void setOnItemLongClickLitsener(onItemLongClickListener listener){
        mLongListener = listener;
    }

    List<ListItem> items = new ArrayList<ListItem>();
    int type;
    public void add(ArrayList<ListItem> data) {
        items.addAll(data);
        Log.e("MYADATER ADD", "OK");
        notifyDataSetChanged();
    }
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
    public void setType(int type){
        this.type = type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        ImageView imageView;
        View view;
        ListItem mData;

        public ViewHolder(View view){
            super(view);
            this.view = view;
            titleView = (TextView) view.findViewById(R.id.name);
            imageView = (ImageView) view.findViewById(R.id.picture);
        }

        public void setItem(ListItem data) {
            titleView.setText(data.getTitle());
            data.setType(type);
            Log.e("MYADATER SETITEM ", data.getImage());
            Glide.with(imageView.getContext()).load(data.getImage()).into(imageView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_griditem, parent, false);
        Log.e("ADAPTER:", "checked");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.setItem(items.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlistener != null){
                    mlistener.onItemClick(v,items.get(position));
                }
            }
        });
        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mLongListener != null){
                    mLongListener.onItemClick(v,Integer.decode(items.get(position).getId()));
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
