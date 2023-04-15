package com.example.manish.cgdoctors.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manish.cgdoctors.BookAppoiment;
import com.example.manish.cgdoctors.R;

public class DrListadapter extends RecyclerView.Adapter<DrListadapter.DrViewHolder> {

    private final ClickLineserDrList clickLineserDrList;




    int [] dr_img ;
    String [] dr_name ;
    String [] hos_name ;
    String [] rating_num ;
    String [] rating_ple ;
    String [] hos_add ;
    String [] dr_fee ;
    String [] avi_mornig ;
    String [] avi_eving ;

    Context context;

    public DrListadapter(int[] dr_img, String[] dr_name, String[] hos_name, String[] rating_num, String[] rating_ple, String[] hos_add, String[] dr_fee, String[] avi_mornig, String[] avi_eving,ClickLineserDrList clickLineserDrList) {
        this.dr_img = dr_img;
        this.dr_name = dr_name;
        this.hos_name = hos_name;
        this.rating_num = rating_num;
        this.rating_ple = rating_ple;
        this.hos_add = hos_add;
        this.dr_fee = dr_fee;
        this.avi_mornig = avi_mornig;
        this.avi_eving = avi_eving;

        this.clickLineserDrList = clickLineserDrList;
    }



    @NonNull
    @Override
    public DrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context =parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dr_under_list,parent,false);




        return new DrViewHolder(view,clickLineserDrList);
    }

    @Override
    public void onBindViewHolder(@NonNull DrViewHolder holder, int position)
    {

        holder.dr_photo_list.setImageResource(dr_img[position]);
        holder.dr_name_list.setText(dr_name[position]);
        holder.hos_name_list.setText(hos_name[position]);
        holder.rating_number_list.setText(rating_num[position]);
        holder.rating_pel_list.setText(rating_ple[position]);
        holder.hos_adders_list.setText(hos_add[position]);
        holder.fee_list.setText(dr_fee[position]);
        holder.avi_evinig_list.setText(avi_eving[position]);
        holder.avi_morning_list.setText(avi_mornig[position]);


    }

    @Override
    public int getItemCount() {

        return hos_name.length;
    }


    class DrViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView dr_photo_list;
        private TextView dr_name_list,hos_name_list,rating_number_list,rating_pel_list,
                hos_adders_list,fee_list,avi_morning_list,avi_evinig_list,dr_call_list,booknow_list;

        public DrViewHolder(@NonNull View itemView, ClickLineserDrList clickLineserDrList) {
            super(itemView);

            dr_photo_list = itemView.findViewById(R.id.dr_photo_list);
            dr_name_list = itemView.findViewById(R.id.dr_name_list);
            hos_name_list = itemView.findViewById(R.id.hos_name_list);
            rating_number_list = itemView.findViewById(R.id.rating_number_list);
            rating_pel_list = itemView.findViewById(R.id.rating_pel_list);
            hos_adders_list = itemView.findViewById(R.id.hos_adders_list);
            fee_list = itemView.findViewById(R.id.fee_list);
            avi_morning_list = itemView.findViewById(R.id.avi_morning_list);
            avi_evinig_list = itemView.findViewById(R.id.avi_evinig_list);
            booknow_list = itemView.findViewById(R.id.booknow_list);
            dr_call_list = itemView.findViewById(R.id.dr_call_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(clickLineserDrList != null)
                    {

                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION)
                            clickLineserDrList.itmeOnClick(pos);
                    }

                }
            });



            booknow_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(clickLineserDrList != null)
                    {
                        int poss = getAdapterPosition();
                        if(poss != RecyclerView.NO_POSITION)
                            clickLineserDrList.buttonOnClick(poss);
                    }
                }
            });



            dr_call_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(clickLineserDrList != null)
                    {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION)
                            clickLineserDrList.buttonOnCall(pos);
                    }
                }
            });

        }
    }

}
