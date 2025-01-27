import tkinter as tk

class Alumno:
    def __init__(self, nombreAlumno, nombreCentro, ciclo, curso, anioEscolar):
        self.nombreAlumno = nombreAlumno
        self.nombreCentro = nombreCentro
        self.ciclo = ciclo
        self.curso = curso
        self.anioEscolar = anioEscolar

    def obtener_datos(self):
        return f"Nombre: {self.nombreAlumno}\nCentro: {self.nombreCentro}\nCiclo: {self.ciclo}\nCurso: {self.curso}\nAnio Escolar: {self.anioEscolar}"

    def mostrar_datos_alumno(self, frame):
        # Limpiar el contenido actual del center_frame
        for widget in frame.winfo_children():
            widget.destroy()
        
        # Obtener los datos y mostrarlos en un Label
        datos = self.obtener_datos()
        label = tk.Label(frame, text=datos, bg="#DAB0CC", fg="white", font=("Arial", 20), justify="left")
        label.pack(expand=True, fill="both")
