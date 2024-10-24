export class Person {
    public name:string
    public address:string

    constructor(name:string,address:string){
        this.name = name
        this.address = address
    }

}

export class Hero extends Person {
    constructor(
        public alterEgo:string,
        public age:number,
        public realName:string,
    ){
        super(alterEgo,"NY")
    }
}

const ironMan = new Hero("Iron man",45,"Tony Star")
console.log(ironMan);
