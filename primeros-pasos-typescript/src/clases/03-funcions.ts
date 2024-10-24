function sum(a:number, b:number){
    return a+b;
}
const sumArrow =(a:number, b:number):string => {
    return `${a + b}`;
}

function multlipy(firstNumber: number, secondNumbre?:number, base:number = 2){
    return firstNumber*base;
}

interface Character{
    name:String
    hp:number
    showHp:()=> void;
    skill?:string[]
    hometown?: string
}
const healCharater = (character:Character , amount:number) =>{
    character.hp += amount;

}

const strider:Character = {
    name:"Strider",
    hp:50,
    showHp(){
        console.log(`Puntos de vida ${this.hp}`);
        
    }  

}

strider.showHp();
healCharater(strider, 50)
strider.showHp();
/* const result:number = sum(10,20)
const resul2:string = sumArrow(10,10)
const multiplyResult = multlipy(10)
console.log({result,resul2,multiplyResult}) */



export{

}