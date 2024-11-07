package practicaPreExamen;

import java.util.List;
import com.opencsv.bean.CsvBindAndSplitByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carrera {
	@CsvBindAndSplitByPosition(position = 0, elementType= Vuelta.class, splitOn = "%", converter = TextToVuelta.class)
	private List<Vuelta> vueltas;
}
