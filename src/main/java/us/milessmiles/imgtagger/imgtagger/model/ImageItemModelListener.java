package us.milessmiles.imgtagger.imgtagger.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class ImageItemModelListener extends AbstractMongoEventListener<ImageItem> {

    private final SequenceGeneratorService sequenceGenerator;

    @Autowired
    public ImageItemModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<ImageItem> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(ImageItem.SEQUENCE_NAME));
        }
    }


}
