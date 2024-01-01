package com.pinal.patternbullet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    List<UserModel> userModelList;
    private OnItemClickListener onItemClickListener;


    public UserAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_check,parent,false);
        return new UserViewHolder(view);
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, @SuppressLint("RecyclerView") int position) {
        UserModel userModel = userModelList.get(position);

        boolean isItemSelected = userModel.isImageVisible();

        // Adjust the visibility based on the selected item
        holder.imgBullet.setVisibility(isItemSelected ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle item click
                handleItemClick(position);
            }
        });
    }

    private void clearHighlighting() {
        for (UserModel userModel : userModelList) {
            userModel.setImageVisible(false);
        }
    }



    private void handleItemClick(int clickedPosition) {
        clearHighlighting();
        int spanCount = (int) Math.sqrt(getItemCount());

        int row = clickedPosition / spanCount;
        int col = clickedPosition % spanCount;

        // Toggle visibility for the clicked row
        for (int i = 0; i < spanCount; i++) {
            userModelList.get(row * spanCount + i).toggleImageVisibility();
        }

        // Toggle visibility for the clicked column
        for (int i = 0; i < spanCount; i++) {
            userModelList.get(i * spanCount + col).toggleImageVisibility();
        }

        // Toggle visibility for the main diagonal
        if (row == col) {
            for (int i = 0; i < spanCount; i++) {
                userModelList.get(i * spanCount + i).toggleImageVisibility();
            }
        }

        // Toggle visibility for the other diagonal
        if (row + col == spanCount - 1) {
            for (int i = 0; i < spanCount; i++) {
                userModelList.get(i * spanCount + (spanCount - 1 - i)).toggleImageVisibility();
            }
        }

        notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBullet;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBullet = itemView.findViewById(R.id.imgBullet);
        }
    }
}
