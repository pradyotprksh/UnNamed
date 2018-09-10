package com.project.pradyotprakash.unnamed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.lzyzsd.randomcolor.RandomColor;

import java.util.List;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {

    public List<BlogPost> blog_list;

    public BlogRecyclerAdapter(List<BlogPost> blog_list) {
        this.blog_list = blog_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blog_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String userName = blog_list.get(position).getUserName();
        String blogPost = blog_list.get(position).getBlogPost();
        viewHolder.userName.setText(userName);
        viewHolder.blogPost.setText(blogPost);
        RandomColor viewRandomColor = new RandomColor();
        int viewColor = viewRandomColor.randomColor();
        viewHolder.mView.setBackgroundColor(viewColor);
    }

    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView userName, blogPost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            userName = mView.findViewById(R.id.blogProfileUsername);
            blogPost = mView.findViewById(R.id.blogProfileText);
        }
    }

}
