package stack;

public class MyStack<T> {

    T[] stack;
    int capacity;
    int pointer=-1;


    public MyStack(int size) {
        this.stack=(T[])new Object[size];
        this.capacity=size;
    }

    public void push(T data)
    {
        if(pointer==this.capacity-1)
            throw new RuntimeException("Stack Overflow");

        stack[++pointer]=data;
    }

    public T peak()
    {
        if(pointer!=-1)
            return stack[pointer];
        else
            throw new RuntimeException("Stack is Empty");
    }

    public T pop()
    {
        if(pointer==-1)
            throw new RuntimeException("Stack Underflow");
        return stack[pointer--];
    }

    public boolean isEmpty()
    {
        return pointer!=-1;
    }

    public int size()
    {
        return pointer+1;
    }
}

class Test{

    public static void main(String[] args) {

        MyStack<Integer> myStack=new MyStack<Integer>(3);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
//        myStack.push(8);

//        myStack.pop();
        myStack.pop();
//        myStack.pop();
        //myStack.pop();

        System.out.println(myStack.size());
        System.out.println(myStack.peak());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.size());
//        System.out.println(myStack.peak());
//
        //s

    }
}

class User
{
    private final String name;
    private final String salary;
    private final String address;

    private User(String name, String salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    static class UserBuilder{
        private String name;
        private String salary;
        private String address;

        private UserBuilder(){}

        public UserBuilder setName(String name){
            this.name=name;
            return this;
        }

        public UserBuilder setSalary(String salary){
            this.salary=salary;
            return this;
        }

        public UserBuilder setAddress(String address){
            this.address=address;
            return this;
        }

        public User build()
        {
            return new User(this.name,this.salary,this.address);
        }
    }


}
