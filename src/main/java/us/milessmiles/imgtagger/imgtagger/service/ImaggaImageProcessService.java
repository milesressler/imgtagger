package us.milessmiles.imgtagger.imgtagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import us.milessmiles.imgtagger.imgtagger.exceptions.ErrorCode;
import us.milessmiles.imgtagger.imgtagger.exceptions.ServiceUnavailableException;
import us.milessmiles.imgtagger.imgtagger.imagga.model.ImaggaTagResponse;
import us.milessmiles.imgtagger.imgtagger.model.ImageItemTag;

import java.util.*;

@Service
public class ImaggaImageProcessService implements ImageProcessingService {

    @Autowired
    WebClient webClient;

    private static final String TAG_URL = "/tags";

    /**
     * Retrieves a map of tag:confidence
     * @return list of Image Item tags
     */
    @Override
    public List<ImageItemTag> getTags(String imageUrl) {
        final ImaggaTagResponse response = webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path(TAG_URL)
                    .queryParam("image_url", imageUrl)
                    .build())
            .retrieve()
            .onStatus(HttpStatus::is5xxServerError, i ->
                    Mono.error(new ServiceUnavailableException("Image processing unavailable.", ErrorCode.IMAGGA_SERVICE_FAILURE, null )))
            .onStatus(HttpStatus::is4xxClientError, i ->
                    Mono.error(new ServiceUnavailableException("Image processing unavailable.", ErrorCode.IMAGGA_REQUEST_FAILURE, new HashMap<>(Map.of("url", imageUrl)))))
            .bodyToMono(ImaggaTagResponse.class).block();
        if (response == null || response.getResult() == null) {
            throw new ServiceUnavailableException("Unexpected image processing error.", ErrorCode.IMAGGA_UNEXPECTED_ERROR, null);
        }

        return response.getResult().getTags().stream().map(t -> new ImageItemTag(t.getTag().values().stream().findFirst().orElse(""), t.getConfidence())).toList();
    }
}
