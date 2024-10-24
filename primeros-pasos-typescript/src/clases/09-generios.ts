export function whatsMyType<T>(argument:T):T{
    return argument;
}

const amIString = whatsMyType<String>("hola mundo");
const amINumber = whatsMyType<number>(12323123);
const amIArray  = whatsMyType<number[]>([1,23,3,4,5,5,6,5]);

console.log(amIString.split(" "));
console.log(amINumber.toFixed());
console.log(amIArray.join("-"));

