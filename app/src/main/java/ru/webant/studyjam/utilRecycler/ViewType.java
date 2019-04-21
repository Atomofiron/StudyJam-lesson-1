package ru.webant.studyjam.utilRecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import ru.webant.studyjam.R;

/**
 * Created by vdaron on 19.08.17.
 */

enum ViewType {
    FULL_NEWS {
        @Override
        public BaseHolder getViewHolder(ViewGroup parent) {
            return new ItemNewsFullViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_full, parent, false));
        }
    },
    NEWS {
        @Override
        public BaseHolder getViewHolder(ViewGroup parent) {
            return new ItemNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
        }
    },
    DIVIDER {
        @Override
        public BaseHolder getViewHolder(ViewGroup parent) {
            return new DividerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_divider, parent, false));
        }
    },
    EMPTY {
        @Override
        public BaseHolder getViewHolder(ViewGroup parent) {
            return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false));
        }
    };

    abstract BaseHolder getViewHolder(ViewGroup parent);
}
