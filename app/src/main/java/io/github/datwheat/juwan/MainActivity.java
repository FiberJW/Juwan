package io.github.datwheat.juwan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static io.github.datwheat.juwan.CardUtils.ARG_DESCRIPTION;
import static io.github.datwheat.juwan.CardUtils.ARG_IMAGE;
import static io.github.datwheat.juwan.CardUtils.ARG_TITLE;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 5;

    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.profile_picture)
    ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAboutActivityIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(openAboutActivityIntent);
            }
        });

        PagerAdapter pagerAdapter = new CardPagerAdapter(getSupportFragmentManager());
        pager.setPageMargin(48);
        pager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    private class CardPagerAdapter extends FragmentStatePagerAdapter {

        CardPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            CardFragment cardFragment = new CardFragment();
            Bundle cardFragmentArguments;

            switch (position) {
                case 0:
                    cardFragmentArguments = generateCardFragmentArguments(
                            "Work",
                            "Projects I’m proud of, featuring a lot of open-source work.",
                            R.drawable.ic_code_white_48dp
                    );
                    break;
                case 1:
                    cardFragmentArguments = generateCardFragmentArguments(
                            "Skills",
                            "Learn about what I can do for you!",
                            R.drawable.ic_assessment_white_48dp
                    );
                    break;
                case 2:
                    cardFragmentArguments = generateCardFragmentArguments(
                            "Social",
                            "Find me on all of my social media platforms.",
                            R.drawable.ic_whatshot_white_48dp
                    );
                    break;
                case 3:
                    cardFragmentArguments = generateCardFragmentArguments(
                            "Need Help?",
                            "Contact me if you need a helping hand for your programming needs.",
                            R.drawable.ic_help_outline_white_48dp
                    );
                    break;
                case 4:
                    cardFragmentArguments = generateCardFragmentArguments(
                            "Donate",
                            "Help support my contributions to the open-source ecosystem.",
                            R.drawable.ic_attach_money_white_48dp
                    );
                    break;
                default:
                    cardFragmentArguments = new Bundle();
                    break;
            }

            cardFragment.setArguments(cardFragmentArguments);
            return cardFragment;
        }

        private Bundle generateCardFragmentArguments(String title, String description, int imageResourceId) {
            Bundle cardFragmentArguments = new Bundle();

            cardFragmentArguments.putString(ARG_TITLE, title);
            cardFragmentArguments.putString(ARG_DESCRIPTION, description);
            cardFragmentArguments.putInt(ARG_IMAGE, imageResourceId);

            return cardFragmentArguments;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
