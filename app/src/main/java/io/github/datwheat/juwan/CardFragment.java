package io.github.datwheat.juwan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CardFragment extends Fragment {
    @BindView(R.id.card_title)
    TextView cardTitle;

    @BindView(R.id.card_description)
    TextView cardDescription;

    @BindView(R.id.icon)
    ImageView icon;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        ButterKnife.bind(this, rootView);

        Bundle arguments = getArguments();

        String title = arguments.getString(CardUtils.ARG_TITLE);
        String description = arguments.getString(CardUtils.ARG_DESCRIPTION);
        int imageResource = arguments.getInt(CardUtils.ARG_IMAGE);

        cardTitle.setText(title);
        cardDescription.setText(description);
        icon.setImageResource(imageResource);

        return rootView;
    }
}
