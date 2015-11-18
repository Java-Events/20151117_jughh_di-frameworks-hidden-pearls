package org.rapidpm.event.jughh.weld.v001;

/**
 * Created by svenruppert on 10.11.15.
 */
public class MyEvent {

  private String message;


  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "MyEvent{" +
        "message='" + message + '\'' +
        '}';
  }
}
