package io.github.datwheat.juwan;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.cardView2)
    CardView cardView;

    @BindView(R.id.projectImageView)
    ImageView projectImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;

        ab.setTitle(R.string.work_activity_toolbar_title);
        ab.setDisplayHomeAsUpEnabled(true);

        Picasso.with(this)
                .load("https://i.imgur.com/FB7xWqw.png")
                .resize(128, 128)
                .centerCrop()
                .into(projectImageView);
    }

    @OnClick(R.id.cardView2)
    public void onCardClicked() {
        Toast.makeText(WorkActivity.this, "CLICKED", Toast.LENGTH_SHORT).show();

    }
}
