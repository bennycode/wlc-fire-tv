package com.welovecoding.app.firetv.rest;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.jackson.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;
import com.welovecoding.app.firetv.data.Category;
import java.io.IOException;
import roboguice.util.temp.Ln;

public class CategoryRequest extends GoogleHttpClientSpiceRequest<Category> {

  private String baseUrl;

  public CategoryRequest() {
    super(Category.class);
    this.baseUrl = String.format("http://www.welovecoding.com/rest/service/v1/categories");
  }

  @Override
  public Category loadDataFromNetwork() throws IOException {
    Ln.d("Call web service " + baseUrl);
    HttpRequest request = getHttpRequestFactory().buildGetRequest(new GenericUrl(baseUrl));
    request.setParser(new JacksonFactory().createJsonObjectParser());
    return request.execute().parseAs(getResultType());
  }
}
