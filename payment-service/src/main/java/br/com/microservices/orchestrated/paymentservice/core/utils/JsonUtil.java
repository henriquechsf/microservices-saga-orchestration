package br.com.microservices.orchestrated.paymentservice.core.utils;

import br.com.microservices.orchestrated.paymentservice.core.dto.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper mapper;

    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return "";
        }
    }

    public Event toEvent(String json) {
        try {
            return mapper.readValue(json, Event.class);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return null;
        }
    }
}
