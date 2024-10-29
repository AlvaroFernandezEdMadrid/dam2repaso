package segundo;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class TipoFormacionAdapterJ extends TypeAdapter<TipoFormacion>{

	@Override
    public void write(JsonWriter out, TipoFormacion value) throws IOException {
        if (value != null) {
            out.value(value.toString());
        } else {
            out.nullValue();
        }
    }

    @Override
    public TipoFormacion read(JsonReader in) throws IOException {
        String valor = in.nextString();
        return TipoFormacion.crearFormacion(valor);
    }
	
}
