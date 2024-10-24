export interface product{
    description:string,
    price:number
}

    const phone: product = {
        description: "nokia A1",
        price: 150.2
    }

    const table: product = {
        description: "ipad Air",
        price: 250.0
    }

    interface taxCalculationOpcition{
        tax:number;
        products:product[]
    }
   export function taxCalculation(options:taxCalculationOpcition):number[] {
        
        //desestructurar parametros
        const{tax, products} = options

        let total:number = 0;

        products.forEach( ({price}) =>{
            total += price
        })


        return [total, total*tax ]; 
    }

    const shoppingCart = [phone,table];


    const [total, totalTax] = taxCalculation({tax:0.15, products:shoppingCart})
    console.log(total,totalTax);
    

