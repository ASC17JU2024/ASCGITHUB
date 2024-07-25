package funda.arrays;

public class ObjectArray {
    public static void main(String[] args) {
        WaterBottle[] waterBottles;
        waterBottles = new WaterBottle[4];

        WaterBottle waterBottle1 = new WaterBottle("silver", 450, "Milton");
        waterBottles[1] = waterBottle1;
        waterBottles[2] = new WaterBottle("Blue", 750, "Cello");
        waterBottles[3] = new WaterBottle("metallic", 1000, "Tupperware");

//        for (WaterBottle waterBottle : waterBottles) {
//            System.out.println(waterBottle.getColor() + " " + waterBottle.getVolume() + " " + waterBottle.getBrand());
//        }

        for (int bottleCounter = 0; bottleCounter < waterBottles.length; bottleCounter++) {
            try {
                System.out.println(waterBottles[bottleCounter].getColor() + " " + waterBottles[bottleCounter].getVolume() + " " + waterBottles[bottleCounter].getBrand());
            } catch (NullPointerException nullPointerException) {
                System.out.println("Oh dear, no water bottle here!!!!!!");
            }
        }
        for (WaterBottle waterBottle : waterBottles) {
            if (waterBottle != null) {
                System.out.println(waterBottle.getColor() + " " + waterBottle.getVolume() + " " + waterBottle.getBrand());
            }
        }
    }
}

    class WaterBottle {
        private String color;
        private int volume;
        private String brand;

        public WaterBottle(String color, int volume, String brand) {
            this.color = color;
            this.volume = volume;
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public int getVolume() {
            return volume;
        }

        public String getBrand() {
            return brand;
        }
    }
