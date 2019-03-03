package book.toby.toby_spring.ch1;

abstract class AnimalFactory {
    abstract Animal factoryReturn(String str);
}
class FactoryReturn extends AnimalFactory{
    @Override
    Animal factoryReturn(String str){
        switch (str){
            case "dog" : return new Dog();
            case "cat" : return new Cat();
        }
        return null;
    }
}
