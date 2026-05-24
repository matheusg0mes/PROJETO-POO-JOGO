package controller;

import model.Cartas;
import service.cartas.CartasService;

public class CartasController {

   final CartasService service = new CartasService() ;

    public Cartas cadastrarCartas(Cartas novo){
       return  service.criar(novo);
    }

    public void deleteCartas(Integer id){
        service.deletar(id);
    }

    public Cartas buscarPorId(Integer id) {
        return service.buscarporid(id);
    }

    public void atualizar(Cartas carta) {
        service.atualizar(carta);
    }
}
