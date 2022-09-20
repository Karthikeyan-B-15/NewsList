package com.example.newslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListModel> list;
    public ListAdapter(List<ListModel> list){
        this.list=list;
    }
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListModel model=list.get(position);
        holder.textView.setText(model.getLtext());
        holder.imageView.setImageResource(model.getLimg());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.listtext);
            imageView=(ImageView) itemView.findViewById(R.id.listimg);
        }
    }
}
