import tkinter as tk
from PIL import Image, ImageTk
from Grafica import Grafica 

# Definir la clase Alumno
class Alumno:
    def __init__(self, nombreAlumno, nombreCentro, ciclo, curso, anioEscolar):
        self.nombreAlumno = nombreAlumno
        self.nombreCentro = nombreCentro
        self.ciclo = ciclo
        self.curso = curso
        self.anioEscolar = anioEscolar

    def obtener_datos(self):
        return f"Nombre: {self.nombreAlumno}\nCentro: {self.nombreCentro}\nCiclo: {self.ciclo}\nCurso: {self.curso}\nAño Escolar: {self.anioEscolar}"

def mostrar_datos_alumno(center_frame, alumno):
    # Limpiar el center_frame
    for widget in center_frame.winfo_children():
        widget.destroy()

    # Crear etiqueta con los datos del alumno
    datos = alumno.obtener_datos()
    label_datos = tk.Label(center_frame, text=datos, bg="#DAB0CC", fg="white", font=("Arial", 20), justify="center")
    label_datos.pack(expand=True, fill="both")

def main():
    root = tk.Tk()
    root.title("Practica - Frames")
    root.geometry("1280x720") 

    # Frame principal
    main_frame = tk.Frame(root)
    main_frame.pack(fill="both", expand=True)

    # Titulo superior
    tk.Label(main_frame, text="Practica - Frames", bg="#B15B94", fg="white", font=("Arial", 25)).pack(fill="x", side="top")
    
    # Pie de pagina
    frame_pie = tk.Frame(root, bg="#B15B94")
    frame_pie.pack(fill="x", side="bottom")
    tk.Label(frame_pie, text="Alvaro", bg="#B15B94", fg="white", font=("Arial", 25), anchor="w").pack(fill="x", padx=10)

    # Frame izquierdo
    left_frame = tk.Frame(main_frame, bg="#C88AB3", padx=10)
    left_frame.pack(side="left", fill="y", expand=False)

    # Cargar y redimensionar imagen
    image = Image.open("proyectoSGE/frames/ies.png")
    image = image.resize((120, 100))
    photo = ImageTk.PhotoImage(image)

    # Mostrar imagen
    logo_label = tk.Label(left_frame, image=photo)
    logo_label.image = photo 
    logo_label.pack(pady=10)

    # Frame central
    center_frame = tk.Frame(main_frame)
    center_frame.pack(expand=True, fill="both")
    
    # Crear Grafica en center_frame
    grafica = Grafica(center_frame)
    tk.Button(left_frame, text="Ver Grafica", bg="#B15B94", fg="white", command=grafica.mostrar_grafica).pack(pady=20, side="top")
    
    # Crear el alumno
    alumno = Alumno("Chicho Terremoto", "I.E.S. Villablanca", "DAM", "2º", "2024-2025")

    # Crear el botón para mostrar los datos del alumno
    tk.Button(left_frame, text="Datos Alumno", bg="#B15B94", fg="white", command=lambda: mostrar_datos_alumno(center_frame, alumno)).pack(pady=20, side="bottom")

    tk.Label(center_frame, text="I.E.S.\nVillablanca.\nCurso 24 - 25", bg="#DAB0CC", fg="white", font=("Arial", 25), justify="center").pack(expand=True, fill="both")

    root.mainloop()

if __name__ == "__main__":
    main()
