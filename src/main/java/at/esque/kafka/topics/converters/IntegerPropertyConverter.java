package at.esque.kafka.topics.converters;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class IntegerPropertyConverter extends AbstractBeanField {

    @Override
    public Object convert(String value) {
        return new SimpleIntegerProperty(Integer.parseInt(value));
    }

    @Override
    public String convertToWrite(Object value) {
        IntegerProperty prop = (IntegerProperty) value;
        return String.format("%d", prop.get());
    }

}