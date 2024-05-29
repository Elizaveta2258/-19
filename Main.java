public class Main {
    public static void main(String[] args) {

        Clothing[] clothing = new Clothing[4];
        clothing[0] = new Skirt(Size.S, 345, "Розовый");
        clothing[1] = new Pants(Size.XXS, 237, "Черный");
        clothing[2] = new TShirt(Size.L, 34, "Зеленый");
        clothing[3] = new Tie(Size.XS, 8, "Красный");
        Atelier.dressMen(clothing);
        Atelier.dressWomen(clothing);
    }
}
enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }

    public int getEuroSize() {
        return euroSize;
    }
}

interface ManCloth {
    void wearMan();
}

interface WomanCloth {
    void wearWoman();
}

abstract class Clothing {
    Size size;
    double price;
    String color;

    Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

class TShirt extends Clothing implements ManCloth, WomanCloth {
    TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void wearMan() {
        System.out.printf("Мужчина в футболке: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }

    public void wearWoman() {
        System.out.printf("Женщина в футболке: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Pants extends Clothing implements ManCloth, WomanCloth {
    Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    public void wearMan() {
        System.out.printf("Мужчина в штанах: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }

    public void wearWoman() {
        System.out.printf("Женщина в штанах: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Skirt extends Clothing implements WomanCloth {
    Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void wearWoman() {
        System.out.printf("Женщина в юбке: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Tie extends Clothing implements ManCloth {

    Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    public void wearMan() {
        System.out.printf("Мужчина в галстуке: цвет - %s, цена - %f, размер - %s, %d, %s\n",
                color, price, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class  Atelier {
    static void dressWomen(Clothing[] cloth) {
        for (Clothing c : cloth) {
            if (c instanceof WomanCloth) {
                ((WomanCloth) c).wearWoman();
            }
        }
    }

    static void dressMen(Clothing[] cloth) {
        for (Clothing c : cloth) {
            if (c instanceof ManCloth) {
                ((ManCloth) c).wearMan();
            }
        }
    }
}