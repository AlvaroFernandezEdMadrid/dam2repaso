package segundo;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TipoFormacionAdapterX extends XmlAdapter <String, TipoFormacion> {

	@Override
	public TipoFormacion unmarshal(String v)  {
		// TODO Auto-generated method stub
		
		return TipoFormacion.crearFormacion(v);
	}

	@Override
	public String marshal(TipoFormacion v)  {
		// TODO Auto-generated method stub
		return v == null? null: v.toString();
	}

}
