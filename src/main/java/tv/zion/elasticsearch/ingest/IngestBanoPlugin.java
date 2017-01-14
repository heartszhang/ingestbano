package tv.zion.elasticsearch.ingest;

import org.elasticsearch.ingest.Processor;
import org.elasticsearch.plugins.IngestPlugin;
import org.elasticsearch.plugins.Plugin;
import tv.zion.elasticsearch.ingest.liufang.BanoProcessor;

import java.util.Collections;
import java.util.Map;

public class IngestBanoPlugin extends Plugin implements IngestPlugin {
  @Override
  public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
    return Collections.singletonMap("bano", new BanoProcessor.BanoFactory());
  }
}
