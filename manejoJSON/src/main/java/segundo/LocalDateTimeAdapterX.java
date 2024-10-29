package segundo;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapterX extends XmlAdapter <String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
	
		return LocalDateTime.parse(v);
	}

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		// TODO Auto-generated method stub
		
		return v.toString();
	}
	

}