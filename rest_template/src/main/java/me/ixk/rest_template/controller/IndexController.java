package me.ixk.rest_template.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class IndexController {
  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/{id}")
  public String index(@PathVariable final String id) {
    return "index-" + id;
  }

  @GetMapping("/rest-get")
  public String get() {
    final URI uri = UriComponentsBuilder
      .fromUriString("http://localhost:8080/{id}")
      .build("1");
    return restTemplate.getForObject(uri, String.class);
  }

  public void header() {
    final URI uri = UriComponentsBuilder
      .fromUriString("http://localhost:8080/{id}")
      .build("1");
    RequestEntity<Void> requestEntity = RequestEntity
      .get(uri)
      .header("X-Header", "1")
      .build();
    ResponseEntity<String> responseEntity = restTemplate.exchange(
      requestEntity,
      String.class
    );
    ResponseEntity<String> responseEntity1 = restTemplate.exchange(
      requestEntity,
      new ParameterizedTypeReference<String>() {
        // ...
      }
    );
  }
}
