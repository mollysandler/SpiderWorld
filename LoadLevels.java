class LoadLevels {

    // Keeping track of current level
    private int curLevel;

    // Constructor
    public LoadLevels (int level) {
        this.curLevel = level
    }

    public JSONObject mapToJSON(Point coordB, Point coordR, Point coordG) {

        // Creating map for JSON
        Map<String, Integer> map = new Hashmap<>();
        map.put("blue", coordB);
        map.put("red", coordR);
        map.put("green", coordG);

        return new JSONObject(map);
    }

    // To create levels
    public void createLevel(Point coordB, Point coordR, Point coordG) {
        
        JSONObject jo = mapToJSON(coordB, coordR, coordG);

        String fname = "level" + this.curLevel.toString() + ".json";
        
        try (FileWriter file = new FileWriter(fname)) {
            file.write(gson.toJson(jsonObject));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
