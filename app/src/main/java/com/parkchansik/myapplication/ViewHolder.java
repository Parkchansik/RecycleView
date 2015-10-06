package com.parkchansik.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public interface OnItemClickListener {
        public void onItemClick(String name, int position);
    }

    OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    TextView nameView;
    public ViewHolder(View itemView) {//뷰홀더의 생성자 뷰를 받아서 생성해라
        super(itemView);
        nameView = (TextView)itemView.findViewById(R.id.text_name);//뷰를 생성하느넛
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mName, position);
                }
            }
        });
    }

    String mName;
    public void setName(String name) {
        mName = name;
        nameView.setText(name);
    }
}
