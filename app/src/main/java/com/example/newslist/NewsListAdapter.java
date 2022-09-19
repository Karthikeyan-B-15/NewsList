package com.example.newslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter {
    private List<NewsListModel> list;

    public NewsListAdapter(List<NewsListModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case NewsListModel.HEADLINE_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headline_centric, parent, false);
                return new HeadLineViewHolder(view);
            case NewsListModel.PHOTO_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_centric, parent, false);
                return new PhotoViewHolder(view);
            case NewsListModel.LIST_CENTRIC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_centric, parent, false);
                return new ListViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsListModel model = list.get(position);
        if (model != null) {
            switch (model.type) {
                case NewsListModel.HEADLINE_CENTRIC:

                        ((HeadLineViewHolder) holder).textView.setText(model.text);
                        ((HeadLineViewHolder) holder).imageView.setImageResource(model.data);
                        break;


                case NewsListModel.PHOTO_CENTRIC:
                    if(model.dtype=="video") {
                        ((PhotoViewHolder) holder).textView.setText(model.text);
                        ((PhotoViewHolder) holder).imageView.setImageResource(model.data);
                        break;
                    }else{
                        ((PhotoViewHolder) holder).textView.setText(model.text);
                        ((PhotoViewHolder) holder).imageView.setImageResource(model.data);
                        ((PhotoViewHolder) holder).play.setVisibility(View.GONE);
                        break;
                    }
                case NewsListModel.LIST_CENTRIC:
                    ((ListViewHolder) holder).textView.setText(model.text);
                    ((ListViewHolder) holder).imageView.setImageResource(model.data);

                    break;
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).type) {
            case 0:
                return NewsListModel.HEADLINE_CENTRIC;
            case 1:
                return NewsListModel.PHOTO_CENTRIC;
            case 2:
                return NewsListModel.LIST_CENTRIC;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeadLineViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,play;
        private TextView textView;

        public HeadLineViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.headimg);
            textView = (TextView) itemView.findViewById(R.id.headtext1);

        }
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,play;
        private TextView textView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.photoimg);
            textView = (TextView) itemView.findViewById(R.id.phototext);
            play=(ImageView) itemView.findViewById(R.id.play);
        }
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.listimg);
            textView = (TextView) itemView.findViewById(R.id.listtext);
        }
    }
}
