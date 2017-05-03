package io.github.datwheat.juwan.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.ui.adapters.ProjectsAdapter;
import io.github.datwheat.juwan.R;

public class WorkActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.projectRecyclerView)
    RecyclerView projectRecyclerView;

    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private RecyclerView.Adapter projectRecyclerViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;

        ab.setTitle(R.string.work_activity_toolbar_title);
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        projectRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        List<Object> projectData = new ArrayList<>();
        projectData.add(new Object());
        projectData.add(new Object());
        projectData.add(new Object());

        projectRecyclerViewAdapter = new ProjectsAdapter(this, projectData);
        projectRecyclerView.setAdapter(projectRecyclerViewAdapter);


    }
}
