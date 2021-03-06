package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.BreadthFirstSearch;
import static com.sma.annotation.Tag.DataStructure.PriorityQueueT;

import com.sma.annotation.Tag;
import com.sma.ds.graph.basic.Edge;
import com.sma.ds.graph.basic.Graph;
import com.sma.ds.graph.basic.Node;
import com.sma.ds.graph.basic.PathNode;
import com.sma.ds.graph.basic.VisitStatus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Tag(algs = BreadthFirstSearch, dss = PriorityQueueT)
public class BFS {
  public List<Node> path = new ArrayList<>();
  public static final boolean verbose = true;

  /**
   * return all paths; and null if not find
   * @param g
   * @param end: target node; if null, then traverse
   */
  public List<List<PathNode>> find(Graph g, PathNode start, PathNode end) {
    if (verbose) {
      System.out.println("**** BFS Searching Illustration ****");
    }
    if (start == null || end == null) return new ArrayList<>();

    LinkedList<PathNode> curLvl = new LinkedList<>();
    start.setVisitStatus(VisitStatus.VISITED);
    curLvl.add(start);

    int lvl = 0;
    while (curLvl.size() > 0) {
      if (verbose) {
        System.out.println("level " + lvl + " : " + curLvl);
      }
      LinkedList<PathNode> nextLvl = new LinkedList<>();
      while (curLvl.size() > 0) {
        PathNode cur = curLvl.poll();
        if (cur.equals(end)) break;

        cur.setVisitStatus(VisitStatus.EXPANDED);
        for (Edge<PathNode> e : cur.getAdjacentEdges()) {
          if (e.getVisitStatus() == VisitStatus.UNVISITED) {
            PathNode oppo = e.getOppositeNode(cur);

            // if(oppo.visitStatus==Node.STATUS.UNVISITED){
            // e.visitStatus=STATUS.VISITED;
            // oppo.visitStatus=Node.STATUS.VISITED;
            // nextLvl.add(oppo);
            // }else
            if (oppo.getDistance() < Integer.MAX_VALUE) {
              e.setVisitStatus(VisitStatus.CROSSED);
              if (verbose) {
                System.out.print("Cycle Detected : ");
                // g.printPath(g.buildAllPath(oppo, cur),true);
                System.out.println(" --> " + oppo.getValue());
              }
            }
            double newDist = lvl + 1;
            if (newDist <= oppo.getDistance()) {
              if (newDist < oppo.getDistance()) {
                oppo.setDistance(newDist);
                oppo.clearPrevNodes();
                nextLvl.add(oppo);
              }
              oppo.addPrevNode(cur);
            }
          }
        }
      }

      curLvl = nextLvl;
      lvl++;
    }

    return g.buildAllPaths(end);
  }

  public void traverse(Graph g, PathNode start) {
    find(g, start, null);
  }
}
