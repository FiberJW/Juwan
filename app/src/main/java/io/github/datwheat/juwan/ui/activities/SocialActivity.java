package io.github.datwheat.juwan.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.datwheat.juwan.R;
import io.github.datwheat.juwan.ui.adapters.SocialAdapter;
import io.github.datwheat.juwan.ui.decorations.SocialItemDecoration;
import io.github.datwheat.juwan.ui.models.SocialOutlet;
import io.github.datwheat.juwan.utils.DimensionUtils;

public class SocialActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.socialRecyclerView)
    RecyclerView socialRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;

        ab.setTitle(R.string.social_activity_toolbar_title);
        ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 2);
        socialRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        List<SocialOutlet> socialOutlets = new ArrayList<>();
        socialOutlets.add(new SocialOutlet("Twitter", Uri.parse("https://twitter.com/datwheat"), R.drawable.twitter_128));
        socialOutlets.add(new SocialOutlet("GitHub", Uri.parse("https://github.com/datwheat"), R.drawable.github_128));
        socialOutlets.add(new SocialOutlet("Instagram", Uri.parse("https://instagram.com/fiber.god"), R.drawable.instagram_128));
        socialOutlets.add(new SocialOutlet("Facebook", Uri.parse("https://www.facebook.com/profile.php?id=100014087559824"), R.drawable.facebook_128));
        socialOutlets.add(new SocialOutlet("LinkedIn", Uri.parse("https://www.linkedin.com/in/wheatleyj404"), R.drawable.linkedin_128));

        RecyclerView.Adapter socialRecyclerViewAdapter = new SocialAdapter(socialOutlets);

        socialRecyclerView.addItemDecoration(new SocialItemDecoration(DimensionUtils.pxToDp(this, 8)));
        socialRecyclerView.setAdapter(socialRecyclerViewAdapter);
    }
}
