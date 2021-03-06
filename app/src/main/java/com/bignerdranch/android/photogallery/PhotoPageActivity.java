package com.bignerdranch.android.photogallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.webkit.WebView;

public class PhotoPageActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context, Uri photoPageUri) {
        Intent i = new Intent(context, PhotoPageActivity.class);
        i.setData(photoPageUri);
        return i;
    }

    @Override
    protected Fragment createFragment() {
        return PhotoPageFragment.newInstance(getIntent().getData());
    }

    @Override
    public void onBackPressed() {

        // Maybe used interfaces in the future.
        FragmentManager fm = getSupportFragmentManager();
        PhotoPageFragment fragment = (PhotoPageFragment) fm.findFragmentById(R.id.fragment_container);

        if(!fragment.goBack()) {
            super.onBackPressed();
        }

    }
}
