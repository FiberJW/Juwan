package io.github.datwheat.juwan.ui.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.R;


public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {
    private Context context;
    private List skills;

    public SkillsAdapter(List dataset) {
        super();
        skills = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View skillView = inflater.inflate(R.layout.item_skill, parent, false);
        return new ViewHolder(skillView);
    }

    @Override
    public void onBindViewHolder(SkillsAdapter.ViewHolder holder, int position) {
        // populate fields

        if (position == getItemCount() - 1) {
            int paddingPixel = 16;
            float density = context.getResources().getDisplayMetrics().density;
            int paddingDp = (int)(paddingPixel * density);

            holder.rootConstraintLayout.setPadding(paddingDp, paddingDp, paddingDp, paddingDp);
        }
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // get fields

        @BindView(R.id.rootConstraintLayout)
        ConstraintLayout rootConstraintLayout;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
