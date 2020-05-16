package me.bndev.memorizeapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.bndev.memorizeapps.R;

public class RecyclerMainAdapter extends RecyclerView.Adapter<RecyclerMainAdapter.MenuHolder> {

    private Context context;
    private List<String> menuList;
    private OnMenuClickListener mListener;

    public RecyclerMainAdapter(Context context, List<String> objects) {
        this.context = context;
        menuList = objects;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recycler_item_main_menu, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, final int position) {
        holder.textItem.setText(menuList.get(position));
        holder.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onMenuClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public void setOnMenuClickListener(OnMenuClickListener listener) {
        mListener = listener;
    }

    static class MenuHolder extends RecyclerView.ViewHolder {

        private TextView textItem;

        MenuHolder(@NonNull View itemView) {
            super(itemView);

            textItem = itemView.findViewById(R.id.text_item);
        }

        void setOnClick(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }
    }

    public interface OnMenuClickListener {
        void onMenuClicked(int position);
    }
}
