package com.welovecoding.app.firetv.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.welovecoding.app.firetv.R;
import com.welovecoding.app.firetv.adapter.CategoryAdapter;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GridView gridView = (GridView) findViewById(R.id.gridview);
    gridView.setAdapter(new CategoryAdapter(this));

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
        intent.putExtra("id", position);
        startActivity(intent);
      }
    });
  }

}
