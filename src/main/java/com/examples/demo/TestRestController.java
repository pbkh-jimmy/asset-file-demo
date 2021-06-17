package com.examples.demo;

import java.io.IOException;
import java.net.URLEncoder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestRestController {
  private ResourceLoader loader = new DefaultResourceLoader();
  @GetMapping("/animal/{text}")
  public ResponseEntity testModel(@PathVariable("text") String text) {
    System.out.println("TEXT IS " + text);
    String url = "http://localhost:1234/v1/picture/";
    return new ResponseEntity(new ResponseModel(url + URLEncoder.encode(text), url +  text), HttpStatus.OK);
  }

  @GetMapping("/picture/{text}")
  public ResponseEntity getPicture(@PathVariable("text") String text) {
    System.out.println("TEXT IS " + text);
    return new ResponseEntity(text, HttpStatus.OK);
  }

  @PostMapping("/animal")
  public ResponseEntity testModel(@RequestBody Animal animal) {
    System.out.println("animal is " + animal.type);
    System.out.println("animal is " + animal.toString());
    return new ResponseEntity(animal, HttpStatus.OK);
  }

  @GetMapping(value = "/picture", produces = "image/png")
  public Resource getImage() throws IOException {
    return loader.getResource("classpath:images/cannot_delete_step_flow_complete.png");
  }

  @GetMapping(value = "/css", produces = "text/css")
  public Resource getCss() throws IOException {
    return loader.getResource("classpath:css/style.css");
  }
}
