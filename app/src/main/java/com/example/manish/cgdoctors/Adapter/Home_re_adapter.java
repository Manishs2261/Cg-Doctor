package com.example.manish.cgdoctors.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manish.cgdoctors.ModalClassHome;
import com.example.manish.cgdoctors.R;

import java.util.ArrayList;
import java.util.List;

public class Home_re_adapter extends RecyclerView.Adapter<Home_re_adapter.MyViewHolder> {

    private final ClickLineserRecyl clickLineserRecyl;

    private List<ModalClassHome> list;
    List<ModalClassHome>modalClassHomes;


    Context context;


    int lastposition = -1;

public Home_re_adapter(  Context context, List<ModalClassHome>modalClassHomes ,ClickLineserRecyl clickLineserRecyl)
{

    this.clickLineserRecyl = clickLineserRecyl;
    this.context = context;

    this.modalClassHomes =modalClassHomes;

}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.doctor_list_row,parent,false);

        return new MyViewHolder(view,clickLineserRecyl);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    holder.dis_img.setImageResource(modalClassHomes.get(position).getDis_img());
    holder.name_h.setText(modalClassHomes.get(position).getName_h());
    holder.name_e.setText(modalClassHomes.get(position).getName_e());

//
//    holder.dis_img.setImageResource(modalClassHomes.get(position).dis_img);
//    holder.name_e.setText(modalClassHomes.get(position).name_e);
//    holder.name_h.setText(modalClassHomes.get(position).name_h);



    rv_handle(position); // create mathod to handle recyleview

    }

    @Override
    public int getItemCount() {
        return modalClassHomes.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
{

    private ImageView dis_img;
    private TextView name_e,name_h;

    public MyViewHolder(@NonNull View itemView, ClickLineserRecyl clickLineserRecyl) {
        super(itemView);

        dis_img = itemView.findViewById(R.id.re_card_view_img);
        name_e = itemView.findViewById(R.id.re_name_english);
        name_h = itemView.findViewById(R.id.re_name_hindi);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clickLineserRecyl != null)
                {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                        clickLineserRecyl.onItemClicked(pos);
                }

            }
        });


    }
}

public void rv_handle(int position)
{

    if(position > lastposition)
    {
        lastposition = position;
    }

}




}
