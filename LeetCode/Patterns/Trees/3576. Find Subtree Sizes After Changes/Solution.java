class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        List<Integer>[] origTree=new ArrayList[n];
        for(int i=0;i<n;i++) origTree[i]=new ArrayList<>();
        for(int i=1;i<n;i++) origTree[parent[i]].add(i);
        int[] newParent=parent.clone();
        int[] lastSeen=new int[26];
        Arrays.fill(lastSeen,-1);
        dfs1(0,origTree, newParent, lastSeen,s);
        List<Integer>[] newTree=new ArrayList[n];
        for(int i=0;i<n;i++) newTree[i]=new ArrayList<>();
        for(int i=1;i<n;i++) newTree[newParent[i]].add(i);
        int[] ans=new int[n];
        dfs2(0, newTree, ans);
        return ans;
    }
    private void dfs1(int node, List<Integer>[] origTree, int[] newParent, int[] lastSeen, String s){
        int charIdx=s.charAt(node)-'a';
        int oldLast=lastSeen[charIdx];
        lastSeen[charIdx]=node;
        for(int child:origTree[node]){
            int cIdx=s.charAt(child)-'a';
            if(lastSeen[cIdx]!=-1) newParent[child]=lastSeen[cIdx];
            dfs1(child, origTree, newParent, lastSeen, s);
        }
        lastSeen[charIdx]=oldLast;
    }
    private int dfs2(int node, List<Integer>[] newTree, int[] ans){
        int size=1;
        for(int child: newTree[node]) size+=dfs2(child, newTree, ans);
        ans[node]=size;
        return size;
    }
}