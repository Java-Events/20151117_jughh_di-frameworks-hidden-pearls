package org.rapidpm.event.jughh.hk2.runlevel;

import org.glassfish.hk2.runlevel.*;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

/**
 * Created by svenruppert on 01.11.15.
 */
public class AllRunLevel {


  @Service
  public static class RunLevelListenerLogger implements RunLevelListener {

    public void onProgress(ChangeableRunLevelFuture currentJob,
                           int levelAchieved) {
      System.out.println("Achieved level: " + levelAchieved);
    }

    public void onCancelled(RunLevelFuture currentJob,
                            int levelAchieved) {
      System.out.println("Cancelled at level: " + levelAchieved);

    }

    public void onError(RunLevelFuture currentJob, ErrorInformation info) {
      System.out.println("Error while progressing to level: " + currentJob.getProposedLevel() + " " +
          info.getError());
    }
  }


  @Service
  @RunLevel(value = 1)
  public static class Level01 {
    public Level01() {
      System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
    }

    @PostConstruct
    private void startMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName startMe= " + simpleName);
    }

    @PreDestroy
    private void stopMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName stopMe= " + simpleName);

    }
  }

  @Service
  @RunLevel(value = 2)
  public static class Level02 {
    public Level02() {
      System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
    }

    @PostConstruct
    private void startMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName startMe= " + simpleName);
    }

    @PreDestroy
    private void stopMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName stopMe= " + simpleName);

    }
  }

  @Service
  @RunLevel(value = 3)
  public static class Level03A {
    public Level03A() {
      System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
    }

    @PostConstruct
    private void startMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName startMe= " + simpleName);
    }

    @PreDestroy
    private void stopMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName stopMe= " + simpleName);

    }
  }

  @Service
  @RunLevel(value = 3)
  public static class Level03B {
    public Level03B() {
      System.out.println(this.getClass().getSimpleName() + " LocalDateTime.now() = " + LocalDateTime.now());
    }

    @PostConstruct
    private void startMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName startMe= " + simpleName);
    }

    @PreDestroy
    private void stopMe() {
      final String simpleName = this.getClass().getSimpleName();
      System.out.println("simpleName stopMe= " + simpleName);

    }
  }


}
