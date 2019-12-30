package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_list_view.R;

import java.util.List;

public class IslandAdapter extends ArrayAdapter<Island> {

    private Context context;
    private int layoutResourceId;
    private List<Island> islands;


    public IslandAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public IslandAdapter(@NonNull Context context, int layoutResourceId, @NonNull List<Island> islands) {
        super(context, layoutResourceId, islands);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.islands = islands;
    }

    @Nullable
    @Override
    public Island getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View islandView = inflateLayoutForSingleIsland(parent);

        TextView islandName = islandView.findViewById(R.id.name);
        TextView islandSpeciality = islandView.findViewById(R.id.speciality);
        ImageView islandFlag = islandView.findViewById(R.id.flag);

        Island island = islands.get(position);
        islandName.setText(island.name);
        islandSpeciality.setText(island.speciality);
        islandFlag.setImageResource(getDrawableIdentifier(island.flag));

        return islandView;
    }

    private int getDrawableIdentifier(String imageName) {
        return context.getResources()
                .getIdentifier(imageName, "drawable", context.getPackageName());
    }

    private View inflateLayoutForSingleIsland(@NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(layoutResourceId, parent, false);
    }
}