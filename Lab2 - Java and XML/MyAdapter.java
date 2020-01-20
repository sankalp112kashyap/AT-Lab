package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout containerView;
        public TextView textView;

        MyViewHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.my_row);
            textView = view.findViewById(R.id.my_row_text_view);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String current = (String)containerView.getTag();
                    Intent intent = new Intent(v.getContext(), MyActivity.class);
                    intent.putExtra("name", current);

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<String> items =Arrays.asList(
            new String("Onion"),
            new String("Chicken"),
            new String("Chicken1"),
            new String("Chicken2"),
            new String("Chicken3"),
            new String("Chicken4")
    );



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent, false); //from xml to JAVA object in memory
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String current = items.get(position);
        holder.textView.setText(current);
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return items.size();


    }


}
