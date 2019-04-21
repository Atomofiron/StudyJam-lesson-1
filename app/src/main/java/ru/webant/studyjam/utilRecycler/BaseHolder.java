package ru.webant.studyjam.utilRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.webant.studyjam.models.Article;

public abstract class BaseHolder extends RecyclerView.ViewHolder {
    public BaseHolder(@NonNull View itemView) {
        super(itemView);
    }

    abstract void bind(Article article, ArticleClickListener listener);
}
