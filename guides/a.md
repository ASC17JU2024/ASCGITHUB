### Classes
1. **Definition**: A class is a blueprint for creating objects, providing initial values for state (member variables) and implementations of behavior (member functions or methods).
2. **Inheritance**: Classes support inheritance, allowing one class to inherit the attributes and methods of another.
3. **Encapsulation**: Classes encapsulate data for the object, ensuring that data is hidden from other classes and can be accessed only through methods.
4. **Constructors**: Classes have constructors, special methods called when an object is instantiated.
5. **Static Members**: Classes can have static methods and variables, which belong to the class rather than any object instance.
6. **Final Classes**: A class can be declared as final, preventing it from being subclassed.
7. **Inner Classes**: Java supports inner classes, including local, anonymous, and static nested classes.
8. **Object Creation**: Objects are created from classes using the `new` keyword.
9. **Initialization Block**: Classes can have initialization blocks that run before constructors.
10. **Access Modifiers**: Classes can use access modifiers (public, private, etc.) to control visibility of their members.

### Abstract Classes
11. **Definition**: An abstract class cannot be instantiated and is designed to be subclassed. It can contain abstract methods (without an implementation).
12. **Abstract Methods**: Abstract classes can have abstract methods, which must be implemented by subclasses.
13. **Partial Implementation**: Abstract classes can provide a partial implementation, leaving some methods abstract.
14. **Constructors**: Abstract classes can have constructors that are called when a subclass is instantiated.
15. **Static Members**: Abstract classes can have static fields and methods.
16. **Cannot Be Final**: An abstract class cannot be declared as final.
17. **Supports Inheritance**: Abstract classes support inheritance and can extend other classes (except final classes).
18. **Use Case**: Abstract classes are used when it makes no sense to create an instance of the class itself.
19. **Abstract Class vs Interface**: Abstract classes can have member variables, whereas interfaces cannot.
20. **Multiple Inheritance**: Abstract classes do not support multiple inheritance directly (a class can only extend one parent class).

### Interfaces
21. **Definition**: An interface is a reference type in Java, it is a collection of abstract methods and static constants.
22. **Implementation**: A class implements an interface, thereby inheriting the abstract methods of the interface.
23. **Multiple Inheritance**: Interfaces support multiple inheritance, allowing a class to implement multiple interfaces.
24. **All Abstract Methods**: By default, all methods in an interface are abstract and public.
25. **Static and Default Methods**: From Java 8 onwards, interfaces can have static and default methods with implementations.
26. **Functional Interfaces**: An interface with exactly one abstract method becomes a Functional Interface, which can be used in lambda expressions.
27. **Constants**: Interfaces can contain constants, which are implicitly public, static, and final.
28. **Marker Interfaces**: An interface with no methods is known as a marker interface, e.g., `Serializable`.
29. **Extension**: Interfaces can extend one or more other interfaces.
30. **Use Case**: Interfaces are used to define a contract for classes without forcing the class's inheritance structure.

### General Points
31. **Polymorphism**: Both abstract classes and interfaces support polymorphism in Java, allowing objects to be treated as instances of their parent class or implemented interfaces.
32. **Design Principle**: Favor using interfaces over abstract classes to avoid the constraints of single inheritance.
33. **Abstract Class vs Interface Usage**: Use abstract classes when you need to share code among several closely related classes; use interfaces when you need to enforce a contract for unrelated classes.
34. **Visibility**: Interface members are public by default, while abstract class members can have any visibility.
35. **Fields**: Abstract classes can have final, non-final, static, and non-static fields. Interfaces cannot have instance fields.
36. **Constructors and Destructors**: Interfaces cannot have constructors or destructors, but abstract classes can.
37. **Method Bodies**: Before Java 8, interfaces could not contain method bodies. Now, default and static methods in interfaces can have bodies.
38. **Instantiation**: Neither abstract classes nor interfaces can be instantiated directly.
39. **Abstract Class Inheritance**: A subclass of an abstract class must implement all its abstract methods unless the subclass is also abstract.
40. **Implementing Multiple Interfaces**: When a class implements multiple interfaces that define the same default method, the class must override the method.
41. **Lambda Expressions**: Functional interfaces are a target for lambda expressions due to their single abstract method.
42. **Type Checking**: Objects can be type-checked against abstract classes and interfaces they are derived from.
43. **Abstract Class and Interface as Types**: Both can be used as data types for variable declaration, allowing for dynamic polymorphism.
44. **Performance**: Historically, interfaces were slower than abstract classes due to the method lookup required. However, with modern JVM optimizations, the difference is negligible.
45. **Choosing Between Abstract Class and Interface**: If you expect classes to have methods with different implementations, use an interface. If you want to share code among all classes, use an abstract class.
46. **Compatibility**: Adding a new method to an abstract class breaks subclasses. Adding a new method to an interface breaks implementing classes unless it's a default or static method.
47. **Abstract Methods in Classes**: A non-abstract class that extends an abstract class must implement all its abstract methods.
48. **Interface Evolution**: Default methods were introduced to allow interfaces to evolve while maintaining backward compatibility.
49. **Abstract Class as a Skeleton**: Abstract classes can serve as a skeleton implementation, with some methods implemented and others left abstract.
50. **Interface Segregation Principle**: Interfaces encourage the Interface Segregation Principle, part of SOLID principles, promoting fine-grained interfaces that are client-specific rather than general-purpose abstract classes.