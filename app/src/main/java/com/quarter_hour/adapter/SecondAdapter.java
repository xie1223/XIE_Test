package com.quarter_hour.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.quarter_hour.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondAdapter extends RecyclerView.Adapter {
    private boolean isMenuOpen = false;
    private Context context;

    public SecondAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.episode_list,null);
        Second_Holder second_holder = new Second_Holder(view);
        return second_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Second_Holder second_holder = (Second_Holder) holder;
        ((Second_Holder) holder).second_title.setText("11111111111");
        ((Second_Holder) holder).second_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (isMenuOpen){
                   ((Second_Holder) holder).second_jia.setImageResource(R.drawable.jian);
                   ObjectAnimator rotate = ObjectAnimator.ofFloat( ((Second_Holder) holder).second_jia, "rotation", 0, 180).setDuration(300);
                   rotate.start();
                   //平移动画
                   ObjectAnimator translation1 = ObjectAnimator.ofFloat( ((Second_Holder) holder).pl_img, "translationX", 0, -120).setDuration(500);
                   translation1.start();
                   ObjectAnimator alpha1 = ObjectAnimator.ofFloat(((Second_Holder) holder).pl_img,"alpha",0f,1f);
                   alpha1.start();
                   ((Second_Holder) holder).pl_img.setVisibility(View.VISIBLE);

                   ObjectAnimator translation2 = ObjectAnimator.ofFloat( ((Second_Holder) holder).fx_img, "translationX", 0, -220).setDuration(400);
                   translation2.start();
                   ObjectAnimator alpha2 = ObjectAnimator.ofFloat(((Second_Holder) holder).fx_img,"alpha",0f,1f);
                   alpha2.start();
                   ((Second_Holder) holder).fx_img.setVisibility(View.VISIBLE);

                   ObjectAnimator translation3 = ObjectAnimator.ofFloat( ((Second_Holder) holder).dz_img, "translationX", 0, -310).setDuration(300);
                   translation3.start();
                   ((Second_Holder) holder).dz_img.setVisibility(View.VISIBLE);

                   isMenuOpen = false;

               }else {
                   ((Second_Holder) holder).second_jia.setImageResource(R.drawable.jia);

                   ObjectAnimator t1 = ObjectAnimator.ofFloat( ((Second_Holder) holder).pl_img, "translationX", -120, 0);
                   t1.setDuration(300);
                   t1.start();
                   ObjectAnimator a1 = ObjectAnimator.ofFloat(((Second_Holder) holder).pl_img,"alpha",1f,0f);
                   a1.start();


                   ObjectAnimator t2 = ObjectAnimator.ofFloat( ((Second_Holder) holder).fx_img, "translationX", -220, 0);
                   t2.setDuration(400);
                   t2.start();
                   ObjectAnimator alpha2 = ObjectAnimator.ofFloat(((Second_Holder) holder).fx_img,"alpha",1f,0f);
                   alpha2.start();


                   ObjectAnimator t3 = ObjectAnimator.ofFloat( ((Second_Holder) holder).dz_img, "translationX", -310, 0);
                   t3.setDuration(500);
                   t3.start();

                   ((Second_Holder) holder).dz_img.setVisibility(View.GONE);

                   isMenuOpen = true;
               }
               //点赞
               ((Second_Holder) holder).dz_img.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (isMenuOpen){
                           ((Second_Holder) holder).dz_img.setImageResource(R.drawable.dz2);
                           isMenuOpen = false;
                       }else {
                           ((Second_Holder) holder).dz_img.setImageResource(R.drawable.dz);
                           isMenuOpen = true;
                       }
                   }
               });
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    public class Second_Holder extends RecyclerView.ViewHolder {

        private CircleImageView second_img;
        private TextView second_name;
        private TextView second_time;
        private TextView second_title;
        private ImageView second_jia;
        private ImageView fx_img;
        private ImageView pl_img;
        private ImageView dz_img;
        public Second_Holder(View itemView) {
            super(itemView);
            second_img = itemView.findViewById(R.id.second_img);
            second_name = itemView.findViewById(R.id.second_name);
            second_time = itemView.findViewById(R.id.second_time);
            second_title = itemView.findViewById(R.id.second_title);
            second_jia = itemView.findViewById(R.id.second_jia);
            fx_img = itemView.findViewById(R.id.fx_img);
            pl_img = itemView.findViewById(R.id.pl_img);
            dz_img = itemView.findViewById(R.id.dz_img);
        }
    }
}
