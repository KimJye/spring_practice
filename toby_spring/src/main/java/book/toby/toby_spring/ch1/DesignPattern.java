package book.toby.toby_spring.ch1;

public class DesignPattern {

    public static void main(String[] args){
        AnimalFactory af = new FactoryReturn();

        Animal dog = af.factoryReturn("dog");

        // 강아지 안녕하세요
        System.out.println(dog.getName() + " " + dog.hello());

        Animal cat = af.factoryReturn("cat");

        // 고양이 냐옹
        System.out.println(cat.getName() + " " + cat.hello());
    }
}
