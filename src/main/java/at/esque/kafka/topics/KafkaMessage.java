package at.esque.kafka.topics;

import at.esque.kafka.serialization.jackson.HeaderObservableListConverter;
import at.esque.kafka.serialization.jackson.MessageMetaDataObservableListConverter;
import at.esque.kafka.topics.converters.IntegerPropertyConverter;
import at.esque.kafka.topics.converters.StringPropertyConverter;
import at.esque.kafka.topics.metadata.MessageMetaData;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvCustomBindByName;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.kafka.common.header.Header;

public class KafkaMessage {
    private LongProperty offset = new SimpleLongProperty();
    @CsvCustomBindByName(column = "partition", converter = IntegerPropertyConverter.class)
    private IntegerProperty partition = new SimpleIntegerProperty();
    @CsvCustomBindByName(column = "key", converter = StringPropertyConverter.class)
    private StringProperty key = new SimpleStringProperty();
    @CsvCustomBindByName(column = "value", converter = StringPropertyConverter.class)
    private StringProperty value = new SimpleStringProperty();
    @CsvCustomBindByName(column = "timestamp", converter = StringPropertyConverter.class)
    private StringProperty timestamp = new SimpleStringProperty();
    @JsonDeserialize(converter = HeaderObservableListConverter.class)
    private ListProperty<Header> headers = new SimpleListProperty<>();
    private StringProperty keyType = new SimpleStringProperty();
    private StringProperty valueType = new SimpleStringProperty();
    @JsonDeserialize(converter = MessageMetaDataObservableListConverter.class)
    private ObservableList<MessageMetaData> metaData = FXCollections.observableArrayList();

    public long getOffset() {
        return offset.get();
    }

    public LongProperty offsetProperty() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset.set(offset);
    }

    public int getPartition() {
        return partition.get();
    }

    public IntegerProperty partitionProperty() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition.set(partition);
    }

    public String getKey() {
        return key.get();
    }

    public StringProperty keyProperty() {
        return key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public String getTimestamp() {
        return timestamp.get();
    }

    public StringProperty timestampProperty() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp.set(timestamp);
    }

    public ObservableList<Header> getHeaders() {
        return headers.get();
    }

    public ListProperty<Header> headersProperty() {
        return headers;
    }

    public void setHeaders(ObservableList<Header> headers) {
        this.headers.set(headers);
    }

    public String getKeyType() {
        return keyType.get();
    }

    public StringProperty keyTypeProperty() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType.set(keyType);
    }

    public String getValueType() {
        return valueType.get();
    }

    public StringProperty valueTypeProperty() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType.set(valueType);
    }

    public ObservableList<MessageMetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(ObservableList<MessageMetaData> metaData) {
        this.metaData = metaData;
    }
}
