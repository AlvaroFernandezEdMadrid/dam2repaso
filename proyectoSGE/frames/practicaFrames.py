import tkinter as tk
from PIL import Image, ImageTk
from Grafica import Grafica 
from Alumno import Alumno
from InterfazMail import InterfazMail

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
    
    # Crear boton para abrir formulario
    interfaz_mail = InterfazMail(center_frame) 
    tk.Button(left_frame, text="Mandar Correo", bg="#B15B94", fg="white", command=lambda: interfaz_mail.mostrarFormulario()).pack(pady=20, side="top")
    
    # Crear boton para mostrar los datos del alumno
    alumno = Alumno("Chicho Terremoto", "I.E.S. Villablanca", "DAM", "2º", "2024-2025")
    tk.Button(left_frame, text="Datos Alumno", bg="#B15B94", fg="white", command=lambda: alumno.mostrar_datos_alumno(center_frame)).pack(pady=20, side="bottom")

    tk.Label(center_frame, text="I.E.S.\nVillablanca.\nCurso 24 - 25", bg="#DAB0CC", fg="white", font=("Arial", 25), justify="center").pack(expand=True, fill="both")
    
    root.mainloop()

if __name__ == "__main__":
    main()
