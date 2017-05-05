package io.github.datwheat.juwan.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.R;
import io.github.datwheat.juwan.ui.models.SocialOutlet;


public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {
    private Context context;
    private List socialOutlets;

    public SocialAdapter(List dataset) {
        socialOutlets = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View skillView = inflater.inflate(R.layout.item_social_outlet, parent, false);
        return new ViewHolder(skillView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final SocialOutlet socialOutlet = ((SocialOutlet) socialOutlets.get(position));

        holder.socialOutletNameTextView.setText(socialOutlet.getName());

        Picasso.with(context)
                .load(socialOutlet.getIconResourceId())
                .resize(128, 128)
                .centerCrop()
                .into(holder.socialIconImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Palette colorPalette = Palette.from(((BitmapDrawable) holder.socialIconImageView.getDrawable()).getBitmap()).generate();
                        int backgroundColor = colorPalette.getLightVibrantColor(ContextCompat.getColor(context, android.R.color.white));
                        int textColor = ColorUtils.calculateLuminance(backgroundColor) < 0.5f ? Color.parseColor("#FFFFFF") : Color.parseColor("#333333");

                        holder.rootCardView.setCardBackgroundColor(backgroundColor);
                        holder.socialOutletNameTextView.setTextColor(textColor);
                    }

                    @Override
                    public void onError() {

                    }
                });
        holder.rootCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, socialOutlet.getLink());
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return socialOutlets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rootCardView)
        CardView rootCardView;

        @BindView(R.id.socialIcon)
        ImageView socialIconImageView;

        @BindView(R.id.socialOutletName)
        TextView socialOutletNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
