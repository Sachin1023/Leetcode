class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        //create a adj list for this 
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree= new int[n];
        for(int i=0;i<n;i++ )
        {
            adj.add(new ArrayList<>());
        }

        for(int [] edge : prerequisites)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                 q.offer(i);
            }
        }

        int topo=0;
        while(!q.isEmpty())
        {   
            int node = q.poll();
            topo++;
            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        return topo==n;
    }
}