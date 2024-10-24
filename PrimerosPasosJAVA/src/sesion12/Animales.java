package sesion12;

public class Animales {

    protected void comer (){
        System.out.println("como mucho");
    }

    protected void dormir (){
        System.out.println("duermo mucho");
    }

    class perro extends Animales{

        public void hacerSonido(){
            System.out.println("puede ladrar");
        }
    }
}
