package ru.webant.studyjam.utilRecycler;

import android.view.View;

import ru.webant.studyjam.models.Article;

/**
 * Created by vdaron on 19.08.17.
 */

public class EmptyViewHolder extends BaseHolder {
    public EmptyViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    void bind(Article article, ArticleClickListener listener) {
    }
}
