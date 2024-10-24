import { product, taxCalculation } from './06-funcitons-destructuring';

const shoppingCart: product [] = [
    {
        description:"pc",
        price:200.5
    },
    {
        description:"portatil",
        price:150.5
    }

];
const[total,tax]=taxCalculation({tax:0.15, products:shoppingCart})
console.log("total",total)
console.log("tax",tax)
