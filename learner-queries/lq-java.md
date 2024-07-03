:star:**Abhishek  S**
### Java Collections and Their Underlying Data Structures:

- **ArrayList**: Dynamic array
- **LinkedList**: Doubly linked list
- **HashSet**: Hash table
- **LinkedHashSet**: Hash table + Linked list (for maintaining insertion order)
- **TreeSet**: Red-Black tree
- **HashMap**: Hash table
- **LinkedHashMap**: Hash table + Linked list (for maintaining insertion order)
- **TreeMap**: Red-Black tree
- **PriorityQueue**: Binary heap
- **Vector**: Dynamic array (synchronized)
- **Stack**: Last-In-First-Out (LIFO) stack, based on a dynamic array

:star:**Balasaranya S**  

When overriding a method in Java, the following rules must be adhered to:

- **Method Signature Must Match**: The overriding method in the child class must have the same name, return type, and parameters as the method in the parent class.

- **Access Level**: The access level cannot be more restrictive than the overridden method's access level. For example, if the parent method is protected, the overriding method can be protected or public, but not private.

- **Static Methods**: Static methods cannot be overridden. If you declare a static method with the same signature as a static method in the base class, it is considered method hiding, not overriding.

- **Final Methods**: You cannot override a method marked as final in the parent class.

- **Abstract Methods**: If a class inherits an abstract method, it must either implement (override) the abstract method or be declared abstract itself.

- **Return Type**: The return type of the overriding method must be the same as, or a subtype of, the return type of the overridden method. This is known as covariant return types.


:star:**Banu Priya Selvaraj**  

:star:**Dakshnakumar G S**  

:star:**Gurupriya  Kumaran**  

:star:**Mikkalya N S**  
### Java Exception Handling Keywords:

- **try**: Defines a block of code to be tested for errors while it is being executed.
- **catch**: Defines a block of code to be executed if an error occurs in the try block.
- **finally**: Defines a block of code to be executed after the try/catch blocks, regardless of the outcome.
- **throw**: Used to explicitly throw an exception.
- **throws**: Indicates what exception(s) a method can throw.
- **assert**: Used for debugging purposes to test assumptions in code (not directly related to exception handling but can cause an AssertionError if the assumption fails).

:star:**Nandhini V**  

:star:**Rithikaa V**  

:star:**Sanjay M**  

:star:**Selva Krishnan**  

### Important Java Collections: Initial Size and Growth

1. **ArrayList**
   - Initial Size: 10
   - Growth: Increases by 50% of its size when full.

2. **HashSet**
   - Initial Size: 16
   - Growth: Doubles in size when it's 75% full.

3. **HashMap**
   - Initial Size: 16
   - Growth: Doubles in size when it's 75% full.

4. **LinkedList**
   - Initial Size: Not applicable (each element is a separate object).
   - Growth: Grows by one for each element added.

5. **PriorityQueue**
   - Initial Size: 11
   - Growth: Increases by 50% of its size or by 2 (whichever is greater) when full.

6. **Vector**
   - Initial Size: 10
   - Growth: Doubles its size when full.

7. **Stack**
   - Initial Size: 10 (if created with default constructor)
   - Growth: Doubles its size when full.

:star:**Sri Nandhish Kumar S**  

:star:**Sruthi R**  

:star:**Swetha Krishnasamy**  

:star:**Syamala Pranavi Chinnala**  

:star:**Varshitha Nalabothu**  

