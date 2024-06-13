// レベル3: 抽象ファクトリーパターンの適用

// 抽象的な部品Aインターフェース
interface ComponentA {
    void operationA();
}

// 具体的な部品Aクラス1
class ConcreteComponentA1 implements ComponentA {
    @Override
    public void operationA() {
        System.out.println("Operation A from component A1");
    }
}

// 具体的な部品Aクラス2
class ConcreteComponentA2 implements ComponentA {
    @Override
    public void operationA() {
        System.out.println("Operation A from component A2");
    }
}

// 抽象的な部品Bインターフェース
interface ComponentB {
    void operationB();
}

// 具体的な部品Bクラス1
class ConcreteComponentB1 implements ComponentB {
    @Override
    public void operationB() {
        System.out.println("Operation B from component B1");
    }
}

// 具体的な部品Bクラス2
class ConcreteComponentB2 implements ComponentB {
    @Override
    public void operationB() {
        System.out.println("Operation B from component B2");
    }
}

// 抽象的なファクトリーインターフェース
interface AbstractFactory {
    ComponentA createComponentA();
    ComponentB createComponentB();
}

// 具体的なファクトリークラス1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ComponentA createComponentA() {
        return new ConcreteComponentA1();
    }

    @Override
    public ComponentB createComponentB() {
        return new ConcreteComponentB1();
    }
}

// 具体的なファクトリークラス2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ComponentA createComponentA() {
        return new ConcreteComponentA2();
    }

    @Override
    public ComponentB createComponentB() {
        return new ConcreteComponentB2();
    }
}

// メインクラス
public class FactoryPatternExample {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ComponentA componentA1 = factory1.createComponentA();
        componentA1.operationA(); // Operation A from component A1
        ComponentB componentB1 = factory1.createComponentB();
        componentB1.operationB(); // Operation B from component B1

        AbstractFactory factory2 = new ConcreteFactory2();
        ComponentA componentA2 = factory2.createComponentA();
        componentA2.operationA(); // Operation A from component A2
        ComponentB componentB2 = factory2.createComponentB();
        componentB2.operationB(); // Operation B from component B2
    }
}
