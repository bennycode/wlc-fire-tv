package com.welovecoding.app.firetv.rest;

import android.util.Log;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;
import com.welovecoding.app.firetv.MainActivity;
import com.welovecoding.app.firetv.data.CategoryResult;
import java.io.IOException;

public class CategoryRequest extends GoogleHttpClientSpiceRequest<CategoryResult> {

  private String baseUrl;

  public CategoryRequest() {
    super(CategoryResult.class);
    this.baseUrl = String.format("http://www.welovecoding.com/rest/service/v2/categories");
  }

  @Override
  public CategoryResult loadDataFromNetwork() throws IOException {
    Log.i(MainActivity.ANDROID_APP_TAG, "GOTCHA!");
    HttpRequestFactory requestFactory = getHttpRequestFactory();
    GenericUrl url = new GenericUrl(baseUrl);
    HttpRequest request = requestFactory.buildGetRequest(url);
    request.setParser(new JacksonFactory().createJsonObjectParser());
    return request.execute().parseAs(getResultType());
  }
}
