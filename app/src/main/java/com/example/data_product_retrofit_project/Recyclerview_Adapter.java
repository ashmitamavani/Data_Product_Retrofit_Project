package com.example.data_product_retrofit_project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<Model_Class> modelList;


    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Model_Class> modelList) {
        this.mainActivity = mainActivity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_file, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.title.setText("" + modelList.get(position).getTitle());
        holder.completed.setText("" + modelList.get(position).getCompleted());
        Log.d("TTT", "onBindViewHolder:title======== " + modelList.get(position).getTitle());
        Log.d("TTT", "onBindViewHolder:title======== " + modelList.get(position).getCompleted());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title, completed;

        public Holder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            completed = itemView.findViewById(R.id.completed);
        }
    }
}
