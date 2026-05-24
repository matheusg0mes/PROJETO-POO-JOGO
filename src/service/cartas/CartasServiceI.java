package service.cartas;

import controller.CartasController;
import model.Cartas;

public interface CartasServiceI {

    public Cartas criar(Cartas novo);

    public Cartas atualizar(Cartas atualizar);

    public Cartas buscarporid(Integer id);

    public void deletar(Integer id);
}
