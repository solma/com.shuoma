package com.sma.ds.graph.basic;

import java.util.LinkedList;
import java.util.List;

/** Node that keeps path information. */
public class PathNode extends Node implements Comparable<PathNode> {

  private double distance;
  private List<PathNode> prevNodes;

  public PathNode(Node node) {
    this(node, Integer.MAX_VALUE);
  }

  public PathNode(Node node, double distance) {
    super(node);
    this.distance = distance;
    prevNodes = new LinkedList<>();
  }

  public PathNode(String id, double value, double distance) {
    super(id, value);
    this.distance = distance;
    prevNodes = new LinkedList<>();
  }

  public void addPrevNode(PathNode prev) {
    prevNodes.add(prev);
  }

  public void clearPrevNodes() {
    prevNodes.clear();
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public List<PathNode> getPrevNodes() {
    return prevNodes;
  }

  @Override
  public int compareTo(PathNode other) {
    double diff = distance - other.distance;
    if (diff < 0)
      return -1;
    else if (diff > 0)
      return 1;
    else
      return 0;
  }
}
