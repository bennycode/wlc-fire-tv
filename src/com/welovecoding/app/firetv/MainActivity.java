package com.welovecoding.app.firetv;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.welovecoding.app.firetv.data.CategoryResult;
import com.welovecoding.app.firetv.rest.CategoryRequest;
import com.welovecoding.app.firetv.robospice.BaseSpiceActivity;

/**
 * An activity representing a list of Items. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link ItemDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details (if present) is a
 * {@link ItemDetailFragment}.
 * <p>
 * This activity also implements the required {@link ItemListFragment.Callbacks}
 * interface to listen for item selections.
 */
public class MainActivity extends BaseSpiceActivity
        implements ItemListFragment.Callbacks {

  public static final String ANDROID_APP_TAG = "wlc-fire-tv";
  private CategoryRequest restRequest;

  /**
   * Whether or not the activity is in two-pane mode, i.e. running on a tablet
   * device.
   */
  private boolean mTwoPane;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String tag = "wlc-fire-tv";
    String message = "Hello World";

    // Log info
    Log.i(tag, message);

    setContentView(R.layout.activity_item_list);

    if (findViewById(R.id.item_detail_container) != null) {
      // The detail container view will be present only in the
      // large-screen layouts (res/values-large and
      // res/values-sw600dp). If this view is present, then the
      // activity should be in two-pane mode.
      mTwoPane = true;

      // In two-pane mode, list items should be given the
      // 'activated' state when touched.
      ((ItemListFragment) getFragmentManager()
              .findFragmentById(R.id.item_list))
              .setActivateOnItemClick(true);
    }

    // TODO: If exposing deep links into your app, handle intents here.
    restRequest = new CategoryRequest();
  }

  /**
   * Callback method from {@link ItemListFragment.Callbacks} indicating that the
   * item with the given ID was selected.
   */
  @Override
  public void onItemSelected(String id) {
    if (mTwoPane) {
      // In two-pane mode, show the detail view in this activity by
      // adding or replacing the detail fragment using a
      // fragment transaction.
      Bundle arguments = new Bundle();
      arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
      ItemDetailFragment fragment = new ItemDetailFragment();
      fragment.setArguments(arguments);
      getFragmentManager().beginTransaction()
              .replace(R.id.item_detail_container, fragment)
              .commit();

    } else {
      // In single-pane mode, simply start the detail activity
      // for the selected item ID.
      Intent detailIntent = new Intent(this, ItemDetailActivity.class);
      detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
      startActivity(detailIntent);
    }
  }

  @Override
  protected void onStart() {
    super.onStart();

    setProgressBarIndeterminate(false);
    setProgressBarVisibility(true);

    getSpiceManager().execute(restRequest, "json", DurationInMillis.ONE_MINUTE, new CategoryRequestListener());
  }

  public final class CategoryRequestListener implements RequestListener<CategoryResult> {

    @Override
    public void onRequestFailure(SpiceException spiceException) {
      Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
      Log.w(ANDROID_APP_TAG, spiceException.getMessage());
    }

    @Override
    public void onRequestSuccess(final CategoryResult result) {
      Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
      Log.i(ANDROID_APP_TAG, "Found categories: " + result.getCategories().size());
    }
  }
}
