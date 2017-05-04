package io.github.datwheat.juwan.ui.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.R;
import io.github.datwheat.juwan.ui.adapters.SkillsAdapter;

public class SkillsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.skillsRecyclerView)
    RecyclerView skillsRecyclerView;

    @BindView(R.id.rootConstraintLayout)
    ConstraintLayout rootConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;

        ab.setTitle(R.string.skills_activity_toolbar_title);
        ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        skillsRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        List<Object> skills = new ArrayList<>();
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());
        skills.add(new Object());

        RecyclerView.Adapter skillsRecyclerViewAdapter = new SkillsAdapter(skills);
        skillsRecyclerView.setAdapter(skillsRecyclerViewAdapter);
        skillsRecyclerView.setMinimumWidth(300);
    }
}
