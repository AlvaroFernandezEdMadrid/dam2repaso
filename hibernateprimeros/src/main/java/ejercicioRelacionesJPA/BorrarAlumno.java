package ejercicioRelacionesJPA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.TriggerAdapter;

public class BorrarAlumno extends TriggerAdapter{

	@Override
	public void fire(Connection conn, ResultSet oldRow, ResultSet newRow) throws SQLException {
		// TODO Auto-generated method stub
		String dni = oldRow.getString(1);
		System.out.println("borrando alumno...." + dni);


		/*
		String query = "DELETE FROM Calificacion WHERE idAlumno= ?1";	
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dni);
		ps.executeUpdate();
		 */

		AlumnoListener listener = new AlumnoListener();

		listener.borradoAlumno(Alumno.builder().dni(dni).build());

	}

}
