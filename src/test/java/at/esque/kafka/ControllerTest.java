package at.esque.kafka;

import at.esque.kafka.topics.KafkaMessageBookWrapper;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

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