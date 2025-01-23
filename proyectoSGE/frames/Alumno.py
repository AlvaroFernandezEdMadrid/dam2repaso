class Alumno:
    def __init__(self, nombreAlumno, nombreCentro, ciclo, curso, anioEscolar):
        self.nombreAlumno = nombreAlumno
        self.nombreCentro = nombreCentro
        self.ciclo = ciclo
        self.curso = curso
        self.anioEscolar = anioEscolar

    def obtener_datos(self):
        return f"Nombre: {self.nombreAlumno}\nCentro: {self.nombreCentro}\nCiclo: {self.ciclo}\nCurso: {self.curso}\nAnio Escolar: {self.anioEscolar}"
