package tv.zion.elasticsearch.ingest.liufang;

import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.ConfigurationUtils;
import org.elasticsearch.ingest.IngestDocument;
import org.elasticsearch.ingest.Processor;

import java.util.Map;

public class BanoProcessor  extends AbstractProcessor {
  final String source;
  final String target;
  protected BanoProcessor(String tag, String source, String target) {
    super(tag);
    this.source = source;
    this.target = target;
  }

  @Override
  public void execute(IngestDocument doc) throws Exception {
    if (doc.hasField(source)){
      doc.setFieldValue(target, doc.getFieldValue(source, String.class));
    }
  }

  @Override
  public String getType() {
    return "bano";
  }

  public static final class BanoFactory implements Processor.Factory{

    @Override
    public Processor create(Map<String, Factory> processorFactories, String tag, Map<String, Object> config) throws Exception {
      String source =ConfigurationUtils.readStringProperty("bano", tag, config, "source", "foo");
      String target = ConfigurationUtils.readStringProperty("bano", tag, config, "target", "new-"+source);
      return new BanoProcessor(tag, source, target);
    }
  }
}
