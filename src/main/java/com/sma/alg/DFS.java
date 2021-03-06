package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.DepthFirstSearch;
import static com.sma.annotation.Tag.Algorithm.Recursion;

import com.sma.annotation.Tag;
import com.sma.ds.graph.basic.Edge;
import com.sma.ds.graph.basic.Graph;
import com.sma.ds.graph.basic.Node;
import com.sma.ds.graph.basic.PathNode;
import com.sma.ds.graph.basic.VisitStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Tag(algs = {DepthFirstSearch, Recursion})
public class DFS {
  public List<Node> path = new ArrayList<>();
  public static final boolean verbose = true;

  /**
   * return null if not find
   *
   * @param g
   * @param end: target node; if null, then traverse
   */
  public PathNode find(Graph g, PathNode start, PathNode end, int depthLimit) {
    if (verbose) {
      System.out.println("**** DFS Searching Illustration ****");
      if (depthLimit != Integer.MAX_VALUE) System.out.println("Depth Limit: " + depthLimit);
    }
    if (start == null || start.equals(end)) return start;
    Stack<PathNode> stack = new Stack<>();
    start.setVisitStatus(VisitStatus.VISITED);
    stack.push(start);

    int lvl = 0;
    while (stack.size() > 0) {
      if (lvl > depthLimit) return null;
      PathNode cur = stack.pop();
      if (verbose) {
        System.out.println("level " + lvl + " : " + cur);
      }
      cur.setVisitStatus(VisitStatus.EXPANDED);
      for (Edge<PathNode> e : cur.getAdjacentEdges()) {
        if (e.getVisitStatus() == VisitStatus.UNVISITED) {
          PathNode oppo = e.getOppositeNode(cur);
          if (oppo.getVisitStatus() == VisitStatus.UNVISITED) {
            e.setVisitStatus(VisitStatus.VISITED);
            oppo.setVisitStatus(VisitStatus.VISITED);
            oppo.addPrevNode(cur);

            if (oppo.equals(end)) return oppo;
            stack.add(oppo);
          } else if (oppo.getVisitStatus() == VisitStatus.VISITED) {
            e.setVisitStatus(VisitStatus.CROSSED);
          }
        }
      }
      lvl++;
    }

    return null;
  }

  public PathNode find(Graph g, PathNode start, PathNode end) {
    return find(g, start, end, Integer.MAX_VALUE);
  }

  public void traverse(Graph g, PathNode start) {
    find(g, start, null);
  }
}
