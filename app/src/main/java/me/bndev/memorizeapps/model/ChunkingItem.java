package me.bndev.memorizeapps.model;

import androidx.annotation.ColorRes;

public class ChunkingItem {
    private ChunkingEnum id;
    private String title;
    private String description;
    private int color;

    public ChunkingItem() {
    }

    public ChunkingItem(ChunkingEnum id, String title, String description, @ColorRes int color) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public ChunkingEnum getId() {
        return id;
    }

    public void setId(ChunkingEnum id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
