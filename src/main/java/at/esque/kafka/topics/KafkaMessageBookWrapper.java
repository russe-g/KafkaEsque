package at.esque.kafka.topics;

public class KafkaMessageBookWrapper {

    private String targetTopic;
    private KafkaMessageForMessageBook wrappedMessage;

    public KafkaMessageBookWrapper(String targetTopic, KafkaMessageForMessageBook wrappedMessage) {
        this.targetTopic = targetTopic;
        this.wrappedMessage = wrappedMessage;
    }

    public String getTargetTopic() {
        return targetTopic;
    }

    public KafkaMessageForMessageBook getWrappedMessage() {
        return wrappedMessage;
    }

    public String getKey() {
        return wrappedMessage.getKey();
    }

    public void setKey(String key) {
        wrappedMessage.setKey(key);
    }

    public String getValue() {
        return wrappedMessage.getValue();
    }

    public void setValue(String value) {
        wrappedMessage.setValue(value);
    }

    public String getKeyType() {
        return wrappedMessage.getKeyType();
    }

    public void setKeyType(String keyType) {
        wrappedMessage.setKeyType(keyType);
    }

    public String getValueType() {
        return wrappedMessage.getValueType();
    }

    public void setValueType(String valueType) {
        wrappedMessage.setValueType(valueType);
    }

    public int getPartition() {
        return wrappedMessage.getPartition();
    }

    public String getTimestamp() {
        return wrappedMessage.getTimestamp();
    }


}
