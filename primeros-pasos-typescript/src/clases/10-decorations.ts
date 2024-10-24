function classDecoration/*<T extends{new(...args:any[]):{} }>*/(constructor:any){
    return class extends constructor {
        newProperty = "New property"
        hello = "override"
    }
}

@classDecoration
export class SuperClass {
    public myProperty:string = "abc"

    print(){
        console.log("hola mundo")
    }
}

console.log(SuperClass);

const myClass = new SuperClass();
console.log(myClass);

