package service.cartas;

import controller.CartasController;
import model.Cartas;
import repository.CartasRepository;

public class CartasService implements  CartasServiceI{

    CartasRepository repository = new CartasRepository();


    @Override
    public Cartas criar(Cartas novo) {
        return repository.criar(novo);
    }

    @Override
    public CartasController atualizar(Integer id) {
        return null;
    }

    @Override
    public CartasController buscar(Integer id) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }
}
