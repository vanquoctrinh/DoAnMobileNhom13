package com.example.bottomnavi;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TrainAdapter extends BaseAdapter {
    Activity activity;
    List<TrainModel> trains;
    LayoutInflater inflater;

    public TrainAdapter(Activity activity) {
        this.activity = activity;
    }

    public TrainAdapter(Activity activity, List<TrainModel> trains) {
        this.activity = activity;
        this.trains = trains;

        inflater= activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return trains.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view == null){
            view = inflater.inflate(R.layout.list_train_item,viewGroup,false);
            holder = new ViewHolder();
            holder.tvTrainName = (TextView) view.findViewById(R.id.tv_train_name);
            holder.ivCheckBox = (ImageView) view.findViewById(R.id.iv_check_box);

            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();

        TrainModel model = trains.get(i);

        holder.tvTrainName.setText(model.getTrainName());
        if(model.isSelected())
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
        else
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);

        return view;
    }

    public void updateRecords(List<TrainModel> trains){
        this.trains = trains;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView tvTrainName;
        ImageView ivCheckBox;
    }
}