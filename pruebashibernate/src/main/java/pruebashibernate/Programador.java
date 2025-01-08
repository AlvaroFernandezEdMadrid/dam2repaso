package pruebashibernate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Programador extends Tecnologo{
	private String lenguajeFavorito;
	private int aniosExperiencia;
}
