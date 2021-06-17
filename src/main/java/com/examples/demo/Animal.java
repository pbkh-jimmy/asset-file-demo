package com.examples.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonTypeInfo(
    use = Id.NAME,
    visible = false,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Cat.class, name = "cat"),
    @JsonSubTypes.Type(value = Dog.class, name = "dog")
})
@Getter
@Setter
@ToString
public abstract class Animal {
  protected String type;
}

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
class Dog extends Animal {
  private String paws;
}


@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
class Cat extends Animal {
  private String claws;
}
