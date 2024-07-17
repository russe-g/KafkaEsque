package at.esque.kafka.topics.converters;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringPropertyConverter extends AbstractBeanField {

    @Override
    public Object convert(String value) {
        return new SimpleStringProperty(value);
    }

    @Override
    public String convertToWrite(Object value) {
        StringProperty prop = (StringProperty) value;
        return String.format("%s", prop.get());
    }
}