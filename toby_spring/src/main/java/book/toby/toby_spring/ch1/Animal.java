package book.toby.toby_spring.ch1;

abstract class Animal {

    //추상 메소드
    public abstract String getName();

    //훅 메소드
    public String hello(){
        return "안녕하세요";
    }
}

class Dog extends  Animal{
    @Override
    public String getName(){
        return "강아지";
    }
}
class Cat extends  Animal{
    @Override
    public String getName(){
        return "고양이";
    }
    @Override
    public String hello(){
        return "냐옹";
    }
}
