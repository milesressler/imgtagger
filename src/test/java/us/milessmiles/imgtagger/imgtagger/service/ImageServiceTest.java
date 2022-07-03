package us.milessmiles.imgtagger.imgtagger.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import us.milessmiles.imgtagger.imgtagger.exceptions.BadRequestException;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@AutoConfigureDataMongo
@SpringBootTest
@ActiveProfiles("test")
public class ImageServiceTest {

    @Mock
    private ImageProcessingService imageProcessingService;

    @Autowired
    private ImageService imageService;

    @Test
    void testNullUrl() {
        assertThrows(ValidationException.class, () -> imageService.uploadImage(null, null, null));
    }
    @Test
    void testInvalidUrl() {
        assertThrows(BadRequestException.class, () -> imageService.uploadImage("url..com", null, null));
    }
}
