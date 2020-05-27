package me.bndev.memorizeapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.bndev.memorizeapps.R;

public class RecyclerChunkingNumberAdapter
        extends RecyclerView.Adapter<RecyclerChunkingNumberAdapter.ChunkingHolder> {

    private Context context;
    private List<Integer> objects;

    public RecyclerChunkingNumberAdapter(Context context, List<Integer> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public ChunkingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recycler_item_chunking_number, parent, false);
        return new ChunkingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChunkingHolder holder, int position) {
        String value = objects.get(position).toString();
        holder.textItem.setText(value);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    static class ChunkingHolder extends RecyclerView.ViewHolder {

        TextView textItem;

        public ChunkingHolder(@NonNull View itemView) {
            super(itemView);

            textItem = itemView.findViewById(R.id.text_item);
        }

    }
}
