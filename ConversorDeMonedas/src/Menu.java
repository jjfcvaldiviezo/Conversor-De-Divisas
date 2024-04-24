public class Menu {
    public String direccion;
    Divisa usd = Divisa.USD;
    Divisa arg = Divisa.ARS;
    Divisa bra = Divisa.BRL;
    Divisa col = Divisa.COP;

    public String retornaDireccion(int opcion) {
        switch (opcion) {
            case 1:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + usd.name() + "/" + arg.name() + "/";
                break;

            case 2:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + arg.name() + "/" + usd.name() + "/";
                break;

            case 3:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + usd.name() + "/" + bra.name() + "/";
                break;

            case 4:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + bra.name() + "/" + usd.name() + "/";
                break;

            case 5:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + usd.name() + "/" + col.name() + "/";
                break;

            case 6:
                direccion = "https://v6.exchangerate-api.com/v6/75c75a0106e75baffd8423d0/pair/" + col.name() + "/" + usd.name() + "/";
                break;
        }
        return direccion;
    }

    public void mensajeFinal(int opcion, float monto){
        switch (opcion) {
            case 1:
                System.out.println("La conversion de "+monto+" "+usd.name()+ " a "+arg.name()+" es: ");
                break;

            case 2:
                System.out.println("La conversion de "+monto+" "+arg.name()+ " a "+usd.name()+" es: ");
                break;

            case 3:
                System.out.println("La conversion de "+monto+" "+usd.name()+ " a "+bra.name()+" es: ");
                break;

            case 4:
                System.out.println("La conversion de "+monto+" "+bra.name()+ " a "+usd.name()+" es: ");
                break;

            case 5:
                System.out.println("La conversion de "+monto+" "+usd.name()+ " a "+col.name()+" es: ");
                break;

            case 6:
                System.out.println("La conversion de "+monto+" "+col.name()+ " a "+usd.name()+" es: ");
                break;
        }
    }
}
