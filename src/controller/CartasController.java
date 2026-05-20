package controller;

import model.Cartas;
import service.CartasService;

public class CartasController {

    CartasService service = new CartasService() ;


    public Cartas cadastrarCartas(Cartas novo){
       return  service.criar(novo);
    }

}
