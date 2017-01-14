package tv.zion.elasticsearch.rest;

import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestHandler;

import java.util.Collections;
import java.util.List;

public class LiuFangRestPlugin extends Plugin implements ActionPlugin {
  @Override public List<Class<? extends RestHandler>> getRestHandlers() {
    return Collections.singletonList(RestAction.class);
  }
}
