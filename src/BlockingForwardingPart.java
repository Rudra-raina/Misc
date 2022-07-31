import java.security.KeyPair;
import java.util.Arrays;
import java.util.HashSet;

public class BlockingForwardingPart {

    public static void main(String[] args) {
        int[][] graph={{0,3,1,0},{3,0,2,4},{1,2,0,5},{0,4,5,0}};
        MST(graph);
    }

    public static void MST(int[][] graph){
        int vertices=graph.length;
        // Weight array to keep trach of edge lengths
        int[] weight=new int[vertices];
        Arrays.fill(weight,Integer.MAX_VALUE);
        weight[0]=0;
        // MST array to keep track of MST set
        boolean[] MST=new boolean[vertices];
        // Parent array to print the MST
        int[] parent=new int[vertices];
        parent[0]=-1;

        // Form MST, it will have V-1 edges
        for(int i=0;i<vertices-1;i++){
            int min=minVertex(weight,MST); // We got our min index/vertex
            MST[min]=true; // This has to be a part of MST
            // This just fills the weight array. We do not select anything here.
            // We get the minimum vertex and we just fill its adjacent's weight in the weight array
            // Our minVertex() function will choose the minimum from this weight array
            for(int j=0;j<vertices;j++){
                if(graph[min][j]!=0 && !MST[j] && graph[min][j]<weight[j]){
                    weight[j]=graph[min][j];
                    parent[j]=min;
                }
            }
        }

        // Print MST via parent array
        for(int i=1;i<parent.length;i++){
            System.out.println(parent[i]+" to "+i+" = "+ graph[parent[i]][i]);
        }
    }

    // In simple words , its just selecting the index which has the smallest value in the weight array
    // So we need to maintain a variable for storing the index & one for cheking the values
    // We also have to make sure that we are not dealing with vertex that is already in MST
    public static int minVertex(int[] weight,boolean[] MST){
        int min=Integer.MAX_VALUE;
        int vertex=-1;
        for(int i=0;i<weight.length;i++){
            if(!MST[i] && weight[i]<min){
                vertex=i;
                min=weight[i];
            }
        }
        return vertex;
    }
}
