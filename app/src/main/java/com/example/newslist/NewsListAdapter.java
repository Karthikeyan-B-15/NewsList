package com.example.newslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter {
    private List<NewsListModel> list;
    private Context context;
    private HeadListAdapter adapter;
    private PhotoListAdapter photoListAdapter;
    private ListAdapter listAdapter;
    public NewsListAdapter(List<NewsListModel> list,Context context) {
        this.list = list;
        this.context=context;
        notifyDataSetChanged();
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
                        if(model.dtype=="video") {
                            ((HeadLineViewHolder) holder).textView.setText(model.text);
                            ((HeadLineViewHolder) holder).imageView.setImageResource(model.data);
                            ((HeadLineViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                            adapter = new HeadListAdapter(list.get(position).headLineModels);
                            ((HeadLineViewHolder) holder).recyclerView.setAdapter(adapter);
                            ((HeadLineViewHolder) holder).recyclerView.setHasFixedSize(true);
                            adapter.notifyDataSetChanged();
                            break;
                        }else {
                            ((HeadLineViewHolder) holder).textView.setText(model.text);
                            ((HeadLineViewHolder) holder).imageView.setImageResource(model.data);
                            ((HeadLineViewHolder) holder).hplay.setVisibility(View.GONE);
                            ((HeadLineViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                            adapter = new HeadListAdapter(list.get(position).headLineModels);
                            ((HeadLineViewHolder) holder).recyclerView.setAdapter(adapter);
                            ((HeadLineViewHolder) holder).recyclerView.setHasFixedSize(true);
                            adapter.notifyDataSetChanged();
                            break;
                        }


                case NewsListModel.PHOTO_CENTRIC:
                    if(model.dtype=="video") {
                        ((PhotoViewHolder) holder).textView.setText(model.text);
                        ((PhotoViewHolder) holder).imageView.setImageResource(model.data);
                        ((PhotoViewHolder) holder).recyclerView.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false));

                        photoListAdapter=new PhotoListAdapter(list.get(position).photoModels);
                        ((PhotoViewHolder)holder).recyclerView.setAdapter(photoListAdapter);
                        adapter.notifyDataSetChanged();
                        break;
                    }else{
                        ((PhotoViewHolder) holder).textView.setText(model.text);
                        ((PhotoViewHolder) holder).imageView.setImageResource(model.data);
                        ((PhotoViewHolder) holder).play.setVisibility(View.GONE);
                        ((PhotoViewHolder) holder).recyclerView.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false));
                        photoListAdapter=new PhotoListAdapter(list.get(position).photoModels);
                        ((PhotoViewHolder)holder).recyclerView.setAdapter(photoListAdapter);
                        adapter.notifyDataSetChanged();
                        break;
                    }
                case NewsListModel.LIST_CENTRIC:
                    if(model.dtype=="video") {
                        ((ListViewHolder) holder).textView.setText(model.text);
                        ((ListViewHolder) holder).imageView.setImageResource(model.data);
                        ((ListViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        listAdapter = new ListAdapter(list.get(position).listmodels);
                        SpaceDecorator decorator = new SpaceDecorator(5);
                        ((ListViewHolder) holder).recyclerView.addItemDecoration(decorator);
                        ((ListViewHolder) holder).recyclerView.setAdapter(listAdapter);
                        adapter.notifyDataSetChanged();

                        break;
                    }else {
                        ((ListViewHolder) holder).textView.setText(model.text);
                        ((ListViewHolder) holder).imageView.setImageResource(model.data);
                        ((ListViewHolder) holder).lplay.setVisibility(View.GONE);
                        ((ListViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context));

                        listAdapter = new ListAdapter(list.get(position).listmodels);
                        SpaceDecorator decorator = new SpaceDecorator(5);
                        ((ListViewHolder) holder).recyclerView.addItemDecoration(decorator);
                        ((ListViewHolder) holder).recyclerView.setAdapter(listAdapter);
                        adapter.notifyDataSetChanged();

                        break;
                    }
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
        private ImageView imageView,hplay;
        private TextView textView;
        private RecyclerView recyclerView;


        public HeadLineViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.headimg);
            textView = (TextView) itemView.findViewById(R.id.headtext1);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.headrecycle);
            hplay=(ImageView) itemView.findViewById(R.id.hplay);

        }
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,play;
        private TextView textView;
        private RecyclerView recyclerView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.photoimg);
            textView = (TextView) itemView.findViewById(R.id.phototext);
            play=(ImageView) itemView.findViewById(R.id.play);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.photorecycle);
        }
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,lplay;
        private TextView textView;
        private RecyclerView recyclerView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.listimg);
            textView = (TextView) itemView.findViewById(R.id.listtext);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.listrecycle);
            lplay=(ImageView) itemView.findViewById(R.id.lplay);
        }
    }
}
