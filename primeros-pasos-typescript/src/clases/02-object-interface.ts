let skills:string[] = ["bash","counter","healing"]

interface Character{
    name:String
    hp:number
    skill:string[]
    hometown?: string
}

const strider:Character = {
    name: "ANDRES",
    hp: 100,
    skill: skills,
    hometown: "cali"
}

console.table(strider);

export{}
