package kafka;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;

import static com.google.code.tempusfugit.concurrency.ThreadUtils.sleep;
import static com.google.code.tempusfugit.temporal.Duration.seconds;

@Ignore("currently just started for quick manual testing")
public class StartEmbeddedKafka {

    @ClassRule
    public static EmbeddedKafkaRule embeddedKafkaRule =
            new EmbeddedKafkaRule(1, true, "test.me").kafkaPorts(59000);

    @Test
    public void startKafkaForManualTestsLaterWriterRealTests() {
        EmbeddedKafkaBroker embeddedKafka = embeddedKafkaRule.getEmbeddedKafka();
        embeddedKafka.afterPropertiesSet();
        sleep(seconds(60));
    }
}
