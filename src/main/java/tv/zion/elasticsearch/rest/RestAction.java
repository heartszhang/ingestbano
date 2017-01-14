package tv.zion.elasticsearch.rest;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentHelper;
import org.elasticsearch.rest.*;

import java.io.IOException;
import java.util.Map;

public class RestAction extends BaseRestHandler {
  @Inject
  public RestAction(Settings settings, RestController ctrl) {
    super(settings);
    ctrl.registerHandler(RestRequest.Method.GET, "/liufang", this);
    ctrl.registerHandler(RestRequest.Method.POST, "/liufang", this);
  }

  @Override
  protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    String name = request.param("name");
    if (Strings.isNullOrEmpty(name)){
      Map<String, Object> params = XContentHelper.convertToMap(request.content(), false).v2();
      if (params.containsKey("name")){
        name = (String)params.get("name");
      }
    }
    final String fname = name;
    return channel -> {
      XContentBuilder builder = channel.newBuilder();
      builder.startObject();
      builder.field("name", fname);
      builder.endObject();
      channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
    };
  }
}
