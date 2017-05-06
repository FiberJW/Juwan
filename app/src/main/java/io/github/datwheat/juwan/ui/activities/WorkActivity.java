package io.github.datwheat.juwan.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.GetAllProjectsQuery;
import io.github.datwheat.juwan.JApplication;
import io.github.datwheat.juwan.R;
import io.github.datwheat.juwan.fragment.ProjectFragment;
import io.github.datwheat.juwan.ui.adapters.ProjectsAdapter;

public class WorkActivity extends AppCompatActivity {
    private static final String TAG = WorkActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.projectRecyclerView)
    RecyclerView projectRecyclerView;

    private RecyclerView.Adapter projectRecyclerViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        ButterKnife.bind(this);

        JApplication application = (JApplication) getApplication();

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;

        ab.setTitle(R.string.work_activity_toolbar_title);
        ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        projectRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        final List<ProjectFragment> projectData = new ArrayList<>();

        projectRecyclerViewAdapter = new ProjectsAdapter(projectData);
        projectRecyclerView.setAdapter(projectRecyclerViewAdapter);

        application.apolloClient().newCall(new GetAllProjectsQuery()).enqueue(new ApolloCall.Callback<GetAllProjectsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetAllProjectsQuery.Data> response) {
                for (final GetAllProjectsQuery.Data.Project project : response.data().projects()) {
                    WorkActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            projectData.add(project.fragments().projectFragment());
                            projectRecyclerViewAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }

            @Override
            public void onFailure(@Nonnull final ApolloException e) {
                WorkActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WorkActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
