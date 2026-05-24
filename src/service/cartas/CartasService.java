package service.cartas;

import controller.CartasController;
import model.Cartas;
import repository.CartasRepository;

public class CartasService implements  CartasServiceI{

   final CartasRepository repository = new CartasRepository();


    @Override
    public Cartas criar(Cartas novo) {
        return repository.criar(novo);
    }

    @Override
    public Cartas atualizar(Cartas atualizar) {
        return repository.atualizar(atualizar);
    }

    @Override
    public Cartas buscarporid(Integer id) {
        return repository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {
       repository.deletarPorId(id);
    }
}
