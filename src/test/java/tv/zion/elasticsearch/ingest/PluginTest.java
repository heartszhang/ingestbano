package tv.zion.elasticsearch.ingest;

import org.elasticsearch.action.admin.cluster.node.info.NodeInfo;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.PluginInfo;
import org.elasticsearch.test.ESIntegTestCase;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.is;

public class PluginTest extends ESIntegTestCase {
  @Override
  protected Collection<Class<? extends Plugin>> nodePlugins() {
    return Collections.singleton(IngestPlugin.class);
  }

  public void testPluginIsLoaded() throws Exception {
    NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().setPlugins(true).get();
    for (NodeInfo nodeInfo : response.getNodes()) {
      boolean pluginFound = false;
      for (PluginInfo pluginInfo : nodeInfo.getPlugins().getPluginInfos()) {
        if (pluginInfo.getName().equals(IngestPlugin.class.getName())) {
          pluginFound = true;
          break;
        }
      }
      assertThat(pluginFound, is(true));
    }
  }
}
