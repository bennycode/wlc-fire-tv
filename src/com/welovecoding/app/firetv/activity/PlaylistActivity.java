package com.welovecoding.app.firetv.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import com.welovecoding.app.firetv.R;
import com.welovecoding.app.firetv.adapter.PlaylistAdapter;

public class PlaylistActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_playlist);

    Intent intent = getIntent();

    int position = intent.getExtras().getInt("id");
        //PlaylistAdapter imageAdapter = new PlaylistAdapter(this);

    PlaylistAdapter playlist = new PlaylistAdapter(this);

    GridView gridView = (GridView) findViewById(R.id.gridviewa);
    gridView.setAdapter(playlist);
        //ImageView imageView = (ImageView) findViewById(R.id.SingleView);
    //imageView.setImageResource(imageAdapter.mThumbIds[position]);
  }
}
