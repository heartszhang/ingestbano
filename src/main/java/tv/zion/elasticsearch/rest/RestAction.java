package tv.zion.elasticsearch.rest;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.*;

import java.io.IOException;

public class RestAction extends BaseRestHandler {
  @Inject
  public RestAction(Settings settings, RestController ctrl) {
    super(settings);
    ctrl.registerHandler(RestRequest.Method.GET, "/liufang", this);
  }

  @Override
  protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    String name = request.param("name");

    return channel -> {
      XContentBuilder builder = channel.newBuilder();
      builder.startObject();
      builder.field("name", name);
      builder.endObject();
      channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
    };
  }
}
