package ejercicioSevilla;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter <String, LocalTime> {

	private static DateTimeFormatter formato=DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public LocalTime unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
	
		return LocalTime.parse(v);
	}

	@Override
	public String marshal(LocalTime v) throws Exception {
		// TODO Auto-generated method stub
		
		return v.format(formato);
	}
	

}
