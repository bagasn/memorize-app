package me.bndev.memorizeapps.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.bndev.memorizeapps.R;
import me.bndev.memorizeapps.model.ChunkingItem;

public class RecyclerChunkingMenuAdapter extends RecyclerView.Adapter<RecyclerChunkingMenuAdapter.ChunkinHolder> {

    private Context context;
    private List<ChunkingItem> chunkingList;
    private IRecycler.OnSelectItemListener mListener;

    public RecyclerChunkingMenuAdapter(Context context, List<ChunkingItem> objects) {
        this.context = context;
        chunkingList = objects;
    }

    @NonNull
    @Override
    public ChunkinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recycler_item_chunking_menu, parent, false);
        return new ChunkinHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChunkinHolder holder, final int position) {
        ChunkingItem item = chunkingList.get(position);

        holder.textTitle.setText(item.getTitle());
        holder.textDescription.setText(item.getDescription());
        holder.cardContainer.setCardBackgroundColor(context.getColor(item.getColor()));
        holder.setupClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onSelectedItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chunkingList.size();
    }

    public void setOnSelectedItemListener(IRecycler.OnSelectItemListener listener) {
        mListener = listener;
    }

    static class ChunkinHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private CardView cardContainer;

        ChunkinHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
            cardContainer = itemView.findViewById(R.id.card_container);
        }

        void setupClickAction(View.OnClickListener listener) {
            cardContainer.setOnClickListener(listener);
        }
    }

}
