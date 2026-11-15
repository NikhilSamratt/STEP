import java.util.List;

public class WarehouseSummary {
    
    public static class Result {
        public int totalItems;
        public int[] maxCoordinate;
        
        public Result(int totalItems, int[] maxCoordinate) {
            this.totalItems = totalItems;
            this.maxCoordinate = maxCoordinate;
        }
    }

    public static Result warehouseSummary(List<List<Integer>> grid) {
        int totalItems = 0;
        int maxItems = -1;
        int[] maxCoordinate = new int[]{-1, -1};

        for (int r = 0; r < grid.size(); r++) {
            List<Integer> row = grid.get(r);
            for (int c = 0; c < row.size(); c++) {
                int items = row.get(c);
                totalItems += items;
                
                if (items > maxItems) {
                    maxItems = items;
                    maxCoordinate[0] = r;
                    maxCoordinate[1] = c;
                }
            }
        }
        
        return new Result(totalItems, maxCoordinate);
    }
}