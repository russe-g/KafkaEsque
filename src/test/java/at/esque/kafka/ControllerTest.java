package at.esque.kafka;

import at.esque.kafka.topics.KafkaMessageBookWrapper;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(JfxRunner.class)
public class ControllerTest {

    @Test
    public void testAddMessagesToSend() {
        // Given
        List<KafkaMessageBookWrapper> messagesToSend = new ArrayList<>();
        File playFile = new File("src/test/resources/csv_testfiles/testAddMessagesToSend.csv");

        // When
        Controller controller = new Controller();
        controller.addMessagesToSend(messagesToSend, playFile);

        // Then
        assertEquals(2, messagesToSend.size());
    }
}