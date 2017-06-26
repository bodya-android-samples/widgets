package ru.popov.bodya.navdrawerdemo;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class NavigationListAdapter extends RecyclerView.Adapter<NavigationListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Drawable> icons;
    private ArrayList<String> labels;
    private OnItemClickListener itemClickListener;

    public NavigationListAdapter(Context context, ArrayList<Drawable> icons, ArrayList<String> labels) {
        inflater = LayoutInflater.from(context);
        this.icons = icons;
        this.labels = labels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_navigation_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.navButton.setText(labels.get(position));
        holder.navButton.setCompoundDrawablesWithIntrinsicBounds(icons.get(position), null, null, null);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public interface OnItemClickListener {
        void onNavigationItemClick(int position);
    }

    public void setOnClickListener(final OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatButton navButton;

        private ViewHolder(View itemView) {
            super(itemView);
            navButton = (AppCompatButton) itemView.findViewById(R.id.btn_nav_item);
            navButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onNavigationItemClick(getAdapterPosition());
                }
            });
        }
    }
}
