package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.AdViewActivity;
import com.example.myapplication.Activity.MyAddView;
import com.example.myapplication.MyPostRecylerViewModel.MyPost;
import com.example.myapplication.R;

import java.util.List;

public class MyPostRecylerViewAdapter extends RecyclerView.Adapter<MyPostRecylerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<MyPost> postList;

    String Tag = "MyAdPostRecylerViewAdapter";

    public MyPostRecylerViewAdapter(Context mContext, List<MyPost> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        final LayoutInflater inflater = LayoutInflater.from( mContext );
        view = inflater.inflate( R.layout.my_post_recyler_view_item,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder( view );
        viewHolder.my_post_recyler_view_item.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent( mContext, MyAddView.class );
                intent.putExtra( "ad_id",postList.get( viewHolder.getAdapterPosition()).getId());

                intent.putExtra( "post_title",postList.get( viewHolder.getAdapterPosition()).getPostTitle());
                intent.putExtra( "division",postList.get( viewHolder.getAdapterPosition()).getDivision());
                intent.putExtra( "city",postList.get( viewHolder.getAdapterPosition()).getCity());
                intent.putExtra( "authority_types",postList.get( viewHolder.getAdapterPosition()).getAuthorityTypes());
                intent.putExtra( "address",postList.get( viewHolder.getAdapterPosition()).getAddress());
                intent.putExtra( "apartment_no",postList.get( viewHolder.getAdapterPosition()).getApartmentNo());
                intent.putExtra( "rent_date",postList.get( viewHolder.getAdapterPosition()).getRentDate());
                intent.putExtra( "tenant",postList.get( viewHolder.getAdapterPosition()).getTenant());
                intent.putExtra( "description",postList.get( viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra( "space_size",postList.get( viewHolder.getAdapterPosition()).getSpaceSize());
                intent.putExtra( "renters",postList.get( viewHolder.getAdapterPosition()).getRenters());
                intent.putExtra( "utility",postList.get( viewHolder.getAdapterPosition()).getUtility());
                intent.putExtra( "category",postList.get( viewHolder.getAdapterPosition()).getCategory());
                intent.putExtra( "floor",postList.get( viewHolder.getAdapterPosition()).getFloor());
                intent.putExtra( "bedroom",postList.get( viewHolder.getAdapterPosition()).getBedroom());
                intent.putExtra( "bathroom",postList.get( viewHolder.getAdapterPosition()).getBathroom());
                intent.putExtra( "balconi",postList.get( viewHolder.getAdapterPosition()).getBalconi());
                intent.putExtra( "kitchen",postList.get( viewHolder.getAdapterPosition()).getKitchen());
                intent.putExtra( "dining_room",postList.get( viewHolder.getAdapterPosition()).getDiningRoom());
                intent.putExtra( "drawing_room",postList.get( viewHolder.getAdapterPosition()).getDrawingRoom());
                intent.putExtra( "garage",postList.get( viewHolder.getAdapterPosition()).getGarage());
                intent.putExtra( "closing_time",postList.get( viewHolder.getAdapterPosition()).getClosingTime());
                intent.putExtra( "opening_time",postList.get( viewHolder.getAdapterPosition()).getOpeningTime());
                intent.putExtra( "nearest_famous_place_one",postList.get( viewHolder.getAdapterPosition()).getNearestFamousPlaceOne());
                intent.putExtra( "nearest_famous_place_two",postList.get( viewHolder.getAdapterPosition()).getNearestFamousPlaceTwo());
                intent.putExtra( "featured_image",postList.get( viewHolder.getAdapterPosition()).getFeaturedImage());
                intent.putExtra( "more_image",postList.get( viewHolder.getAdapterPosition()).getMoreImage());
                intent.putExtra( "Status",postList.get( viewHolder.getAdapterPosition()).getStatus());

                Log.e( Tag,"MYpost Status "+postList.get( viewHolder.getAdapterPosition()).getStatus().toString() );


                mContext.startActivity(intent);

               // Log.d( Tag,"RecylerViewID"+ postList.get( viewHolder.getAdapterPosition()).getId().toString());

            }
        } );






        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.Category.setText( postList.get( position ).getCategory() );
        holder.postPrice.setText(postList.get(position).getRenters());
        holder.Rental_type.setText(postList.get(position).getTenant());
        holder.Address.setText( postList.get( position ).getAddress());
        holder.postId.setText( postList.get( position ).getUserId());
       // Picasso.get().load(postList.get(position).getMoreImage()).into(holder.iv);

        MyPost product = postList.get(position);
        Glide.with(mContext)
                .load(product.getFeaturedImage())
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Address,postPrice, Category, Rental_type,postId;
        LinearLayout my_post_recyler_view_item;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super( itemView );

            my_post_recyler_view_item = itemView.findViewById( R.id.my_post_recyler_view_content );


            Address = itemView.findViewById( R.id.address );
            postPrice = itemView.findViewById( R.id.post_price );
            Category = itemView.findViewById( R.id.category );
            Rental_type = itemView.findViewById( R.id.tenant );
            postId = itemView.findViewById( R.id.post_id );

            iv = itemView.findViewById(R.id.iv);
        }
    }


    public void updateList(List<MyPost> postList){
        this.postList=postList;
        notifyDataSetChanged();
    }
}
