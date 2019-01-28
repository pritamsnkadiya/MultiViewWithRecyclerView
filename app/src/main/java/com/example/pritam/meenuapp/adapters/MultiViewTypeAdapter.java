package com.example.pritam.meenuapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.pritam.meenuapp.R;
import com.example.pritam.meenuapp.models.Model;
import com.example.pritam.meenuapp.models.MultiView;

import java.util.ArrayList;
import java.util.List;

import static com.example.pritam.meenuapp.init.ApplicationAppContext.getAppContext;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    //private ArrayList<Model> dataSet;

    private List<MultiView> dataSet;
    Context mContext;
    int total_types;

    public static class ImageType2ViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        ImageView image;
        ImageView image2;
        CardView cardView;

        public ImageType2ViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView)itemView.findViewById (R.id.image);
            this.image2 = (ImageView)itemView.findViewById (R.id.image2);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    public static class ImageType4ViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        ImageView image;
        ImageView image2;
        ImageView image3;
        ImageView image4;

        public ImageType4ViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView) itemView.findViewById(R.id.background);
            this.image2 = (ImageView) itemView.findViewById(R.id.image);
            this.image3 = (ImageView) itemView.findViewById(R.id.image2);
            this.image4 = (ImageView) itemView.findViewById(R.id.image3);
        }
    }

    public static class ImageType6ViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        ImageView image;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        ImageView image6;

        public ImageType6ViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView) itemView.findViewById(R.id.background);
            this.image2 = (ImageView) itemView.findViewById(R.id.image);
            this.image3 = (ImageView) itemView.findViewById(R.id.image2);
            this.image4 = (ImageView) itemView.findViewById(R.id.image3);
            this.image5 = (ImageView) itemView.findViewById(R.id.image4);
            this.image6 = (ImageView) itemView.findViewById(R.id.image5);
        }
    }

    public static class VideoTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;
        ImageView videoView;
        CardView cardView;

        public VideoTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.videoView = (ImageView) itemView.findViewById (R.id.videoView);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

  /*  public MultiViewTypeAdapter(ArrayList<Model>data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }*/

    public MultiViewTypeAdapter(Context context,List<MultiView> data) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.IMAGE_TYPE2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type2, parent, false);
                return new ImageType2ViewHolder (view);
            case Model.IMAGE_TYPE4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type4, parent, false);
                return new ImageType4ViewHolder (view);
            case Model.IMAGE_TYPE6:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type6, parent, false);
                return new ImageType6ViewHolder (view);
            case Model.VIDEO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_type, parent, false);
                return new VideoTypeViewHolder (view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).getType ()) {
            case 0:
                return Model.IMAGE_TYPE2;
            case 1:
                return Model.IMAGE_TYPE4;
            case 2:
                return Model.IMAGE_TYPE6;
            case 3:
                return Model.VIDEO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        MultiView object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.getType ()) {
                case Model.IMAGE_TYPE2:
                    ((ImageType2ViewHolder) holder).txtType.setText(object.getText ());

                    Glide.with(getAppContext()).load(object.getImageName1 ())
                            .thumbnail(0.9f)
                            .into(((ImageType2ViewHolder) holder).image);

                    Glide.with(getAppContext()).load(object.getImageName2 ())
                            .thumbnail(0.9f)
                            .into(((ImageType2ViewHolder) holder).image2);

                    break;
                case Model.IMAGE_TYPE4:
                    ((ImageType4ViewHolder) holder).txtType.setText(object.getText ());

                    Glide.with(getAppContext()).load(object.getImageName1 ())
                            .thumbnail(0.9f)
                            .into(((ImageType4ViewHolder) holder).image);

                    Glide.with(getAppContext()).load(object.getImageName2 ())
                            .thumbnail(0.9f)
                            .into(((ImageType4ViewHolder) holder).image2);

                    Glide.with(getAppContext()).load(object.getImageName3 ())
                            .thumbnail(0.9f)
                            .into(((ImageType4ViewHolder) holder).image3);

                    Glide.with(getAppContext()).load(object.getImageName4 ())
                            .thumbnail(0.9f)
                            .into(((ImageType4ViewHolder) holder).image4);

                    break;
                case Model.IMAGE_TYPE6:

                    ((ImageType6ViewHolder) holder).txtType.setText(object.getText ());

                    Glide.with(getAppContext()).load(object.getImageName1 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image);

                    Glide.with(getAppContext()).load(object.getImageName2 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image2);

                    Glide.with(getAppContext()).load(object.getImageName3 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image3);

                    Glide.with(getAppContext()).load(object.getImageName4 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image4);

                    Glide.with(getAppContext()).load(object.getImageName5 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image5);

                    Glide.with(getAppContext()).load(object.getImageName6 ())
                            .thumbnail(0.9f)
                            .into(((ImageType6ViewHolder) holder).image6);

                    break;
                case Model.VIDEO_TYPE:
                    ((VideoTypeViewHolder) holder).txtType.setText(object.getText ());

                    Glide.with(getAppContext()).load(object.getVedioName ())
                            .thumbnail(0.9f)
                            .into(((VideoTypeViewHolder) holder).videoView);
                 //   ((VideoTypeViewHolder) holder).videoView.setImageResource(object.data);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}