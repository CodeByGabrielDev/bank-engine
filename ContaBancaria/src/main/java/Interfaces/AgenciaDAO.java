package Interfaces;

import java.util.List;

import Entities.Agencia;

public interface AgenciaDAO {

	Agencia findAgencia(int id);

	List<Agencia> findAll();

	void insert(Agencia agencia);

	void update(Agencia agencia);

	void save(Agencia agencia);

	void delete(int id);
}
