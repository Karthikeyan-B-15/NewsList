package com.example.newslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {
    private List<PhotoModel> list;
    public PhotoListAdapter(List<PhotoModel> list){
        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photoitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoModel model= list.get(position);
        if(model.getType()=="video"){
            holder.textView.setText(model.getText());
            holder.imageView.setImageResource(model.getImg());
        }else{
            holder.textView.setText(model.getText());
            holder.imageView.setImageResource(model.getImg());
            holder.layout.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.photoimg);
            textView=(TextView)itemView.findViewById(R.id.phototext);
            layout=(RelativeLayout) itemView.findViewById(R.id.relativephoto);
        }
    }
}
