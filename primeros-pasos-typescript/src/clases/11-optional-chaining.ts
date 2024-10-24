export interface Passenger {
    name:string,
    children?:string[]
}

const passenger1:Passenger ={
    name :" andres felipe de la cruz"
}

const passenger2:Passenger ={
    name :" andres felipe de la cruz",
    children:["perla","princesa"]
}

const printChildren = (passenger:Passenger)=>{

    const howManyChildren = passenger.children?.length || 0;

    console.log(howManyChildren);
    

}

printChildren(passenger2);
printChildren(passenger1);
