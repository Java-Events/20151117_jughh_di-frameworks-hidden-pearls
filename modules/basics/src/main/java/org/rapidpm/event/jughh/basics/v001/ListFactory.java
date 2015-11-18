package org.rapidpm.event.jughh.basics.v001;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by svenruppert on 10.11.15.
 */

public class ListFactory {
  public static List createArrayList()  { return new ArrayList();  }
  public static List createLinkedList() { return new LinkedList(); }
  public static List createList()       { return new ArrayList();  }

  public static void main(String[] args) {
    final List arrayList = createArrayList();
    final List linkedList = createLinkedList();
    final List list = createList();
  }

}
