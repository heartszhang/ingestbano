package tv.zion.elasticsearch.ingest;

import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.IngestDocument;
import org.elasticsearch.ingest.Processor;

import java.util.Map;

public final class MediaProcessor  extends AbstractProcessor {
  protected MediaProcessor(String tag) {
    super(tag);
  }

  @Override
  public void execute(IngestDocument doc) throws Exception {

  }

  @Override
  public String getType() {
    return "media";
  }

  public static final class Factory implements Processor.Factory {
    @Override
    public Processor create(Map<String, Processor.Factory> processorFactories, String tag, Map<String, Object> config)
        throws Exception {
      return new MediaProcessor(tag);
    }
  }
}
