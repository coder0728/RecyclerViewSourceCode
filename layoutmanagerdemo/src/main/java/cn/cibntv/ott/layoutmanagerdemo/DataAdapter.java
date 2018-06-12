package cn.cibntv.ott.layoutmanagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Dajavu on 25/10/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private int[] images = {R.drawable.item1, R.drawable.item2, R.drawable.item3,
            R.drawable.item4, R.drawable.item5, R.drawable.item6, R.drawable.item7,
            R.drawable.item8, R.drawable.item9, R.drawable.item10};

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.imageView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "clicked:" + v.getTag(), Toast.LENGTH_SHORT).show();

//                    String url = "ykott://tv/detail?url=tv/v3/show/detail?id=123&fullscreen=true&fullback=true&from=cn.cibntv.ott";
                    String url = "ykott://tv/search?url=tv/v3/search?from_app=cn.cibntv.ott";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    ((Activity)itemView.getContext()).startActivity(intent);
                }
            });

            imageView.setOnFocusChangeListener((view, hasFocus) -> {
                if (hasFocus) {
                    // System.out.println("------------OnFocusChange----requestFocus-----------");
                } else {
                    // System.out.println("------------OnFocusChange----loseFocus-----------");
                }
            });
        }
    }
}
