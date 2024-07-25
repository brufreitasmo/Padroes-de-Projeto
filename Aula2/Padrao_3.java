package Aula2;

public class Padrao_3 {

    public static void main(String[] args) {
        ViagemPadrao viagemPadrao = new ViagemPadrao();
        viagemPadrao.organizarViagem("São Paulo", "Rio de Janeiro");
    }
    
}



//----------------------------------------------------



class ReservaVoo {
    public void reservarVoo(String origem, String destino) {
        System.out.println("Voo reservado de " + origem + " para " + destino);
    }
}



//----------------------------------------------------




class ReservaHotel {
    public void reservarHotel(String local) {
        System.out.println("Hotel reservado em " + local);
    }
}


//----------------------------------------------------




class AluguelCarro {
    public void alugarCarro(String local) {
        System.out.println("Carro alugado em " + local);
    }
}


//----------------------------------------------------



class ViagemPadrao {
    private ReservaVoo reservaVoo;
    private ReservaHotel reservaHotel;
    private AluguelCarro aluguelCarro;

    public ViagemPadrao() {
        this.reservaVoo = new ReservaVoo();
        this.reservaHotel = new ReservaHotel();
        this.aluguelCarro = new AluguelCarro();
    }

    public void organizarViagem(String origem, String destino) {
        reservaVoo.reservarVoo(origem, destino);
        reservaHotel.reservarHotel(destino);
        aluguelCarro.alugarCarro(destino);
    }
}

