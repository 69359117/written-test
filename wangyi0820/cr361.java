package wangyi0820;



import java.util.*;

/**
 * @author Tdd
 * @creat 2022-08-27 16:36
输入
3 3
1 1 2
2 3 3
885 513 817

竖着来的，1 2 885
        1 3 513
        2 3 817
 */
public class cr361 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();//节点数n和道路数m
        int[][] path = new int[m][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < m; j++){
                path[i][j] = sc.nextInt();
            }
        }
        EdgeWeightedGraph g = new EdgeWeightedGraph(n);//n个点
        Edge[] edges = new Edge[m];
        for(int i = 0; i < edges.length; i++){
            edges[i] = new Edge(path[0][i], path[1][i], path[2][i]);
            g.addEdge(edges[i]);
        }

        //构建PrimMST对象
        KruskalMST mst = new KruskalMST(g);
        //获取最小生成树的边
        Deque<Edge> edgesDeque = mst.edges();

        int res = 0;
        for(Edge edge : edgesDeque) res += edge.weight();
        System.out.println(res);
    }
}


class KruskalMST {
    //使用队列保存最小生成树的所有边
    private Deque<Edge> mst;
    //使用并查集，索引代表顶点，uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
    private UF_Tree_Weighted uf;
    //存储图中所有的边，使用最小优先队列，对边按照权重排序
    private PriorityQueue<Edge> pq;

    //根据一副加权无向图，创建最小生成树计算对象
    public KruskalMST(EdgeWeightedGraph G) {
        //初始化mst
        this.mst = new LinkedList<>();
        //初始化uf
        this.uf = new UF_Tree_Weighted(G.V());
        //初始化pq
        this.pq = new PriorityQueue<>();
        //把图中所有的边存储到pq中
        for (Edge e : G.edges()) {
            pq.offer(e);
        }
        //遍历pq队列，拿到最小权重的边，进行处理
        while(!pq.isEmpty() && mst.size() < G.V()-1){
            //找到权重最小的边
            Edge e = pq.poll();
            //找到该边的两个顶点
            int v = e.either();
            int w = e.other(v);

            //判断这两个顶点是否已经在同一颗树中，如果在同一颗树中，则不对该边做处理，如果不在一棵树中，则让这两个顶点属于的两棵树合并成一棵树
            if (uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            //让边e进入到mst队列中
            mst.offer(e);
        }
    }
    //获取最小生成树的所有边
    public Deque<Edge> edges() {
        return mst;
    }
}

class UF_Tree_Weighted {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;

    //用来存储每一个根结点对应的树中保存的结点个数
    private int[] sz;
    //初始化并查集
    public UF_Tree_Weighted(int N){
        //默认情况下，有N个分组
        this.count = N;
        //初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        //初始化eleAndGroup中的元素及其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个结点的元素，并且让每个索引处的值(该元素所在的组的标识符)等于该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        this.sz = new int[N];
        //默认情况下，sz中每个索引处的值都是1
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    public int find(int p){
        while(true){
            if (p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }

    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        //找到p元素和q元素所在组对应的树的根结点
        int pRoot = find(p);
        int qRoot = find(q);

        //如果p和q已经在同一分组，则不需要合并了
        if (pRoot==qRoot){
            return;
        }

        //判断proot对应的树大还是qroot对应的树大，最终需要把较小的树合并到较大的树中
        if (sz[pRoot] < sz[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        //分组数量-1
        this.count--;
    }
}

class EdgeWeightedGraph {
    //顶点总数
    private final int V;
    //边的总数
    private int E;
    //邻接表
    private Deque<Edge>[] adj;

    //创建一个含有V个顶点的空加权无向图
    public EdgeWeightedGraph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Deque[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    //获取图中顶点的数量
    public int V() {
        return V;
    }

    //获取图中边的数量
    public int E() {
        return E;
    }


    //向加权无向图中添加一条边e
    public void addEdge(Edge e) {
        //需要让边e同时出现在e这个边的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].offer(e);
        adj[w].offer(e);

        //边的数量+1
        E++;
    }

    //获取和顶点v关联的所有边
    public Deque<Edge> adj(int v) {
        return adj[v];
    }

    //获取加权无向图的所有边
    public Deque<Edge> edges() {
        //创建一个队列对象，存储所有的边
        Deque<Edge> allEdges = new LinkedList<>();
        //遍历顶点，拿到每个顶点的邻接表
        for(int v=0; v<V;v++){
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for (Edge e : adj(v)) {
                /*
                因为无向图中，每条边对象Edge都会在两个顶点的邻接表中各出现一次，为了不重复获取，暂定一条规则：
                除了当前顶点v，再获取边e中的另外一个顶点w，如果w<v则添加，这样可以保证同一条边只会被统计一次
                 */
                if (e.other(v)<v){
                    allEdges.offer(e);
                }
            }
        }
        return allEdges;
    }
}

class Edge implements Comparable<Edge> {
    private final int v;//顶点一
    private final int w;//顶点二
    private final double weight;//当前边的权重

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                "}";
    }

    //通过顶点v和w，以及权重weight值构造一个边对象
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double weight(){
        return weight;
    }

    //获取边上的一个点
    public int either(){
        return v;
    }

    //获取边上除了顶点vertex外的另外一个顶点
    public int other(int vertex){
        if (vertex==v){
            return w;
        }else{
            return v;
        }
    }

    @Override
    public int compareTo(Edge that) {
        int cmp;

        if (this.weight() > that.weight()){
            //如果当前边的权重大于参数边that的权重，返回1
            cmp = 1;
        } else if (this.weight() < that.weight()){
            //如果当前边的权重小于参数边that的权重，返回-1
            cmp=-1;
        }else{
            //如果当前边的权重等于参数边that的权重，返回0
            cmp = 0;
        }

        return cmp;
    }
}
