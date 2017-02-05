package tv.zion.elasticsearch.ingest;

import org.elasticsearch.ingest.Processor;
import org.elasticsearch.plugins.IngestPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class LiufangIngestPlugin extends Plugin implements IngestPlugin {
  /*  @Override public List<Class<? extends RestHandler>> getRestHandlers() {
      return Collections.singletonList(RestAction.class);
    }
    */
  @Override
  public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
    return Collections.singletonMap("media", new MediaProcessor.Factory());
  }
}
