package io.github.datwheat.juwan.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.R;


public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {
    private List projects;
    private Context parentContext;

    public ProjectsAdapter(Context context, List dataset) {
        super();

        projects = dataset;
        parentContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View projectView = inflater.inflate(R.layout.item_project, parent, false);

        return new ViewHolder(projectView);
    }

    @Override
    public void onBindViewHolder(ProjectsAdapter.ViewHolder holder, int position) {
        // populate viewholder fields
        // Object project = projects.get(position);

        Picasso.with(parentContext)
                .load("https://i.imgur.com/FB7xWqw.png")
                .resize(128, 128)
                .centerCrop()
                .into(holder.projectImageView);

        if (position == getItemCount() - 1) {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.rootCardView.getLayoutParams();
            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, 8);
            holder.rootCardView.setLayoutParams(params);
        }

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // get fields
        @BindView(R.id.projectImageView)
        ImageView projectImageView;

        @BindView(R.id.projectName)
        TextView projectNameTextView;

        @BindView(R.id.projectDescription)
        TextView projectDescriptionTextView;

        @BindView(R.id.rootCardView)
        CardView rootCardView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
