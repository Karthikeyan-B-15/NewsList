package com.example.newslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class HeadListAdapter extends RecyclerView.Adapter<HeadListAdapter.ViewHolder> {
    private List<HeadLineModel> list;
    public HeadListAdapter(List<HeadLineModel> list){
        this.list=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.headitem,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HeadLineModel model = list.get(position);
        if(model.getHeadtype()=="video") {
            holder.textView.setText(model.getHeadlinetext());
        }else{
            holder.textView.setText(model.getHeadlinetext());
            holder.layout.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.headlisttext);
            layout=(RelativeLayout) itemView.findViewById(R.id.videorelate);
        }
    }
}
