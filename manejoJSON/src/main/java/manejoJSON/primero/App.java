package manejoJSON.primero;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;


public class App 
{
	public static void main( String[] args ) throws IOException
	{
		//Cargar datos
		Gson gson=new Gson();

		PersonaWrapper wrapper;

		Reader reader = new FileReader(new File("personas.json"));

		wrapper=gson.fromJson(reader, PersonaWrapper.class);

		reader.close();

		System.out.println(wrapper); 


		try {

			// Crear contexto
			JAXBContext context = JAXBContext.newInstance(PersonaWrapper.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			Marshaller ms = context.createMarshaller();

			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			ms.marshal(wrapper, new FileWriter("personas.xml"));


		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
