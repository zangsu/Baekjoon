import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Building[] buildings = new Building[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            buildings[i] = new Building(i, Integer.parseInt(input[i]));
        }

        for (int i = 0; i < n; i++) {
            //System.out.println("i: " + buildings[i].location + ", " + buildings[i].height);
            for (int j = i + 1; j < n; j++) {
                if (buildings[i].isVisible(buildings[j])) {
                    buildings[i].addVisibleBuilding(buildings[j]);
                }
            }
            //System.out.println("visibleBuildingCnt: " + buildings[i].getVisibleBuildingCount());
        }

        int maxVisibleBuildingCnt = Arrays.stream(buildings)
                .mapToInt(Building::getVisibleBuildingCount)
                .max()
                .getAsInt();
        System.out.println(maxVisibleBuildingCnt);
    }
}

class Building {
    final int location;
    final int height;
    private final List<Building> visibleBuildings;

    private double gradient = Double.NEGATIVE_INFINITY;

    Building(int location, int height) {
        this.location = location;
        this.height = height;
        this.visibleBuildings = new ArrayList<>();
    }

    public boolean isVisible(Building building) {
        //System.out.println(building.location + " , " + building.height);
        double gradient = (double) (this.height - building.height)
                / (this.location - building.location);
        //System.out.println("gradient: " + gradient + ", this.gradient: " + this.gradient);
        if (this.gradient < gradient) {
            //System.out.println("add");
            this.gradient = gradient;
            return true;
        } else {
            return false;
        }
    }

    public void addVisibleBuilding(Building building) {
        this.visibleBuildings.add(building);
        building.visibleBuildings.add(this);
    }

    public int getVisibleBuildingCount() {
        return this.visibleBuildings.size();
    }
}