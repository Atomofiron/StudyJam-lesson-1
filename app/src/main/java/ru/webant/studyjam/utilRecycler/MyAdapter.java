package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.webant.studyjam.models.Article;

public class MyAdapter extends RecyclerView.Adapter<BaseHolder> {

    private ArrayList<Article> listNews;
    private List<Item> items = new ArrayList<>();
    private ArticleClickListener listener;

    public MyAdapter(ArrayList<Article> listNews, ArticleClickListener listener) {
        this.listNews = listNews;
        this.listener = listener;
        buildAdapter();
    }

    private void buildAdapter() {
        items.clear();
        Collections.sort(listNews, new Comparator<Article>() {
            @Override
            public int compare(Article article1, Article article2) {
                return article1.getSection().equalsIgnoreCase(article2.getSection()) ? 1 : -1;
            }
        });
        for (int i = 0; i < listNews.size(); i++) {
            Article article = listNews.get(i);
            boolean isFirstInSection = isFirstInSection(listNews, article);
            if (isFirstInSection) {
                items.add(new Item(ViewType.EMPTY));
                items.add(new Item(ViewType.FULL_NEWS, article));
            } else {
                items.add(new Item(ViewType.DIVIDER));
                items.add(new Item(ViewType.NEWS, article));
            }
        }
        notifyDataSetChanged();
    }


    private boolean isFirstInSection(List<Article> list, Article article) {
        try {
            Article lastArticle = list.get(list.indexOf(article) - 1);
            return !lastArticle.getSection().equalsIgnoreCase(article.getSection());
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewType.values()[viewType].getViewHolder(parent);
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).viewType.ordinal();
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        Item item = items.get(position);
        holder.bind((Article) item.object, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class Item {
        private ViewType viewType;
        private Object object;

        public Item(ViewType vt, Object o) {
            this.viewType = vt;
            this.object = o;
        }

        public Item(ViewType vt) {
            this.viewType = vt;
        }
    }
}
